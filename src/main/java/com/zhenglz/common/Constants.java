package com.zhenglz.common;

/**
 * @description:常量池
 * @author: zlz
 * @date: 2021/3/24
 * @version:
 */
public interface Constants {
    /**
     * 启用
     */
    Integer ENABLE = 1;
    /**
     * 禁用
     */
    Integer DISABLE = 0;

    Boolean TRYE = true;

    Boolean FALSE = false;

    /**
     * 页面
     */
    Integer PAGE = 1;

    /**
     * 按钮
     */
    Integer BUTTON = 2;

    /**
     * JWT 在 Redis 中保存的key前缀
     */
    String REDIS_JWT_KEY_PREFIX = "security:jwt:";

    /**
     * 星号
     */
    String SYMBOL_STAR = "*";

    /**
     * 邮箱符号
     */
    String SYMBOL_EMAIL = "@";

    /**
     * 匿名用户 用户名
     */
    String ANONYMOUS_NAME = "匿名用户";

    /**
     * int型过滤条件：所有
     */
    int ALL = -100;

    /**
     * int型过滤条件：未分配
     */
    int NONE = -99;

    /**
     * string型过滤条件：全部
     */
    String STRING_ALL = "ALL";

    /**
     * string型过滤条件：未分配
     */
    String STRING_NONE = "";

}
