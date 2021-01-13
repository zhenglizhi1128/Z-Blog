package com.demo.mapper;

import com.demo.SpringbootMybatisApplication;
import com.demo.entity.Book;
import com.demo.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class UserMapperTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void test(){
        //List<User> users = userMapper.queryUserList();
       // System.out.println(users);

        Book book = bookService.getById(1000);
        //List<Book> list = bookService.getList();
        System.out.println(book);
    }

}
