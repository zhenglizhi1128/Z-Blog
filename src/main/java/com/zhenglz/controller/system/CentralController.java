package com.zhenglz.controller.system;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import com.zhenglz.common.resultmodel.Result;
import com.zhenglz.entity.Label;
import com.zhenglz.service.IBlogService;
import com.zhenglz.service.ISystemService;
import com.zhenglz.service.IUserService;
import com.zhenglz.vo.CentralVo;

/**
 * 中控台
 */
@RestController
@RequestMapping("/central")
public class CentralController {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Resource
    private IUserService userService;

    @Resource
    private IBlogService blogService;

    @Resource
    private ISystemService systemService;

    /**
     * 查寻数据库中是否有相同名字的标签
     * 
     * @param
     * @return
     * @throws RuntimeException
     */
    @GetMapping("/initialize")
    public Result initialization() throws RuntimeException {
        CentralVo central = systemService.getCentral();
        return Result.success(central);
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

        return Result.success();
    }

    /**
     * 修改
     *
     * @param label
     * @return
     * @throws RuntimeException
     */
    @PutMapping("/update")
    public Result updateName(Label label) throws RuntimeException {

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

        return Result.success();
    }

    /**
     * 删除
     * 
     * @param
     * @return
     * @throws RuntimeException
     */
    @DeleteMapping ("/delete")
    public Result deleteLabel(long id) throws RuntimeException {

        return Result.success();
    }

}
