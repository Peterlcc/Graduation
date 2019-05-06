package com.peter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peter.bean.House;
import com.peter.bean.ServiceResult;
import com.peter.mapper.HouseMapper;
import com.peter.service.HouseService;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseMapper houseMapper;
	
	@Override
	public House findById(int id) {
		return houseMapper.selectByPrimaryKey(id);
	}

	@Override
	public ServiceResult<List<House>> list(int start, int size) {
		return null;
	}

}
