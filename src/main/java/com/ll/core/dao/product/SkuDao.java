package com.ll.core.dao.product;

import java.util.List;

import com.ll.core.bean.product.Sku;
import com.ll.core.query.product.SkuQuery;


public interface SkuDao {

	public void addSku(Sku sku);

	public Sku getSkuById(Integer id);

	public List<Sku> getSkusByKeys(List<Integer> idList);

	public void delSku(Integer id);

	public void deleteByKeys(List<Integer> idList);

	public void updateSku(Sku sku);

	public List<Sku> getSkuList(SkuQuery skuQuery);
	
	public List<Sku> getStock(Integer productId);//²éÑ¯¿â´æ´óÓÚ0

}
