package com.ll.core.bean.product;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;//主键
	private String no;//商品编号
	private String name;//商品名称
	private Double weight;//重量 单位:克
	private Integer isNew ;//是否新品:0:旧品,1:新品
	private Integer isHot ;//是否热销:0,否 1:是
	private Integer isCommend ;//推荐 1推荐 0 不推荐
	private Date createTime;//添加时间
	private String createUserId;//添加人ID
	private Date checkTime;//审核时间
	private String checkUserId;//审核人ID
	private Integer isShow = 0;//上下架:0否 1是
	private Integer isDel = 1;//是否删除:0删除,1,没删除
	private Integer typeId;//类型ID
	private Integer brandId;//品牌ID
	private String keywords;//检索关键词
	private Integer sales;//销量
	private String description;//商品描述
	private String packageList;//包装清单
	private String feature;//商品属性集
	private String color;//颜色集  9,10,11,12
	private String size;//尺寸集  S,L,XXL
	
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
