package com.peter.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.peter.bean.Collect;
import com.peter.bean.House;
import com.peter.bean.Log;
import com.peter.bean.PageBean;
import com.peter.bean.Phone;
import com.peter.bean.ServiceResult;
import com.peter.bean.User;
import com.peter.service.CollectService;
import com.peter.service.HouseService;
import com.peter.service.LogService;
import com.peter.service.PhoneService;
import com.peter.service.UserService;
import com.peter.utils.URLUtil;
import com.peter.utils.VerifyUtil;;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private UserService userService;

	@Autowired
	private CollectService collectService;

	@Autowired
	private LogService logService;

	@Autowired
	private PhoneService phoneService;

	@Autowired
	private HouseService houseService;

	@RequestMapping("/code")
	public void getCode(HttpServletResponse response) throws IOException {
		Object[] images = VerifyUtil.createImage();
		request.getSession().setAttribute("valicode", images[0]);
		BufferedImage image = (BufferedImage) images[1];
		response.setContentType("image/png");
		OutputStream os = response.getOutputStream();
		ImageIO.write(image, "png", os);

	}

	@RequestMapping("register")
	public String register() {

		return "/WEB-INF/user/register.jsp";
	}

	@RequestMapping("/login")
	public String index() {
		String errorMsg = request.getParameter("errorMsg");
		if (errorMsg != null) {
			request.setAttribute("errorMsg", errorMsg);
		}
		return "/WEB-INF/user/login.jsp";
	}

	@RequestMapping("logout")
	public ModelAndView logout() {
		ModelAndView modelAndView = new ModelAndView("redirect:/house/ilive");
		request.getSession().setAttribute("user", null);
		return modelAndView;
	}

	@RequestMapping("/getin")
	public ModelAndView login() {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String requestValicode = request.getParameter("valicode");
		String valicode = (String) request.getSession().getAttribute("valicode");
		if (valicode == null) {
			throw new RuntimeException("会话的验证码为null");
		}
		ModelAndView modelAndView = new ModelAndView();
		if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
			modelAndView.addObject("errorMsg", "用户名或密码不能为空");
			modelAndView.addObject("result", false);
			modelAndView.setViewName("redirect:/user/login");
			return modelAndView;
		}
		if (!valicode.toLowerCase().equals(requestValicode.toLowerCase())) {
			modelAndView.addObject("errorMsg", "验证码错误");
			modelAndView.addObject("result", false);
			modelAndView.setViewName("redirect:/user/login");
			return modelAndView;
		}
		User user = new User();
		user.setId(null);
		user.setName(username);
		user.setPassword(password);

		ServiceResult<Boolean> result = userService.login(user);
		if (!result.getResult()) {
			modelAndView.addObject("errorMsg", result.getMsg());
			modelAndView.addObject("result", result.getResult());
			modelAndView.setViewName("redirect:/user/login");
			return modelAndView;
		} else {
			request.getSession().setAttribute("user", user);
			modelAndView.setViewName("redirect:/house/ilive");
			return modelAndView;
		}
	}

	@RequestMapping("/detail")
	public ModelAndView editDetail() throws UnsupportedEncodingException {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			modelAndView.addObject("errorMsg", "用户未登录，请先登录");
			modelAndView.addObject("result", false);
			modelAndView.setViewName("redirect:/user/login");
			return modelAndView;
		}
		String modifyMsg = request.getParameter("modifyMsg");
		if (modifyMsg != null && !modifyMsg.equals("")) {
			request.setAttribute("modifyMsg", modifyMsg);
		}
		modelAndView.setViewName("/WEB-INF/user/edit.jsp");
		return modelAndView;
	}

	@RequestMapping("passwordEdit")
	public ModelAndView passwordEdit() {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			modelAndView.addObject("errorMsg", "用户未登录，请先登录");
			modelAndView.addObject("result", false);
			modelAndView.setViewName("redirect:/user/login");
			return modelAndView;
		}
		String passwordModifyMsg = request.getParameter("passwordModifyMsg");
		if (passwordModifyMsg != null && !passwordModifyMsg.equals("")) {
			request.setAttribute("passwordModifyMsg", passwordModifyMsg);
		}
		modelAndView.setViewName("/WEB-INF/user/editPassword.jsp");
		return modelAndView;
	}

	@RequestMapping("/modify")
	public ModelAndView modify(User user) throws IOException {
		User userOld = (User) request.getSession().getAttribute("user");
		if (userOld == null) {
			throw new RuntimeException("来自未登录用户的请求");
		}
		if (!user.getName().equals(userOld.getName())) {
			throw new RuntimeException("来自名称不一致的用户请求");
		}
		ModelAndView modelAndView = new ModelAndView();
		if (user == null || StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassword())) {
			modelAndView.addObject("modifyMsg", "用户名或密码为空");
			modelAndView.setViewName("redirect:/user/detail");
			return modelAndView;
		}
		user.setId(userOld.getId());
		if (!user.equals(userOld)) {
			userService.modify(user);
			modelAndView.addObject("modifyMsg", "修改成功");
			request.getSession().setAttribute("user", user);
		} else {
			modelAndView.addObject("modifyMsg", "用户没有信息修改");
		}
		modelAndView.setViewName("redirect:/user/detail");
		return modelAndView;
	}

	@RequestMapping("passwordModify")
	public ModelAndView passwordModify(User user) {
		User userOld = (User) request.getSession().getAttribute("user");
		if (userOld == null) {
			throw new RuntimeException("来自未登录用户的请求");
		}
		if (!user.getName().equals(userOld.getName())) {
			throw new RuntimeException("来自名称不一致的用户请求");
		}
		ModelAndView modelAndView = new ModelAndView();
		if (user == null || StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassword())) {
			modelAndView.addObject("passwordModifyMsg", "用户名或密码为空");
			modelAndView.setViewName("redirect:/user/passwordEdit");
			return modelAndView;
		}
		String passwordConfirm = request.getParameter("passwordConfirm");
		String newpassword = request.getParameter("newpassword");
		if (StringUtils.isEmpty(passwordConfirm)||StringUtils.isEmpty(newpassword)) {
			modelAndView.addObject("passwordModifyMsg", "新密码或者确认密码为空");
			modelAndView.setViewName("redirect:/user/passwordEdit");
			return modelAndView;
		}
		if (userOld.getPassword().equals(newpassword)) {
			modelAndView.addObject("passwordModifyMsg", "新密码与原密码相同");
			modelAndView.setViewName("redirect:/user/passwordEdit");
			return modelAndView;
		}
		userOld.setPassword(newpassword);
		userService.modify(userOld);
		modelAndView.addObject("passwordModifyMsg", "密码修改成功");
		modelAndView.setViewName("redirect:/user/passwordEdit");
		return modelAndView;
	}

	@RequestMapping("/add")
	@ResponseBody
	public ServiceResult<Boolean> userAdd(User user) {
		System.out.println(user);
		ServiceResult<Boolean> result = userService.add(user);
		return result;
	}

	@RequestMapping("/collect")
	@ResponseBody
	public Collect getCollect(Integer userId, Integer houseId) {
		return collectService.getCollectByUserAndHouse(userId, houseId);
	}

	@RequestMapping("/userCollect")
	@ResponseBody
	public Collect userCollect(Integer userId, Integer houseId) {
		return collectService.setCollectByUserAndHouse(userId, houseId);
	}

	@RequestMapping("/log")
	@ResponseBody
	public Log collectLog(Integer userId, Integer houseId) {
		return logService.getLogByUserAndHouse(userId, houseId);
	}

	@RequestMapping("/phone")
	@ResponseBody
	public Phone collectPhone(Integer userId, Integer houseId) {
		return phoneService.getPhoneByUserAndHouse(userId, houseId);
	}

	@RequestMapping("/collectedHouses")
	public ModelAndView collectedHouses() throws UnsupportedEncodingException {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			modelAndView.addObject("errorMsg", "用户未登录，请先登录");
			modelAndView.addObject("result", false);
			modelAndView.setViewName("redirect:/user/login");
			return modelAndView;
		}
		if (user.getId() == null) {
			throw new RuntimeException("collectedHouses:userId不能为空");
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
		PageBean<House> pageBean = houseService.getCollectHouses(user.getId(), pc, ps, url);
		request.setAttribute("pageBean", pageBean);
		System.out.println(pageBean.getTotalPage());
		modelAndView.setViewName("/WEB-INF/user/collectedHouses.jsp");
		return modelAndView;
	}

	@RequestMapping("/logedHouses")
	public ModelAndView logedHouses() throws UnsupportedEncodingException {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			modelAndView.addObject("errorMsg", "用户未登录，请先登录");
			modelAndView.addObject("result", false);
			modelAndView.setViewName("redirect:/user/login");
			return modelAndView;
		}
		if (user.getId() == null) {
			throw new RuntimeException("collectedHouses:userId不能为空");
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
		PageBean<House> pageBean = houseService.getLogHouses(user.getId(), pc, ps, url);
		request.setAttribute("pageBean", pageBean);
		System.out.println(pageBean.getTotalPage());
		modelAndView.setViewName("/WEB-INF/user/logedHouses.jsp");
		return modelAndView;
	}

	@RequestMapping("/phonedHouses")
	public ModelAndView phoneedHouses() throws UnsupportedEncodingException {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			modelAndView.addObject("errorMsg", "用户未登录，请先登录");
			modelAndView.addObject("result", false);
			modelAndView.setViewName("redirect:/user/login");
			return modelAndView;
		}
		if (user.getId() == null) {
			throw new RuntimeException("collectedHouses:userId不能为空");
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
		PageBean<House> pageBean = houseService.getPhoneHouses(user.getId(), pc, ps, url);
		request.setAttribute("pageBean", pageBean);
		System.out.println(pageBean.getTotalPage());
		modelAndView.setViewName("/WEB-INF/user/phonedHouses.jsp");
		return modelAndView;
	}
}
