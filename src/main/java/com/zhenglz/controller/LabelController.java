package com.zhenglz.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import com.zhenglz.common.Constants;
import com.zhenglz.common.resultmodel.Result;
import com.zhenglz.common.resultmodel.Status;
import com.zhenglz.entity.Label;
import com.zhenglz.service.ILabelService;

@RestController
@RequestMapping("/label")
public class LabelController {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Resource
    private ILabelService labelService;

    /**
     * 查寻数据库中是否有相同名字的标签
     * 
     * @param name
     * @return
     * @throws RuntimeException
     */
    @GetMapping("/countLabel")
    public Result countLabelByName(String name) throws RuntimeException {
        int count = labelService.countLabelByName(name);
        return Result.success(count);
    }

    /**
     * 新增
     * 
     * @param label
     * @return
     * @throws RuntimeException
     */
    @PostMapping("/label")
    public Result insertLabel(@RequestBody Label label) throws RuntimeException {
        label.setCreateTime(LocalDateTime.now()).setUpdateTime(LocalDateTime.now())
            .setStatus(Constants.ENABLE);
        labelService.insert(label);
        return Result.success();
    }

    /**
     * 修改
     *
     * @param label
     * @return
     * @throws RuntimeException
     */
    @PostMapping("/update")
    public Result updateName(@RequestBody Label label) throws RuntimeException {
        label.setUpdateTime(LocalDateTime.now()).setStatus(Constants.ENABLE);
        int value = labelService.updateNameById(label);
        if (value == 0) {
            return Result.failure(Status.ERROR);
        }
        return Result.success();
    }

    /**
     * 获取列表
     * 
     * @return
     * @throws RuntimeException
     */
    @GetMapping("/labels")
    public Result getLabels() throws RuntimeException {
        List<Label> labels = labelService.getLabels();
        return Result.success(labels);
    }

    /**
     * 删除
     * 
     * @param
     * @return
     * @throws RuntimeException
     */
    @PostMapping("/delete")
    public Result deleteLabel(@RequestBody Label label) throws RuntimeException {
        int value = labelService.updateStatus(label.getId());
        if (value == 0) {
            return Result.failure(Status.ERROR);
        }
        return Result.success();
    }

}
