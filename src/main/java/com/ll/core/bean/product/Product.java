package com.ll.core.bean.product;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;//����
	private String no;//��Ʒ���
	private String name;//��Ʒ����
	private Double weight;//���� ��λ:��
	private Integer isNew ;//�Ƿ���Ʒ:0:��Ʒ,1:��Ʒ
	private Integer isHot ;//�Ƿ�����:0,�� 1:��
	private Integer isCommend ;//�Ƽ� 1�Ƽ� 0 ���Ƽ�
	private Date createTime;//���ʱ��
	private String createUserId;//�����ID
	private Date checkTime;//���ʱ��
	private String checkUserId;//�����ID
	private Integer isShow = 0;//���¼�:0�� 1��
	private Integer isDel = 1;//�Ƿ�ɾ��:0ɾ��,1,ûɾ��
	private Integer typeId;//����ID
	private Integer brandId;//Ʒ��ID
	private String keywords;//�����ؼ���
	private Integer sales;//����
	private String description;//��Ʒ����
	private String packageList;//��װ�嵥
	private String feature;//��Ʒ���Լ�
	private String color;//��ɫ��  9,10,11,12
	private String size;//�ߴ缯  S,L,XXL
	
	private Img img;

	public Img getImg() {
		return img;
	}

	public void setImg(Img img) {
		this.img = img;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getIsNew() {
		return isNew;
	}

	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}

	public Integer getIsHot() {
		return isHot;
	}

	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}

	public Integer getIsCommend() {
		return isCommend;
	}

	public void setIsCommend(Integer isCommend) {
		this.isCommend = isCommend;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getCheckUserId() {
		return checkUserId;
	}

	public void setCheckUserId(String checkUserId) {
		this.checkUserId = checkUserId;
	}

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPackageList() {
		return packageList;
	}

	public void setPackageList(String packageList) {
		this.packageList = packageList;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", no=" + no + ", name=" + name + ", weight=" + weight + ", isNew=" + isNew
				+ ", isHot=" + isHot + ", isCommend=" + isCommend + ", createTime=" + createTime + ", createUserId="
				+ createUserId + ", checkTime=" + checkTime + ", checkUserId=" + checkUserId + ", isShow=" + isShow
				+ ", isDel=" + isDel + ", typeId=" + typeId + ", brandId=" + brandId + ", keywords=" + keywords
				+ ", sales=" + sales + ", description=" + description + ", packageList=" + packageList + ", feature="
				+ feature + ", color=" + color + ", size=" + size + "]";
	}

}
