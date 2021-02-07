package com.zhenglz.service;

import com.zhenglz.dto.PageCondition;
import com.zhenglz.entity.Blog;

import java.util.List;

/**
 * @Auther: zlz
 * @Date: 2021/01/29/13:11
 * @Description:
 */
public interface IBlogService {

    List<Blog> getBlogs(PageCondition pageCondition);

    Blog getBlogById(long id);

    int insert(Blog blog);

    int updateByPrimaryKey(Blog blog);

}
