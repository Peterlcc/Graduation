package com.peter.service;

import java.util.List;
import java.util.Map;

import com.peter.bean.House;
import com.peter.bean.HouseQueryVo;

public interface HouseService {
	
	House findById(int id);
	List<Map<String, String>> analyzeByProperty(String property);
	
	void queryList(HouseQueryVo houseQueryVo);
}
