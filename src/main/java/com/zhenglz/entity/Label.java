package com.zhenglz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
* @description: 标签表
* @author: zlz
* @date: 2021/3/24
* @version:
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Label implements Serializable {

    private static final long serialVersionUID = -7763449745013062534L;

    /**
    * 主键
    */
    private Long id;

    /**
    * 标签名称
    */
    private String name;

    /**
    * 创建日期
    */
    private LocalDateTime createTime;

    /**
    * 修改日期
    */
    private LocalDateTime updateTime;

    /**
    * 是否有效，默认为1有效，为0无效
    */
    private int status;
}