package com.peter.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.peter.service.AnalyzeService;
import com.peter.service.HouseService;
import com.peter.service.UserService;

@Controller
@RequestMapping("/analyze")
public class AnalyzeController {
	@Autowired
	private HouseService houseService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private AnalyzeService analyzeService;

	@RequestMapping("/houseAnalyze")
	@ResponseBody
	public String houseAnalyze(HttpServletRequest request) {
		/*
		 * Admin admin = (Admin) request.getSession().getAttribute("admin"); if
		 * (admin==null) { request.setAttribute("errorMsg", "管理员未登录"); return
		 * "/admin/login"; }
		 */
		String property = request.getParameter("property");
		if (property == null) {
			return null;
		}
		List<Map<String, String>> map = houseService.analyzeByProperty(property);
		JSONArray jsonArray = new JSONArray(map);

		return jsonArray.toString();
	}

	@RequestMapping("/userAnalyze")
	@ResponseBody
	public String userAnalyze(HttpServletRequest request) {
		/*
		 * Admin admin = (Admin) request.getSession().getAttribute("admin"); if
		 * (admin==null) { request.setAttribute("errorMsg", "管理员未登录"); return
		 * "/admin/login"; }
		 */
		String property = request.getParameter("property");
		if (property == null) {
			return null;
		}
		List<Map<String, String>> map = userService.analyzeByProperty(property);
		JSONArray jsonArray = new JSONArray(map);

		return jsonArray.toString();
	}

	@RequestMapping("/userAndHouseAnalyze")
	@ResponseBody
	public String userAndHouseAnalyze(HttpServletRequest request) {
		/*
		 * Admin admin = (Admin) request.getSession().getAttribute("admin"); if
		 * (admin==null) { request.setAttribute("errorMsg", "管理员未登录"); return
		 * "/admin/login"; }
		 */
		
		String userProperty = request.getParameter("userProperty");
		String houseProperty = request.getParameter("houseProperty");
		String middleTable = request.getParameter("middleTable");
		if (userProperty == null || houseProperty == null || middleTable == null) {
			return null;
		}
		if (userProperty.trim().equals("") || houseProperty.trim().equals("") || middleTable.trim().equals("")) {
			return null;
		}
		List<Map<String, String>> map = analyzeService.analyzeByProperty(userProperty, houseProperty, middleTable);
		JSONArray jsonArray = new JSONArray(map);

		return jsonArray.toString();
	}
}
