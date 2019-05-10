package com.peter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peter.bean.Area;
import com.peter.mapper.AreaMapper;
import com.peter.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaMapper areaMapper;
	@Override
	public Area getAreaById(Integer areaId) {
		
		return areaMapper.selectByPrimaryKey(areaId);
	}
	@Override
	public Area getAreaByName(String name) {
		
		return areaMapper.selectByName(name);
	}

}
