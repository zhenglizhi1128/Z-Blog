package com.zhenglz.service;

import java.util.List;

import com.zhenglz.dto.PageCondition;
import com.zhenglz.entity.Blog;
import com.zhenglz.vo.BlogVo;

/**
 * @description:
 * @author: zlz
 * @date: 2021/3/24
 * @version:
 */
public interface IBlogService {

    /**
     * 获取blogs
     * 
     * @param pageCondition
     * @return
     */
    List<Blog> getBlogs(PageCondition pageCondition);

    /**
     * 根据id查询
     * 
     * @param id
     * @return
     */
    Blog getBlogById(long id);

    /**
     * 新增
     * 
     * @param blog
     * @return
     */
    int insert(BlogVo blog);

    /**
     * 修改
     * 
     * @param blogVo
     * @return
     */
    int updateByPrimaryKey(BlogVo blogVo);

    /**
     * 根据状态、名称、标签获取文章列表
     * 
     * @param title
     * @param labelId
     * @param status
     * @param pageCondition
     * @return
     */
    List<BlogVo> getBlogsByTitleAndStatus(String title, Long labelId, Integer status, PageCondition pageCondition);

    /**
     * 删除一篇文章
     * @param blogId
     */
    void deleteBlog(long blogId);

    /**
     * 修改状态
     * @param blogId
     * @param status
     */
    void updateStatus(long blogId,int status);

    /**
     * 修改评论开关
     * @param blogId
     * @param commentStatus
     */
    void updateCommentStatus(long blogId,int commentStatus);
}
