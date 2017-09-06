package com.ll.core.dao.product;

import java.util.List;

import com.ll.core.bean.product.Product;
import com.ll.core.query.product.ProductQuery;

public interface ProductDao {
	
	public List<Product> getProductList(ProductQuery productQuery);//查询集合
	
	public Integer addProduct(Product product);//添加商品
	
	public void delProduct(Integer id);//删除商品
	
	public void delProducts(Integer[] ids);//批量删除商品
	
	public void updateProduct(Product product);//修改商品
	
	public Product getProductById(Integer id);//根据主键查找商品
	
}
