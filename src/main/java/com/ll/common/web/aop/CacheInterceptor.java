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
 * ��������  ���� redis�����ݵ��������
 */
public class CacheInterceptor{
	
	@Autowired
	private RedisAccess redisAccess;
	@Autowired
	private JedisPool jedisPool;
	
	//��ʱ����ʱ��
	public static final int TIMEOUT=86400;//һ��
	
	private int timeout=TIMEOUT;
	
	//���û��Ʒ���
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		Object result=null;
		//ȥredis�в鿴�Ƿ�����Ҫ������
		String cacheKey=getKey(pjp);
		Class returnType=((MethodSignature)pjp.getSignature()).getReturnType();
		result=redisAccess.get(cacheKey, returnType);
		if(result == null){
			//����service
			result=pjp.proceed();
			//���浽redis
			redisAccess.set(cacheKey, timeout, result);
			return result;
		}
		return result;
	}
	
	//�����е�   �������ݿ����ݱ��������get*
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
	
	//���� key  ���ɹ���  ����+������
	public String getKey(ProceedingJoinPoint pjp) {
		StringBuilder key=new StringBuilder();
		// ����
		String className=pjp.getClass().getName();
		key.append(className);
		//������
		String methodName=pjp.getSignature().getName();
		key.append(".").append(methodName);
		return key.toString();
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	
}
