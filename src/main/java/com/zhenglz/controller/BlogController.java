package com.zhenglz.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: zlz
 * @Date: 2021/01/29/12:50
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class BlogController {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);


}
