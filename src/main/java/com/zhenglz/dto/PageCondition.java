package com.zhenglz.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
* @description: 分页请求 Dto
* @author: zlz
* @date: 2021/3/24
* @version:
*/
@Data
@Accessors(chain = true)
public class PageCondition {

    /**
     * 当前页码
     */
    private Integer currentPage=1;

    /**
     * 每页条数
     */
    private Integer pageSize=10;

    /**
     * 排序规则
     */
    private String orderType ="";

}
