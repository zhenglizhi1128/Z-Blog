package com.zhenglz;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhenglz.common.Constants;
import com.zhenglz.mapper.UserMapper;
import com.zhenglz.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    UserMapper userMapper;

    @Resource
    private IUserService userService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test1() {
        List<Long> collect = new ArrayList<>();
        collect.add(2l);
        collect.add(3l);
        collect.add(4l);

        List<Long> old = new ArrayList<>();
        old.add(1l);
        old.add(2l);
        old.add(3l);

        List<Long> insertIds = collect.stream().filter(x -> !old.contains(x)).collect(Collectors.toList());
        List<Long> deleteIds = old.stream().filter(x -> !collect.contains(x)).collect(Collectors.toList());
        System.out.println(deleteIds.toString());
        System.out.println(insertIds.toString());
    }

    @Test
    public void test2() {
        Set<String> keys = stringRedisTemplate.keys(Constants.REDIS_JWT_KEY_PREFIX + "*");
        System.out.println(keys);
    }
}