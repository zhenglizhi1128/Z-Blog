package com.zhenglz.exception.handler;

import javax.validation.ConstraintViolationException;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.zhenglz.common.BaseException;
import com.zhenglz.common.resultmodel.Result;
import com.zhenglz.common.resultmodel.Status;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:全局统一异常处理
 * @author: zlz
 * @date: 2021/3/24
 * @version:
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handlerException(Exception e) {
        if (e instanceof NoHandlerFoundException) {
            log.error("【全局异常拦截】NoHandlerFoundException: 请求方法 {}, 请求路径 {}", ((NoHandlerFoundException)e).getRequestURL(),
                ((NoHandlerFoundException)e).getHttpMethod());
            return Result.ofStatus(Status.REQUEST_NOT_FOUND);
        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            log.error("【全局异常拦截】HttpRequestMethodNotSupportedException: 当前请求方式 {}, 支持请求方式 {}",
                ((HttpRequestMethodNotSupportedException)e).getMethod(),
                JSONUtil.toJsonStr(((HttpRequestMethodNotSupportedException)e).getSupportedHttpMethods()));
            return Result.ofStatus(Status.HTTP_BAD_METHOD);
        } else if (e instanceof MethodArgumentNotValidException) {
            log.error("【全局异常拦截】MethodArgumentNotValidException", e);
            return Result.of(Status.BAD_REQUEST.getCode(),
                ((MethodArgumentNotValidException)e).getBindingResult().getAllErrors().get(0).getDefaultMessage(),
                null);
        } else if (e instanceof ConstraintViolationException) {
            log.error("【全局异常拦截】ConstraintViolationException", e);
            return Result.of(Status.BAD_REQUEST.getCode(),
                CollUtil.getFirst(((ConstraintViolationException)e).getConstraintViolations()).getMessage(), null);
        } else if (e instanceof MethodArgumentTypeMismatchException) {
            log.error("【全局异常拦截】MethodArgumentTypeMismatchException: 参数名 {}, 异常信息 {}",
                ((MethodArgumentTypeMismatchException)e).getName(),
                ((MethodArgumentTypeMismatchException)e).getMessage());
            return Result.ofStatus(Status.PARAM_NOT_MATCH);
        } else if (e instanceof HttpMessageNotReadableException) {
            log.error("【全局异常拦截】HttpMessageNotReadableException: 错误信息 {}",
                ((HttpMessageNotReadableException)e).getMessage());
            return Result.ofStatus(Status.PARAM_NOT_NULL);
        } else if (e instanceof BadCredentialsException) {
            log.error("【全局异常拦截】BadCredentialsException: 错误信息 {}", e.toString());
            return Result.ofStatus(Status.USERNAME_PASSWORD_ERROR);
        } else if (e instanceof DisabledException) {
            log.error("【全局异常拦截】BadCredentialsException: 错误信息 {}", e.getMessage());
            return Result.ofStatus(Status.USER_DISABLED);
        } else if (e instanceof BaseException) {
            log.error("【全局异常拦截】DataManagerException: 状态码 {}, 异常信息 {}", ((BaseException)e).getCode(), e.getMessage());
            return Result.ofException((BaseException)e);
        }

        log.error("【全局异常拦截】: 异常信息 {} ", e.toString(), e);
        return Result.ofStatus(Status.ERROR);
    }
}
