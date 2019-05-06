package com.peter.service;

import java.util.List;

import com.peter.bean.ServiceResult;
import com.peter.bean.User;

public interface UserService {
	User findById(int id);
	User findByName(String name);
	ServiceResult<Boolean> login(User user);
	ServiceResult<Boolean> modify(User user);
	ServiceResult<List<User>> list(int start,int size);
}
