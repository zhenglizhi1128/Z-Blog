package com.zhenglz.mapper;

import com.zhenglz.SpringbootMybatisApplication;
import com.zhenglz.common.resultModel.ResultCode;
import com.zhenglz.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class UserMapperTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void test(){
        List<Long> list = new ArrayList<>();
        list.add(1l);
        list.add(12l);
        list.add(3l);
        ResponseEntity<List<Long>> responseEntity = ResponseEntity.ok(list);
        System.out.println(responseEntity);
        ResponseEntity<Object> build = ResponseEntity.notFound().header("MyResponseHeader", "MyValue").build();

        ResponseEntity<String> body = ResponseEntity.badRequest().body("文件不存在!");

        ResponseEntity<String> custom_header_set = new ResponseEntity<>(
                "Custom header set", HttpStatus.OK);

        new com.zhenglz.common.resultModel.Result<List<Long>>(ResultCode.SUCCESS,list);

        System.out.println(HttpStatus.CONFLICT);
    }

}
