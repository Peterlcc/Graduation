package com.peter.parse;

import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.context.ApplicationContext;

import com.peter.bean.Page;
import com.peter.bean.Street;
import com.peter.mapper.PageMapper;
import com.peter.mapper.StreetMapper;
import com.peter.utils.HttpClientRequest;

public class PageInfoParser extends InfoParser {

	public PageInfoParser(ApplicationContext context) {
		super(context);
	}

	@Override
	public void parser() {
		StreetMapper streetMapper = context.getBean(StreetMapper.class);
		PageMapper pageMapper = context.getBean(PageMapper.class);
		Page page = new Page();
		for (int i = 3819; i <= 3839; i++) {
			Street street = streetMapper.selectByPrimaryKey(i);
			System.out.print("street:" + street.getId());
			HttpClientRequest request = new HttpClientRequest();

			String html = request.request(street.getUrl());
			if (html == null) {
				System.out.println("第" + i + "street return  null,now go back it!");
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

				pageMapper.insertSelective(page);
				System.out.println("page:" + page.getId());
			}
			if (i % 20 == 0)
				System.gc();
		}
	}

}
