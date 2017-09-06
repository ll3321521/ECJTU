package com.ll.core.bean.product;

import java.io.Serializable;
import java.util.Date;

/**
 * 最小销售单元
 */
public class Sku implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer productId;// 商品ID
	private Integer colorId;// 颜色ID
	private String size;// 尺码
	private Double deliveFee;// 运费 默认10元
	private Double skuPrice;// 售价
	private Integer stockInventory;// 库存
	private Integer skuUpperLimit;// 购买限制
	private String location;// 仓库位置:货架号
	private String skuImg;// SKU图片 精确到颜色及尺码对应的图片
	private Integer skuSort;// 前台显示排序
	private String skuName;// SKU名称
	private Double marketPrice;// 市场价
	private Date createTime;
	private Date updateTime;
	private String createUserId;
	private String updateUserId;
	private Integer lastStatus;// 0,历史 1最新
	private Integer skuType;// 0:赠品,1普通
	private Integer sales;// 销量
	
	private Color color;//加载颜色
	
	private Product product;//加载商品
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getColorId() {
		return colorId;
	}

	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Double getDeliveFee() {
		return deliveFee;
	}

	public void setDeliveFee(Double deliveFee) {
		this.deliveFee = deliveFee;
	}

	public Double getSkuPrice() {
		return skuPrice;
	}

	public void setSkuPrice(Double skuPrice) {
		this.skuPrice = skuPrice;
	}

	public Integer getStockInventory() {
		return stockInventory;
	}

	public void setStockInventory(Integer stockInventory) {
		this.stockInventory = stockInventory;
	}

	public Integer getSkuUpperLimit() {
		return skuUpperLimit;
	}

	public void setSkuUpperLimit(Integer skuUpperLimit) {
		this.skuUpperLimit = skuUpperLimit;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSkuImg() {
		return skuImg;
	}

	public void setSkuImg(String skuImg) {
		this.skuImg = skuImg;
	}

	public Integer getSkuSort() {
		return skuSort;
	}

	public void setSkuSort(Integer skuSort) {
		this.skuSort = skuSort;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public Double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Integer getLastStatus() {
		return lastStatus;
	}

	public void setLastStatus(Integer lastStatus) {
		this.lastStatus = lastStatus;
	}

	public Integer getSkuType() {
		return skuType;
	}

	public void setSkuType(Integer skuType) {
		this.skuType = skuType;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Sku [id=" + id + ", productId=" + productId + ", colorId=" + colorId + ", size=" + size + ", deliveFee="
				+ deliveFee + ", skuPrice=" + skuPrice + ", stockInventory=" + stockInventory + ", skuUpperLimit="
				+ skuUpperLimit + ", location=" + location + ", skuImg=" + skuImg + ", skuSort=" + skuSort
				+ ", skuName=" + skuName + ", marketPrice=" + marketPrice + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", createUserId=" + createUserId + ", updateUserId=" + updateUserId
				+ ", lastStatus=" + lastStatus + ", skuType=" + skuType + ", sales=" + sales + "]";
	}

}
