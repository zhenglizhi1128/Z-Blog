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
import com.zhenglz.mapper.LabelMapper;
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

    @Resource
    private LabelMapper labelMapper;

    @Override
    public List<Blog> getBlogs(PageCondition pageCondition) throws RuntimeException {
        PageHelper.startPage(pageCondition.getCurrentPage(), pageCondition.getPageSize(), " id desc ");
        List<Blog> blogs = blogMapper.listBlogs();
        return blogs;
    }

    @Override
    public Blog getBlogById(long id) throws RuntimeException {
        Blog blog = blogMapper.getBlogById(id);
        BlogContent blogContent = blogContentMapper.getBlogContentById(blog.getContentId());
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
        blog.setContentId(blogContent.getId()).setTitle(blogvo.getTitle()).setUserId(blogvo.getUser().getId())
            .setCreateTime(LocalDateTime.now()).setUpdateTime(LocalDateTime.now()).setStatus(Constants.TRYE)
            .setLikeNumber(0L).setReadNumber(0L).setCommentNumber(0L);
        return blogMapper.insert(blog);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKey(BlogVo blogVo) throws RuntimeException {
        Blog blog = new Blog();
        blog.setUpdateTime(LocalDateTime.now());
        BeanUtil.copyProperties(blogVo, blog);
        int value = blogMapper.updatePrimaryById(blog);
        blogContentMapper.updateById(blogVo.getBlogContent());
        return value;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<BlogVo> getBlogsByTitleAndStatus(String title, Long labelId, Integer status,
        PageCondition pageCondition) throws RuntimeException {
        PageHelper.startPage(pageCondition.getCurrentPage(), pageCondition.getPageSize(), " create_time desc ");
        List<BlogVo> blogVos = blogMapper.getBlogsByTitleAndStatus(title, labelId, status);
        return blogVos;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBlog(long blogId) throws RuntimeException {
        blogContentMapper.deleteByBlogId(blogId);
        labelMapper.deleteBlogLabelByBlogId(blogId);
        blogMapper.deleteById(blogId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateStatus(long blogId, Boolean status) throws RuntimeException {
       Blog blog = new Blog();
       blog.setId(blogId).setUpdateTime(LocalDateTime.now()).setStatus(status);
       blogMapper.updatePrimaryById(blog);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCommentStatus(long blogId, boolean commentStatus) throws RuntimeException {
        Blog blog = new Blog();
        blog.setId(blogId).setUpdateTime(LocalDateTime.now()).setCommentStatus(commentStatus);
        blogMapper.updatePrimaryById(blog);
    }

}
