package com.ll.core.bean.order;

import java.io.Serializable;

/**
 * 订单详情
 */
public class Detail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer orderId;//订单ID
	private String productNo;//商品编号
	private String productName;//商品名称
	private String color;// 颜色名称
	private String size;//尺码
	private Double skuPrice;//商品销售价
	private Integer amount;//购买数量

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Double getSkuPrice() {
		return skuPrice;
	}
	public void setSkuPrice(Double skuPrice) {
		this.skuPrice = skuPrice;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String toString() {
		return "Detail [id=" + id + ",orderId=" + orderId + ",productNo=" + productNo + ",productName=" + productName + ",color=" + color + ",size=" + size + ",skuPrice=" + skuPrice + ",amount=" + amount + "]";
	}
}
