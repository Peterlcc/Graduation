package com.peter.mapper;

import java.util.List;

import com.peter.bean.Major;

public interface MajorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(Integer id);
    List<Major> selectAll();

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);
}