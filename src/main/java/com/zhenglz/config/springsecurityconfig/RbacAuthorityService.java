package com.zhenglz.config.springsecurityconfig;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.google.common.collect.Multimap;
import com.zhenglz.entity.Permission;
import com.zhenglz.entity.Role;
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
		Object userInfo = authentication.getPrincipal();
		boolean hasPermission = false;
		if (userInfo instanceof UserDetails) {
			UserPrincipal principal = (UserPrincipal) userInfo;
			Long id = principal.getId();
			if (null == userId || !userId.equals(id)) {
				userId = id;
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
}


