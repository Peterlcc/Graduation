package com.peter.run;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.bcel.classfile.Field;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;
import com.peter.bean.Area;
import com.peter.bean.City;
import com.peter.bean.Page;
import com.peter.bean.Street;
import com.peter.mapper.AreaMapper;
import com.peter.mapper.CityMapper;
import com.peter.mapper.PageMapper;
import com.peter.mapper.StreetMapper;
import com.peter.utils.CrawlConfig;
import com.peter.utils.HtmlUnitRequest;
import com.peter.utils.HttpClientRequest;
import com.peter.utils.JedisPoolUtil;
import com.peter.utils.RedisUtil;

import redis.clients.jedis.Jedis;

public class GetBaseInfo {
	private static final String host = "https://tj.lianjia.com";
	private static Random random = new Random();
	private static ApplicationContext context;

	private static void init() {
		context = CrawlConfig.getApplicationContext();
	}

	public static void main(String[] args) throws Exception {
		init();

		//getStreetsFromAreas();
		StreetMapper streetMapper = context.getBean(StreetMapper.class);
		Street street = streetMapper.selectByPrimaryKey(1);
		System.out.println(street);
	}

	public static void getStreetsFromAreas() throws Exception, InterruptedException {
		AreaMapper areaMapper = (AreaMapper) context.getBean("areaMapper");
		

		StreetMapper streetMapper = (StreetMapper) context.getBean("streetMapper");
		HttpClientRequest request = new HttpClientRequest();

		//List<Area> areas = areaMapper.selectAll();
		Street street = new Street();
		for (int i=494;i<=498;i++) {
			Area area = areaMapper.selectByPrimaryKey(i);
			System.out.print("areaId:"+area.getId());
			String html = request.request(area.getUrl());
			System.out.print("html got! ");
			Document doc = Jsoup.parse(html);
			
			Elements streetEles = doc
					.select("div.filter > div.filter__wrapper.w1150> ul[data-target=area] > li.filter__item--level3 > a");
			System.out.println("doc got!");
			
			if (streetEles == null || streetEles.size() == 0) {
				System.out.println("**************");
				System.out.println(area);
				System.out.println("**************");
			}
			for (int j = 1; j < streetEles.size(); j++) {
				Element streetEle = streetEles.get(j);
				
				street.setId(null);
				street.setAreaId(area.getId());
				String host = area.getCity().getUrl();
				street.setUrl(host.substring(0, host.length() - 1) + streetEle.attr("href"));
				street.setName(streetEle.text());
				street.setJobType(2);

				streetMapper.insertSelective(street);
				System.out.println("street:"+street.getId());
				Thread.sleep(3000+random.nextInt(3)*1000);
			}
			Thread.sleep(5000+random.nextInt(4)*1000);
			
		}
	}

	public static void getAreaFromCity() throws Exception {
		CityMapper cityMapper = (CityMapper) context.getBean("cityMapper");
		AreaMapper areaMapper = (AreaMapper) context.getBean("areaMapper");
		List<City> citys = cityMapper.selectAll();
		for (City city : citys) {
			List<Area> areaOfCity = getAreaOfCity(city);
			// System.out.println(city);
			for (Area area : areaOfCity) {
				areaMapper.insert(area);
				// System.out.println(area);
			}
		}
	}

	private static List<Area> getAreaOfCity(City city) throws Exception {
		HttpClientRequest request = new HttpClientRequest();
		String html = request.request(city.getUrl() + "zufang");
		Document document = Jsoup.parse(html);
		Elements areas = document.select("div.filter ul[data-target=area] li");

		List<Area> resList = new ArrayList<Area>();

		for (int i = 1; i < areas.size(); i++) {
			Element a = areas.get(i).select("a").first();
			String url = a.attr("href");
			String areaOfCity = a.text();
			Area area = new Area();
			area.setCity(city);
			area.setJobType(1);
			area.setName(areaOfCity);
			area.setUrl(city.getUrl() + url.substring(1));

			resList.add(area);
		}
		return resList;
	}

	private static void getCityInfo() throws Exception {
		HttpClientRequest request = new HttpClientRequest();
		String html = request.request("https://www.lianjia.com/city/");
		Document document = Jsoup.parse(html);
		Element cityUl = document.select("div.city_selection_section >div.city_recommend > div > div > ul").first();
		Elements lis = cityUl.select("li.city_list_li.city_list_li_selected");
		City city = new City();
		CityMapper cityMapper = (CityMapper) context.getBean("cityMapper");
		for (Element li : lis) {
			String provinceLetter = li.select("div.city_firstletter").first().select("span").first().text();
			String province = li.selectFirst("div.city_province").selectFirst("div.city_list_tit.c_b").text();
			Elements cityElements = li.selectFirst("div.city_province").select("ul li a");
			for (Element lic : cityElements) {
				String cityName = lic.text();
				String url = lic.attr("href");
				city.setJobType(0);
				city.setLetter(provinceLetter);
				city.setName(cityName);
				city.setUrl(url);
				city.setProvince(province);
				cityMapper.insert(city);
			}
		}
	}
}
