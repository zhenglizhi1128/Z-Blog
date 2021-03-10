package com.zhenglz.mapper;

import com.zhenglz.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: zlz
 * @Date: 2021/03/09/18:34
 * @Description:
 */
@Mapper
public interface CommentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}