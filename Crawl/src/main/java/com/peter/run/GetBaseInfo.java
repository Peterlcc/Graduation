package com.peter.run;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.peter.bean.Area;
import com.peter.bean.City;
import com.peter.dao.AreaDaoImpl;
import com.peter.dao.CityDaoImpl;
import com.peter.utils.HttpClientRequest;

public class GetBaseInfo {
	public static void main(String[] args) throws Exception {
		//getCityInfo();
		CityDaoImpl cityDaoImpl = new CityDaoImpl();
		List<City> citys = cityDaoImpl.findAll();
		AreaDaoImpl areaDaoImpl=new AreaDaoImpl();
		for (City city : citys) {
			List<Area> areaOfCity = getAreaOfCity(city);
			//System.out.println(city);
			for (Area area : areaOfCity) {
				areaDaoImpl.insert(area);
				//System.out.println(area);
			}
		}
	}
	
	private static List<Area> getAreaOfCity(City city) throws Exception
	{
		HttpClientRequest request = new HttpClientRequest();
		String html = request.request(city.getUrl()+"zufang");
		Document document = Jsoup.parse(html);
		Elements areas = document.select("div.filter ul[data-target=area] li");
		
		List<Area> resList=new ArrayList<Area>();
		
		for (int i = 1; i < areas.size(); i++) {
			Element a = areas.get(i).select("a").first();
			String url = a.attr("href");
			String areaOfCity = a.text();
			Area area=new Area();
			area.setCity(city);
			area.setJobType(1);
			area.setName(areaOfCity);
			area.setUrl(city.getUrl()+url.substring(1));
			
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
		City city=new City();
		CityDaoImpl cityDaoImpl = new CityDaoImpl();
		for (Element li : lis) {
			String provinceLetter = li.select("div.city_firstletter").first().select("span").first().text();
			String province = li.selectFirst("div.city_province").selectFirst("div.city_list_tit.c_b").text();
			Elements cityElements = li.selectFirst("div.city_province").select("ul li a");
			for (Element lic : cityElements) {
				String cityName=lic.text();
				String url=lic.attr("href");
				city.setJobType(0);
				city.setLetter(provinceLetter);
				city.setName(cityName);
				city.setUrl(url);
				city.setProvince(province);
				cityDaoImpl.insert(city);
			}
		}
	}
}
