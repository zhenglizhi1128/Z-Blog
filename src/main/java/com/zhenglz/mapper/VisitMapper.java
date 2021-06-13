package com.zhenglz.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zhenglz.entity.Visit;

/**
 * @description: 访问Mapper
 * @author: zlz
 * @date: 2021/3/24
 * @version:
 */
@Mapper
public interface VisitMapper {

    /**
     * 根据id 删除
     * 
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 新增
     * 
     * @param visit
     * @return
     */
    int insert(Visit visit);

    /**
     * 根据id获取Visit
     * 
     * @param id
     * @return
     */
    Visit getVisitById(Long id);

    /**
     * 更新访问的部分内容
     * 
     * @param visit
     * @return
     */
    int updatePartialById(Visit visit);

    /**
     * 更新访问记录
     * 
     * @param visit
     * @return
     */
    int updateById(Visit visit);
}