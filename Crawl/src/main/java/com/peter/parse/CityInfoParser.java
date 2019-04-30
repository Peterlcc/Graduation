package com.peter.parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;

import com.peter.bean.City;
import com.peter.mapper.CityMapper;
import com.peter.utils.HttpClientRequest;

public class CityInfoParser extends InfoParser {

	public CityInfoParser(ApplicationContext context) {
		super(context);
	}

	@Override
	public void parser() {
		final String url="https://www.lianjia.com/city/";
		HttpClientRequest request = new HttpClientRequest();
		String html = request.request(url);
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
				String href = lic.attr("href");
				city.setJobType(0);
				city.setLetter(provinceLetter);
				city.setName(cityName);
				city.setUrl(href);
				city.setProvince(province);
				cityMapper.insert(city);
			}
		}
	}

}
