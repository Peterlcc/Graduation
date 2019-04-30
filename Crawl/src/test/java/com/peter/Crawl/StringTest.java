package com.peter.Crawl;

import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;

import com.peter.bean.HouseUrl;
import com.peter.bean.Page;
import com.peter.mapper.HouseUrlMapper;
import com.peter.mapper.PageMapper;
import com.peter.utils.CrawlConfig;

public class StringTest {
	public static void main(String[] args) {
		ApplicationContext context = CrawlConfig.getApplicationContext();
		/*PageMapper pageMapper = context.getBean(PageMapper.class);
		Page page = pageMapper.selectByPrimaryKey(1);
		String host=page.getUrl().substring(0, page.getUrl().indexOf("/", page.getUrl().indexOf("//")+2));
		System.out.println(host);*/
		
		HouseUrlMapper houseUrlMapper = context.getBean(HouseUrlMapper.class);
		HouseUrl houseUrl = houseUrlMapper.selectByPrimaryKey(1);
		String host=houseUrl.getUrl().substring(0, houseUrl.getUrl().indexOf("/", houseUrl.getUrl().indexOf("zufang")+1)+1);
		System.out.println(host);
		
		
		String str="1 2,,5,6   8";
		String[] split = StringUtils.split(str,",| ");
		System.out.println(Arrays.toString(split)+"-"+split.length);
		
	}
}
