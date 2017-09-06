package com.ll.core.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.common.web.Constants;
import com.ll.common.web.session.SessionProvider;
import com.ll.core.bean.BuyItem;
import com.ll.core.bean.Cart;
import com.ll.core.bean.order.Order;
import com.ll.core.bean.product.Sku;
import com.ll.core.bean.user.Buyer;
import com.ll.core.service.order.OrderService;
import com.ll.core.service.product.SkuService;

/**
 * 前端 提交订单
 */
@Controller
public class FrontOrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private SessionProvider sessionProvider;
	@Autowired
	private SkuService skuService;
	
	//提交订单
	@RequestMapping(value="/buyer/confirmOrder.shtml")
	public String confirmOrder(Order order,HttpServletRequest request,HttpServletResponse response,Model model) {
		//接收前端四个参数
		ObjectMapper  om = new ObjectMapper();
		om.setSerializationInclusion(Include.NON_NULL);
		//声明购物车
		Cart cart=null;
		//判断cookie中是否有购物车
		Cookie[] cookies=request.getCookies();
		if(cookies!=null && cookies.length>0){
			for (Cookie c : cookies) {
				if(Constants.CART_COOKIE.equals(c.getName())){
					//如果有，则使用此购物车
					String value=c.getValue();
					try {
						cart=om.readValue(value, Cart.class);
					} catch (Exception e) {
						e.printStackTrace();
					} 
					break;
				}
			}
		}
		//装购物车
		List<BuyItem> items=cart.getItems();
		for (BuyItem item : items) {
			Sku s=skuService.getSkuById(item.getSku().getId());
			item.setSku(s);
		}
		Buyer buyer=(Buyer) sessionProvider.getAttribute(request, response, Constants.BUY_SESSION);
		//用户id
		order.setBuyerId(buyer.getUsername());
		//保存订单   订单详情
		orderService.addOrder(order, cart);
		//清空购物车
		Cookie cookie=new Cookie(Constants.CART_COOKIE, null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		//向前端发送订单情况
		Order o=orderService.getOrderById(order.getId());
		model.addAttribute("order", o);
		return "product/confirmOrder";
	}
	
}
