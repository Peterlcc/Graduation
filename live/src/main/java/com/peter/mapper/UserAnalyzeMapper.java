package com.peter.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserAnalyzeMapper {
	List<Map<String, String>> selectByProperty(@Param("property")String property);
}
