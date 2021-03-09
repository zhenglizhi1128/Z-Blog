package com.zhenglz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Auther: zlz
 * @Date: 2021/01/27/16:55
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Blog implements Serializable {

    private static final long serialVersionUID = -2846018628963767853L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 标题
     */
    private String title;

    /**
     * 摘要
     */
    private String description;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    private LocalDateTime createTime=LocalDateTime.now();

    /**
     * 更新时间
     */
    private LocalDateTime updateTime=LocalDateTime.now();

    /**
     * 状态
     */
    private int status=0;
}