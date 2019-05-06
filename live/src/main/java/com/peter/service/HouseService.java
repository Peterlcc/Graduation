package com.peter.service;

import java.util.List;

import com.peter.bean.House;
import com.peter.bean.ServiceResult;

public interface HouseService {
	
	House findById(int id);
	
	
	ServiceResult<List<House>> list(int start,int size);
}
