package com.peter.mapper;

import java.util.List;

import com.peter.bean.Phone;

public interface PhoneMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Phone record);

    int insertSelective(Phone record);

    Phone selectByPrimaryKey(Integer id);
    List<Phone> selectPhonesByUserId(Integer userId);

    int updateByPrimaryKeySelective(Phone record);

    int updateByPrimaryKey(Phone record);
    
    int selectPhoneNumByHouseId(Integer houseId);

	Phone selectByUserAndHouse(Integer userId, Integer houseId);
    
}