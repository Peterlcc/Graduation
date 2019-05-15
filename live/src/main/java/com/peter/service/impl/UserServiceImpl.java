package com.peter.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peter.bean.ServiceResult;
import com.peter.bean.User;
import com.peter.mapper.UserAnalyzeMapper;
import com.peter.mapper.UserMapper;
import com.peter.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserAnalyzeMapper userAnalyzeMapper;

	@Override
	public ServiceResult<Boolean> login(User user) {
		List<User> users = userMapper.selectByName(user.getName());
		ServiceResult<Boolean> result=new ServiceResult<>();
		if (users==null||users.size()==0) {
			result.setResult(false);
			result.setMsg("用户名或密码不正确！");
			return result;
		}
		if (users.size()>1) {
			result.setResult(false);
			result.setMsg("用户名不唯一，请确认您的用户名是否正确！");
			return result;
		}
		User userFind = users.get(0);
		if (!user.getPassword().equals(userFind.getPassword())) {
			result.setResult(false);
			result.setMsg("用户名或密码错误！");
			return result;
		}
		
		user.clone(userFind);
		result.setResult(true);
		result.setMsg(null);
		return result;
	}

	@Override
	public ServiceResult<Boolean> modify(User user) {
		if (user.getId()==null) {
			throw new RuntimeException("修改的用户id不能为空！");
		}
		userMapper.updateByPrimaryKeySelective(user);
		return null;
	}

	@Override
	public ServiceResult<List<User>> list(int start, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(int id) {
		
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public User findByName(String name) {
		return userMapper.selectByName(name).get(0);
	}

	@Override
	public ServiceResult<Boolean> add(User user) {
		List<User> users = userMapper.selectByName(user.getName());
		ServiceResult<Boolean> result=new ServiceResult<>();
		if (users==null||users.size()==0) {
			int insertSelective = userMapper.insertSelective(user);
			if (insertSelective==1) {
				result.setResult(true);
				result.setMsg(null);
			}
			else {
				result.setResult(false);
				result.setMsg("插入失败");
			}
		}
		else{
			result.setResult(false);
			result.setMsg("用户已存在");
		}
		return result;
	}

	@Override
	public List<Map<String, String>> analyzeByProperty(String property) {
		return userAnalyzeMapper.selectByProperty(property);
	}

}
