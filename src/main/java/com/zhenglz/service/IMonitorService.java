package com.zhenglz.service;

import java.util.List;

/**
* @description:
* @author: zlz
* @date: 2021/3/24
* @version:
*/
public interface IMonitorService {
    
    /**
     * 踢出在线用户
     * @param names 用户名列表
     */
    void kicked(List<String> names);
}
