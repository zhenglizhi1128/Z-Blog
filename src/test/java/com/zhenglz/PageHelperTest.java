package com.zhenglz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhenglz.dto.LoginRequest;
import com.zhenglz.entity.User;
import com.zhenglz.mapper.UserMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PageHelperTest {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public static Logger logger1 = LogManager.getLogger("infoLogger");

    @Resource
    private UserMapper userMapper;

    @Test
    public void loggerTest(){
        logger.debug("debug");
        logger.error("error");
        logger.info("info");

        logger1.debug("logger1-debug");
        logger1.error("logger1-error");
        logger1.info("logger1-info");

    }
    @Test
    public void pageHelperTest(){
        int currentPage = 1;
        int pageSize = 1;
        String orderBy = "id ASC";

        PageHelper.startPage(currentPage, pageSize,"");
        List<User> users = userMapper.listUsers();
        PageInfo<User> userPageInfo = new PageInfo<>(users);
       // Assert.assertEquals(count, userPageInfo.getTotal());
        logger.debug("【userPageInfo】= {}", userPageInfo.getList().get(0).getUsername());
    }

    @Test
    public void builderTest(){
        LoginRequest loginRequest = new LoginRequest();
        LoginRequest loginRequest1 = loginRequest.setPassword("sss").setRememberMe(true);
        System.out.println(loginRequest);
        System.out.println(loginRequest1);
        System.out.println(loginRequest.equals(loginRequest1));

    }
}