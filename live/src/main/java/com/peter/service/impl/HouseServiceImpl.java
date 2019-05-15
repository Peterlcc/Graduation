package com.peter.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peter.bean.House;
import com.peter.bean.HouseQueryVo;
import com.peter.bean.PageBean;
import com.peter.mapper.HouseAnalyzeMapper;
import com.peter.mapper.HouseMapper;
import com.peter.service.HouseService;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseMapper houseMapper;
	
	@Autowired
	private HouseAnalyzeMapper houseAnalyzeMapper;

	@Override
	public House findById(int id) {
		return houseMapper.selectByPrimaryKey(id);
	}

	@Override
	public void queryList(HouseQueryVo houseQueryVo) {
		PageBean<House> pageBean = houseQueryVo.getPageBean();

		Map<String, Object> map=new HashMap<>();
		map.put("houseQueryVo", houseQueryVo);
		map.put("start", (pageBean.getCurrentPage() - 1) * pageBean.getPageSize());
		map.put("size", pageBean.getPageSize());
		pageBean.setTotalRecord(houseMapper.selectTotalRecord(map));
		pageBean.setBeanList(houseMapper.selectHouseList(map));
		for(House house:pageBean.getBeanList())
		{
			if (house.getTitle().length()>15) {
				house.setTitle(house.getTitle().substring(0, 12)+"...");
			}
		}
		System.out.println("service queryvo.beanlist:"+houseQueryVo.getPageBean().getBeanList());

	}

	@Override
	public List<Map<String, String>> analyzeByProperty(String property) {
		
		return houseAnalyzeMapper.selectByProperty(property);
	}
}
