package com.zhenglz.controller.system;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhenglz.common.resultmodel.Result;
import com.zhenglz.service.ISystemService;
import com.zhenglz.vo.CentralVo;

/**
 * 中控台
 */
@RestController
@RequestMapping("/central")
public class CentralController {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Resource
    private ISystemService systemService;


    @GetMapping("/initialize")
    public Result initialization() throws RuntimeException {
        CentralVo central = systemService.getCentral();
        return Result.success(central);
    }

}
