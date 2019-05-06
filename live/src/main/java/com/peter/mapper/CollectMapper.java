package com.peter.mapper;

import java.util.List;

import com.peter.bean.Collect;

public interface CollectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collect record);

    int insertSelective(Collect record);

    Collect selectByPrimaryKey(Integer id);

    List<Collect> selectCollectsByUserId(Integer userId);
    
    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);
    
    int selectCollectNumByHouseId(Integer houseId);
    
}