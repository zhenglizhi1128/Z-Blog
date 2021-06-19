package com.zhenglz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zhenglz.entity.Role;
import com.zhenglz.mapper.RoleMapper;
import com.zhenglz.service.IRoleService;

/**
 * @author zlz
 */
@Service
public class RoleServiceImpl implements IRoleService {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Resource
    private RoleMapper roleMapper;

    public List<Role> listRoles() throws RuntimeException{
        return roleMapper.listRoles();
    }

}
