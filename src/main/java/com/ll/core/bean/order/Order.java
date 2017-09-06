package com.ll.core.bean.order;

import java.io.Serializable;
import java.util.Date;

/**
 * ����
 */
public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;//����
	private String oid;// ������
	private Double deliverFee;// �˷�
	private Double payableFee;// Ӧ�����
	private Double totalPrice;// �������
	private Integer paymentWay;// ֧����ʽ 0:���� 1:���� 2:�ʾ� 3:��˾ת��
	private Integer paymentCash;// �������ʽ.1�ֽ�,2POSˢ��
	private Integer delivery;// �ͻ�ʱ��
	private Integer isConfirm;// �Ƿ�绰ȷ�� 1:�� 0: ��
	private Integer isPaiy;// ֧��״̬ :0����1������,2�Ѹ���,3���˿�,4�˿�ɹ�,5�˿�ʧ��
	private Integer state;// ����״̬ 0:�ύ���� 1:�ֿ���� 2:��Ʒ���� 3:�ȴ��ջ� 4:��� 5���˻� 6���˻�
	private Date createDate;// ��������ʱ��
	private String note;// ����
	private String buyerId;// �û���
	
	/** ���⴦���ֶ�   */
	/** ֧����ʽ           */
	public String getPaymentWayName() {
		switch (paymentWay) {
			case 0:  return "��������";
			case 1:  return "����֧��";
			case 2:  return "��˾ת��";
			case 3:  return "�ʾֻ��";
			default: return "";
		}
	}
	/** ֧��Ҫ��     �����ǻ�������ʱ  �Ż���֧��Ҫ�� ��Ϊ 0:�ֽ� 1:POS��       */
	public String getPaymentCashName() {
		if(null == paymentCash) return null;
		
		switch (paymentCash) {
			case 0:  return "�ֽ�";
			case 1:  return "POS��";
			default: return "";
		}
	}
	/** ֧��״̬        //֧��״̬ :0����,1������,2�Ѹ���,3���˿�,4�˿�ɹ�,5�˿�ʧ��  */
	public String getIsPaiyName() {
		switch (isPaiy) {
			case 0:  return "��������";
			case 1:  return "������";
			case 2:  return "�Ѹ���";
			case 3:  return "���˿�";
			case 4:  return "�˿�ɹ�";
			case 5:  return "�˿�ʧ��";
			default: return "";
		}
	}
	/** ����״̬        //����״̬ 0:�ύ���� 1:�ֿ���� 2:��Ʒ���� 3:�ȴ��ջ� 4:��� 5:���˻� 6���˻� 7��ȡ��  */
	public String getStateName() {
		switch (state) {
			case 0:  return "�ύ����";
			case 1:  return "�ֿ����";
			case 2:  return "��Ʒ����";
			case 3:  return "�ȴ��ջ�";
			case 4:  return "�����";
			case 5:  return "���˻�";
			case 6:  return "���˻�";
			case 7:  return "��ȡ��";
			default: return "";
		}
	}
	/** �ͻ�ʱ��    //  1:�����գ�˫���գ����վ����ͻ�  2:ֻ˫���գ������ͻ�   3:ֻ�������ͻ���˫���գ��ڼ��ղ��ͣ�         */
	public String getDeliveryName() {
		switch (delivery) {
		case 1:  return "�����գ�˫���գ����վ����ͻ�";
		case 2:  return "ֻ˫���գ������ͻ�";
		case 3:  return "ֻ�������ͻ���˫���գ��ڼ��ղ��ͣ�";
		default: return "";
		}
	}
	/** �绰ȷ��     1:��   0:��          */
	public String getIsConfirmName() {
		switch (isConfirm) {
			case 0:  return "��";
			case 1:  return "��";
			default: return "";
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Double getDeliverFee() {
		return deliverFee;
	}

	public void setDeliverFee(Double deliverFee) {
		this.deliverFee = deliverFee;
	}

	public Double getPayableFee() {
		return payableFee;
	}

	public void setPayableFee(Double payableFee) {
		this.payableFee = payableFee;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getPaymentWay() {
		return paymentWay;
	}

	public void setPaymentWay(Integer paymentWay) {
		this.paymentWay = paymentWay;
	}

	public Integer getPaymentCash() {
		return paymentCash;
	}

	public void setPaymentCash(Integer paymentCash) {
		this.paymentCash = paymentCash;
	}

	public Integer getDelivery() {
		return delivery;
	}

	public void setDelivery(Integer delivery) {
		this.delivery = delivery;
	}

	public Integer getIsConfirm() {
		return isConfirm;
	}

	public void setIsConfirm(Integer isConfirm) {
		this.isConfirm = isConfirm;
	}

	public Integer getIsPaiy() {
		return isPaiy;
	}

	public void setIsPaiy(Integer isPaiy) {
		this.isPaiy = isPaiy;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", oid=" + oid + ", deliverFee=" + deliverFee + ", payableFee=" + payableFee
				+ ", totalPrice=" + totalPrice + ", paymentWay=" + paymentWay + ", paymentCash=" + paymentCash
				+ ", delivery=" + delivery + ", isConfirm=" + isConfirm + ", isPaiy=" + isPaiy + ", state=" + state
				+ ", createDate=" + createDate + ", note=" + note + ", buyerId=" + buyerId + "]";
	}

}
