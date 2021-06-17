package com.zhenglz.service;

import java.util.List;

import com.zhenglz.entity.Label;

/**
 * @author zlz
 */
public interface ILabelService {

    /**
     * 获取blogs
     * 
     * @return
     */
    List<Label> getLabels();

    /**
     * 修改名字
     * 
     * @param label
     * @return
     */
    int updateNameById(Label label);

    /**
     * 物理删除
     * 
     * @param id
     * @return
     */
    int updateStatus(long id);

    /**
     * 新增
     * 
     * @param label
     * @return
     */
    int insert(Label label);

    /**
     * 查寻数据库中是否有相同名字的标签
     * 
     * @param name
     * @return
     */
    int countLabelByName(String name);

    /**
     * 根据id查询
     * 
     * @param id
     * @return
     */
    Label getLabelById(long id);

}
