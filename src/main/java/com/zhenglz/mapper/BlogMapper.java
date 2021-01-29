package com.zhenglz.mapper;

import com.zhenglz.entity.Blog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: zlz
 * @Date: 2021/01/27/16:55
 * @Description:
 */
@Mapper
public interface BlogMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKey(Blog record);

}