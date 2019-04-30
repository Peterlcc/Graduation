package com.peter.parse;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;

import com.peter.bean.Area;
import com.peter.bean.City;
import com.peter.mapper.AreaMapper;
import com.peter.mapper.CityMapper;
import com.peter.utils.HttpClientRequest;

public class AreaInfoParser extends InfoParser {

	public AreaInfoParser(ApplicationContext context) {
		super(context);
	}

	
	
	@Override
	public void parser() {
		CityMapper cityMapper = (CityMapper) context.getBean("cityMapper");
		AreaMapper areaMapper = (AreaMapper) context.getBean("areaMapper");
		List<City> citys = cityMapper.selectAll();
		for (City city : citys) {
			List<Area> areaOfCity = getAreaOfCity(city);
			for (Area area : areaOfCity) {
				areaMapper.insert(area);
			}
		}
	}



	private List<Area> getAreaOfCity(City city) {
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

}
