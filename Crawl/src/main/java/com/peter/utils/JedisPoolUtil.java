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
					poolConfig.setMaxTotal(1000);
					poolConfig.setMaxIdle(32);
					poolConfig.setMaxWaitMillis(100*1000);
					poolConfig.setTestOnBorrow(true);
					jedisPool=new JedisPool(poolConfig, "127.0.0.1", 6379);
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
