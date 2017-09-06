package com.ll.core.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ll.common.web.Constants;
import com.ll.common.web.session.SessionProvider;
import com.ll.core.bean.user.Buyer;

/**
 * 处理上下文
 * 处理Session
 * 全局
 */
public class SpringMVCInterceptor implements HandlerInterceptor{
	@Autowired
	private SessionProvider sessionProvider;
	
	//常量，定义拦截规则   以 /buyer/...
	private static final String INTERCEPTOR_URL="/sport/buyer/";
	
	//方法前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
				Object handler) throws Exception {
		Buyer buyer=(Buyer) sessionProvider.getAttribute(request, response, Constants.BUY_SESSION);
		boolean flag=false;
		if(buyer!=null){
			flag=true;
		}
		request.setAttribute("isLogin", flag);
		//是否拦截
		String requrstURI=request.getRequestURI();
		if(requrstURI.startsWith(INTERCEPTOR_URL)){
			//必须登录
			if(buyer==null){
				//返回登录页
				response.sendRedirect("/sport/shop/login.shtml?returnUrl="+request.getParameter("returnUrl"));
				return false;
			}
		}
		return true;
	}
	
	//方法后
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, 
				Object handler, ModelAndView modelAndView) throws Exception {
	}
	
	//页面渲染后
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
				Object handler, Exception exception) throws Exception {

	}

}
