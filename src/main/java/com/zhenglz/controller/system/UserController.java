package com.zhenglz.controller.system;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.zhenglz.common.resultmodel.Result;
import com.zhenglz.dto.PageCondition;
import com.zhenglz.service.IUserService;
import com.zhenglz.vo.UserVo;

/**
 * 用户设置
 * @author zlz
 */
@RestController
@RequestMapping("/userSet")
public class UserController {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Resource
    private IUserService userService;

    @GetMapping("/users")
    public Result getUsers(PageCondition pageCondition) throws RuntimeException {
        PageInfo<UserVo> pageInfo = userService.getUserPage(pageCondition);
        return Result.success(pageInfo);
    }

    @PutMapping("/user")
    public Result updateUser(UserVo userVo) throws RuntimeException {
        userService.updateUser(userVo);
        return Result.success();
    }

    @DeleteMapping("/user")
    public Result deleteUser(long id) throws RuntimeException {
        userService.deleteUser(id);
        return Result.success();
    }

}
