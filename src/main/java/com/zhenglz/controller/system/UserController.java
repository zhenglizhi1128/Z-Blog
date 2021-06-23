package com.zhenglz.controller.system;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zhenglz.common.resultmodel.Result;
import com.zhenglz.dto.PageCondition;
import com.zhenglz.entity.Role;
import com.zhenglz.service.IRoleService;
import com.zhenglz.service.IUserService;
import com.zhenglz.vo.UserVo;

/**
 * 用户设置
 * @author zlz
 */
@RestController
@RequestMapping("/user/set")
public class UserController {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Resource
    private IUserService userService;

    @Resource
    private IRoleService roleService;

    @GetMapping("/users")
    public Result getUsers(Boolean status, Long roleId, String userNameOrPhone, PageCondition pageCondition) throws RuntimeException {
        PageInfo<UserVo> pageInfo = userService.getUserPage(status, roleId,userNameOrPhone , pageCondition);
        List<Role> roles = roleService.listRoles();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("pageInfo",pageInfo);
        jsonObject.put("roles",roles);
        return Result.success(jsonObject);
    }

    /**
     * 修改用户信息
     * @param userVo
     * @return
     * @throws RuntimeException
     */
    @PutMapping("/user")
    public Result updateUser(UserVo userVo) throws RuntimeException {
        userService.updateUser(userVo);
        return Result.success();
    }

    /**
     * 删除用户
     * @param userId
     * @return
     * @throws RuntimeException
     */
    @DeleteMapping("/delete")
    public Result deleteUser(long userId) throws RuntimeException {
        userService.deleteUser(userId);
        return Result.success();
    }

    /**
     * 修改用户状态
     * @param userId
     * @param status
     * @return
     * @throws RuntimeException
     */
    @PutMapping("/changeStatus")
    public Result changeStatus(long userId,Boolean status) throws RuntimeException {

        return Result.success();
    }

    /**
     * 获取在线用户
     * @return
     * @throws RuntimeException
     */
    @GetMapping("/onlineUser")
    public Result onlineUser() throws RuntimeException {
        List<UserVo> userVos = userService.getOnlineUsers();
        return Result.success(userVos);
    }

    /**
     * 强制退出
     * @param username
     * @return
     * @throws RuntimeException
     */
    @DeleteMapping ("/logout")
    public Result logout(String username) throws RuntimeException {
        userService.logout(username);
        return Result.success();
    }



}
