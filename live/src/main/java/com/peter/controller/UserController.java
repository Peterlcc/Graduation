package com.peter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.peter.bean.ServiceResult;
import com.peter.bean.User;
import com.peter.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String index() {
		System.out.println("user login");
		return "/WEB-INF/user/login.jsp";
	}

	@RequestMapping("/getin")
	public String login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+" -- "+password);
		if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
			request.setAttribute("errorMsg", "用户名或密码不能为空");
			request.setAttribute("result", false);
			return "/user/login";
			// throw new RuntimeException("用户名或密码不能为空");
		}
		User user = new User();
		user.setId(null);
		user.setName(username);
		user.setPassword(password);

		ServiceResult<Boolean> result = userService.login(user);
		System.out.println(result);
		if (!result.getResult()) {
			request.setAttribute("errorMsg", result.getMsg());
			request.setAttribute("result", result.getResult());
			return "/user/login";
		}
		else
		{
			request.getSession().setAttribute("user", user);
			request.setAttribute("errorMsg", result.getMsg());
			request.setAttribute("result", result.getResult());
			return "/house/home";
		}
	}
}
