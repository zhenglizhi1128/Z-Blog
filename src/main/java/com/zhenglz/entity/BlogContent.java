package com.zhenglz.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @description: 博客内容
 * @author: zlz
 * @date: 2021/3/24
 * @version:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BlogContent implements Serializable {

    private static final long serialVersionUID = 4293084691846979425L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 内容
     */
    private String content;

}