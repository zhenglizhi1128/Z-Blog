package com.zhenglz.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: zlz
 * @Date: 2021/01/27/10:48
 * @Description: 权限
 */
@Data
public class Permission implements Serializable {

    private static final long serialVersionUID = 9069053638651545813L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 权限名
     */
    private String name;

    /**
     * 类型为页面时，代表前端路由地址，类型为按钮时，代表后端接口地址
     */
    private String url;

    /**
     * 权限类型，页面-1，按钮-2
     */
    private Integer type;

    /**
     * 权限表达式
     */
    private String permission;

    /**
     * 后端接口访问方式
     */
    private String method;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 父级id
     */
    private Long parentId;
}
