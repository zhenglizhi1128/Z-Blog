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

    List<Permission> selectByRoleIdList(@Param("ids") List<Long> ids);

}
