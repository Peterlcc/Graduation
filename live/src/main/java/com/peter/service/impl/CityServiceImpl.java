package com.peter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peter.bean.City;
import com.peter.mapper.CityMapper;
import com.peter.service.CityService;

@Service
public class CityServiceImpl implements CityService{

	@Autowired
	private CityMapper cityMapper;
	@Override
	public City getCityById(Integer cityId) {
		return cityMapper.selectByPrimaryKey(cityId);
	}

}
