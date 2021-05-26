package com.zhenglz.vo;

import java.time.LocalDateTime;
import java.util.List;

import com.zhenglz.entity.Role;

import lombok.Data;
import lombok.experimental.Accessors;

/*
 * @Description: 用户设置VO
 * @Author: zlz
 * @Date: 2021/5/17
 **/
@Data
@Accessors(chain = true)
public class UserVo {

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 注册时间
     */
    private LocalDateTime createTime;

    /**
     * 上次登陆时间
     */
    private LocalDateTime lastTime;

    /**
     * 状态，启用-1，禁用-0
     */
    private Integer status;

    /**
     * 在线状态，在线-1，不在线-0
     */
    private Integer onlineStatus;

    /**
     * 发布文章数
     */
    private Integer blogNum;

    private List<Role> roles;

    private List<Long> roleIds;

}
