package com.ll.core.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/control")
public class CenterController {

	/**
	 * ��ת���ҳ��
	 */
	@RequestMapping(value="/index.do")
	public String index() {
		return "index";
	}
	
	/**
	 * ��תͷҳ��
	 */
	@RequestMapping(value="/top.do")
	public String top() {
		return "top";
	}
	
	/**
	 * ��ת��ҳ��
	 */
	@RequestMapping(value="/main.do")
	public String main() {
		return "main";
	}
	
	/**
	 * ��ת��ҳ��
	 */
	@RequestMapping(value="/left.do")
	public String left() {
		return "left";
	}

	/**
	 * ��ת��ҳ��
	 */
	@RequestMapping(value="/right.do")
	public String right() {
		return "right";
	}

	
}
