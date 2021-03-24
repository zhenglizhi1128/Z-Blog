package com.zhenglz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
* @description: 系统通知表
* @author: zlz
* @date: 2021/3/24
* @version:
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Announcement implements Serializable {

    private static final long serialVersionUID = 7334003507289002390L;

    /**
    * 主键
    */
    private Integer id;

    /**
    * 创建日期
    */
    private LocalDateTime createTime;

    /**
    * 修改日期
    */
    private LocalDateTime updateTime;

    /**
    * 标题
    */
    private String title;

    /**
    * 详情
    */
    private String detail;

    /**
    * 是否有效，默认为1有效，为0无效
    */
    private Boolean status;
}