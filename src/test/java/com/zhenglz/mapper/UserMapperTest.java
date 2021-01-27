package com.zhenglz.mapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    UserMapper userMapper;

    @Test
    public void queryUserList() {
        System.out.println("d");
        logger.error("错了吗？");
        logger.info("info");
        logger.debug("debug");
        //List<User> users = userMapper.queryUserList();

    }


    public void findByUsernameOrEmailOrPhone() {
    }
}