package com.ll.core.bean.country;

import java.io.Serializable;

/**
 * 省份
 */
public class Province implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;// 主键
	private String code;// 省份编码
	private String name;// 省份名称

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

	@Override
	public String toString() {
		return "Province [id=" + id + ", code=" + code + ", name=" + name + "]";
	}

}
