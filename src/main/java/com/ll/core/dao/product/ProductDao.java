package com.ll.core.dao.product;

import java.util.List;

import com.ll.core.bean.product.Product;
import com.ll.core.query.product.ProductQuery;

public interface ProductDao {
	
	public List<Product> getProductList(ProductQuery productQuery);//��ѯ����
	
	public Integer addProduct(Product product);//�����Ʒ
	
	public void delProduct(Integer id);//ɾ����Ʒ
	
	public void delProducts(Integer[] ids);//����ɾ����Ʒ
	
	public void updateProduct(Product product);//�޸���Ʒ
	
	public Product getProductById(Integer id);//��������������Ʒ
	
}
