package com.zhenglz.mapper;

import com.zhenglz.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/*
 * @Description: 角色
 * @Author: zlz
 * @Date: 2021/1/24
 **/
@Mapper
public interface RoleMapper {

    List<Role> selectByUserId(@Param("userId") Long userId);

}
