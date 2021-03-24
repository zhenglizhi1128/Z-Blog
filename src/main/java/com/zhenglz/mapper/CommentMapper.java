package com.zhenglz.mapper;

import com.zhenglz.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
* @description: 评论Mapper
* @author: zlz
* @date: 2021/3/24
* @version:
*/
@Mapper
public interface CommentMapper {

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 新增
     * @param comment
     * @return
     */
    int insert(Comment comment);

    /**
     * 根据id获取
     * @param id
     * @return
     */
    Comment getCommentById(Long id);

    /**
     * 根据id部分更新
     * @param comment
     * @return
     */
    int updatePrimaryById(Comment comment);

    /**
     * 更新
     * @param comment
     * @return
     */
    int updateById(Comment comment);

}