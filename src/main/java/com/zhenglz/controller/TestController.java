package com.zhenglz.controller;

import com.zhenglz.common.resultModel.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 测试Controller
 * </p>
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping
    public Result list() {
        log.info("测试列表查询");
        return Result.success("测试列表查询");
    }

    @PostMapping
    public Result add() {
        log.info("测试列表添加");
        return Result.success("测试列表添加");
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id) {
        log.info("测试列表修改");
        return Result.success("测试列表修改");
    }
}
