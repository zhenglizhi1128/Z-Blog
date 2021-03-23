package com.zhenglz.service.impl;

import com.github.pagehelper.PageHelper;
import com.zhenglz.dto.PageCondition;
import com.zhenglz.entity.Blog;
import com.zhenglz.entity.BlogContent;
import com.zhenglz.mapper.BlogContentMapper;
import com.zhenglz.mapper.BlogMapper;
import com.zhenglz.service.IBlogService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: zlz
 * @Date: 2021/01/29/13:11
 * @Description:
 */
@Service
public class BlogService implements IBlogService {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);


    @Resource
    private BlogMapper blogMapper;

    @Resource
    private BlogContentMapper blogContentMapper;

    @Override
    @Transactional
    public List<Blog> getBlogs(PageCondition pageCondition) throws RuntimeException {
        PageHelper.startPage(pageCondition.getCurrentPage(), pageCondition.getPageSize(),pageCondition.getOrderType());
        List<Blog> blogs = blogMapper.list();
        return blogs;
    }

    @Override
    public Blog getBlogById(long id) {
        Blog blog= blogMapper.selectByPrimaryKey(id);
        BlogContent blogContent =blogContentMapper.selectByPrimaryKey(blog.getContentId());
        return blogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Blog blog) {
        return blogMapper.insert(blog);
    }

    @Override
    public int updateByPrimaryKey(Blog blog) {
        return blogMapper.updateByPrimaryKey(blog);
    }

}
