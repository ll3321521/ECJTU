package com.ll.common.web.session;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Session��Ӧ��
 */
public interface SessionProvider {

	//��Session����ֵ
	public void setAttribute(HttpServletRequest request, HttpServletResponse response, String name,Serializable value);
	
	//��Session��ȡֵ
	public Serializable getAttribute(HttpServletRequest request, HttpServletResponse response, String name);
	
	//�˳���¼
	public void logOut(HttpServletRequest request,HttpServletResponse response);
	
	//��ȡSessionId
	public String getSessionId(HttpServletRequest request,HttpServletResponse response);
	
}
