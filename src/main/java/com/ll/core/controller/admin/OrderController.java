package com.ll.core.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ll.core.bean.order.Detail;
import com.ll.core.bean.order.Order;
import com.ll.core.bean.user.Addr;
import com.ll.core.query.order.DetailQuery;
import com.ll.core.query.order.OrderQuery;
import com.ll.core.query.user.AddrQuery;
import com.ll.core.service.order.DetailService;
import com.ll.core.service.order.OrderService;
import com.ll.core.service.user.AddrService;

/**
 * 后台订单页面
 */
@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private AddrService addrService;
	@Autowired
	private DetailService detailService;
	
	//订单列表
	@RequestMapping(value="/order/list.do")
	public String list(Integer isPaiy,Integer state,Model model) {
		OrderQuery orderQuery=new OrderQuery();
		//支付状态
		if(isPaiy!=null){
			orderQuery.setIsPaiy(isPaiy);
		}
		//订单状态
		if(state!=null){
			orderQuery.setState(state);
		}
		List<Order> orders=orderService.getOrderList(orderQuery);
		model.addAttribute("orders", orders);
		return "order/list";
	}
	
	
	//查看订单
	@RequestMapping(value="/order/view.do")
	public String view(Integer id,Model model){
		//加载订单
		Order order=orderService.getOrderById(id);
		model.addAttribute("order", order);
		//加载收货地址
		AddrQuery addrQuery=new AddrQuery();
		addrQuery.setBuyerId(order.getBuyerId());
		List<Addr> addrs=addrService.getAddrList(addrQuery);
		model.addAttribute("addr", addrs.get(0));
		//加载订单详情
		DetailQuery detailQuery=new DetailQuery();
		detailQuery.setOrderId(order.getId());
		List<Detail> details=detailService.getDetailList(detailQuery);
		model.addAttribute("details", details);
		return "order/view";
	}
}
