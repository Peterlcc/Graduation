package com.peter.mapper;

import java.util.List;

import com.peter.bean.HouseUrl;

public interface HouseUrlMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HouseUrl record);

    int insertSelective(HouseUrl record);

    HouseUrl selectByPrimaryKey(Integer id);
    List<HouseUrl> selectAll();

    int updateByPrimaryKeySelective(HouseUrl record);

    int updateByPrimaryKey(HouseUrl record);
}