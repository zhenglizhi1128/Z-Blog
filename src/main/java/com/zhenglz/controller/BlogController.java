package com.zhenglz.controller;

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
import com.zhenglz.entity.Label;
import com.zhenglz.service.IBlogService;
import com.zhenglz.service.ILabelService;
import com.zhenglz.vo.BlogVo;

import cn.hutool.json.JSONObject;

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

    @Resource
    private ILabelService labelService;

    /**
     * 获取blogs
     * 
     * @param pageCondition
     * @return
     */
    @GetMapping("/blogs")
    public Result blogs(PageCondition pageCondition) throws Exception {
        List<Blog> blogs = blogService.getBlogs(pageCondition);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        return Result.success(pageInfo);
    }

    /**
     * 获取单个blog详情
     * 
     * @param id
     * @return
     */
    @GetMapping("/blog")
    public Result detail(@RequestParam(value = "id", required = true) Long id) throws Exception {
        Blog blog = blogService.getBlogById(id);
        return Result.success(blog);
    }

    /**
     * 保存编辑blog
     * 
     * @param blog
     * @return
     */
    @PostMapping("/edit")
    public Result edit(@Validated @RequestBody BlogVo blog) throws Exception {
        if (blog.getId() != null) {
            blogService.updateByPrimaryKey(blog);
        } else {
            blogService.insert(blog);
        }
        return Result.success();
    }

    @GetMapping("/set/blogs")
    public Result setBlogs(String title, @RequestParam(required = false) Long labelId,
        @RequestParam(value = "status",required = false) Boolean status, PageCondition pageCondition) throws Exception {
        List<BlogVo> blogVos = blogService.getBlogsByTitleAndStatus(title, labelId, status, pageCondition);
        PageInfo<BlogVo> pageInfo = new PageInfo<>(blogVos);
        List<Label> labels = labelService.getLabels();
        JSONObject jsonObject = new JSONObject();
        jsonObject.putOnce("title", title);
        jsonObject.putOnce("labelId", labelId);
        jsonObject.putOnce("status", status);
        jsonObject.putOnce("labels", labels);
        jsonObject.putOnce("pageInfo", pageInfo);
        return Result.success(jsonObject);
    }

    @DeleteMapping("/set/deleteBlog")
    public Result deleteBlog(long id) throws Exception {
        blogService.deleteBlog(id);
        return Result.success();
    }

    @PutMapping("/set/updateStatus")
    public Result updateStatus(long blogId,Boolean status) throws Exception {
        blogService.updateStatus(blogId,status);
        return Result.success();
    }

    @PutMapping("/set/updateCommentStatus")
    public Result updateCommentStatus(long blogId,Boolean commentStatus) throws Exception {
        blogService.updateCommentStatus(blogId,commentStatus);
        return Result.success();
    }
}
