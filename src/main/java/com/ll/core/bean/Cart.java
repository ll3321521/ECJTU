package com.ll.core.bean;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * ���ﳵ
 */
public class Cart {
	
	//�������
	List<BuyItem> items=new ArrayList<BuyItem>(); 
	
	//����������һ��
	private Integer productId;
	
	//
	public void addItem(BuyItem item) {
		//�ж��Ƿ��ظ�
		if(items.contains(item)){
			for (BuyItem buyItem : items) {
				if(buyItem.equals(item)){
					int number=buyItem.getNumber()+item.getNumber();
					if(buyItem.getSku().getSkuUpperLimit()>=number){
						buyItem.setNumber(number);
					}else {
						buyItem.setNumber(buyItem.getSku().getSkuUpperLimit());
					}
				}
			}
		}else {
			items.add(item);
		}
		
	}
	
	//С��
	//��Ʒ����
	@JsonIgnore
	public int getNumber() {
		int result=0;
		for (BuyItem item : items) {
			result += item.getNumber();
		}
		return result;
	}
	
	//��Ʒ���
	@JsonIgnore
	public Double getPrice() {
		Double result=0.0;
		for (BuyItem item : items) {
			result += item.getSku().getSkuPrice()*item.getNumber();
		}
		return result;
	}
	
	//�˷�
	@JsonIgnore
	public Double getFee() {
		Double result=0.0;
		if(getPrice()<=39){
			result=10.0;
		}
		return result;
	}
	
	//�ܽ��
	@JsonIgnore
	public Double getTotalPrice() {
		return getPrice()+getFee();
	}
	
	//��չ��ﳵ
	public void clearCart() {
		items.clear();
	}
	
	//�ӹ��ﳵ��ɾ��һ����Ʒ
	public void delItem(BuyItem item) {
		items.remove(item);
	}

	public List<BuyItem> getItems() {
		return items;
	}

	public void setItems(List<BuyItem> items) {
		this.items = items;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Cart [items=" + items + ", productId=" + productId + "]";
	}
	
}
