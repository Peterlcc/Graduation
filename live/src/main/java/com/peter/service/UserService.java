package com.peter.service;

import java.util.List;
import java.util.Map;

import com.peter.bean.PageBean;
import com.peter.bean.ServiceResult;
import com.peter.bean.User;

public interface UserService {
	User findById(int id);
	User findByName(String name);
	
	ServiceResult<Boolean> add(User user);
	
	ServiceResult<Boolean> login(User user);
	ServiceResult<Boolean> modify(User user);
	ServiceResult<List<User>> list(int start,int size);
	
	List<Map<String, String>> analyzeByProperty(String property, String aggregate, String aggregation);
	
	PageBean<User> getAllUsers(int pc,int ps,String url);
}
