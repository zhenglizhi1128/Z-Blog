package com.zhenglz.controller;

import com.zhenglz.common.resultModel.Result;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 测试Controller
 * </p>
 */

@RestController
@RequestMapping("/test")
public class TestController {
    
    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @GetMapping
    public Result list() {
        logger.info("测试列表查询");
        return Result.success("测试列表查询");
    }

    @PostMapping
    public Result add() {
        logger.info("测试列表添加");
        return Result.success("测试列表添加");
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id) {
        logger.info("测试列表修改");
        return Result.success("测试列表修改");
    }
}
