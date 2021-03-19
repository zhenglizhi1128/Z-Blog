package com.zhenglz.mapper;

import com.zhenglz.entity.BlogContent;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: zlz
 * @Date: 2021/03/19/16:16
 * @Description: 
 */
@Mapper
public interface BlogContentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(BlogContent record);

    int insertSelective(BlogContent record);

    BlogContent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BlogContent record);

    int updateByPrimaryKey(BlogContent record);
}