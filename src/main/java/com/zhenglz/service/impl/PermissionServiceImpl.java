package com.zhenglz.service.impl;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zhenglz.mapper.PermissionMapper;
import com.zhenglz.service.IPermissionService;

/**
 * @author zlz
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Resource
    private PermissionMapper permissionMapper;


}
