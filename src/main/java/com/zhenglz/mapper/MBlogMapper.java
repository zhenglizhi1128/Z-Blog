package com.zhenglz.mapper;

import com.zhenglz.entity.MBlog;

/**
 * @Auther: zlz
 * @Date: 2021/03/19/16:34
 * @Description: 
 */
public interface MBlogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MBlog record);

    int insertSelective(MBlog record);

    MBlog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MBlog record);

    int updateByPrimaryKey(MBlog record);
}