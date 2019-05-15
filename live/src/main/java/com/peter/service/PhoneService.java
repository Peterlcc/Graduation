package com.peter.service;

import com.peter.bean.Phone;

public interface PhoneService {
	Phone getPhoneByUserAndHouse(Integer userId,Integer houseId);
}
