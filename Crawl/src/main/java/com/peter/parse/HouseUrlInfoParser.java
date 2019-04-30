package com.peter.parse;

import java.util.concurrent.TimeUnit;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;

import com.peter.bean.HouseUrl;
import com.peter.bean.Page;
import com.peter.mapper.HouseUrlMapper;
import com.peter.mapper.PageMapper;
import com.peter.utils.JouspRequest;

public class HouseUrlInfoParser extends InfoParser {

	public HouseUrlInfoParser(ApplicationContext context) {
		super(context);
	}

	@Override
	public void parser() {
		PageMapper pageMapper = context.getBean(PageMapper.class);
		HouseUrlMapper houseUrlMapper = context.getBean(HouseUrlMapper.class);
		HouseUrl houseUrl = new HouseUrl();
		for (int i = 15236; i <= 28228; i++) {
			Page page = pageMapper.selectByPrimaryKey(i);
			String host = page.getUrl().substring(0, page.getUrl().indexOf("/", page.getUrl().indexOf("//") + 2));
			System.out.print("page:" + page.getId());
			// HttpClientRequest request = new HttpClientRequest();
			JouspRequest request = new JouspRequest();
			Document doc = request.request(page.getUrl());
			if (doc == null) {
				System.out.println("第" + i + "page return  null,now go back it!");
				i--;
				try {
					TimeUnit.SECONDS.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue;
			}
			System.out.println("html got! ");
			Elements houseas = doc
					.select("#content > div.content__article > div.content__list > div.content__list--item > a");
			for (Element a : houseas) {
				houseUrl.setId(null);
				houseUrl.setJobType(4);
				houseUrl.setPageId(page.getId());
				houseUrl.setUrl(host + a.attr("href"));

				houseUrlMapper.insertSelective(houseUrl);
				System.out.println("houseUrl:" + houseUrl.getId());
			}
			if (i % 50 == 0) {
				try {
					System.gc();
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
