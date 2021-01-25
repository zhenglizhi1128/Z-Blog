package com.zhenglz.common.resultModel;

import com.zhenglz.common.BaseException;
import lombok.Data;

import java.io.Serializable;

/**
 * 返回结果
 * @author zhenglizhi
 * @date 2021-1-17
 * @param <T>
 */
@Data
public class Result<T> implements Serializable {

    private final Integer code;

    private final String message;

    private final T data;

    public Result(Status status, T data) {
        this.code = status.code();
        this.message = status.message();
        this.data = data;
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 构造一个自定义的API返回
     *
     * @param code    状态码
     * @param message 返回内容
     * @param data    返回数据
     * @return ApiResponse
     */
    public static Result of(Integer code, String message, Object data) {
        return new Result(code, message, data);
    }

    public static Result success() {
        return new Result(Status.SUCCESS, null);
    }

    public static <T> Result<T> ofStatus(Status status) {
        return new Result(status, null);
    }

    public static <T> Result<T> ofStatus(Status status, T data) {
        return new Result(status, data);
    }

    public static <T> Result<T> success(T data) {
        return new Result(Status.SUCCESS, data);
    }

    public static <T> Result<T> failure(Status status) {
        return new Result(status, null);
    }

    public static <T> Result<T> failure(Status status, T data) {
        return new Result(status, data);
    }

    /**
     * 构造一个异常的API返回
     *
     * @param t   异常
     * @param <T> {@link BaseException} 的子类
     * @return ApiResponse
     */
    public static <T extends BaseException> Result ofException(T t) {
        return of(t.getCode(), t.getMessage(), t.getData());
    }
}
