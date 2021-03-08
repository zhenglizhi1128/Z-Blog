package com.zhenglz.mapper;

import com.zhenglz.entity.Announcement;
import org.apache.ibatis.annotations.Mapper;

/*
 * @Description:
 * @Author: zlz
 * @Date: 2021/3/7
 **/
@Mapper
public interface AnnouncementMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Announcement record);

    int insertSelective(Announcement record);

    Announcement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Announcement record);

    int updateByPrimaryKey(Announcement record);
}