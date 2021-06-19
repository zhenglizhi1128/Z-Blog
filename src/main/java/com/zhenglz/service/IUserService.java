package com.zhenglz.service;

import com.github.pagehelper.PageInfo;
import com.zhenglz.dto.PageCondition;
import com.zhenglz.entity.User;
import com.zhenglz.vo.UserVo;

/**
 * @author zlz
 */
public interface IUserService {

    /**
     * 获取users
     * 
     *
     * @param status
     * @param roleId
     * @param userNameOrPhone
     * @param pageCondition
     * @return
     */
    PageInfo<UserVo> getUserPage(Boolean status, Long roleId, String userNameOrPhone, PageCondition pageCondition);

    /**
     * 删除
     * 
     * @param userId
     */
    void deleteUser(Long userId);

    /**
     * 修改用户信息
     * 
     * @param userVo
     */
    void updateUser(UserVo userVo);

    /**
     * 新增用户
     * 
     * @param user
     */
    void insertUser(User user);

}
