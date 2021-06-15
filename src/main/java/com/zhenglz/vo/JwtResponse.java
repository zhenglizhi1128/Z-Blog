package com.zhenglz.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: JWT 响应返回
 * @author: zlz
 * @date: 2021/3/24
 * @version:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
    /**
     * token 字段
     */
    private String token;
    /**
     * token类型
     */
    private String tokenType = "Bearer";

    public JwtResponse(String token) {
        this.token = token;
    }
}
