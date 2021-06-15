package com.zhenglz.config.springsecurityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.zhenglz.common.resultmodel.Status;
import com.zhenglz.utils.ResponseUtil;

/**
 * @description: Security 结果处理配置用来解决认证过的用户访问无权限资源时的异常
 * @author: zlz
 * @date: 2021/3/24
 * @version:
 */
@Configuration
public class SecurityHandlerConfig {

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) -> ResponseUtil.renderJson(response, Status.ACCESS_DENIED,
            null);
    }

}
