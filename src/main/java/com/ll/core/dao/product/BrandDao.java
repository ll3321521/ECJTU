package com.ll.core.dao.product;

import java.util.List;

import com.ll.core.bean.product.Brand;
import com.ll.core.query.product.BrandQuery;

public interface BrandDao {

	public List<Brand> getBrandListWithPage(Brand brand);//��ҳ��ѯ
	
	public List<Brand> getBrandList(BrandQuery brandQuery);//��ѯ����
	
	public void addBrand(Brand brand);//���Ʒ��
	
	public void deleteBrand(Integer id);//ɾ������Ʒ��
	
	public void deleteBrands(Integer[] ids);//ɾ�����Ʒ��
	
	public void updateBrand(Brand brand);//�޸�Ʒ��
	
	public Brand getBrandById(Integer id);//ͨ��id��ѯһ��Ʒ��
}
