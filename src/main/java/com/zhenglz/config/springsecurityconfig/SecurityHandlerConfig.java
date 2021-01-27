package com.zhenglz.config.springsecurityconfig;

import com.zhenglz.common.resultModel.Status;
import com.zhenglz.utils.ResponseUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * Security 结果处理配置
 * 用来解决认证过的用户访问无权限资源时的异常
 */
@Configuration
public class SecurityHandlerConfig {

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) ->
                ResponseUtil.renderJson(response, Status.ACCESS_DENIED, null);
    }

}
