package com.peter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peter.bean.Phone;
import com.peter.mapper.PhoneMapper;
import com.peter.service.PhoneService;

@Service
public class PhoneServiceImpl implements PhoneService{

	
	@Autowired
	private PhoneMapper phoneMapper;
	@Override
	public Phone getPhoneByUserAndHouse(Integer userId, Integer houseId) {
		if (userId==null||houseId==null) {
			throw new RuntimeException("用户id或者房屋id不能为空");
		}
		Phone phone=phoneMapper.selectByUserAndHouse(userId,houseId);
		if (phone==null) {
			phone=new Phone(null, userId, houseId);
			phoneMapper.insertSelective(phone);
			System.out.println(userId+"---"+houseId+" inserted");
		}
		return phone;
	}

}
