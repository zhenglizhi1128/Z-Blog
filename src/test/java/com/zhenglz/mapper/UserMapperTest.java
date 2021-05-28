package com.zhenglz.mapper;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhenglz.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    UserMapper userMapper;

    @Test
    public void queryUserList() {
        List<User> users = userMapper.listUsers();
        System.out.println(users);


    }

    @Test
    public void findByUsernameOrEmailOrPhone() {
        String pass = "1";
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashPass = bcryptPasswordEncoder.encode(pass);
        System.out.println(hashPass);
    }
}