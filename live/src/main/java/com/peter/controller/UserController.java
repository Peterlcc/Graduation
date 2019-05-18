package com.peter.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		BufferedImage image=(BufferedImage) images[1];
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
		return "/WEB-INF/user/login.jsp";
	}

	@RequestMapping("logout")
	public String logout() {
		request.getSession().setAttribute("user", null);
		return "/house/ilive";
	}

	@RequestMapping("/getin")
	public String login() {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String requestValicode = request.getParameter("valicode");
		String valicode = (String) request.getSession().getAttribute("valicode");
		if (valicode==null) {
			throw new RuntimeException("会话的验证码为null");
		}
		System.out.println(valicode + " -- " + requestValicode);
		if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
			request.setAttribute("errorMsg", "用户名或密码不能为空");
			request.setAttribute("result", false);
			return "redirect:/user/login";
			// throw new RuntimeException("用户名或密码不能为空");
		}
		if (!valicode.toLowerCase().equals(requestValicode.toLowerCase())) {
			request.setAttribute("errorMsg", "验证码错误");
			request.setAttribute("result", false);
			return "redirect:/user/login";
		}
		User user = new User();
		user.setId(null);
		user.setName(username);
		user.setPassword(password);

		ServiceResult<Boolean> result = userService.login(user);
		if (!result.getResult()) {
			request.setAttribute("errorMsg", result.getMsg());
			request.setAttribute("result", result.getResult());
			return "redirect:/user/login";
		} else {
			request.getSession().setAttribute("user", user);
			request.setAttribute("errorMsg", result.getMsg());
			request.setAttribute("result", result.getResult());
			return "/house/home";
		}
	}

	@RequestMapping("/detail")
	public String editDetail() throws UnsupportedEncodingException {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "redirect:/user/login?errorMsg=" + URLEncoder.encode("用户未登录，请先登录", "utf-8") + "&result=" + false;
		}
		String modifyMsgParam = request.getParameter("modifyMsg");
		if (modifyMsgParam != null && !modifyMsgParam.equals("")) {

			String modifyMsg = URLDecoder.decode(modifyMsgParam, "utf-8");
			request.setAttribute("modifyMsg", modifyMsg);
		}

		return "/WEB-INF/user/edit.jsp";
	}

	@RequestMapping("/modify")
	public void modify(User user, HttpServletResponse response) throws IOException {
		User userOld = (User) request.getSession().getAttribute("user");
		
		user.setId(userOld.getId());
		String modifyMsg = null;
		String passwordConfirm = request.getParameter("passwordConfirm");
		String newpassword = request.getParameter("newpassword");
		if ((!user.equals(userOld)) && passwordConfirm != null
				&&!passwordConfirm.equals("")&&newpassword!=null 
				&& passwordConfirm.equals(newpassword)) {
			userService.modify(user);
			modifyMsg = "修改成功";
			request.getSession().setAttribute("user", user);
		} else {
			modifyMsg = "用户没有信息修改或者新密码与确认密码不一致";
		}
		response.sendRedirect("/user/detail?modifyMsg=" + URLEncoder.encode(modifyMsg, "utf-8"));
	}

	@RequestMapping("/add")
	@ResponseBody
	public ServiceResult<Boolean> userAdd(HttpServletRequest request) {
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String majorId = request.getParameter("major_id");
		String age = request.getParameter("age");
		String email = request.getParameter("eamil");
		User user = new User(null, username, password, sex, Integer.parseInt(age), email, Integer.parseInt(majorId));
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
	public String collectedHouses() throws UnsupportedEncodingException {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "redirect:/user/login?errorMsg=" + URLEncoder.encode("用户未登录，请先登录", "utf-8") + "&result=" + false;
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
		return "/WEB-INF/user/collectedHouses.jsp";
	}

	@RequestMapping("/logedHouses")
	public String logedHouses() throws UnsupportedEncodingException {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "redirect:/user/login?errorMsg=" + URLEncoder.encode("用户未登录，请先登录", "utf-8") + "&result=" + false;
		}
		if (user.getId() == null) {
			throw new RuntimeException("logedHouses:userId不能为空");
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
		return "/WEB-INF/user/logedHouses.jsp";
	}

	@RequestMapping("/phonedHouses")
	public String phoneedHouses() throws UnsupportedEncodingException {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "redirect:/user/login?errorMsg=" + URLEncoder.encode("用户未登录，请先登录", "utf-8") + "&result=" + false;
		}
		if (user.getId() == null) {
			throw new RuntimeException("logedHouses:userId不能为空");
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
		return "/WEB-INF/user/phonedHouses.jsp";
	}
}
