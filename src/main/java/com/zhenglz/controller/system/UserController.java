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
