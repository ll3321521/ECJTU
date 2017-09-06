package com.ll.core.bean.country;

import java.io.Serializable;

/**
 * 县/区
 */
public class Town implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;//主键
	private String code;//区县编码
	private String name;//区县名称
	private String city;//所属城市编码

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Town [id=" + id + ", code=" + code + ", name=" + name + ", city=" + city + "]";
	}

}
