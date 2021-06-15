package com.zhenglz.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.MapLikeType;

import cn.hutool.core.util.StrUtil;

/**
 * @Description: jackson 工具类
 * @Author: zlz
 * @Date: 2021/2/26
 */
public class JsonUtils {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    private static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.configure(MapperFeature.AUTO_DETECT_CREATORS, false);
        OBJECT_MAPPER.configure(MapperFeature.AUTO_DETECT_FIELDS, false);
        OBJECT_MAPPER.configure(MapperFeature.AUTO_DETECT_GETTERS, true);
        OBJECT_MAPPER.configure(MapperFeature.AUTO_DETECT_SETTERS, true);
        OBJECT_MAPPER.configure(MapperFeature.AUTO_DETECT_IS_GETTERS, true);
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 在反序列化时忽略在 json 中存在但 Java 对象不存在的属性
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // 在序列化时自定义时间日期格式
        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        // 在序列化时忽略值为 null 的属性
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 在序列化时忽略值为默认值的属性
        OBJECT_MAPPER.setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT);
    }

    private JsonUtils() {

    }

    public static ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER;
    }

    /**
     * @Description: 创建json
     * @Author: zlz
     * @Date: 2021/2/26
     */
    public static ObjectNode createJson() {
        return OBJECT_MAPPER.createObjectNode();
    }

    /**
     * @Description: 创建jsonArray
     * @Author: zlz
     * @Date: 2021/2/26
     */
    public static ArrayNode createJsonArray() {
        return OBJECT_MAPPER.createArrayNode();
    }

    /**
     * @Description: jsonStr转json
     * @Author: zlz
     * @Date: 2021/2/26
     */
    public static JsonNode jsonStrToJson(String jsonStr) {
        try {
            return OBJECT_MAPPER.readTree(jsonStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Description: jsonStr转jsonArray
     * @Author: zlz
     * @Date: 2021/2/26
     */
    public static ArrayNode jsonStrToJsonArray(String jsonStr) {
        if (StrUtil.hasBlank(jsonStr)) {
            return OBJECT_MAPPER.createArrayNode();
        }
        try {
            return OBJECT_MAPPER.readValue(jsonStr, ArrayNode.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Description: javaBean、map、list转jsonStr
     * @Author: zlz
     * @Date: 2021/2/26
     */

    public static String objectToJsonStr(Object obj) {
        try {
            if (obj == null) {
                return "";
            }
            if (obj instanceof Number) {
                return obj.toString();
            }
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * @Description: jsonStr转javaBean
     * @Author: zlz
     * @Date: 2021/2/26
     */
    private static <T> T jsonStrToObject(String jsonStr, Class<T> classInfo) {
        T obj = null;
        try {
            obj = OBJECT_MAPPER.readValue(jsonStr, classInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * @Description: 将jsonStr转成相应的Map
     * @Author: zlz
     * @Date: 2021/2/26
     */
    public static Map<String, Object> jsonStrJsonMap(String jsonStr) {
        MapLikeType mapLikeType =
            OBJECT_MAPPER.getTypeFactory().constructMapLikeType(HashMap.class, String.class, Object.class);
        try {
            return OBJECT_MAPPER.readValue(jsonStr, mapLikeType);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * @Description: 将jsonStr转成相应的List
     * @Author: zlz
     * @Date: 2021/2/26
     */
    public static <E> List<E> jsonStrToList(String jsonStr, Class<E> eClass) {
        if (StrUtil.hasBlank(jsonStr)) {
            return Collections.emptyList();
        }
        try {
            return OBJECT_MAPPER.readValue(jsonStr,
                OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, eClass));
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * @Description: 键值路径，支持多级键值路径，如: data.originInfo.price，或 data.list.1
     * @Author: zlz
     * @Date: 2021/2/26
     */
    public static JsonNode getNode(JsonNode node, String keys) {
        String[] pathArray = {keys};
        String s = ".";
        if (keys.contains(s)) {
            pathArray = keys.split("\\.");
        }
        JsonNode next = node;
        try {
            for (String key : pathArray) {
                if (isStartWithNumeric(key)) {
                    next = next.get(Integer.parseInt(key));
                } else {
                    next = next.get(key);
                }
                if (next == null) {
                    return null;
                }
            }
        } catch (NullPointerException npe) {
            return null;
        }
        return next;
    }

    private static boolean isStartWithNumeric(String str) {
        if (str.length() > 0) {
            int chr = str.charAt(0);
            return chr >= 48 && chr <= 57;
        }
        return false;
    }

}
