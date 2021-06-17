package com.zhenglz.config.springsecurityconfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.zhenglz.common.resultmodel.Status;
import com.zhenglz.entity.Permission;
import com.zhenglz.entity.Role;
import com.zhenglz.exception.SecurityException;
import com.zhenglz.mapper.PermissionMapper;
import com.zhenglz.mapper.RoleMapper;
import com.zhenglz.vo.UserPrincipal;

import cn.hutool.core.util.StrUtil;

/**
 * @description: 动态路由认证
 * @author: zlz
 * @date: 2021/3/24
 * @version:
 */
@Component
public class RbacAuthorityService {

	@Autowired
	private RoleMapper roleMapper;

	@Autowired(required = false)
	private PermissionMapper permissionMapper;

	@Autowired
	private RequestMappingHandlerMapping mapping;

	private Multimap<String, String> urlMapping;

	private Long userId;

	private List<Permission> permissions = new ArrayList<>();

	public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
		checkRequest(request);

		Object userInfo = authentication.getPrincipal();
		boolean hasPermission = false;


		if (userInfo instanceof UserDetails) {
			UserPrincipal principal = (UserPrincipal) userInfo;
			Long id = principal.getId();
			if(null==userId || !userId.equals(id)){
				userId=id;
				List<Role> roles = roleMapper.listRolesByUserId(userId);
				List<Long> roleIds = roles.stream().map(Role::getId).collect(Collectors.toList());
				permissions = permissionMapper.selectByRoleIdList(roleIds);
			}

			// 获取资源，前后端分离，所以过滤页面权限，只保留按钮权限
			List<Permission> btnPerms = permissions.stream().filter(permission -> StrUtil.isNotBlank(permission.getUrl()))
					.collect(Collectors.toList());
			for (Permission btnPerm : btnPerms) {
				AntPathRequestMatcher antPathMatcher = new AntPathRequestMatcher(btnPerm.getUrl(), btnPerm.getMethod());
				if (antPathMatcher.matches(request)) {
					hasPermission = true;
					break;
				}
			}

			return hasPermission;
		} else {
			return false;
		}
	}

	/**
	 * 校验请求是否存在
	 *
	 * @param request
	 *            请求
	 */
	private void checkRequest(HttpServletRequest request) {
		// 获取当前 request 的方法
		String currentMethod = request.getMethod();
		if(null==urlMapping){
            allUrlMapping();
        }
		for (String uri : urlMapping.keySet()) {
			AntPathRequestMatcher antPathMatcher = new AntPathRequestMatcher(uri);
			if (antPathMatcher.matches(request)) {
				if (!urlMapping.get(uri).contains(currentMethod)) {
					throw new SecurityException(Status.HTTP_BAD_METHOD);
				} else {
					return;
				}
			}
		}
		throw new SecurityException(Status.REQUEST_NOT_FOUND);
	}

	/**
	 * 获取 所有URL Mapping，返回格式为{"/test":["GET","POST"],"/sys":["GET","DELETE"]}
	 *
	 * @return {@link ArrayListMultimap} 格式的 URL Mapping
	 */
	private void allUrlMapping() {
		urlMapping = ArrayListMultimap.create();
		// 获取url与类和方法的对应信息
		Map<RequestMappingInfo, HandlerMethod> handlerMethods = mapping.getHandlerMethods();
		handlerMethods.forEach((k, v) -> {
			// 获取当前 key 下的获取所有URL
			Set<String> url = k.getPatternsCondition().getPatterns();
			RequestMethodsRequestCondition method = k.getMethodsCondition();
			// 为每个URL添加所有的请求方法
			url.forEach(s -> urlMapping.putAll(s, method.getMethods().stream().map(Enum::toString).collect(Collectors.toList())));
		});
	}
}
