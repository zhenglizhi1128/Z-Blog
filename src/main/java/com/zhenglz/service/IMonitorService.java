package com.zhenglz.service;

import java.util.List;

/**
 * @Auther: zlz
 * @Date: 2021/01/29/12:55
 * @Description:
 */
public interface IMonitorService {
    
    /**
     * 踢出在线用户
     * @param names 用户名列表
     */
    void kicked(List<String> names);
}
