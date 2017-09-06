package com.ll.common.web.aop;

import java.util.Iterator;
import java.util.Set;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 缓存拦截  缓存 redis中数据的切面对象
 */
public class CacheInterceptor{
	
	@Autowired
	private RedisAccess redisAccess;
	@Autowired
	private JedisPool jedisPool;
	
	//超时缓存时间
	public static final int TIMEOUT=86400;//一天
	
	private int timeout=TIMEOUT;
	
	//配置环绕方法
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		Object result=null;
		//去redis中查看是否有需要的数据
		String cacheKey=getKey(pjp);
		Class returnType=((MethodSignature)pjp.getSignature()).getReturnType();
		result=redisAccess.get(cacheKey, returnType);
		if(result == null){
			//返回service
			result=pjp.proceed();
			//缓存到redis
			redisAccess.set(cacheKey, timeout, result);
			return result;
		}
		return result;
	}
	
	//后置切点   由于数据库数据变更，清理get*
	public void doAfter(JoinPoint jp) {
		String className=jp.getClass().getName();
		Jedis jedis=jedisPool.getResource();
		Set<String> entrySet=jedis.keys(className+"*");
		Iterator iterator=entrySet.iterator();
		while(iterator.hasNext()){
			String cacheKey=(String) iterator.next();
			jedis.del(cacheKey);
		}
	}
	
	//生成 key  生成规则  类名+方法名
	public String getKey(ProceedingJoinPoint pjp) {
		StringBuilder key=new StringBuilder();
		// 类名
		String className=pjp.getClass().getName();
		key.append(className);
		//方法名
		String methodName=pjp.getSignature().getName();
		key.append(".").append(methodName);
		return key.toString();
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	
}
