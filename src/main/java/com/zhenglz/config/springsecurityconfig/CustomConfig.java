package com.zhenglz.config.springsecurityconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
* @description: 自定义配置
* @author: zlz
* @date: 2021/3/24
* @version:
*/
@ConfigurationProperties(prefix = "custom.config")
@Data
public class CustomConfig {
    /**
     * 不需要拦截的地址
     */
    private IgnoreConfig ignores;
}
