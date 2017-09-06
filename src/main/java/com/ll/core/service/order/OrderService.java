package com.ll.core.service.order;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ll.core.bean.BuyItem;
import com.ll.core.bean.Cart;
import com.ll.core.bean.order.Detail;
import com.ll.core.bean.order.Order;
import com.ll.core.dao.order.OrderDao;
import com.ll.core.query.order.OrderQuery;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private DetailService detailService;
	
	public Integer addOrder(Order order,Cart cart){
		//生成订单号
		DateFormat df=new SimpleDateFormat("yyyyMMddmmssSSS");
		String oid=df.format(new Date());
		order.setOid(oid);
		//运费
		order.setDeliverFee(cart.getFee());
		//应付金额
		order.setPayableFee(cart.getTotalPrice());
		//订单金额
		order.setTotalPrice(cart.getPrice());
		//支付状态   到付或其他付款
		if(order.getPaymentWay()==0){
			//未付款
			order.setIsPaiy(0);
		}else {
			//已付款
			order.setIsPaiy(1);
		}
		//订单状态   提交订单
		order.setState(0);
		//订单生成时间
		order.setCreateDate(new Date());
		//保存订单
		Integer o=orderDao.addOrder(order);
		//购物项集合
		List<BuyItem> items=cart.getItems();
		for (BuyItem item : items) {
			//保存订单详情
			Detail detail=new Detail();
			//设置一个订单id
			detail.setOrderId(order.getId());
			//商品名称
			detail.setProductName(item.getSku().getProduct().getName());
			//商品编号
			detail.setProductNo(item.getSku().getProduct().getNo());
			//颜色名称
			detail.setColor(item.getSku().getColor().getName());
			//尺码
			detail.setSize(item.getSku().getSize());
			//商品销售价
			detail.setSkuPrice(item.getSku().getSkuPrice());
			//购买数量
			detail.setAmount(item.getNumber());
			//保存订单
			detailService.addDetail(detail);
		}
		return o;
	}

	public Order getOrderById(Integer id){
		return orderDao.getOrderById(id);
	}
	
	public void delOrder(Integer id){
		orderDao.delOrder(id);
	}
	
	public void updateOrder(Order order){
		orderDao.updateOrder(order);
	}

	public List<Order> getOrderList(OrderQuery orderQuery){
		return orderDao.getOrderList(orderQuery);
	}
	
}
