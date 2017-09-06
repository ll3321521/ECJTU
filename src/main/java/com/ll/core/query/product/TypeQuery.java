package com.ll.core.query.product;

import java.util.ArrayList;
import java.util.List;

import com.ll.core.query.BaseQuery;

public class TypeQuery extends BaseQuery{
	/**
	 * 批量查询、更新、删除时的Where条件设置
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public TypeQuery setId(Integer id) {
		this.id = id;
		return this;
	}
	private String name;
	public String getName() {
		return name;
	}
	public TypeQuery setName(String name) {
		this.name = name;
		return this;
	}
	private boolean nameLike;
	public TypeQuery setNameLike(boolean isLike) {
		this.nameLike = isLike;
		return this;
	}
	private Integer parentId;
	public Integer getParentId() {
		return parentId;
	}
	public TypeQuery setParentId(Integer parentId) {
		this.parentId = parentId;
		return this;
	}
	private String note;
	public String getNote() {
		return note;
	}
	public TypeQuery setNote(String note) {
		this.note = note;
		return this;
	}
	private boolean noteLike;
	public TypeQuery setNoteLike(boolean isLike) {
		this.noteLike = isLike;
		return this;
	}
	private Integer isDisplay;
	public Integer getIsDisplay() {
		return isDisplay;
	}
	public TypeQuery setIsDisplay(Integer isDisplay) {
		this.isDisplay = isDisplay;
		return this;
	}
	/**
	 * ==============================鎵归噺鏌ヨ鏃剁殑Order鏉�?�欢椤哄簭璁剧疆==========================
	 * ========
	 **/
	 	public class OrderField {
		public OrderField(String fieldName, String order) {
			super();
			this.fieldName = fieldName;
			this.order = order;
		}
		private String fieldName;
		private String order;

		public String getFieldName() {
			return fieldName;
		}
		public OrderField setFieldName(String fieldName) {
			this.fieldName = fieldName;
			return this;
		}
		public String getOrder() {
			return order;
		}
		public OrderField setOrder(String order) {
			this.order = order;
			return this;
		}
	}
		/**
	 * ==============================鎵归噺鏌ヨ鏃剁殑Order鏉�?�欢椤哄簭璁剧疆==========================
	 * ========
	 **/
	/** 鎺掑簭鍒楄�?��?�楁�? **/
	private List<OrderField> orderFields = new ArrayList<OrderField>();
	/**
	 * 璁剧疆鎺掑簭鎸夊睘鎬э細id
	 * 
	 * @param isAsc
	 *            鏄惁鍗囧簭锛屽惁鍒欎负闄嶅�?
	 */
	public TypeQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 璁剧疆鎺掑簭鎸夊睘鎬э細name
	 * 
	 * @param isAsc
	 *            鏄惁鍗囧簭锛屽惁鍒欎负闄嶅�?
	 */
	public TypeQuery orderbyName(boolean isAsc) {
		orderFields.add(new OrderField("name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 璁剧疆鎺掑簭鎸夊睘鎬э細parent_id
	 * 
	 * @param isAsc
	 *            鏄惁鍗囧簭锛屽惁鍒欎负闄嶅�?
	 */
	public TypeQuery orderbyParentId(boolean isAsc) {
		orderFields.add(new OrderField("parent_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 璁剧疆鎺掑簭鎸夊睘鎬э細note
	 * 
	 * @param isAsc
	 *            鏄惁鍗囧簭锛屽惁鍒欎负闄嶅�?
	 */
	public TypeQuery orderbyNote(boolean isAsc) {
		orderFields.add(new OrderField("note", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 璁剧疆鎺掑簭鎸夊睘鎬э細is_display
	 * 
	 * @param isAsc
	 *            鏄惁鍗囧簭锛屽惁鍒欎负闄嶅�?
	 */
	public TypeQuery orderbyIsDisplay(boolean isAsc) {
		orderFields.add(new OrderField("is_display", isAsc ? "ASC" : "DESC"));
		return this;
	}
}
