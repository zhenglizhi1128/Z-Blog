package com.zhenglz.controller;

import cn.hutool.core.collection.CollUtil;
import com.zhenglz.common.resultmodel.Result;
import com.zhenglz.common.resultmodel.Status;
import com.zhenglz.exception.SecurityException;
import com.zhenglz.service.IMonitorService;
import com.zhenglz.utils.SecurityUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* @description: 监控 Controller，在线用户，手动踢出用户等功能
* @author: zlz
* @date: 2021/3/24
* @version:
*/
@RestController
@RequestMapping("/api/monitor")
public class MonitorController {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    private IMonitorService monitorService;

    /**
     * 在线用户列表
     *
     * @param pageCondition 分页参数
     */
    @GetMapping("/online/user")
    public Result onlineUser() {
        /*PageResult<OnlineUser> pageResult = monitorService.onlineUser(pageCondition);*/
        return Result.success("");
    }

    /**
     * 批量踢出在线用户
     *
     * @param names 用户名列表
     */
    @DeleteMapping("/online/user/kickout")
    public Result kickoutOnlineUser(@RequestBody List<String> names) {
        if (CollUtil.isEmpty(names)) {
            throw new SecurityException(Status.PARAM_NOT_NULL);
        }
        if (names.contains(SecurityUtil.getCurrentUsername())) {
            throw new SecurityException(Status.KICKOUT_SELF);
        }
        monitorService.kicked(names);
        return Result.success();
    }
}
