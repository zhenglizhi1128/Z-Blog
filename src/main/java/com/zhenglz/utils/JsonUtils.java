package com.zhenglz.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

public class JsonUtils {

    private static ObjectMapper objectMapper;

    public static ObjectMapper getObjectMapper() {
        if(null==objectMapper){
            objectMapper = new ObjectMapper();
            objectMapper.configure(MapperFeature.AUTO_DETECT_CREATORS, false);
            objectMapper.configure(MapperFeature.AUTO_DETECT_FIELDS, false);
            objectMapper.configure(MapperFeature.AUTO_DETECT_GETTERS, true);
            objectMapper.configure(MapperFeature.AUTO_DETECT_SETTERS, true);
            objectMapper.configure(MapperFeature.AUTO_DETECT_IS_GETTERS, true);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            //在反序列化时忽略在 json 中存在但 Java 对象不存在的属性
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            //在序列化时日期格式默认为 yyyy-MM-dd'T'HH:mm:ss.SSSZ
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            //在序列化时自定义时间日期格式
            objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            //在序列化时忽略值为 null 的属性
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            //在序列化时忽略值为默认值的属性
            objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT);
        }
        return objectMapper;
    }
    //TODO 常用转化方法

}
