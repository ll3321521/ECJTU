package com.ll.core.query.user;

import java.util.ArrayList;
import java.util.List;

import com.ll.core.query.BaseQuery;

public class AddrQuery extends BaseQuery {
	/**
	 * ==============================������ѯ�����¡�ɾ��ʱ��Where��������======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public AddrQuery setId(Integer id) {
		this.id = id;
		return this;
	}
	private String buyerId;
	public String getBuyerId() {
		return buyerId;
	}
	public AddrQuery setBuyerId(String buyerId) {
		this.buyerId = buyerId;
		return this;
	}
	private boolean buyerIdLike;
	public AddrQuery setBuyerIdLike(boolean isLike) {
		this.buyerIdLike = isLike;
		return this;
	}
	private String name;
	public String getName() {
		return name;
	}
	public AddrQuery setName(String name) {
		this.name = name;
		return this;
	}
	private boolean nameLike;
	public AddrQuery setNameLike(boolean isLike) {
		this.nameLike = isLike;
		return this;
	}
	private String city;
	public String getCity() {
		return city;
	}
	public AddrQuery setCity(String city) {
		this.city = city;
		return this;
	}
	private boolean cityLike;
	public AddrQuery setCityLike(boolean isLike) {
		this.cityLike = isLike;
		return this;
	}
	private String addr;
	public String getAddr() {
		return addr;
	}
	public AddrQuery setAddr(String addr) {
		this.addr = addr;
		return this;
	}
	private boolean addrLike;
	public AddrQuery setAddrLike(boolean isLike) {
		this.addrLike = isLike;
		return this;
	}
	private String phone;
	public String getPhone() {
		return phone;
	}
	public AddrQuery setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	private boolean phoneLike;
	public AddrQuery setPhoneLike(boolean isLike) {
		this.phoneLike = isLike;
		return this;
	}
	private Integer isDef;
	public Integer getIsDef() {
		return isDef;
	}
	public AddrQuery setIsDef(Integer isDef) {
		this.isDef = isDef;
		return this;
	}
	/**
	 * ==============================������ѯʱ��Order����˳������==========================
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
	 * ==============================������ѯʱ��Order����˳������==========================
	 * ========
	 **/
	/** �����б��ֶ� **/
	private List<OrderField> orderFields = new ArrayList<OrderField>();
	/**
	 * �����������ԣ�id
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public AddrQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�buyer_id
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public AddrQuery orderbyBuyerId(boolean isAsc) {
		orderFields.add(new OrderField("buyer_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�name
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public AddrQuery orderbyName(boolean isAsc) {
		orderFields.add(new OrderField("name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�city
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public AddrQuery orderbyCity(boolean isAsc) {
		orderFields.add(new OrderField("city", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�addr
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public AddrQuery orderbyAddr(boolean isAsc) {
		orderFields.add(new OrderField("addr", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�phone
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public AddrQuery orderbyPhone(boolean isAsc) {
		orderFields.add(new OrderField("phone", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�is_def
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public AddrQuery orderbyIsDef(boolean isAsc) {
		orderFields.add(new OrderField("is_def", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
}
