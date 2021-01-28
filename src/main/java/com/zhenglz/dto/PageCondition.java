package com.zhenglz.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 分页请求参数
 * </p>
 */
@Data
@Accessors(chain = true)
public class PageCondition {

    /**
     * 当前页码
     */
    private Integer currentPage;

    /**
     * 每页条数
     */
    private Integer pageSize;

    /**
     * 排序规则
     */
    private String orderType;

}
