package com.peter.utils;

import java.util.List;

import redis.clients.jedis.Jedis;

public class RedisUtil {
	private Jedis jedis=null;

	public RedisUtil() {
		this.jedis = JedisPoolUtil.getJedis();
		jedis.select(1);
	}
	public boolean push(String key,String strings) {
		Long rpush = jedis.rpush(key, strings);
		
		return rpush==1;
	}
	public String pop(String key) {
		String res = jedis.lpop(key);
		return res;
	}
	public String index(String key,int index) {
		return jedis.lindex(key, index);
	}
	public List<String> range(String key,int l,int r) {
		return jedis.lrange(key, l, r);
	}
}
