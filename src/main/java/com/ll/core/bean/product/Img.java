package com.ll.core.bean.product;

import java.io.Serializable;

import com.ll.common.web.Constants;

/**
 * 图片
 */
public class Img implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;// 主键
	private Integer productId;// 商品ID
	private String url;// 图片URL
	private Integer isDef;// 是否默认:0否 1:是
	
	public String getAllUrl() {
		return Constants.IMG_URL+url;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getIsDef() {
		return isDef;
	}

	public void setIsDef(Integer isDef) {
		this.isDef = isDef;
	}

	@Override
	public String toString() {
		return "Img [id=" + id + ", productId=" + productId + ", url=" + url + ", isDef=" + isDef + "]";
	}

}
