package com.zhenglz.mapper;

import com.zhenglz.entity.Label;
import org.apache.ibatis.annotations.Mapper;

/**
* @description: 标签Mapper
* @author: zlz
* @date: 2021/3/24
* @version:
*/
@Mapper
public interface LabelMapper {
    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 新增
     * @param label
     * @return
     */
    int insert(Label label);

    /**
     * 根据id获取
     * @param id
     * @return
     */
    Label selectById(Long id);

    /**
     * 根据id部分更新
     * @param label
     * @return
     */
    int updatePrimaryById(Label label);

    /**
     * 根据id更新
     * @param label
     * @return
     */
    int updateById(Label label);
}