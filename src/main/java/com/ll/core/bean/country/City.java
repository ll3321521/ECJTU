package com.ll.core.bean.country;

import java.io.Serializable;

/**
 * 城市
 */
public class City implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;// 主键
	private String code;// 城市编码
	private String name;// 城市名称
	private String province;// 所属省份编码

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", code=" + code + ", name=" + name + ", province=" + province + "]";
	}

}
