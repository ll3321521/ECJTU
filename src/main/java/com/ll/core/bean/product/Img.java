package com.ll.core.bean.product;

import java.io.Serializable;

import com.ll.common.web.Constants;

/**
 * ͼƬ
 */
public class Img implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;// ����
	private Integer productId;// ��ƷID
	private String url;// ͼƬURL
	private Integer isDef;// �Ƿ�Ĭ��:0�� 1:��
	
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
