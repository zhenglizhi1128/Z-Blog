package com.zhenglz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/*
 * @Description: 文章评论表
 * @Author: zlz
 * @Date: 2021/3/7
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Comment implements Serializable {

    private static final long serialVersionUID = 9140641146124832341L;

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
    private int status;

}