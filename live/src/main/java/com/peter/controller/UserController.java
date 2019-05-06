package com.peter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/login")
	public String index() {
		System.out.println("user login");
		return "/WEB-INF/user/login.jsp";
	}
	@RequestMapping("/getin")
	public String login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username==null||username.trim().equals("")||password==null||password.trim().equals(""))
		{
			//request.setAttribute("errorMsg", "用户名或密码不能为空");
			throw new RuntimeException("用户名或密码不能为空");
		}
		
		request.getSession().setAttribute("user", "");
		return "/WEB-INF/user/login.jsp";
	}
}
