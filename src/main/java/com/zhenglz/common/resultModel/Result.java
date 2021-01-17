package com.zhenglz.common.resultModel;

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

    public Result (ResultCode resultCode,T data){
       this.code=resultCode.code();
       this.message=resultCode.message();
       this.data=data;
    }

    public static Result success(){
        return new Result(ResultCode.SUCCESS,null);
    }

    public static <T> Result<T> success(T data){
        return new Result(ResultCode.SUCCESS,data);
    }

    public static <T> Result<T> failure(ResultCode resultCode){
        return new Result(resultCode,null);
    }

    public static <T> Result<T> failure(ResultCode resultCode,T data){
        return new Result(resultCode,data);
    }

}
