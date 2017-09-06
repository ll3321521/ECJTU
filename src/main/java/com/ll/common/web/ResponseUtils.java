package com.ll.common.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

/**
 * 异步返回各种格式	text xml json等
 */
public class ResponseUtils {

	//发送内容
	public static void send(HttpServletResponse response,String contentType,String text) {
		response.setContentType(contentType);
		try {
			response.getWriter().write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//如果发送json格式
	public static void sendJson(HttpServletResponse response,String text) {
		send(response, "application/json;charset=UTF-8", text);
	}
	//发送xml文件
	public static void sendXml(HttpServletResponse response,String text) {
		send(response, "text/xml;charset=UTF-8", text);
	}
	//发送text
	public static void sendText(HttpServletResponse response,String text) {
		send(response, "text/plain;charset=UTF-8", text);
	}
	
}
