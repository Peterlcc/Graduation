package com.peter.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AnalyzeMapper {
	List<Map<String, String>> selectByPropertys(@Param("userProperty") String userProperty,
			@Param("houseProperty") String houseProperty,
			@Param("middleTable") String middleTable,
			@Param("aggregate")String aggregate,
			@Param("aggregation")String aggregation);
}
