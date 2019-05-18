package com.peter.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.peter.bean.Admin;
import com.peter.bean.ServiceResult;
import com.peter.service.AdminService;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	
	@RequestMapping("login")
	public String login() {
		return "/WEB-INF/admin/login.jsp";
	}
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		request.getSession().setAttribute("admin", null);
		return "/admin/login";
	}
	
	@RequestMapping("getin")
	public String getin(HttpServletRequest request) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		Admin admin=new Admin(null, name, password);
		ServiceResult<Admin> result = adminService.login(admin);
		if (result.getResult()==null) {
			request.setAttribute("errorMsg", result.getMsg());
			return "/WEB-INF/admin/login.jsp";
		}
		request.getSession().setAttribute("admin", result.getResult());
		return "/admin/analyze";
	}
	
	@RequestMapping("/analyze")
	public String analyze(HttpServletRequest request) {
		/*Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin==null) {
			request.setAttribute("errorMsg", "管理员未登录");
			return "/admin/login";
		}*/
		return "/WEB-INF/admin/analyze.jsp";
	}
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request) {
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin==null) {
			request.setAttribute("errorMsg", "管理员未登录");
			return "/admin/login";
		}
		return "/WEB-INF/admin/edit.jsp";
	}
	
	@RequestMapping("/modify")
	public void modify(Admin admin,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException, IOException {
		Admin adminOld = (Admin) request.getSession().getAttribute("admin");
		admin.setId(admin.getId());
		String modifyMsg = null;
		String passwordConfirm = request.getParameter("passwordConfirm");
		String newpassword = request.getParameter("newpassword");
		if ((!admin.equals(adminOld)) && passwordConfirm != null
				&&!passwordConfirm.equals("")&&newpassword!=null 
				&& passwordConfirm.equals(newpassword)) {
			//adminService.modify(admin);
			modifyMsg = "修改成功";
			request.getSession().setAttribute("admin", admin);
		} else {
			modifyMsg = "用户没有信息修改或者新密码与确认密码不一致";
		}
		response.sendRedirect("/admin/edit?modifyMsg=" + URLEncoder.encode(modifyMsg, "utf-8"));
		
	}
}
