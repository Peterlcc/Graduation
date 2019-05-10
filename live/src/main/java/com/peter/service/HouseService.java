package com.peter.service;

import com.peter.bean.House;
import com.peter.bean.HouseQueryVo;

public interface HouseService {
	
	House findById(int id);
	
	
	void queryList(HouseQueryVo houseQueryVo);
}
