package com.zhenglz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zhenglz.entity.Blog;

/**
* @description: 博客Mapper
* @author: zlz
* @date: 2021/3/24
* @version:
*/
@Mapper
public interface BlogMapper {

    /**
     *根据id删除
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     *新增
     * @param blog
     * @return
     */
    int insert(Blog blog);

    /**
     *根据id查询
     * @param id
     * @return
     */
    Blog getBlogById(Long id);

    /**
     *部分更新
     * @param blog
     * @return
     */
    int updatePrimaryById(Blog blog);

    /**
     *更新
     * @param blog
     * @return
     */
    int updateById(Blog blog);

    /**
     *获取blog集合
     * @return
     */
    List<Blog> listBlogs();

    Integer countByUserId(long userId);

    /**
     *获取blog集合
     * @return
     */
    List<Blog> listBlogsByUserId(long userId);

    /**
     * 根据userId删除
     * @param userId
     * @return
     */
    int deleteByUserId(Long userId);

}