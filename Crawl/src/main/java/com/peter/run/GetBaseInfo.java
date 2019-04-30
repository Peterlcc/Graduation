package com.peter.run;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import org.springframework.context.ApplicationContext;
import com.peter.parse.AreaInfoParser;
import com.peter.parse.CityInfoParser;
import com.peter.parse.HouseInfoParser;
import com.peter.parse.HouseUrlInfoParser;
import com.peter.parse.InfoParser;
import com.peter.parse.PageInfoParser;
import com.peter.parse.StreetInfoParser;
import com.peter.utils.CrawlConfig;

public class GetBaseInfo {
	
	private static final String root="/home/peter/application/crawl/";//"F:/houses/"
	
	private static ApplicationContext context;

	private static void init() {
		context = CrawlConfig.getApplicationContext();
	}
	public static void main(String[] args) throws Exception {
		init();
	}

	public static void getHouseFromHouseUrl()
	{
		InfoParser infoParser=new HouseInfoParser(context,root);
		infoParser.parser();
	}

	

	public static void getHouseUrlFromPage() {
		InfoParser infoParser=new HouseUrlInfoParser(context);
		infoParser.parser();
	}

	public static void getPageFromStreet() {
		InfoParser infoParser=new PageInfoParser(context);
		infoParser.parser();
	}

	public static void getStreetsFromAreas() throws Exception, InterruptedException {
		InfoParser infoParser=new StreetInfoParser(context);
		infoParser.parser();
	}

	public static void getAreaFromCity() throws Exception {
		InfoParser infoParser=new AreaInfoParser(context);
		infoParser.parser();
	}

	private static void getCityInfo() {
		InfoParser infoParser=new CityInfoParser(context);
		infoParser.parser();
	}
}
