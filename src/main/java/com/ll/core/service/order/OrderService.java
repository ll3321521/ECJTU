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
		//���ɶ�����
		DateFormat df=new SimpleDateFormat("yyyyMMddmmssSSS");
		String oid=df.format(new Date());
		order.setOid(oid);
		//�˷�
		order.setDeliverFee(cart.getFee());
		//Ӧ�����
		order.setPayableFee(cart.getTotalPrice());
		//�������
		order.setTotalPrice(cart.getPrice());
		//֧��״̬   ��������������
		if(order.getPaymentWay()==0){
			//δ����
			order.setIsPaiy(0);
		}else {
			//�Ѹ���
			order.setIsPaiy(1);
		}
		//����״̬   �ύ����
		order.setState(0);
		//��������ʱ��
		order.setCreateDate(new Date());
		//���涩��
		Integer o=orderDao.addOrder(order);
		//�������
		List<BuyItem> items=cart.getItems();
		for (BuyItem item : items) {
			//���涩������
			Detail detail=new Detail();
			//����һ������id
			detail.setOrderId(order.getId());
			//��Ʒ����
			detail.setProductName(item.getSku().getProduct().getName());
			//��Ʒ���
			detail.setProductNo(item.getSku().getProduct().getNo());
			//��ɫ����
			detail.setColor(item.getSku().getColor().getName());
			//����
			detail.setSize(item.getSku().getSize());
			//��Ʒ���ۼ�
			detail.setSkuPrice(item.getSku().getSkuPrice());
			//��������
			detail.setAmount(item.getNumber());
			//���涩��
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
