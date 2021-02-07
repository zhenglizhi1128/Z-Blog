package com.zhenglz.mapper;

import com.zhenglz.entity.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: zlz
 * @Date: 2021/01/27/16:55
 * @Description:
 */
@Mapper
public interface BlogMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Blog blog);

    int insertSelective(Blog blog);

    Blog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Blog blog);

    int updateByPrimaryKey(Blog blog);

    List<Blog> listByAll(Blog blog);

    List<Blog> list();

}