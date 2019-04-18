package com.peter.mapper;

import java.util.List;

import com.peter.bean.Street;

public interface StreetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Street record);

    int insertSelective(Street record);

    Street selectByPrimaryKey(Integer id);
    List<Street> selectAll();

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);
}