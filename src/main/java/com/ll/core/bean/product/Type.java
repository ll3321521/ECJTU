package com.ll.core.bean.product;

import java.io.Serializable;

/**
 * 商品类型
 */
public class Type implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;// 主键
	private String name;// 类型名称
	private Integer parentId;// 父ID
	private String note;// 备注,用于google搜索页面描述
	private Integer isDisplay;// 是否可见 1:可见 0:不可见

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

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getIsDisplay() {
		return isDisplay;
	}

	public void setIsDisplay(Integer isDisplay) {
		this.isDisplay = isDisplay;
	}

	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name + ", parentId=" + parentId + ", note=" + note + ", isDisplay="
				+ isDisplay + "]";
	}

}
