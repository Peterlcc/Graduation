package com.peter.service;

import com.peter.bean.Admin;
import com.peter.bean.ServiceResult;

public interface AdminService {
	Admin getAdminByName(String name);
	Admin getAdminById(Integer id);
	ServiceResult<Admin> login(Admin admin);
	void modify(Admin admin);
}
