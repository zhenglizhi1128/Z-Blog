package com.demo.controller;

import com.demo.entity.Book;
import com.demo.entity.User;
import com.demo.mapper.BookMapper;
import com.demo.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MybatisController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookMapper bookMapper;

    @RequestMapping("/query")
    @ResponseBody
    public List<User> queryUserList(){
        List<User> users = userMapper.queryUserList();
        return users;
    }

    @RequestMapping("/book")
    @ResponseBody
    public Book queryById(){
        Book book = bookMapper.queryById(1000);
        return book;
    }

    @RequestMapping("/books")
    @ResponseBody
    public List<Book> getAllBooks(){
        //1. offsetPage
        PageHelper.offsetPage(1, 2);
        List<Book> books = bookMapper.queryAll();
        return books;
        //PageInfo<Person> pageInfo = new PageInfo<Person>(list);
        //2. Lambda
       // return PageHelper.startPage(1, 10).doSelectPageInfo(() -> userService.findAll());
    }

}
