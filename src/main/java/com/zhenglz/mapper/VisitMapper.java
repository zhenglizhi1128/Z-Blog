package com.zhenglz.mapper;

import com.zhenglz.entity.Visit;
import org.apache.ibatis.annotations.Mapper;

/*
 * @Description:
 * @Author: zlz
 * @Date: 2021/3/7
 **/
@Mapper
public interface VisitMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Visit record);

    int insertSelective(Visit record);

    Visit selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Visit record);

    int updateByPrimaryKey(Visit record);
}