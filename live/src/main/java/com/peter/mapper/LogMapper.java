package com.peter.mapper;

import java.util.List;

import com.peter.bean.Log;

public interface LogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(Integer id);

    List<Log> selectLogsByUserId(Integer userId);
    
    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
    
    int selectLogNumByHouseId(Integer houseId);
}