package com.ll.core.bean;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 购物车
 */
public class Cart {
	
	//购物项集合
	List<BuyItem> items=new ArrayList<BuyItem>(); 
	
	//继续购物，最后一款
	private Integer productId;
	
	//
	public void addItem(BuyItem item) {
		//判断是否重复
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
	
	//小计
	//商品数量
	@JsonIgnore
	public int getNumber() {
		int result=0;
		for (BuyItem item : items) {
			result += item.getNumber();
		}
		return result;
	}
	
	//商品金额
	@JsonIgnore
	public Double getPrice() {
		Double result=0.0;
		for (BuyItem item : items) {
			result += item.getSku().getSkuPrice()*item.getNumber();
		}
		return result;
	}
	
	//运费
	@JsonIgnore
	public Double getFee() {
		Double result=0.0;
		if(getPrice()<=39){
			result=10.0;
		}
		return result;
	}
	
	//总金额
	@JsonIgnore
	public Double getTotalPrice() {
		return getPrice()+getFee();
	}
	
	//清空购物车
	public void clearCart() {
		items.clear();
	}
	
	//从购物车中删除一款商品
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
