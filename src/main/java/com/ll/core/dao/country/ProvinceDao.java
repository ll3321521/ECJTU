package com.ll.core.dao.country;

import java.util.List;

import com.ll.core.bean.country.Province;
import com.ll.core.query.country.ProvinceQuery;

public interface ProvinceDao {

	public void addProvince(Province province);

	public Province getProvinceById(Integer id);

	public List<Province> getProvincesByKeys(List<Integer> idList);

	public void delProvince(Integer id);

	public void deleteByKeys(List<Integer> idList);

	public void updateProvince(Province province);

	public List<Province> getProvinceList(ProvinceQuery provinceQuery);

}
