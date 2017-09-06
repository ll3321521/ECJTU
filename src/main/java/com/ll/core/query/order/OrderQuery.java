package com.ll.core.query.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ll.core.query.BaseQuery;

public class OrderQuery extends BaseQuery {
	/**
	 * ==============================������ѯ�����¡�ɾ��ʱ��Where��������======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public OrderQuery setId(Integer id) {
		this.id = id;
		return this;
	}
	private String oid;
	public String getOid() {
		return oid;
	}
	public OrderQuery setOid(String oid) {
		this.oid = oid;
		return this;
	}
	private boolean oidLike;
	public OrderQuery setOidLike(boolean isLike) {
		this.oidLike = isLike;
		return this;
	}
	private Double deliverFee;
	public Double getDeliverFee() {
		return deliverFee;
	}
	public OrderQuery setDeliverFee(Double deliverFee) {
		this.deliverFee = deliverFee;
		return this;
	}
	private Double payableFee;
	public Double getPayableFee() {
		return payableFee;
	}
	public OrderQuery setPayableFee(Double payableFee) {
		this.payableFee = payableFee;
		return this;
	}
	private Double totalPrice;
	public Double getTotalPrice() {
		return totalPrice;
	}
	public OrderQuery setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
		return this;
	}
	private Integer paymentWay;
	public Integer getPaymentWay() {
		return paymentWay;
	}
	public OrderQuery setPaymentWay(Integer paymentWay) {
		this.paymentWay = paymentWay;
		return this;
	}
	private Integer paymentCash;
	public Integer getPaymentCash() {
		return paymentCash;
	}
	public OrderQuery setPaymentCash(Integer paymentCash) {
		this.paymentCash = paymentCash;
		return this;
	}
	private Integer delivery;
	public Integer getDelivery() {
		return delivery;
	}
	public OrderQuery setDelivery(Integer delivery) {
		this.delivery = delivery;
		return this;
	}
	private Integer isConfirm;
	public Integer getIsConfirm() {
		return isConfirm;
	}
	public OrderQuery setIsConfirm(Integer isConfirm) {
		this.isConfirm = isConfirm;
		return this;
	}
	private Integer isPaiy;
	public Integer getIsPaiy() {
		return isPaiy;
	}
	public OrderQuery setIsPaiy(Integer isPaiy) {
		this.isPaiy = isPaiy;
		return this;
	}
	private Integer state;
	public Integer getState() {
		return state;
	}
	public OrderQuery setState(Integer state) {
		this.state = state;
		return this;
	}
	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public OrderQuery setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
	private String note;
	public String getNote() {
		return note;
	}
	public OrderQuery setNote(String note) {
		this.note = note;
		return this;
	}
	private boolean noteLike;
	public OrderQuery setNoteLike(boolean isLike) {
		this.noteLike = isLike;
		return this;
	}
	private String buyerId;
	public String getBuyerId() {
		return buyerId;
	}
	public OrderQuery setBuyerId(String buyerId) {
		this.buyerId = buyerId;
		return this;
	}
	private boolean buyerIdLike;
	public OrderQuery setBuyerIdLike(boolean isLike) {
		this.buyerIdLike = isLike;
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
	public OrderQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�oid
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public OrderQuery orderbyOid(boolean isAsc) {
		orderFields.add(new OrderField("oid", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�deliver_fee
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public OrderQuery orderbyDeliverFee(boolean isAsc) {
		orderFields.add(new OrderField("deliver_fee", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�payable_fee
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public OrderQuery orderbyPayableFee(boolean isAsc) {
		orderFields.add(new OrderField("payable_fee", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�total_price
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public OrderQuery orderbyTotalPrice(boolean isAsc) {
		orderFields.add(new OrderField("total_price", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�payment_way
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public OrderQuery orderbyPaymentWay(boolean isAsc) {
		orderFields.add(new OrderField("payment_way", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�payment_cash
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public OrderQuery orderbyPaymentCash(boolean isAsc) {
		orderFields.add(new OrderField("payment_cash", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�delivery
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public OrderQuery orderbyDelivery(boolean isAsc) {
		orderFields.add(new OrderField("delivery", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�isConfirm
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public OrderQuery orderbyIsConfirm(boolean isAsc) {
		orderFields.add(new OrderField("isConfirm", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�is_paiy
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public OrderQuery orderbyIsPaiy(boolean isAsc) {
		orderFields.add(new OrderField("is_paiy", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�state
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public OrderQuery orderbyState(boolean isAsc) {
		orderFields.add(new OrderField("state", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�create_date
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public OrderQuery orderbyCreateDate(boolean isAsc) {
		orderFields.add(new OrderField("create_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�note
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public OrderQuery orderbyNote(boolean isAsc) {
		orderFields.add(new OrderField("note", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�buyer_id
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public OrderQuery orderbyBuyerId(boolean isAsc) {
		orderFields.add(new OrderField("buyer_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
}
