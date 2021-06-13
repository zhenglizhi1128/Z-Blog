package com.zhenglz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import com.zhenglz.entity.Role;

/**
 * @description: 角色
 * @author: zlz
 * @date: 2021/3/24
 * @version:
 */
@Mapper
public interface RoleMapper {
    /**
     * 根据id删除
     * 
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 新增
     * 
     * @param role
     * @return
     */
    int insert(Role role);

    /**
     * 根据id获取
     * 
     * @param id
     * @return
     */
    Role getRoleById(Long id);

    /**
     * 部分更新
     * 
     * @param role
     * @return
     */
    int updatePrimaryById(Role role);

    /**
     * 更新
     * 
     * @param role
     * @return
     */
    int updateById(Role role);

    /**
     * 根据userId 获取用户所有角色
     * 
     * @param userId
     * @return
     */
    List<Role> listRolesByUserId(@Param("userId") Long userId);

    /**
     * 根据userId删除
     * 
     * @param userId
     * @return
     */
    int deleteByUserId(Long userId);

    /**
     * 删除部分权限
     * 
     * @param userId
     * @param ids
     * @return
     */
    int deleteByUserIdAndIds(Long userId, List<Long> ids);

    /**
     * 增加角色
     * 
     * @param userId
     * @param roleId
     */
    void insertByUserId(long userId, long roleId);

}
