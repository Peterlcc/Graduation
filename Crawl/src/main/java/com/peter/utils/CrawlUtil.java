package com.peter.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.peter.bean.CrawlJob;

import redis.clients.jedis.Jedis;

public class CrawlUtil {
	private List<String> keys=null;
	private Jedis jedis=null;

	public CrawlUtil() {
		this.jedis=JedisPoolUtil.getJedis();
		keys=new ArrayList<String>();
		keys.add("house5");
		keys.add("house4");
		keys.add("house3");
		keys.add("house2");
		keys.add("house1");
		keys.add("house0");
	}
	
	public CrawlJob getJob()
	{
		for(String key:keys)
		{
			if(jedis.exists(key)&&jedis.llen(key)>0)
			{
				return JobUtil.Str2Job(jedis.lpop(key));
			}
		}
		return null;
	}
	public void upload(CrawlJob job) {
		final String key="house"+job.getJobType();
		if (jedis.exists(key)) {
			jedis.rpush(key, JobUtil.job2Str(job));
		}
		else {
			System.out.println(key+" 不存在");
		}
	}
	
	public void saveJob(CrawlJob job) {
		try {
			JobUtil.save(job);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
