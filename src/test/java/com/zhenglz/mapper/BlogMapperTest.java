package com.zhenglz.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhenglz.entity.Blog;

/**
 * @Auther: zlz
 * @Date: 2021/02/27/10:32
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogMapperTest {

    @Autowired
    BlogMapper blogMapper;

    @Autowired
    LikeMapper likeMapper;

    @Test
    public void list() {
        List<Blog> list = blogMapper.listBlogs();
        System.out.println(list.size());
        Blog blog = list.get(0);
        System.out.println("------");
    }
}