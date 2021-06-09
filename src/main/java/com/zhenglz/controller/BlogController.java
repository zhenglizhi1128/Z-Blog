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
        if(blog.getId() != null) {
            blogService.updateByPrimaryKey(blog);
        } else {
            blogService.insert(blog);
        }
        return Result.success();
    }

    @GetMapping("/set/blogs")
    public Result setBlogs(String title,long labelId,int status ) throws Exception{
        /*PageCondition pageCondition,*/
        /*List<Blog> blogs = blogService.getBlogs(pageCondition);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);*/
        List<Label> labels = labelService.getLabels();
        logger.info(labelId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title",title);
        jsonObject.put("labelId",labelId);
        jsonObject.put("status",status);
        jsonObject.put("labels",labels);
        return Result.success(jsonObject);
    }


}
