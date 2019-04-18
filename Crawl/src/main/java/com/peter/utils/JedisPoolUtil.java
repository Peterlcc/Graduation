package com.peter.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {
	private static volatile JedisPool jedisPool=null;
	private JedisPoolUtil() {}
	public static JedisPool getJedisPool()
	{
		if(jedisPool==null)
		{
			synchronized (JedisPoolUtil.class) {
				if(jedisPool==null)
				{
					JedisPoolConfig poolConfig=new JedisPoolConfig();
					poolConfig.setMaxTotal(100);
					poolConfig.setMaxIdle(20);
					poolConfig.setMaxWaitMillis(100*100);
					poolConfig.setTestOnBorrow(true);
					jedisPool=new JedisPool(poolConfig, "47.93.239.158", 6379);
				}
			}
		}
		return jedisPool;
	}
	public static Jedis getJedis() {
		if (jedisPool==null) {
			getJedisPool();
		}
		return jedisPool.getResource();
	}
	public static void releaseJedis(Jedis jedis) {
		if(jedis!=null)
		{
			jedis.close();
		}
	}
}
