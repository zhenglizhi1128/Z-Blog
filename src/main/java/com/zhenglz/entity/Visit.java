package com.zhenglz.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @description:文章阅读量表
 * @author: zlz
 * @date: 2021/3/24
 * @version:
 */
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class Visit implements Serializable {

    private static final long serialVersionUID = -5387905910852820184L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 访问IP
     */
    private String ip;

    /**
     * 第一次访问时间
     */
    private LocalDateTime createTime;

    /**
     * 最近访问时间
     */
    private LocalDateTime updateTime;

    /**
     * 文章ID
     */
    private Long blogId;

}