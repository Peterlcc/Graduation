package com.peter.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.peter.bean.Area;
import com.peter.bean.City;
import com.peter.bean.House;
import com.peter.bean.HouseQueryVo;
import com.peter.bean.PageBean;
import com.peter.bean.User;
import com.peter.service.AreaService;
import com.peter.service.CityService;
import com.peter.service.HouseService;
import com.peter.utils.URLUtil;

@Controller
@RequestMapping("/house")
public class HouseController {
	@Autowired
	private HouseService houseService;
	@Autowired
	private CityService cityService;

	@Autowired
	private AreaService areaService;

	@RequestMapping("/area")
	@ResponseBody
	public Area getArea(String name) {
		Area area = areaService.getAreaByName(name);
		System.out.println(area.getStreets().size());
		return area;
	}
	
	@RequestMapping("/ilive")
	public String ilive()
	{
		return "/WEB-INF/user/ilive.jsp";
	}

	@RequestMapping("/home")
	public String home(HttpServletRequest request) {
		// 查看用户是否已登录

		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("errorMsg", "用户未登录，请先登录");
			request.setAttribute("result", false);
			return "/user/login";
		}

		// 获取当前页，默认1
		int pc = 1;
		String pcString = request.getParameter("pc");
		if (pcString != null && !pcString.equals("")) {
			pc = Integer.parseInt(pcString);
		}

		// 获取页面大小，默认9
		int ps = 9;
		String psString = request.getParameter("ps");
		if (psString != null && !psString.equals("")) {
			ps = Integer.parseInt(psString);
		}
		//
		String url = URLUtil.getUrl(request);
		HouseQueryVo houseQueryVo = null;
		houseQueryVo = new HouseQueryVo();
		if (request.getParameterMap().size() <= 1) {
			houseQueryVo.setHouse(null);
			houseQueryVo.setMaxPrice(null);
			houseQueryVo.setMinPrice(null);
		} else {
			Map<String, String[]> params = request.getParameterMap();
			if (params.containsKey("price")) {
				String priceStr = request.getParameter("price");
				if (priceStr.equals("")) {
					houseQueryVo.setMaxPrice(null);
					houseQueryVo.setMinPrice(null);
				} else {
					String[] split = priceStr.split("-");
					houseQueryVo.setMaxPrice(Double.parseDouble(split[1]));
					houseQueryVo.setMinPrice(Double.parseDouble(split[0]));
				}
			}
			String area = null;
			String street = null;
			if (params.containsKey("area")) {
				area = request.getParameter("area");
			}
			if (params.containsKey("street")) {
				street = request.getParameter("street");
			}
			if (area != null || street != null) {
				House house = new House();
				house.setAreaCity(area.equals("") ? null : area);
				house.setStreet(street.equals("") ? null : street);
				System.out.println(house);
				houseQueryVo.setHouse(house);
			}
		}
		PageBean<House> pageBean = new PageBean<House>();
		pageBean.setCurrentPage(pc);
		pageBean.setPageSize(ps);
		pageBean.setUrl(url);
		houseQueryVo.setPageBean(pageBean);
		//
		houseService.queryList(houseQueryVo);
		request.setAttribute("houseQueryVo", houseQueryVo);
		City city = cityService.getCityById(44);// cityid of tianjin is 44
		request.setAttribute("city", city);
		String priceStr = URLUtil.getPriceStr(houseQueryVo.getMinPrice(), houseQueryVo.getMaxPrice());
		if(priceStr!=null) request.setAttribute("priceStr", priceStr);
		return "/WEB-INF/user/home.jsp";
	}

	@RequestMapping("/detail")
	public String getHouseDetail(HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("errorMsg", "用户未登录，请先登录");
			request.setAttribute("result", false);
			return "/user/login";
		}

		String idString = request.getParameter("id");
		if (idString == null) {
			throw new RuntimeException("房屋id不能为空");
		}
		Integer id = Integer.parseInt(idString);
		House house = houseService.findById(id);
		request.setAttribute("house", house);
		System.out.println("recommands size*****"+user.getRecommands().size());
		return "/WEB-INF/user/houseDetail.jsp";
	}

}
