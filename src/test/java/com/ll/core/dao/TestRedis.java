package com.ll.core.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ll.common.junit.SpringJunitTest;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestRedis extends SpringJunitTest{
	
	@Autowired
	private JedisPool jedisPool;
	
	@Test
	public void get() {
		Jedis jedis=jedisPool.getResource();
	}
	
}	
