package com.peter.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.peter.bean.Collect;

public interface CollectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collect record);

    int insertSelective(Collect record);

    Collect selectByPrimaryKey(Integer id);
    
    Collect selectByUserAndHouse(@Param("userId")Integer userId,@Param("houseId")Integer houseId);

    List<Collect> selectCollectsByUserId(Integer userId);
    
    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);
    
    int selectCollectNumByHouseId(Integer houseId);
    
}