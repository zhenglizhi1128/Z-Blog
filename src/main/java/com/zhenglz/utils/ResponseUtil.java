package com.zhenglz.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.zhenglz.common.BaseException;
import com.zhenglz.common.resultmodel.Result;
import com.zhenglz.common.resultmodel.Status;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * Response 通用工具类
 * </p>
 *
 */
@Slf4j
public class ResponseUtil {

    /**
     * 往 response 写出 json
     *
     * @param response
     *            响应
     * @param status
     *            状态
     * @param data
     *            返回数据
     */
    public static void renderJson(HttpServletResponse response, Status status, Object data) {
        try {
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(200);
            response.getWriter().write(JSONUtil.toJsonStr(new JSONObject(Result.ofStatus(status, data), false)));
        } catch (IOException e) {
            log.error("Response写出JSON异常，", e);
        }
    }

    /**
     * 往 response 写出 json
     *
     * @param response
     *            响应
     * @param exception
     *            异常
     */
    public static void renderJson(HttpServletResponse response, BaseException exception) {
        try {
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(200);
            response.getWriter().write(JSONUtil.toJsonStr(new JSONObject(Result.ofException(exception), false)));
        } catch (IOException e) {
            log.error("Response写出JSON异常，", e);
        }
    }
}
