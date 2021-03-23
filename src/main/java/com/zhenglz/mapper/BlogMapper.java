package com.zhenglz.mapper;

import com.zhenglz.entity.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: zlz
 * @Date: 2021/03/19/16:34
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

    List<Blog> listByAll(Blog blog);

    List<Blog> list();
}