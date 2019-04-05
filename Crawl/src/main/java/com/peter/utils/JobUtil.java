package com.peter.utils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSONObject;
import com.peter.bean.CrawlJob;

public class JobUtil {
	public static CrawlJob Str2Job(String string) {
		return JSONObject.parseObject(string, CrawlJob.class);
	}
	public static String job2Str(CrawlJob job) {
		return JSONObject.toJSONString(job);
	}
	public static void save(CrawlJob job) throws IOException {
		InputStream inputStream = JobUtil.class.getClassLoader().getResourceAsStream("application.properties");
		Properties properties=new Properties();
		properties.load(inputStream);
		String path = properties.getProperty("resultPath", "F:/");
		inputStream.close();
		IOUtils.write(job.toString(), new FileOutputStream(path, true));
		
	}
}
