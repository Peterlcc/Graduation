package com.peter.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.peter.bean.Admin;
import com.peter.bean.House;
import com.peter.bean.PageBean;
import com.peter.bean.ServiceResult;
import com.peter.bean.User;
import com.peter.service.AdminService;
import com.peter.service.HouseService;
import com.peter.service.UserService;
import com.peter.utils.URLUtil;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private UserService userService;

	@Autowired
	private HouseService houseService;

	@RequestMapping("login")
	public String login(HttpServletRequest request) {
		String errorMsg = request.getParameter("errorMsg");
		if (errorMsg != null) {
			request.setAttribute("errorMsg", errorMsg);
		}
		return "/WEB-INF/admin/login.jsp";
	}

	@RequestMapping("logout")
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("redirect:/admin/login");
		request.getSession().setAttribute("admin", null);
		return modelAndView;
	}

	@RequestMapping("getin")
	public ModelAndView getin(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		Admin admin = new Admin(null, name, password);
		ServiceResult<Admin> result = adminService.login(admin);
		if (result.getResult() == null) {
			modelAndView.addObject("errorMsg", result.getMsg());
			modelAndView.addObject("result", false);
			modelAndView.setViewName("redirect:/admin/login");
			return modelAndView;
		}
		request.getSession().setAttribute("admin", result.getResult());
		modelAndView.setViewName("redirect:/admin/analyze");
		return modelAndView;
	}

	@RequestMapping("/analyze")
	public ModelAndView analyze(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			modelAndView.addObject("errorMsg", "管理员未登录");
			modelAndView.setViewName("redirect:/admin/login");
			return modelAndView;
		}
		modelAndView.setViewName("/WEB-INF/admin/analyze.jsp");
		return modelAndView;
	}
	@RequestMapping("/simpleAnalyze")
	public ModelAndView simpleAnalyze(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			modelAndView.addObject("errorMsg", "管理员未登录");
			modelAndView.setViewName("redirect:/admin/login");
			return modelAndView;
		}
		modelAndView.setViewName("/WEB-INF/admin/simpleAnalyze.jsp");
		return modelAndView;
	}

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			modelAndView.addObject("errorMsg", "管理员未登录");
			modelAndView.setViewName("redirect:/admin/login");
			return modelAndView;
		}
		modelAndView.setViewName("/WEB-INF/admin/edit.jsp");
		String modifyMsg = request.getParameter("modifyMsg");
		if (!StringUtils.isEmpty(modifyMsg)) {
			modelAndView.addObject("modifyMsg", modifyMsg);
		}
		return modelAndView;
	}

	@RequestMapping("/modify")
	public ModelAndView modify(Admin admin, HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException {
		Admin adminOld = (Admin) request.getSession().getAttribute("admin");
		if (adminOld==null) {
			throw new RuntimeException("管理员未登录");
		}
		ModelAndView modelAndView=new ModelAndView();
		admin.setId(adminOld.getId());
		String passwordConfirm = request.getParameter("passwordConfirm");
		String newpassword = request.getParameter("newpassword");
		if ((!admin.equals(adminOld)) && passwordConfirm != null && !passwordConfirm.equals("") && newpassword != null
				&& passwordConfirm.equals(newpassword)) {
			admin.setPassword(newpassword);
			adminService.modify(admin);
			modelAndView.addObject("modifyMsg", "修改成功");
			request.getSession().setAttribute("admin", admin);
		} else {
			modelAndView.addObject("modifyMsg", "用户没有信息修改或者新密码与确认密码不一致");
		}
		modelAndView.setViewName("redirect:/admin/edit");
		return modelAndView;
	}

	@RequestMapping("/users")
	public ModelAndView getUsers(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			modelAndView.addObject("errorMsg", "管理员未登录");
			modelAndView.setViewName("redirect:/admin/login");
			return modelAndView;
		}
		// 获取当前页，默认1
		int pc = 1;
		String pcString = request.getParameter("pc");
		if (pcString != null && !pcString.equals("")) {
			pc = Integer.parseInt(pcString);
		}

		// 获取页面大小，默认5
		int ps = 5;
		String psString = request.getParameter("ps");
		if (psString != null && !psString.equals("")) {
			ps = Integer.parseInt(psString);
		}
		//
		String url = URLUtil.getUrl(request);
		PageBean<User> pageBean = userService.getAllUsers(pc, ps, url);
		request.setAttribute("pageBean", pageBean);
		System.out.println(pageBean.getTotalPage());
		modelAndView.setViewName("/WEB-INF/admin/users.jsp");
		return modelAndView;
	}

	@RequestMapping("/houses")
	public ModelAndView getHouses(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			modelAndView.addObject("errorMsg", "管理员未登录");
			modelAndView.setViewName("redirect:/admin/login");
			return modelAndView;
		}
		// 获取当前页，默认1
		int pc = 1;
		String pcString = request.getParameter("pc");
		if (pcString != null && !pcString.equals("")) {
			pc = Integer.parseInt(pcString);
		}

		// 获取页面大小，默认5
		int ps = 5;
		String psString = request.getParameter("ps");
		if (psString != null && !psString.equals("")) {
			ps = Integer.parseInt(psString);
		}
		//
		String url = URLUtil.getUrl(request);
		PageBean<House> pageBean = houseService.getAllHouses(pc, ps, url);
		request.setAttribute("pageBean", pageBean);
		System.out.println(pageBean.getTotalPage());
		modelAndView.setViewName("/WEB-INF/admin/houses.jsp");
		return modelAndView;
	}
}
