package com.zhenglz.mapper;

import com.zhenglz.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

/*
 * @Description:
 * @Author: zlz
 * @Date: 2021/3/7
 **/
@Mapper
public interface CommentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}