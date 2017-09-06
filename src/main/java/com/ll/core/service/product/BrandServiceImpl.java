package com.ll.core.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ll.core.bean.product.Brand;
import com.ll.core.dao.product.BrandDao;
import com.ll.core.query.product.BrandQuery;

/**
 * Æ·ÅÆÊÂÎñ
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService{
	
	@Autowired
	private BrandDao brandDao;

	@Transactional(readOnly = true)
	public List<Brand> getBrandListWithPage(Brand brand) {
		return brandDao.getBrandListWithPage(brand);
	}
	
	@Transactional(readOnly = true)
	public List<Brand> getBrandList(BrandQuery brandQuery) {
		return brandDao.getBrandList(brandQuery);
	}

	public void addBrand(Brand brand) {
		brandDao.addBrand(brand);
	}

	public void deleteBrand(Integer id) {
		brandDao.deleteBrand(id);
	}

	public void deleteBrands(Integer[] ids) {
		brandDao.deleteBrands(ids);
	}

	public void updateBrand(Brand brand) {
		brandDao.updateBrand(brand);
	}

	public Brand getBrandById(Integer id) {
		return brandDao.getBrandById(id);
	}

}
