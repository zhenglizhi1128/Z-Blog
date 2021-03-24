package com.zhenglz.mapper;

import com.zhenglz.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
* @description: 权限
* @author: zlz
* @date: 2021/3/24
* @version:
*/
@Mapper
public interface PermissionMapper {
    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 新增
     * @param record
     * @return
     */
    int insert(Permission record);

    /**
     * 根据id获取权限
     * @param id
     * @return
     */
    Permission getPermissionById(Long id);

    /**
     * 部分更新
     * @param permission
     * @return
     */
    int updatePrimaryById(Permission permission);

    /**
     * 更新
     * @param permission
     * @return
     */
    int updateById(@Param("record") Permission permission);

    /**
     * 根据用户角色id 获取权限
     * @param roleIds
     * @return
     */
    List<Permission> selectByRoleIdList(@Param("roleIds")List<Long> roleIds);

}
