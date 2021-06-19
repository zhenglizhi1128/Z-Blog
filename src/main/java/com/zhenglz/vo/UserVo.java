package com.zhenglz.vo;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.zhenglz.entity.Role;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户设置VO
 * @author zlz
 */
@Data
@Accessors(chain = true)
public class UserVo {

    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
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
     * 状态
     */
    private Boolean status;

    /**
     * 在线状态，
     */
    private Boolean onlineStatus;

    /**
     * 发布文章数
     */
    private Integer blogNum;

    private List<Role> roles;

    private List<Long> roleIds;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 手机号
     */
    private String phone;

}
