package com.ll.core.bean.user;

import java.io.Serializable;

/**
 * 收货地址
 */
public class Addr implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String buyerId;//用户ID
	private String name;//收货人
	private String city;
	private String addr;//收货地址
	private String phone;//手机号或是固定电话号
	private Integer isDef;//是否默认

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getIsDef() {
		return isDef;
	}
	public void setIsDef(Integer isDef) {
		this.isDef = isDef;
	}
	public String toString() {
		return "Addr [id=" + id + ",buyerId=" + buyerId + ",name=" + name + ",city=" + city + ",addr=" + addr + ",phone=" + phone + ",isDef=" + isDef + "]";
	}
}
