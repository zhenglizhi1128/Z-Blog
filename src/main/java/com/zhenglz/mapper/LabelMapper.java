package com.zhenglz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zhenglz.entity.Label;

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
     *
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 新增
     *
     * @param label
     * @return
     */
    int insert(Label label);

    /**
     * 查询所有
     *
     * @return
     */
    List<Label> getLabels();

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    Label getLabelById(Long id);

    /**
     * 根据id部分更新
     *
     * @param label
     * @return
     */
    int updatePrimaryById(Label label);

    /**
     * 批量更新根据名字
     * 
     * @param labels
     */
    void updateBatchByName(@Param("labels") List<Label> labels);

    /**
     * 根据Id 批量更新
     * 
     * @param labels
     */
    void updateBatchById(@Param("labels") List<Label> labels);

    /**
     * 批量更新
     * 
     * @param labels
     */
    void updateBatch(@Param("labels") List<Label> labels);

    /**
     * 批量添加
     * 
     * @param list
     * @return
     */
    int insertList(@Param("list") List<Label> list);

    /**
     * 根据明名字统计个数
     * 
     * @param name
     * @return
     */
    int countLabelByName(@Param("name") String name);

    /**
     * 删除文章的标签
     * @param blogId
     */
    void deleteBlogLabelByBlogId(Long blogId);

}