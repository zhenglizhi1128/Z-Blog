package com.zhenglz.mapper;

import com.zhenglz.entity.Announcement;
import org.apache.ibatis.annotations.Mapper;


/**
* @description: 公告Mapper
* @author: zlz
* @date: 2021/3/24
* @version:
*/
@Mapper
public interface AnnouncementMapper {


    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增公告
     * @param record
     * @return
     */
    int insert(Announcement record);

    /**
     * 新增
     * @param record
     * @return
     */
    int insertSelective(Announcement record);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Announcement selectByPrimaryKey(Integer id);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Announcement record);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Announcement record);
}