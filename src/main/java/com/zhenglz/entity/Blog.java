package com.zhenglz.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Description: 博客信息
 * @Author: zlz
 * @Date: 2021/3/24
 * @Version:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Blog implements Serializable {

    private static final long serialVersionUID = 3226600408091340446L;

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
     * 内容Id
     */
    private Long contentId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 阅读数
     */
    private Long readNumber;

    /**
     * 点赞数
     */
    private Long likeNumber;

    /**
     * 评论数
     */
    private Long commentNumber;

    /**
     * 状态
     */
    private Boolean status;

    /**
     * 评论状态
     */
    private Boolean commentStatus;

    private User user;

    private BlogContent blogContent;

}