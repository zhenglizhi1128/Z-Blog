package com.zhenglz.config.springsecurityconfig;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* @description:雪花主键生成器
* @author: zlz
* @date: 2021/3/24
* @version:
*/
@Configuration
public class IdConfig {
    /**
     * 雪花生成器
     */
    @Bean
    public Snowflake snowflake() {
        return IdUtil.createSnowflake(1, 1);
    }
}
