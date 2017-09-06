package com.ll.core.bean.product;

import java.io.Serializable;

/**
 * 商品属性
 */
public class Feature implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;// 主键
	private String name;// 名称
	private String value;// 属性值
	private Integer sort;// 前台排序
	private Integer isDel;// 是否废弃:1:未废弃,0:废弃了

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	@Override
	public String toString() {
		return "Feature [id=" + id + ", name=" + name + ", value=" + value + ", sort=" + sort + ", isDel=" + isDel
				+ "]";
	}

}
