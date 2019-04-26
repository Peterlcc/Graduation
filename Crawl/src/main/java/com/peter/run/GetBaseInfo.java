package com.peter.run;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;

import com.peter.bean.Area;
import com.peter.bean.City;
import com.peter.bean.HouseUrl;
import com.peter.bean.Page;
import com.peter.bean.Street;
import com.peter.mapper.AreaMapper;
import com.peter.mapper.CityMapper;
import com.peter.mapper.HouseUrlMapper;
import com.peter.mapper.PageMapper;
import com.peter.mapper.StreetMapper;
import com.peter.utils.CrawlConfig;
import com.peter.utils.HttpClientRequest;
import com.peter.utils.JouspRequest;

public class GetBaseInfo {
	private static final String host = "https://tj.lianjia.com";
	private static Random random = new Random();
	private static ApplicationContext context;

	private static void init() {
		context = CrawlConfig.getApplicationContext();
	}

	public static void main(String[] args) {
		init();
		HouseUrlMapper houseUrlMapper = context.getBean(HouseUrlMapper.class);
		HouseUrl houseUrl = houseUrlMapper.selectByPrimaryKey(1);
		System.out.println(houseUrl);
		
	}

	public static void getHouseUrlFromPage() {
		PageMapper pageMapper = context.getBean(PageMapper.class);
		HouseUrlMapper houseUrlMapper = context.getBean(HouseUrlMapper.class);
		HouseUrl houseUrl=new HouseUrl();
		for (int i = 15236; i <= 28228; i++) {
			Page page = pageMapper.selectByPrimaryKey(i);
			System.out.print("page:"+page.getId());
			//HttpClientRequest request = new HttpClientRequest();
			JouspRequest request=new JouspRequest();
			String html = request.request(page.getUrl());
			if (html==null) {
				System.out.println("第"+i+"page return  null,now go back it!");
				i--;
				try {
					TimeUnit.SECONDS.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue;
			}
			System.out.println("html got! ");
			Document doc = Jsoup.parse(html);
			Elements houseas = doc.select("#content > div.content__article > div.content__list > div.content__list--item > a");
			for(Element a:houseas)
			{
				houseUrl.setId(null);
				houseUrl.setJobType(4);
				houseUrl.setPageId(page.getId());
				houseUrl.setUrl(host+a.attr("href"));
				
				houseUrlMapper.insertSelective(houseUrl);
				System.out.println("houseUrl:"+houseUrl.getId());
			}
			if (i%50==0) {
				try {
					System.gc();
					Thread.sleep(3000+random.nextInt(2000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void getPageFromStreet() {
		StreetMapper streetMapper = context.getBean(StreetMapper.class);
		PageMapper pageMapper = context.getBean(PageMapper.class);
		Page page = new Page();
		for (int i = 3819; i <= 3839; i++) {
			Street street = streetMapper.selectByPrimaryKey(i);
			System.out.print("street:" + street.getId());
			HttpClientRequest request = new HttpClientRequest();

			String html = request.request(street.getUrl());
			if (html==null) {
				System.out.println("第"+i+"street return  null,now go back it!");
				i--;
				try {
					TimeUnit.SECONDS.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue;
			}
			System.out.println("html got! ");
			Document doc = Jsoup.parse(html);
			Element houseNumberEle = doc
					.selectFirst("#content > div.content__article > p.content__title > span.content__title--hl");
			if (houseNumberEle == null) {
				System.out.println("street " + i + " houseNumberEle null");
				i--;
				continue;
			}

			if (houseNumberEle.text().equals("0")) {
				System.out.println("street " + i + " no houses");
				continue;
			}

			Element pageMsg = doc.selectFirst("#content > div.content__article > div.content__pg");
			String totalPage = pageMsg.attr("data-totalpage");
			int totalNum = Integer.parseInt(totalPage);
			for (int j = 1; j <= totalNum; j++) {
				page.setId(null);
				page.setSerialNumber(j);
				page.setStreetId(street.getId());
				page.setUrl(street.getUrl() + "pg" + j + "#contentList");
				page.setJobType(3);
				page.setStreet(street);

				// System.out.println(page);
				pageMapper.insertSelective(page);
				System.out.println("page:" + page.getId());
			}
			if (i % 20 == 0)
				System.gc();
			// Thread.sleep(3000 + random.nextInt(3) * 1000);
		}
	}

	public static void getStreetsFromAreas() throws Exception, InterruptedException {
		AreaMapper areaMapper = (AreaMapper) context.getBean("areaMapper");

		StreetMapper streetMapper = (StreetMapper) context.getBean("streetMapper");
		HttpClientRequest request = new HttpClientRequest();

		// List<Area> areas = areaMapper.selectAll();
		Street street = new Street();
		for (int i = 494; i <= 498; i++) {
			Area area = areaMapper.selectByPrimaryKey(i);
			System.out.print("areaId:" + area.getId());
			String html = request.request(area.getUrl());
			if (html==null) {
				System.out.println("第"+i+"area return  null,now go back it!");
				i--;
				try {
					TimeUnit.SECONDS.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue;
			}
			System.out.print("html got! ");
			Document doc = Jsoup.parse(html);

			Elements streetEles = doc.select(
					"div.filter > div.filter__wrapper.w1150> ul[data-target=area] > li.filter__item--level3 > a");
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
				System.out.println("street:" + street.getId());
				Thread.sleep(3000 + random.nextInt(3) * 1000);
			}
			Thread.sleep(5000 + random.nextInt(4) * 1000);

		}
	}

	public static void getAreaFromCity() throws Exception {
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
