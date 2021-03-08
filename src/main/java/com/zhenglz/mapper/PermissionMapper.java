package com.zhenglz.mapper;

import com.zhenglz.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/*
 * @Description: 权限
 * @Author: zlz
 * @Date: 2021/1/24
 **/
@Mapper
public interface PermissionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(@Param("record") Permission record);

    List<Permission> selectByRoleIdList(@Param("roleIds")List<Long> roleIds);


}
