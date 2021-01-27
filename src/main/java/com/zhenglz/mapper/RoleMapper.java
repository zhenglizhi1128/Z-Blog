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

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectByUserId(@Param("userId") Long userId);

}
