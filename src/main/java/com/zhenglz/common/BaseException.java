package com.zhenglz.common;

import com.zhenglz.common.resultmodel.Status;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
* @Description: 异常基类
* @Author: zlz
* @Date: 2021/3/24
* @Version:
*/
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 7502914629240225953L;
    private Integer code;
    private String message;
    private Object data;

    public BaseException(Status status) {
        super(status.getMessage());
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public BaseException(Status status, Object data) {
        this(status);
        this.data = data;
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BaseException(Integer code, String message, Object data) {
        this(code, message);
        this.data = data;
    }
}
