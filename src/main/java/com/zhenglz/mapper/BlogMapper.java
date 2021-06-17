package com.zhenglz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zhenglz.entity.Blog;
import com.zhenglz.vo.BlogVo;

/**
 * @description: 博客Mapper
 * @author: zlz
 * @date: 2021/3/24
 * @version:
 */
@Mapper
public interface BlogMapper {

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 新增
     *
     * @param blog
     * @return
     */
    int insert(Blog blog);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Blog getBlogById(Long id);

    /**
     * 部分更新
     *
     * @param blog
     * @return
     */
    int updatePrimaryById(Blog blog);

    /**
     * 更新
     *
     * @param blog
     * @return
     */
    int updateById(Blog blog);

    /**
     * 获取blog集合
     *
     * @return
     */
    List<Blog> listBlogs();

    /**
     * 用户的发布文章总数
     * 
     * @param userId
     * @return
     */
    Integer countByUserId(long userId);

    /**
     * 获取blog集合
     * 
     * @param userId
     * @return
     */
    List<Blog> listBlogsByUserId(long userId);

    /**
     * 根据userId删除
     *
     * @param userId
     * @return
     */
    int deleteByUserId(Long userId);

    /**
     * 文章总数
     *
     * @return
     */
    Integer countBlog();

    /**
     * 根据状态、名称、标签获取文章列表
     *
     * @param title
     * @param labelId
     * @param status
     * @return
     */
    List<BlogVo> getBlogsByTitleAndStatus(@Param("title") String title, @Param("labelId") Long labelId,
        @Param("status") Boolean status);

}