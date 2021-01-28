package com.zhenglz.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 登录请求参数
 * </p>
 */
@Data
@Accessors(chain = true)
public class LoginRequest {

    /**
     * 用户名或邮箱或手机号
     */
    private String usernameOrEmailOrPhone;

    /**
     * 密码
     */
    private String password;

    /**
     * 记住我
     */
    private Boolean rememberMe = false;


}
