package com.peter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.peter.bean.User;
import com.peter.service.HouseService;

@Controller
@RequestMapping("/house")
public class HouseController {
	@Autowired
	private HouseService houseService;
	
	@RequestMapping("/home")
	public String home(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user==null) {
			request.setAttribute("errorMsg", "用户未登录，请先登录");
			request.setAttribute("result", false);
			return "/user/login";
		}
		//TODO 返回home页需要的房屋信息列表
		
		return "/WEB-INF/user/home.jsp";
	}
}
