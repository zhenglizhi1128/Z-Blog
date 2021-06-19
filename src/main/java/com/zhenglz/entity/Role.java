package com.zhenglz.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: 角色表
 * @author: zlz
 * @date: 2021/3/24
 * @version:
 */
@Data
@Accessors(chain = true)
public class Role implements Serializable {

    private static final long serialVersionUID = -936825425309384586L;
    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
