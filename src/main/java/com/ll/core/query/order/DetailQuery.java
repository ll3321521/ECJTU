package com.ll.core.query.order;

import java.util.*;

import com.ll.core.query.BaseQuery;

public class DetailQuery extends BaseQuery {
	/**
	 * ==============================������ѯ�����¡�ɾ��ʱ��Where��������======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public DetailQuery setId(Integer id) {
		this.id = id;
		return this;
	}
	private Integer orderId;
	public Integer getOrderId() {
		return orderId;
	}
	public DetailQuery setOrderId(Integer orderId) {
		this.orderId = orderId;
		return this;
	}
	private String productNo;
	public String getProductNo() {
		return productNo;
	}
	public DetailQuery setProductNo(String productNo) {
		this.productNo = productNo;
		return this;
	}
	private boolean productNoLike;
	public DetailQuery setProductNoLike(boolean isLike) {
		this.productNoLike = isLike;
		return this;
	}
	private String productName;
	public String getProductName() {
		return productName;
	}
	public DetailQuery setProductName(String productName) {
		this.productName = productName;
		return this;
	}
	private boolean productNameLike;
	public DetailQuery setProductNameLike(boolean isLike) {
		this.productNameLike = isLike;
		return this;
	}
	private String color;
	public String getColor() {
		return color;
	}
	public DetailQuery setColor(String color) {
		this.color = color;
		return this;
	}
	private boolean colorLike;
	public DetailQuery setColorLike(boolean isLike) {
		this.colorLike = isLike;
		return this;
	}
	private String size;
	public String getSize() {
		return size;
	}
	public DetailQuery setSize(String size) {
		this.size = size;
		return this;
	}
	private boolean sizeLike;
	public DetailQuery setSizeLike(boolean isLike) {
		this.sizeLike = isLike;
		return this;
	}
	private Double skuPrice;
	public Double getSkuPrice() {
		return skuPrice;
	}
	public DetailQuery setSkuPrice(Double skuPrice) {
		this.skuPrice = skuPrice;
		return this;
	}
	private Integer amount;
	public Integer getAmount() {
		return amount;
	}
	public DetailQuery setAmount(Integer amount) {
		this.amount = amount;
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
	public DetailQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�order_id
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public DetailQuery orderbyOrderId(boolean isAsc) {
		orderFields.add(new OrderField("order_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�product_no
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public DetailQuery orderbyProductNo(boolean isAsc) {
		orderFields.add(new OrderField("product_no", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�product_name
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public DetailQuery orderbyProductName(boolean isAsc) {
		orderFields.add(new OrderField("product_name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�color
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public DetailQuery orderbyColor(boolean isAsc) {
		orderFields.add(new OrderField("color", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�size
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public DetailQuery orderbySize(boolean isAsc) {
		orderFields.add(new OrderField("size", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�sku_price
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public DetailQuery orderbySkuPrice(boolean isAsc) {
		orderFields.add(new OrderField("sku_price", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�amount
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public DetailQuery orderbyAmount(boolean isAsc) {
		orderFields.add(new OrderField("amount", isAsc ? "ASC" : "DESC"));
		return this;
	}
	private String fields;
	/**
	 * �ṩ�Զ����ֶ�ʹ��
	 */
	private static Map<String, String> fieldMap;

	private static Map<String, String> getFieldSet() {
		if (fieldMap == null) {
			fieldMap = new HashMap<String, String>();
			fieldMap.put("id", "id");
			fieldMap.put("orderId", "order_id");
			fieldMap.put("productNo", "product_no");
			fieldMap.put("productName", "product_name");
			fieldMap.put("color", "color");
			fieldMap.put("size", "size");
			fieldMap.put("skuPrice", "sku_price");
			fieldMap.put("amount", "amount");
		}
		return fieldMap;
	}

	public String getFields() {
		return this.fields;
	}
	public void setFields(String fields) {
		if (fields == null)
			return;
		String[] array = fields.split(",");
		StringBuffer buffer = new StringBuffer();
		for (String field : array) {
			if (getFieldSet().containsKey(field)) {
				buffer.append(getFieldSet().get(field)).append(" as ")
						.append(field).append(" ,");
			}
			if (getFieldSet().containsKey("`" + field + "`")) {
				buffer.append("`" + getFieldSet().get(field) + "`").append(" as ")
						.append(field).append(" ,");
			}
		}
		if (buffer.length() != 0) {
			this.fields = buffer.substring(0, buffer.length() - 1);
		} else {
			this.fields = " 1 ";// û��һ���������ܻᱨ��
		}
	}
}
