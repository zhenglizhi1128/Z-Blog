package com.zhenglz.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zhenglz.entity.BlogContent;

/**
 * @description: 博客内容
 * @author: zlz
 * @date: 2021/3/24
 * @version:
 */
@Mapper
public interface BlogContentMapper {
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
     * @param blogContent
     * @return
     */
    int insert(BlogContent blogContent);

    /**
     * 根据id查询
     * 
     * @param id
     * @return
     */
    BlogContent getBlogContentById(Long id);

    /**
     * 部分更新
     * 
     * @param blogContent
     * @return
     */
    int updatePrimaryById(BlogContent blogContent);

    /**
     * 更新
     * 
     * @param blogContent
     * @return
     */
    int updateById(BlogContent blogContent);

    /**
     * 根据userId删除
     * 
     * @param userId
     * @return
     */
    int deleteByUserId(Long userId);
}