package com.zhenglz.service;

import com.zhenglz.dto.PageCondition;
import com.zhenglz.entity.Blog;

import java.util.List;

/**
* @description:
* @author: zlz
* @date: 2021/3/24
* @version:
*/
public interface IBlogService {

    /**
     * 获取blogs
     * @param pageCondition
     * @return
     */
    List<Blog> getBlogs(PageCondition pageCondition);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Blog getBlogById(long id);

    /**
     * 新增
     * @param blog
     * @return
     */
    int insert(Blog blog);

    /**
     * 修改
     * @param blog
     * @return
     */
    int updateByPrimaryKey(Blog blog);

}
