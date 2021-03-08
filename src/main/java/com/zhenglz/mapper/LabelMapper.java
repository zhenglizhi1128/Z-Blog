package com.zhenglz.mapper;

import com.zhenglz.entity.Label;
import org.apache.ibatis.annotations.Mapper;

/*
 * @Description:
 * @Author: zlz
 * @Date: 2021/3/7
 **/
@Mapper
public interface LabelMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Label record);

    int insertSelective(Label record);

    Label selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Label record);

    int updateByPrimaryKey(Label record);
}