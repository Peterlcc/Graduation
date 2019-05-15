package com.peter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peter.bean.Log;
import com.peter.mapper.LogMapper;
import com.peter.service.LogService;

@Service
public class LogServiceImpl implements LogService{

	
	@Autowired
	private LogMapper logMapper;
	@Override
	public Log getLogByUserAndHouse(Integer userId, Integer houseId) {
		if (userId==null||houseId==null) {
			throw new RuntimeException("用户id或者房屋id不能为空");
		}
		Log log = logMapper.selectByUserAndHouse(userId, houseId);
		if (log==null) {
			log=new Log(null, userId, houseId);
			logMapper.insertSelective(log);
			System.out.println(userId+"---"+houseId+" inserted");
		}
		return log;
	}

}
