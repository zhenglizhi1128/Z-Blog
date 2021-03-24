package com.zhenglz.service.impl;

import com.zhenglz.entity.Permission;
import com.zhenglz.entity.Role;
import com.zhenglz.entity.User;
import com.zhenglz.mapper.PermissionMapper;
import com.zhenglz.mapper.RoleMapper;
import com.zhenglz.mapper.UserMapper;
import com.zhenglz.vo.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
* @description: 自定义UserDetails查询
* @author: zlz
* @date: 2021/3/24
* @version:
*/
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmailOrPhone) throws UsernameNotFoundException {
        User user = userMapper.findByUsernameOrEmailOrPhone(usernameOrEmailOrPhone, usernameOrEmailOrPhone, usernameOrEmailOrPhone);
        if(user == null){
            throw new UsernameNotFoundException("用户不存在!");
        }
        List<Role> roles= new ArrayList<>();
        List<Permission> permissions= new ArrayList<>();
        roles = roleMapper.listRolesByUserId(user.getId());
        List<Long> roleIds = roles.stream().map(Role::getId).collect(Collectors.toList());
        permissions = permissionMapper.selectByRoleIdList(roleIds);
        return UserPrincipal.create(user, roles, permissions);
    }
}
