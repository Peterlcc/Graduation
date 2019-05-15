package com.peter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peter.bean.Admin;
import com.peter.bean.ServiceResult;
import com.peter.mapper.AdminMapper;
import com.peter.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public Admin getAdminByName(String name) {
		
		return null;
	}

	@Override
	public Admin getAdminById(Integer id) {
		return null;
	}

	@Override
	public ServiceResult<Admin> login(Admin admin) {
		Admin selectByName = adminMapper.selectByName(admin.getName());
		ServiceResult<Admin> result=new ServiceResult<>();
		if (selectByName!=null&&selectByName.getPassword().equals(admin.getPassword())) {
			result.setResult(selectByName);
			result.setMsg(null);
		}
		else {
			result.setResult(null);
			result.setMsg("用户名或密码错误");
		}
		return result;
	}

}
