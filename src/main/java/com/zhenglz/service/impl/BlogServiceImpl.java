package com.zhenglz.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.zhenglz.common.Constants;
import com.zhenglz.dto.PageCondition;
import com.zhenglz.entity.Blog;
import com.zhenglz.entity.BlogContent;
import com.zhenglz.mapper.BlogContentMapper;
import com.zhenglz.mapper.BlogMapper;
import com.zhenglz.service.IBlogService;
import com.zhenglz.vo.BlogVo;

import cn.hutool.core.bean.BeanUtil;

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
        PageHelper.startPage(pageCondition.getCurrentPage(), pageCondition.getPageSize()," id desc ");
        List<Blog> blogs = blogMapper.listBlogs();
        return blogs;
    }

    @Override
    public Blog getBlogById(long id)throws RuntimeException {
        Blog blog= blogMapper.getBlogById(id);
        BlogContent blogContent =blogContentMapper.getBlogContentById(blog.getContentId());
        blog.setBlogContent(blogContent);
        return blog;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(BlogVo blogvo) throws RuntimeException {
        Blog blog = new Blog();
        BlogContent blogContent = blogvo.getBlogContent();
        blogContentMapper.insert(blogContent);
        BeanUtil.copyProperties(blogvo, blog);
        blog.setContentId(blogContent.getId())
                .setTitle(blogvo.getTitle())
                .setUserId(blogvo.getUser().getId())
                .setCreateTime(LocalDateTime.now())
                .setUpdateTime(LocalDateTime.now())
                .setStatus(Constants.ENABLE)
                .setLikeNumber(0l)
                .setReadNumber(0l)
                .setCommentNumber(0l);
        return blogMapper.insert(blog);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKey(BlogVo blogVo) throws RuntimeException {
        Blog blog = new Blog();
        blog.setUpdateTime(LocalDateTime.now());
        BeanUtil.copyProperties(blogVo, blog);
        int value = blogMapper.updatePrimaryById(blog);
        blogContentMapper.updatePrimaryById(blogVo.getBlogContent());
        return value;
    }

}
