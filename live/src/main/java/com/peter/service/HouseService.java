package com.peter.service;

import java.util.List;
import java.util.Map;

import com.peter.bean.House;
import com.peter.bean.HouseQueryVo;
import com.peter.bean.PageBean;

public interface HouseService {
	
	House findById(int id);
	List<Map<String, String>> analyzeByProperty(String property);
	
	void queryList(HouseQueryVo houseQueryVo);
	
	PageBean<House> getLogHouses(Integer userId,int pc,int ps,String url);
	PageBean<House> getCollectHouses(Integer userId,int pc,int ps,String url);
	PageBean<House> getPhoneHouses(Integer userId,int pc,int ps,String url);
}
