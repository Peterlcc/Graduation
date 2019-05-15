package com.peter.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peter.mapper.AnalyzeMapper;
import com.peter.service.AnalyzeService;

@Service
public class AnalyzeServiceImpl implements AnalyzeService{

	@Autowired
	private AnalyzeMapper analyzeMapper;
	@Override
	public List<Map<String, String>> analyzeByProperty(String userProperty, String houseProperty, String middleTable) {
		
		return analyzeMapper.selectByPropertys(userProperty, houseProperty, middleTable);
	}

}
