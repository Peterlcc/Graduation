package com.peter.mapper;

import java.util.List;

import com.peter.bean.City;

public interface CityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer id);//44是天津
    List<City> selectAll();

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}