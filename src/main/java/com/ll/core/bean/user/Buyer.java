package com.ll.core.bean.user;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 */
public class Buyer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;//用户名
	private String password;//密码
	private Gender gender;//性别
	private String email;//密码
	private String realName;//真实名字
	private Date registerTime;//注册时间
	private String province;//省编码
	private String city;//市编码
	private String town;//县编码
	private String addr;//地址
	private Integer isDel;//是否已删除:1:未,0:删除了
	
	public enum Gender {

		MAN{
			public String getName(){return "男";}
		},
		WOMAN{
			public String getName(){return "女";}
		},
		SECRECY{
			public String getName(){return "保密";}
		};
		
		public abstract String getName();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Integer getIsDel() {
		return isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	@Override
	public String toString() {
		return "Buyer [username=" + username + ", password=" + password
				+ ", gender=" + gender + ", email=" + email + ", realName="
				+ realName + ", registerTime=" + registerTime + ", province="
				+ province + ", city=" + city + ", town=" + town + ", addr="
				+ addr + ", isDel=" + isDel + "]";
	}

}
