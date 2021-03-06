package com.zhenglz.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @description: 文章点赞表
 * @author: zlz
 * @date: 2021/3/24
 * @version:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Like implements Serializable {

    private static final long serialVersionUID = -4148564936827358582L;

    /**
     * 主键
     */
    private Long id;

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
     * 是否有效
     */
    private Boolean status;

    /**
     * 是否已读，默认为0 未读，为1已读
     */
    private Boolean isRead;

}