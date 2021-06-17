package com.zhenglz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.zhenglz.entity.Blog;
import com.zhenglz.mapper.BlogMapper;
import com.zhenglz.mapper.UserMapper;
import com.zhenglz.service.ISystemService;
import com.zhenglz.vo.CentralVo;

/**
 * @author zlz
 */
@Service
public class SystemServiceImpl implements ISystemService {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Resource
    private BlogMapper blogMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public CentralVo getCentral() throws RuntimeException {
        CentralVo centralVo = new CentralVo();
        centralVo.setUserNum(userMapper.countUser());
        centralVo.setBlogNum(blogMapper.countBlog());
        PageHelper.startPage(1, 5, " id desc ");
        List<Blog> blogs = blogMapper.listBlogs();
        centralVo.setBlogs(blogs);
        return centralVo;
    }

}
