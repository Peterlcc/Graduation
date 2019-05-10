package com.peter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peter.bean.Collect;
import com.peter.mapper.CollectMapper;
import com.peter.service.CollectService;

@Service
public class CollectServiceImpl implements CollectService {

	@Autowired
	private CollectMapper collectMapper;
	@Override
	public Collect getCollectByUserAndHouse(Integer userId, Integer houseId) {
		if (userId==null||houseId==null) {
			throw new RuntimeException("用户id或者房屋id不能为空");
		}
		return collectMapper.selectByUserAndHouse(userId, houseId);
	}
	@Override
	public Collect setCollectByUserAndHouse(Integer userId, Integer houseId) {
		Collect collect = collectMapper.selectByUserAndHouse(userId, houseId);
		if (collect==null) {
			collect=new Collect();
			collect.setUserId(userId);
			collect.setHouseId(houseId);
			collectMapper.insertSelective(collect);
		}
		else
		{
			collectMapper.deleteByPrimaryKey(collect.getId());
		}
		return collect;
	}

}
