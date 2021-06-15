package com.zhenglz.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.zhenglz.common.Constants;
import com.zhenglz.vo.UserPrincipal;

import cn.hutool.core.util.ObjectUtil;

/**
 * <p>
 * Spring Security工具类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-12-12 18:30
 */
public class SecurityUtil {
    /**
     * 获取当前登录用户用户名
     *
     * @return 当前登录用户用户名
     */
    public static String getCurrentUsername() {
        UserPrincipal currentUser = getCurrentUser();
        return ObjectUtil.isNull(currentUser) ? Constants.ANONYMOUS_NAME : currentUser.getUsername();
    }

    /**
     * 获取当前登录用户信息
     *
     * @return 当前登录用户信息，匿名登录时，为null
     */
    public static UserPrincipal getCurrentUser() {
        Object userInfo = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userInfo instanceof UserDetails) {
            return (UserPrincipal)userInfo;
        }
        return null;
    }
}
