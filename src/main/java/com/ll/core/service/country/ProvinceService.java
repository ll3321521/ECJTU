package com.ll.core.service.country;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ll.core.bean.country.Province;
import com.ll.core.dao.country.ProvinceDao;
import com.ll.core.query.country.ProvinceQuery;

@Service
public class ProvinceService {
	@Autowired
	private ProvinceDao provinceDao;
	
	public void addProvince(Province province){
		provinceDao.addProvince(province);
	}

	public Province getProvinceById(Integer id){
		return provinceDao.getProvinceById(id);
	}
	
	public void delProvince(Integer id){
		provinceDao.delProvince(id);
	}
	
	public void updateProvince(Province province){
		provinceDao.updateProvince(province);
	}

	public List<Province> getProvinceList(ProvinceQuery provinceQuery){
		return provinceDao.getProvinceList(provinceQuery);
	}
	
}
