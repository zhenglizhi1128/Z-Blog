package com.demo.mapper;

import com.demo.SpringbootMybatisApplication;
import com.demo.entity.Book;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class PageHelperTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookMapper bookMapper;
    
    /* 
     * @Description: 普通分页
     * @Author: zlz
     * @Date: 2021/1/4
     **/
    @Test
    public void test(){
        PageHelper.startPage(1, 1);
        List<Book> books = bookMapper.queryAll();
        PageInfo<Book> pageInfo = new PageInfo<Book>(books);
        System.out.println(books);
    }
    /* 
     * @Description: Lambda分页
     * @Author: zlz
     * @Date: 2021/1/4
     **/
    @Test
    public void test1(){
       // Page<Country> page = PageHelper.startPage(1, 10).doSelectPage(()-> countryMapper.selectGroupBy());
        //PageHelper.startPage(1, 10).doSelectPageInfo(() -> userService.findAll());
        PageInfo<Book> objectPageInfo = PageHelper.startPage(0, 3).doSelectPageInfo(() -> bookMapper.queryAll());
        System.out.println(objectPageInfo.getList());
    }
    /*
     * @Description: 配置supportMethodsArguments=true 后可用
     * @Author: zlz
     * @Date: 2021/1/4
     **/
    @Test
    public void test2(){
        List<Book> list = bookMapper.queryAllByPage( 1, 1);
        System.out.println(list);
    }
}