package com.ll.core.bean.product;

import java.io.Serializable;

/**
 * ��Ʒ����
 */
public class Feature implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;// ����
	private String name;// ����
	private String value;// ����ֵ
	private Integer sort;// ǰ̨����
	private Integer isDel;// �Ƿ����:1:δ����,0:������

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
