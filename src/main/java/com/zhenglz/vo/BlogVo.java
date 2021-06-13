package com.zhenglz.vo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.zhenglz.entity.BlogContent;
import com.zhenglz.entity.Label;
import com.zhenglz.entity.User;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: blogVO
 * @author: zlz
 * @date: 2021/3/24
 * @version:
 */
@Data
@Accessors(chain = true)
public class BlogVo implements Serializable {

    private static final long serialVersionUID = 6500362752075218868L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户
     */
    private User user;

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
    private BlogContent blogContent;

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

    private List<Label> labels;

}
