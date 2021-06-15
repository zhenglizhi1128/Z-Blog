package com.zhenglz.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: 权限表
 * @author: zlz
 * @date: 2021/3/24
 * @version:
 */
@Data
@Accessors(chain = true)
public class Permission implements Serializable {

    private static final long serialVersionUID = 9069053638651545813L;
    /**
     * 主键
     */
    public Long id;

    /**
     * 权限名
     */
    public String name;

    /**
     * 类型为页面时，代表前端路由地址，类型为按钮时，代表后端接口地址
     */
    public String url;

    /**
     * 权限类型，页面-1，按钮-2
     */
    public Integer type;

    /**
     * 权限表达式
     */
    public String permission;

    /**
     * 后端接口访问方式
     */
    public String method;

    /**
     * 排序
     */
    public Integer sort;

    /**
     * 父级id
     */
    public Long parentId;
}
