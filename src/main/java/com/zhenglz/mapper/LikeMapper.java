package com.zhenglz.mapper;

import com.zhenglz.entity.Like;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: zlz
 * @Date: 2021/03/09/18:28
 * @Description: 
 */
@Mapper
public interface LikeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Like record);

    int insertSelective(Like record);

    Like selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Like record);

    int updateByPrimaryKey(Like record);
}