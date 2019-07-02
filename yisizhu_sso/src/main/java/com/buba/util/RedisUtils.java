package com.buba.util;

import java.nio.channels.ClosedByInterruptException;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisUtils {
	
	private static ShardedJedis jedis = null;
	
	private static ShardedJedisPool pool;
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);
        config.setMaxIdle(50);
        config.setMaxWaitMillis(3000);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        // 集群
        JedisShardInfo jedisShardInfo1 = new JedisShardInfo("127.0.0.1", 6379);
        List<JedisShardInfo> list = new LinkedList<JedisShardInfo>();
        list.add(jedisShardInfo1); 
        pool = new ShardedJedisPool(config, list);
    }
    
    //获取jedis（ShardedJedis）对象
    public static ShardedJedis getShardedJedis() {
    	jedis = pool.getResource();
    	return jedis;
    }
    //根据token查找json字符串  并更新redis中的过期时间
    public static String getJsonByToken(String token) {
    	getShardedJedis();
	    //根据token从redis中查询用户信息
		String json = jedis.get(token);
	   //判断是否为空
	   if (json==null) {
	    return null;
	   }
	   //更新过期时间
	   jedis.expire(token, 60*60*2);
	   jedis.close();
	   //返回用户信息
	   return json;
	}
    //储存数据到redis，并设置过时间2小时
    public static void save(String key,String value,long outTime) {
    	getShardedJedis();
    	//存值并设置过期时间,NX是不存在时才set， XX是存在时才set， EX是秒，PX是毫秒
    	jedis.set(key,value, "NX", "EX", outTime);
    	jedis.close();
    }
    
    //删除指定令牌
    public static void delByToken(String token) { 
		getShardedJedis();
		jedis.del(token); 
		jedis.close();
	}
	 
	 
    
    public static void main(String[] args) {
    	
    	//存值并设置过期时间,NX是不存在时才set， XX是存在时才set， EX是秒，PX是毫秒
    	//.set("yux", " 于鑫閣", "NX", "EX", 60*60*2);
    	//更新过期时间(2小时)
    	//jedis1.expire("yux", 60*60*2);
    	String type = null;
    	
    	
    	
    }
     
}
