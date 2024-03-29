package com.peter.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peter.bean.House;
import com.peter.bean.HouseQueryVo;
import com.peter.bean.PageBean;
import com.peter.bean.Recommand;
import com.peter.bean.User;
import com.peter.mapper.HouseAnalyzeMapper;
import com.peter.mapper.HouseMapper;
import com.peter.mapper.RecommandMapper;
import com.peter.service.HouseService;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseMapper houseMapper;
	
	@Autowired
	private HouseAnalyzeMapper houseAnalyzeMapper;
	
	@Autowired
	private RecommandMapper recommandMapper;

	@Override
	public House findById(int id,User user) {
		House house = houseMapper.selectByPrimaryKey(id);
		List<Recommand> recommands = recommandMapper.selectByUser(user.getId(), house.getAreaCity());
		user.setRecommands(recommands);
		if (user.getRecommands()==null||user.getRecommands().size()<4) {
			user.getRecommands().addAll(recommandMapper.selectRandomly(4-user.getRecommands().size()));
		}
		return house;
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

	}

	@Override
	public List<Map<String, String>> analyzeByProperty(String property,String aggregate,String aggregation) {
		
		return houseAnalyzeMapper.selectByProperty(property,aggregate,aggregation);
	}

	@Override
	public PageBean<House> getLogHouses(Integer userId,int pc,int ps,String url) {
		PageBean<House> pageBean=new PageBean<>();
		pageBean.setTotalRecord(houseMapper.selectLogHousesTotalRecord(userId));
		pageBean.setCurrentPage(pc);
		pageBean.setPageSize(ps);
		pageBean.setBeanList(houseMapper.selectLogHouses(userId, (pageBean.getCurrentPage()-1)*pageBean.getPageSize(), pageBean.getPageSize()));
		pageBean.setUrl(url);
		return pageBean;
	}

	@Override
	public PageBean<House> getCollectHouses(Integer userId, int pc, int ps, String url) {
		PageBean<House> pageBean=new PageBean<>();
		pageBean.setTotalRecord(houseMapper.selectCollectHousesTotalRecord(userId));
		pageBean.setCurrentPage(pc);
		pageBean.setPageSize(ps);
		pageBean.setBeanList(houseMapper.selectCollectHouses(userId, (pageBean.getCurrentPage()-1)*pageBean.getPageSize(), pageBean.getPageSize()));
		pageBean.setUrl(url);
		return pageBean;
	}

	@Override
	public PageBean<House> getPhoneHouses(Integer userId, int pc, int ps, String url) {
		PageBean<House> pageBean=new PageBean<>();
		pageBean.setTotalRecord(houseMapper.selectPhoneHousesTotalRecord(userId));
		pageBean.setCurrentPage(pc);
		pageBean.setPageSize(ps);
		pageBean.setBeanList(houseMapper.selectPhoneHouses(userId, (pageBean.getCurrentPage()-1)*pageBean.getPageSize(), pageBean.getPageSize()));
		pageBean.setUrl(url);
		return pageBean;
	}

	@Override
	public PageBean<House> getAllHouses(int pc, int ps, String url) {
		PageBean<House> pageBean=new PageBean<>();
		pageBean.setTotalRecord(houseMapper.selectAllTotalRecord());
		pageBean.setCurrentPage(pc);
		pageBean.setPageSize(ps);
		pageBean.setBeanList(houseMapper.selectAll((pageBean.getCurrentPage()-1)*pageBean.getPageSize(), pageBean.getPageSize()));
		pageBean.setUrl(url);
		return pageBean;
	}
}
