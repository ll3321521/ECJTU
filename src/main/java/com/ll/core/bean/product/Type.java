package com.ll.core.bean.product;

import java.io.Serializable;

/**
 * ��Ʒ����
 */
public class Type implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;// ����
	private String name;// ��������
	private Integer parentId;// ��ID
	private String note;// ��ע,����google����ҳ������
	private Integer isDisplay;// �Ƿ�ɼ� 1:�ɼ� 0:���ɼ�

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
