package com.ll.common.web.session;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Session供应类
 */
public interface SessionProvider {

	//往Session设置值
	public void setAttribute(HttpServletRequest request, HttpServletResponse response, String name,Serializable value);
	
	//从Session中取值
	public Serializable getAttribute(HttpServletRequest request, HttpServletResponse response, String name);
	
	//退出登录
	public void logOut(HttpServletRequest request,HttpServletResponse response);
	
	//获取SessionId
	public String getSessionId(HttpServletRequest request,HttpServletResponse response);
	
}
