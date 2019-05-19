package com.peter.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.peter.bean.House;

public interface HouseMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(House record);

	int insertSelective(House record);

	House selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(House record);

	int updateByPrimaryKey(House record);

	// 按条件查询总记录数
	// int selectTotalRecord(HouseQueryVo houseQueryVo);
	int selectTotalRecord(Map<String, Object> map);

	// 按条件查询记录
	// List<House> selectHouseList(@Param("houseQueryVo") HouseQueryVo
	// houseQueryVo,@Param("start") int start,@Param("size") int size);
	List<House> selectHouseList(Map<String, Object> map);

	// 按用户id查询总log记录数
	int selectLogHousesTotalRecord(@Param("userId") Integer userId);
	// 按用户id查询log记录
	List<House> selectLogHouses(@Param("userId") Integer userId, @Param("start") int start, @Param("size") int size);

	// 按用户id查询总collect记录数
	int selectCollectHousesTotalRecord(@Param("userId") Integer userId);
	// 按用户id查询collect记录
	List<House> selectCollectHouses(@Param("userId") Integer userId, @Param("start") int start, @Param("size") int size);
	
	// 按用户id查询总phone记录数
	int selectPhoneHousesTotalRecord(@Param("userId") Integer userId);
	// 按用户id查询phone记录
	List<House> selectPhoneHouses(@Param("userId") Integer userId, @Param("start") int start, @Param("size") int size);

	//查询所有房屋记录数
	int selectAllTotalRecord();
	//查询所有房屋
	List<House> selectAll(@Param("start") int start, @Param("size") int size);
	
}