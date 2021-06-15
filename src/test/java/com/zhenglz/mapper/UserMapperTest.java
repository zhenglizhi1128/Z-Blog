package com.zhenglz.mapper;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhenglz.common.resultmodel.Result;
import com.zhenglz.dto.PageCondition;
import com.zhenglz.entity.User;
import com.zhenglz.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    UserMapper userMapper;

    @Resource
    private IUserService userService;

    @Test
    public void queryUserList() {
        List<User> users = userMapper.listUsers();
        System.out.println(users);
    }

    @Test
    public void userVoList() {
        PageCondition pageCondition = new PageCondition();
        pageCondition.setCurrentPage(1);
        pageCondition.setPageSize(1);
        pageCondition.setOrderType("id");
        PageHelper.startPage(pageCondition.getCurrentPage(), pageCondition.getPageSize(), pageCondition.getOrderType());
        List<User> users = userMapper.listUsers();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        Result.success(pageInfo);
        System.out.println(users);
    }

    @Test
    public void findByUsernameOrEmailOrPhone() {
        User user = new User();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("123456");
        System.out.println(password);
        user.setUsername("z3").setNickname("z3").setStatus(1).setBirthday(785433600100l).setEmail("1113311@163.com")
            .setPhone("15333626141").setPassword(password).setSex(1).setCreateTime(LocalDateTime.now())
            .setUpdateTime(LocalDateTime.now());
        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user.getId());
    }

    @Test
    public void findByUsername() {
        String password = "123456";
        String password1 = "$2a$10$DJVHOmBjLktuLpFZFRd8w.o8Wm8ycI3lgbBRx4eXhkVWflwxXQt/i";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String newPassword = bCryptPasswordEncoder.encode(password);
        boolean matches = bCryptPasswordEncoder.matches(password, newPassword);
        boolean matches1 = bCryptPasswordEncoder.matches(password, password1);
        System.out.println(matches);
        System.out.println(matches1);

    }
}