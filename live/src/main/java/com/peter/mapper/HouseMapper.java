package com.peter.mapper;

import java.util.List;
import java.util.Map;

import com.peter.bean.House;

public interface HouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(House record);

    int insertSelective(House record);

    House selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    //按条件查询总记录数
	//int selectTotalRecord(HouseQueryVo houseQueryVo);
	int selectTotalRecord(Map<String, Object> map);
	//按条件查询记录
	//List<House> selectHouseList(@Param("houseQueryVo") HouseQueryVo houseQueryVo,@Param("start") int start,@Param("size") int size);
	List<House> selectHouseList(Map<String, Object> map);
}