package com.peter.service;

import com.peter.bean.Collect;

public interface CollectService {
	Collect getCollectByUserAndHouse(Integer userId,Integer houseId);
	
	Collect setCollectByUserAndHouse(Integer userId,Integer houseId);
}
