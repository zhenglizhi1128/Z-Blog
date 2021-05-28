package com.zhenglz.service;

import com.github.pagehelper.PageInfo;
import com.zhenglz.dto.PageCondition;
import com.zhenglz.entity.User;
import com.zhenglz.vo.UserVo;

public interface IUserService {

    /**
     * 获取users
     * @param pageCondition
     * @return
     */
    PageInfo<UserVo>  getUserPage(PageCondition pageCondition);

    /**
     * 删除
     * @param userId
     */
    void deleteUser(Long userId);

    /**
     * 修改用户信息
     * @param userVo
     */
    void updateUser(UserVo userVo);

    /**
     * 新增用户
     * @param user
     */
    void insertUser(User user);

}
