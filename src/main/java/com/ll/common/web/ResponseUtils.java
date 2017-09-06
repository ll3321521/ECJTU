package com.ll.common.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

/**
 * �첽���ظ��ָ�ʽ	text xml json��
 */
public class ResponseUtils {

	//��������
	public static void send(HttpServletResponse response,String contentType,String text) {
		response.setContentType(contentType);
		try {
			response.getWriter().write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//�������json��ʽ
	public static void sendJson(HttpServletResponse response,String text) {
		send(response, "application/json;charset=UTF-8", text);
	}
	//����xml�ļ�
	public static void sendXml(HttpServletResponse response,String text) {
		send(response, "text/xml;charset=UTF-8", text);
	}
	//����text
	public static void sendText(HttpServletResponse response,String text) {
		send(response, "text/plain;charset=UTF-8", text);
	}
	
}
