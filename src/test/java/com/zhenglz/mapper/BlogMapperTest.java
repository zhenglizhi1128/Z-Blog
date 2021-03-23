package com.zhenglz.mapper;

import com.zhenglz.entity.Blog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
        List<Blog> list = blogMapper.list();
        System.out.println(list.size());
        Blog blog = list.get(0);
        System.out.println("------");
    }
}