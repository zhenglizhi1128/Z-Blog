package com.zhenglz.common.resultModel;

import lombok.Data;

/**
 * 返回状态码
 *
 * @author zhenglizhi
 * @date
 */
@Data
public enum ResultCode {

    SUCCESS(1, "成功"),
    //参数错误
    PARAM_IS_INVALID(1001, "参数无效"),
    PARAM_IS_BLANK(1002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(1003, "参数类型错误"),
    PARAM_NOT_COMPLETE(1004, "参数缺失"),
    //用户错误
    USER_NOT_LOGGED_IN(2001, "用户未登陆"),
    USER_LOGGED_ERROR(2002, "账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(2003, "账号已被禁用"),
    USER_NOT_EXIST(2004, "用户不存在"),
    USER_HAS_EXISTED(2005, "用户已存在");

    private final Integer code;

    private final String message;

    private ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code(){
        return this.code;
    }

    public String message(){
        return this.message;
    }


}
