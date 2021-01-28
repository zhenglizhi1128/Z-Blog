package com.zhenglz.controller;

import cn.hutool.core.collection.CollUtil;
import com.zhenglz.common.resultModel.Result;
import com.zhenglz.common.resultModel.Status;
import com.zhenglz.exception.SecurityException;
import com.zhenglz.service.impl.MonitorService;
import com.zhenglz.utils.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 监控 Controller，在线用户，手动踢出用户等功能
 * </p>
 */
@Slf4j
@RestController
@RequestMapping("/api/monitor")
public class MonitorController {

    @Autowired
    private MonitorService monitorService;

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
        monitorService.kickout(names);
        return Result.success();
    }
}
