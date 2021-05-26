package com.zhenglz.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhenglz.dto.PageCondition;
import com.zhenglz.entity.User;
import com.zhenglz.mapper.BlogContentMapper;
import com.zhenglz.mapper.BlogMapper;
import com.zhenglz.mapper.RoleMapper;
import com.zhenglz.mapper.UserMapper;
import com.zhenglz.service.IUserService;
import com.zhenglz.vo.UserVo;

import cn.hutool.core.bean.BeanUtil;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private BlogMapper blogMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private BlogContentMapper blogContentMapper;

    @Override
    public PageInfo<UserVo> getUserPage(PageCondition pageCondition) throws RuntimeException {
        PageHelper.startPage(pageCondition.getCurrentPage(), pageCondition.getPageSize(), pageCondition.getOrderType());
        List<User> users = userMapper.listUsers();
        List<UserVo> userVos = new ArrayList<>();
        for (User user : users) {
            UserVo userVo = new UserVo();
            BeanUtil.copyProperties(user, userVo);
            userVo.setRoles(roleMapper.listRolesByUserId(user.getId()));
            userVo.setLastTime(LocalDateTime.now()).setOnlineStatus(0)
                // .setOnlineStatus((stringRedisTemplate.hasKey(Constants.REDIS_JWT_KEY_PREFIX + user.getUsername()) ? 1
                // : 0))
                .setBlogNum(blogMapper.countByUserId(user.getId()));
            userVos.add(userVo);
        }
        PageInfo pageInfo = new PageInfo(users);
        pageInfo.setList(userVos);
        return pageInfo;
    }

    @Override
    public void deleteUser(Long userId) throws RuntimeException{
        roleMapper.deleteByUserId(userId);
        blogContentMapper.deleteByUserId(userId);
        blogMapper.deleteByUserId(userId);
        userMapper.deleteById(userId);
    }

    @Override
    public void updateUser(UserVo userVo) throws RuntimeException{
        User user = new User();
        user.setId(userVo.getId()).setStatus(userVo.getStatus()).setUpdateTime(LocalDateTime.now());
        userMapper.updatePrimaryById(user);
        List<Long> collect = roleMapper.listRolesByUserId(user.getId()).stream().map(x -> x.getId()).collect(Collectors.toList());
        List<Long> insertIds = collect.stream().filter(x -> !userVo.getRoleIds().contains(x)).collect(Collectors.toList());
        List<Long> deleteIds = userVo.getRoleIds().stream().filter(x -> !collect.contains(x)).collect(Collectors.toList());
        for (Long insertId : insertIds) {
            roleMapper.insertByUserId(user.getId(), insertId);
        }

    }

}
