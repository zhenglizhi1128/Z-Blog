package com.zhenglz.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhenglz.common.resultmodel.Result;
import com.zhenglz.common.resultmodel.Status;
import com.zhenglz.dto.LoginRequest;
import com.zhenglz.entity.User;
import com.zhenglz.exception.SecurityException;
import com.zhenglz.service.IUserService;
import com.zhenglz.utils.JwtUtil;
import com.zhenglz.vo.JwtResponse;
import com.zhenglz.vo.UserPrincipal;

import cn.hutool.core.map.MapUtil;

/**
 * @Description: 认证 Controller，包括用户注册，用户登录请求
 * @Author: zlz
 * @Date: 2021/3/24
 * @Version:
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Resource
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private IUserService userService;

    /**
     * 登录
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest) throws Exception {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            loginRequest.getUsernameOrEmailOrPhone(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.createJwt(authentication, loginRequest.getRememberMe());

        UserPrincipal userPrincipal =
            (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        JwtResponse jwtResponse = new JwtResponse(jwt);
        return Result
            .success(MapUtil.builder().put("token", jwtResponse.getToken()).put("tokenType", jwtResponse.getTokenType())
                .put("id", userPrincipal.getId()).put("username", userPrincipal.getUsername())
                .put("roles", userPrincipal.getRoles()).put("authorities", userPrincipal.getAuthorities()).map());
    }

    @PostMapping("/sign-up")
    public Result signup(@RequestBody User user) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.insertUser(user);
        return Result.success();
    }

    /**
     * 退出登录
     * 
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public Result logout(HttpServletRequest request) throws Exception {
        try {
            jwtUtil.invalidateJwt(request);
        } catch (SecurityException e) {
            throw new SecurityException(Status.UNAUTHORIZED);
        }
        return Result.ofStatus(Status.LOGOUT);
    }
}
