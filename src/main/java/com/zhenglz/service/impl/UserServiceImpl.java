package com.zhenglz.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhenglz.common.Constants;
import com.zhenglz.dto.PageCondition;
import com.zhenglz.entity.User;
import com.zhenglz.mapper.BlogContentMapper;
import com.zhenglz.mapper.BlogMapper;
import com.zhenglz.mapper.RoleMapper;
import com.zhenglz.mapper.UserMapper;
import com.zhenglz.service.IUserService;
import com.zhenglz.vo.UserVo;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;

/**
 * @author zlz
 */
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

    //TODO
    @Override
    public PageInfo<UserVo> getUserPage(Boolean status, Long roleId, String userNameOrPhone, PageCondition pageCondition) throws RuntimeException {
        PageHelper.startPage(pageCondition.getCurrentPage(), pageCondition.getPageSize(), pageCondition.getOrderType());
        List<UserVo> userVos = userMapper.listUsersForSet(status, roleId, userNameOrPhone);
        for (UserVo userVo : userVos) {
            userVo.setBlogNum(1)
                        .setOnlineStatus(stringRedisTemplate.hasKey(Constants.REDIS_JWT_KEY_PREFIX + userVo.getUsername()))
            .setLastTime(LocalDateTime.now())
            .setIp("127.0.0.1");
        }
        PageInfo pageInfo = new PageInfo(userVos);
        return pageInfo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(Long userId) throws RuntimeException {
        roleMapper.deleteByUserId(userId);
        blogContentMapper.deleteByUserId(userId);
        blogMapper.deleteByUserId(userId);
        userMapper.deleteById(userId);
    }

    @Override
    @Transactional
    public void updateUser(UserVo userVo) throws RuntimeException {
        User user = new User();
        user.setId(userVo.getId()).setStatus(userVo.getStatus()).setUpdateTime(LocalDateTime.now());
        userMapper.updatePrimaryById(user);
        List<Long> collect =
            roleMapper.listRolesByUserId(user.getId()).stream().map(x -> x.getId()).collect(Collectors.toList());
        List<Long> insertIds =
            collect.stream().filter(x -> !userVo.getRoleIds().contains(x)).collect(Collectors.toList());
        List<Long> deleteIds =
            userVo.getRoleIds().stream().filter(x -> !collect.contains(x)).collect(Collectors.toList());
        for (Long insertId : insertIds) {
            roleMapper.insertByUserId(user.getId(), insertId);
        }
    }

    //TODO
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertUser(User user) throws RuntimeException {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPhone(RandomUtil.randomNumbers(11))
                .setNickname(RandomUtil.randomNumbers(5))
                .setSex(1)
                .setEmail(RandomUtil.randomNumbers(7)+"163.com")
                .setCreateTime(LocalDateTime.now())
                .setUpdateTime(LocalDateTime.now())
                .setStatus(true)
                .setBirthday(new Date());
        userMapper.insert(user);
        roleMapper.insertByUserId(user.getId(), 2L);
    }

    @Override
    public void logout(String username) throws RuntimeException {
        stringRedisTemplate.delete(Constants.REDIS_JWT_KEY_PREFIX + username);
    }

    @Override
    public List<UserVo> getOnlineUsers() throws RuntimeException {
        Set<String> keys = stringRedisTemplate.keys(Constants.REDIS_JWT_KEY_PREFIX + "*");
        List<String> userNames = new ArrayList<>();
        for (String key : keys) {
            userNames.add(StrUtil.removePrefix(key,Constants.REDIS_JWT_KEY_PREFIX));
        }
        List<UserVo> userVos = new ArrayList<>();
        if(userNames.size()>0){
            List<User> users = userMapper.listUsersByNames(userNames);
            for (User user : users) {
                UserVo userVo = new UserVo();
                userVo.setUsername(user.getUsername())
                        .setId(user.getId())
                        .setPhone(user.getPhone())
                        .setNickname(user.getNickname())
                        .setLastTime(LocalDateTime.now()); //TODO
                userVos.add(userVo);
            }
        }
        return userVos;
    }
}
