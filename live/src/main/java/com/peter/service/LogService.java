package com.peter.service;

import com.peter.bean.Log;

public interface LogService {
	Log getLogByUserAndHouse(Integer userId,Integer houseId);
}
