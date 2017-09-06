package com.ll.common.web.aop;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisAccess {
	
	@Autowired
	private JedisPool jedisPool;
	
	public void set(String key,Integer seconds,Object object){  
        Jedis jedis = jedisPool.getResource();  
        jedis.setex(key, seconds, JSONObject.toJSONString(object));
        jedis.close();  
    }  
  
    public <T> T get(String key,Class<T> clazz){  
    	Jedis jedis = jedisPool.getResource();  
        String text = jedis.get(key);  
        T result = JSONObject.parseObject(text, clazz);
        jedis.close();  
        return result;  
    }  
  
    public void del(String key) {  
        Jedis jedis = jedisPool.getResource();  
        jedis.del(key);  
        jedis.close();  
    }
    
    /** 
     * 清空某个DB的数据 
     */  
    public void flushDB() {  
        Jedis jedis = jedisPool.getResource();  
        jedis.flushDB();  
        jedis.close();  
    }  
	
}
