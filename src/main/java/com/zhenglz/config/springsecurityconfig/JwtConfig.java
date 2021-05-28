package com.zhenglz.config.springsecurityconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
* @description: JWT 配置
* @author: zlz
* @date: 2021/3/24
* @version:
*/
@ConfigurationProperties(prefix = "jwt.config")
@Data
public class JwtConfig {
    /**
     * jwt 加密 key，默认值：zhenglz.
     */
    private String key = "zhenglz";

    /**
     * jwt 过期时间，默认值：600000 {@code 10 分钟}.
     */
    private Long ttl = 600000L;

    /**
     * 开启 记住我 之后 jwt 过期时间，默认值 604800000 {@code 7 天}
     */
    private Long remember = 604800000L;
}
