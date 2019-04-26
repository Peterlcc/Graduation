package com.peter.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JouspRequest {

	private List<String> userAgentList = CrawlConfig.getUserAgent();
	private int randomIndex = 0;

	public JouspRequest() {
		randomIndex = RandomUtils.nextInt(0, userAgentList.size());
	}
	public String request(String url) {
		Connection connect = Jsoup.connect(url);
		Map<String, String> requestHead = new HashMap<String, String>();
		requestHead.put("User-Agent", userAgentList.get(randomIndex));
		requestHead.put("Accept", "  text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		requestHead.put("Accept-Language", "zh-cn,zh;q=0.5");
		requestHead.put("Accept-Charset", "  GB2312,utf-8;q=0.7,*;q=0.7");
		connect.headers(requestHead);
		try {
			return connect.get().html();
		} catch (IOException e) {
			System.out.println();
			e.printStackTrace();
			return null;
		}
	}
	
}
