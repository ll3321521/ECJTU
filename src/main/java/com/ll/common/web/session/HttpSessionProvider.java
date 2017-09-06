package com.ll.common.web.session;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 本地Session
 */
public class HttpSessionProvider implements SessionProvider{

	@Override
	public void setAttribute(HttpServletRequest request, HttpServletResponse response, String name, Serializable value) {
		HttpSession session=request.getSession();//true SessionID
		session.setAttribute(name, value);
	}

	@Override
	public Serializable getAttribute(HttpServletRequest request, HttpServletResponse response, String name) {
		HttpSession session=request.getSession(false);
		if(session!=null){
			return (Serializable) session.getAttribute(name);
		}
		return null;
	}

	@Override
	public void logOut(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session=request.getSession(false);
		if(session!=null){
			session.invalidate();
		}
	}

	@Override
	public String getSessionId(HttpServletRequest request,HttpServletResponse response) {
		//request.getRequestedSessionId(); 获取url上的 JSESSIONID
		return request.getSession().getId();
	}

}
