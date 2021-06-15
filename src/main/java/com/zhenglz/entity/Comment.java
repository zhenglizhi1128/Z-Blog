package com.zhenglz.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @description: 文章评论表
 * @author: zlz
 * @date: 2021/3/24
 * @version:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Comment implements Serializable {

    private static final long serialVersionUID = -5985569330420869905L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 回复的评论ID
     */
    private Long parentId;

    /**
     * 创建日期
     */
    private LocalDateTime createTime;

    /**
     * 修改日期
     */
    private LocalDateTime updateTime;

    /**
     * 文章ID
     */
    private Long blogId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 是否有效，默认为1为有效，0为无效
     */
    private Boolean status;

    /**
     * 是否已读，默认为0 未读，为1已读
     */
    private Boolean isRead;

}