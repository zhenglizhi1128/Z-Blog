package com.zhenglz.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.zhenglz.common.resultmodel.Result;
import com.zhenglz.dto.PageCondition;
import com.zhenglz.entity.Blog;
import com.zhenglz.entity.BlogContent;
import com.zhenglz.service.IBlogService;
import com.zhenglz.vo.BlogVo;

/**
* @description:
* @author: zlz
* @date: 2021/3/24
* @version:
*/
@RestController
@RequestMapping("/blog")
public class BlogController {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Resource
    private IBlogService blogService;

    /**
     * 获取blogs
     * @param pageCondition
     * @return
     */
    @GetMapping("/blogs")
    public Result blogs(PageCondition pageCondition){
        List<Blog> blogs = blogService.getBlogs(pageCondition);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        return Result.success(pageInfo);
    }

    /**
     * 获取单个blog详情
     * @param id
     * @return
     */
    @GetMapping("/blog")
    public Result detail(@RequestParam(value = "id", required = true) Long id) {
        Blog blog = blogService.getBlogById(id);
        return Result.success(blog);
    }

    /**
     * 保存编辑blog
     * @param blog
     * @return
     */
    @PostMapping("/edit")
    public Result edit(@Validated @RequestBody BlogVo blog) {
        Blog temp = null;
        Blog newBlog = new Blog();
        BlogContent blogContent = new BlogContent();
        if(blog.getId() != null) {
            blogContent.setBlogId(blog.getId()).setContent(blog.getContent());
            newBlog.setId(blog.getId())
                    .setTitle(blog.getTitle())
                    .setDescription(blog.getDescription())
                    .setUpdateTime(LocalDateTime.now())
                    .setBlogContent(blogContent);
            blogService.updateByPrimaryKey(newBlog);
        } else {
            temp = new Blog();
            temp.setUserId(0L);
           // temp.setTitle(blog.getTitle()).setContent(blog.getContent()).setDescription(blog.getDescription());
            blogService.insert(temp);
        }
        return Result.success();
    }

}
