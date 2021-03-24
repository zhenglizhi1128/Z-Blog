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
* @description: 
* @author: zlz 
* @date: 2021/3/24
* @version:       
*/
@Service
public class BlogServiceImpl implements IBlogService {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);


    @Resource
    private BlogMapper blogMapper;

    @Resource
    private BlogContentMapper blogContentMapper;


    @Override
    public List<Blog> getBlogs(PageCondition pageCondition) throws RuntimeException {
        PageHelper.startPage(pageCondition.getCurrentPage(), pageCondition.getPageSize(),pageCondition.getOrderType());
        List<Blog> blogs = blogMapper.listBlogs();
        return blogs;
    }

    @Override
    public Blog getBlogById(long id)throws RuntimeException {
        Blog blog= blogMapper.getBlogById(id);
        BlogContent blogContent =blogContentMapper.getBlogContentById(blog.getContentId());
        return blogMapper.getBlogById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(Blog blog) throws RuntimeException {
        return blogMapper.insert(blog);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKey(Blog blog) throws RuntimeException {
        return blogMapper.updateById(blog);
    }

}
