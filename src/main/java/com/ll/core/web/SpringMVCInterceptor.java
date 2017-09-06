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
 * ����������
 * ����Session
 * ȫ��
 */
public class SpringMVCInterceptor implements HandlerInterceptor{
	@Autowired
	private SessionProvider sessionProvider;
	
	//�������������ع���   �� /buyer/...
	private static final String INTERCEPTOR_URL="/sport/buyer/";
	
	//����ǰ
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
				Object handler) throws Exception {
		Buyer buyer=(Buyer) sessionProvider.getAttribute(request, response, Constants.BUY_SESSION);
		boolean flag=false;
		if(buyer!=null){
			flag=true;
		}
		request.setAttribute("isLogin", flag);
		//�Ƿ�����
		String requrstURI=request.getRequestURI();
		if(requrstURI.startsWith(INTERCEPTOR_URL)){
			//�����¼
			if(buyer==null){
				//���ص�¼ҳ
				response.sendRedirect("/sport/shop/login.shtml?returnUrl="+request.getParameter("returnUrl"));
				return false;
			}
		}
		return true;
	}
	
	//������
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, 
				Object handler, ModelAndView modelAndView) throws Exception {
	}
	
	//ҳ����Ⱦ��
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
				Object handler, Exception exception) throws Exception {

	}

}
