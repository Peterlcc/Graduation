package com.peter.parse;

import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;

import com.peter.bean.Area;
import com.peter.bean.Street;
import com.peter.mapper.AreaMapper;
import com.peter.mapper.StreetMapper;
import com.peter.utils.HttpClientRequest;

public class StreetInfoParser extends InfoParser {

	public StreetInfoParser(ApplicationContext context) {
		super(context);
	}

	@Override
	public void parser() {
		AreaMapper areaMapper = (AreaMapper) context.getBean("areaMapper");

		StreetMapper streetMapper = (StreetMapper) context.getBean("streetMapper");
		HttpClientRequest request = new HttpClientRequest();

		// List<Area> areas = areaMapper.selectAll();
		Street street = new Street();
		for (int i = 494; i <= 498; i++) {
			Area area = areaMapper.selectByPrimaryKey(i);
			System.out.print("areaId:" + area.getId());
			String html = request.request(area.getUrl());
			if (html == null) {
				System.out.println("第" + i + "area return  null,now go back it!");
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
			}
		}
	}

}
