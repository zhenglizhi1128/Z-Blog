package com.zhenglz.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenglz.common.Constants;
import com.zhenglz.mapper.UserMapper;
import com.zhenglz.service.IMonitorService;
import com.zhenglz.utils.RedisUtil;
import com.zhenglz.utils.SecurityUtil;

/**
 * @description:监控 Service
 * @author: zlz
 * @date: 2021/3/24
 * @version:
 */
@Service
public class MonitorServiceImpl implements IMonitorService {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    private RedisUtil redisUtil;

    @Resource
    private UserMapper userMapper;

    /**
     * 在线用户分页列表
     *
     * @param pageCondition
     *            分页参数
     * @return 在线用户分页列表
     */
    /*public PageResult<OnlineUser> onlineUser(PageCondition pageCondition) {
        PageResult<String> keys = redisUtil.findKeysForPage(Consts.REDIS_JWT_KEY_PREFIX + Consts.SYMBOL_STAR, pageCondition.getCurrentPage(), pageCondition.getPageSize());
        List<String> rows = keys.getRows();
        Long total = keys.getTotal();
    
        // 根据 redis 中键获取用户名列表
        List<String> usernameList = rows.stream().map(s -> StrUtil.subAfter(s, Consts.REDIS_JWT_KEY_PREFIX, true)).collect(Collectors.toList());
        // 根据用户名查询用户信息
        List<User> userList = userMapper.findByUsernameIn(usernameList);
    
        // 封装在线用户信息
        List<OnlineUser> onlineUserList = Lists.newArrayList();
        userList.forEach(user -> onlineUserList.add(OnlineUser.create(user)));
    
        return new PageResult<>(onlineUserList, total);
    }*/

    @Override
    public void kicked(List<String> names) {
        // 清除 Redis 中的 JWT 信息
        List<String> redisKeys =
            names.parallelStream().map(s -> Constants.REDIS_JWT_KEY_PREFIX + s).collect(Collectors.toList());
        redisUtil.delete(redisKeys);

        // 获取当前用户名
        String currentUsername = SecurityUtil.getCurrentUsername();
        names.parallelStream().forEach(name -> {
            logger.debug("用户【{}】被用户【{}】手动下线！", name, currentUsername);
        });
    }
}
