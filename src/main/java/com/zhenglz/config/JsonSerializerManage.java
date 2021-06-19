package com.zhenglz.config;

import java.text.SimpleDateFormat;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @description: jackson全局配置。springboot每内部使用jackson，
 * controller层使用@ResponseBody 其实都是jackson在序列化传到前台
 * @author: zlz
 * @createDate: 2021/6/19
 * @version:
 */

@JsonComponent
public class JsonSerializerManage {

	@Bean
	public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
		ObjectMapper objectMapper = builder.createXmlMapper(false).build();
		objectMapper.configure(MapperFeature.AUTO_DETECT_CREATORS, false);
		objectMapper.configure(MapperFeature.AUTO_DETECT_FIELDS, false);
		objectMapper.configure(MapperFeature.AUTO_DETECT_GETTERS, true);
		objectMapper.configure(MapperFeature.AUTO_DETECT_SETTERS, true);
		objectMapper.configure(MapperFeature.AUTO_DETECT_IS_GETTERS, true);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		/*
         *  // 在反序列化时忽略在 json 中存在但 Java 对象不存在的属性
		 * objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		 * objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		 * // 在序列化时忽略值为 null 的属性
		 * objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		 * // 在序列化时忽略值为默认值的属性
		 * objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT);
		 */
		return objectMapper;
	}
}
