package com.ll.core.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ll.core.bean.product.Product;
import com.ll.core.bean.product.Sku;
import com.ll.core.dao.product.SkuDao;
import com.ll.core.query.product.SkuQuery;

@Service
@Transactional
public class SkuService {
	@Autowired
	private SkuDao skuDao;
	@Autowired
	private ColorService colorService;
	@Autowired
	private ProductService productService;
	
	public void addSku(Sku sku){
		skuDao.addSku(sku);
	}
	public Sku getSkuById(Integer id){
		Sku sku=skuDao.getSkuById(id);
		Product product=productService.getProductById(sku.getProductId());
		sku.setProduct(product);
		sku.setColor(colorService.getColorById(sku.getColorId()));
		return sku;
	}
	public void delSku(Integer id){
		skuDao.delSku(id);
	}
	public void updateSku(Sku sku){
		skuDao.updateSku(sku);
	}
	
	@Transactional(readOnly=true)
	public List<Sku> getSkuList(SkuQuery skuQuery){
		List<Sku> skus=skuDao.getSkuList(skuQuery);
		//加载颜色
		for (Sku sku : skus) {
			sku.setColor(colorService.getColorById(sku.getColorId()));
		}
		return skus;
	}
	
	//查询库存大于0
	@Transactional(readOnly=true)
	public List<Sku> getStock(Integer productId){
		List<Sku> skus=skuDao.getStock(productId);
		//加载颜色
		for (Sku sku : skus) {
			sku.setColor(colorService.getColorById(sku.getColorId()));
		}
		return skus;
	}
}
