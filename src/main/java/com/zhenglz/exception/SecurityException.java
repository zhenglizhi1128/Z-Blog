package com.zhenglz.exception;

import com.zhenglz.common.BaseException;
import com.zhenglz.common.resultmodel.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* @description: 全局异常
* @author: zlz
* @date: 2021/3/24
* @version:
*/
@EqualsAndHashCode(callSuper = true)
@Data
public class SecurityException extends BaseException {
    public SecurityException(Status status) {
        super(status);
    }

    public SecurityException(Status status, Object data) {
        super(status, data);
    }

    public SecurityException(Integer code, String message) {
        super(code, message);
    }

    public SecurityException(Integer code, String message, Object data) {
        super(code, message, data);
    }
}
