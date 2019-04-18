package com.peter.mapper;

import java.util.List;

import com.peter.bean.Area;

public interface AreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer id);
    List<Area> selectAll();

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
}