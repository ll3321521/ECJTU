package com.ll.core.dao.product;

import java.util.List;

import com.ll.core.bean.product.Brand;
import com.ll.core.query.product.BrandQuery;

public interface BrandDao {

	public List<Brand> getBrandListWithPage(Brand brand);//分页查询
	
	public List<Brand> getBrandList(BrandQuery brandQuery);//查询集合
	
	public void addBrand(Brand brand);//添加品牌
	
	public void deleteBrand(Integer id);//删除单个品牌
	
	public void deleteBrands(Integer[] ids);//删除多个品牌
	
	public void updateBrand(Brand brand);//修改品牌
	
	public Brand getBrandById(Integer id);//通过id查询一个品牌
}
