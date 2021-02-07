package com.zhenglz.controller;

import com.github.pagehelper.PageInfo;
import com.zhenglz.common.resultModel.Result;
import com.zhenglz.dto.PageCondition;
import com.zhenglz.entity.Blog;
import com.zhenglz.service.IBlogService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Auther: zlz
 * @Date: 2021/01/29/12:50
 * @Description:
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Resource
    private IBlogService blogService;

    @GetMapping("/blogs")
    public Result blogs(PageCondition pageCondition){
        List<Blog> blogs = blogService.getBlogs(pageCondition);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        return Result.success(pageInfo);
    }

    @GetMapping("/blog")
    public Result detail(@RequestParam(value = "id", required = true) Long id) {
        Blog blog = blogService.getBlogById(id);
        return Result.success(blog);
    }

    @PostMapping("/edit")
    public Result edit(@Validated @RequestBody Blog blog) {
        Blog temp = null;
        if(blog.getId() != null) {
            temp = blogService.getBlogById(blog.getId());
            temp.setUpdateTime(LocalDateTime.now());
            temp.setTitle(blog.getTitle()).setContent(blog.getContent()).setDescription(blog.getDescription());
            blogService.updateByPrimaryKey(temp);
        } else {
            temp = new Blog();
            temp.setUserId(0L);
            temp.setTitle(blog.getTitle()).setContent(blog.getContent()).setDescription(blog.getDescription());
            blogService.insert(temp);
        }
        return Result.success();
    }

}
