package com.ll.core.dao.order;

import java.util.List;

import com.ll.core.bean.order.Order;
import com.ll.core.query.order.OrderQuery;


public interface OrderDao {

	public Integer addOrder(Order order);

	public Order getOrderById(Integer id);

	public List<Order> getOrdersByKeys(List<Integer> idList);

	public void delOrder(Integer id);

	public void deleteByKeys(List<Integer> idList);

	public void updateOrder(Order order);

	public List<Order> getOrderList(OrderQuery orderQuery);

}
