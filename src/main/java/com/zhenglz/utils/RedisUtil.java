package com.zhenglz.utils;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Redis工具类
 *
 * @author yangkai.shen
 * @date Created in 2018-12-11 20:24
 */
@Component
@Slf4j
public class RedisUtil {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 删除 Redis 中的某个key
     *
     * @param key
     *            键
     */
    public void delete(String key) {
        stringRedisTemplate.delete(key);
    }

    /**
     * 批量删除 Redis 中的某些key
     *
     * @param keys
     *            键列表
     */
    public void delete(Collection<String> keys) {
        stringRedisTemplate.delete(keys);
    }
}
