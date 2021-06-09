package com.zhenglz.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhenglz.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonTest {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    private User user;



    @Test
    public void loggerTest()  {
      /*  ArrayNode jsonArray = JsonUtils.createJsonArray();
        ObjectNode json = JsonUtils.createJson();
        json.put("username","张三");
        ObjectNode json1 = JsonUtils.createJson();
        json1.put("username","张三1");
        jsonArray.add(json).add(json1);*/

        System.out.println(JsonUtils.jsonStrToJson(""));
        ObjectMapper objectMapper = JsonUtils.getObjectMapper();


    }

}