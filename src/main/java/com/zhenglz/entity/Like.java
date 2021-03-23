package com.zhenglz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Auther: zlz
 * @Date: 2021/03/09/18:28
 * @Description: 文章点赞
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
    * 是否有效，默认为1为有效，0为无效
    */
    private Boolean status;

    /**
    * 是否已读，默认为0 未读，为1已读
    */
    private Boolean isRead;

}