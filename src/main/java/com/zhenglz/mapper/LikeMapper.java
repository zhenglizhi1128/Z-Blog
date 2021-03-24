package com.zhenglz.mapper;

import com.zhenglz.entity.Like;
import org.apache.ibatis.annotations.Mapper;

/**
* @description: 点赞Mapper
* @author: zlz
* @date: 2021/3/24
* @version:
*/
@Mapper
public interface LikeMapper {

    /**
     * 根据Id删除
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 新增
     * @param like
     * @return
     */
    int insert(Like like);

    /**
     * 根据Id获取
     * @param id
     * @return
     */
    Like getLikeById(Long id);

    /**
     * 部分更新
     * @param like
     * @return
     */
    int updatePartialById(Like like);

    /**
     * 更新
     * @param like
     * @return
     */
    int updateById(Like like);
}