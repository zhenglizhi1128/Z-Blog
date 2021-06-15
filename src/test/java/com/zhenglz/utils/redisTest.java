package com.zhenglz.utils;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class redisTest {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test1() {

        stringRedisTemplate.opsForValue().set("2222",
            "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI0Iiwic3ViIjoieiIsImlhdCI6MTYyMjE4OTg3NSwicm9sZXMiOltdLCJhdXRob3JpdGllcyI6W3siYXV0aG9yaXR5IjoicGFnZTp0ZXN0In0seyJhdXRob3JpdHkiOiJidG46dGVzdDpxdWVyeSJ9LHsiYXV0aG9yaXR5IjoiYnRuOnRlc3Q6aW5zZXJ0In0seyJhdXRob3JpdHkiOiJwYWdlOm1vbml0b3I6b25saW5lIn0seyJhdXRob3JpdHkiOiJidG46bW9uaXRvcjpvbmxpbmU6cXVlcnkifSx7ImF1dGhvcml0eSI6ImJ0bjptb25pdG9yOm9ubGluZTpraWNrb3V0In1dLCJleHAiOjE2MjIxOTA0NzV9.pYcSUpdR-eK9nPrCZaXKn8HpMxHNIn2Mjww8Ekhm7Og",
            1, TimeUnit.MILLISECONDS);
    }
}