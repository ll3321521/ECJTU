package com.ll.common.web.session;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.ll.common.web.Constants;
import com.ll.common.web.aop.SerializationUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 远程sssion
 * 存放在redis中
 */
public class CacheSessionProvider implements SessionProvider{
	
	@Autowired
	private JedisPool jedisPool;
	@Autowired
	private SerializationUtil serializationUtil;
	
	private int timeout=10;
	
	Jedis jedis=jedisPool.getResource();

	@Override
	public void setAttribute(HttpServletRequest request, HttpServletResponse response, String name, Serializable value) {
		Map<String, Serializable> session=new HashMap<String, Serializable>();
		session.put(name, value);
		jedis.setex(getSessionId(request, response).getBytes(), timeout, serializationUtil.serialize(session));
	}

	@Override
	public Serializable getAttribute(HttpServletRequest request, HttpServletResponse response, String name) {
		byte[] bytes = jedis.get(getSessionId(request,response).getBytes());
		Map<String, Serializable> session=(Map<String, Serializable>) serializationUtil.deserialize(bytes);
		if(session!=null){
			return session.get(name);
		}
		return null;
	}

	@Override
	public void logOut(HttpServletRequest request,HttpServletResponse response) {
		if(jedis.exists(getSessionId(request, response))){
			jedis.del(getSessionId(request, response));
		}
	}

	@Override
	public String getSessionId(HttpServletRequest request,HttpServletResponse response) {
		Cookie[] cookies=request.getCookies();
		for (Cookie cookie : cookies) {
			if(Constants.JSESSIONID.equals(cookie.getName())){
				return cookie.getValue();
			}
		}
		//生成一个sessionId
		String sessionId=UUID.randomUUID().toString().replaceAll("-", "");
		Cookie cookie=new Cookie(Constants.JSESSIONID, sessionId);
		cookie.setMaxAge(-1);
		cookie.setPath("/");
		response.addCookie(cookie);
		return sessionId;
	}

}
