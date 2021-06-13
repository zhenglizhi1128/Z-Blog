package com.zhenglz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zhenglz.entity.User;

/**
 * @description: 用户
 * @author: zlz
 * @date: 2021/3/24
 * @version:
 */
@Mapper
public interface UserMapper {

    /**
     * 根据id删除用户
     * 
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 新增用户
     * 
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 根据id 获取用户
     * 
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 部分更新
     * 
     * @param user
     * @return
     */
    int updatePrimaryById(User user);

    /**
     * 更新user
     * 
     * @param user
     * @return
     */
    int updateById(User user);

    /**
     * 获取user集合
     * 
     * @return
     */
    List<User> listUsers();

    /**
     * 根据用户名、邮箱、手机号查询用户
     *
     * @param username
     *            用户名
     * @param email
     *            邮箱
     * @param phone
     *            手机号
     * @return 用户信息
     */
    User findByUsernameOrEmailOrPhone(@Param("username") String username, @Param("email") String email,
        @Param("phone") String phone);

    /**
     * 获取用户总数
     * 
     * @return
     */
    int countUser();

}
