package com.ll.core.dao.country;

import java.util.List;

import com.ll.core.bean.country.City;
import com.ll.core.query.country.CityQuery;

public interface CityDao {

	public void addCity(City city);

	public City getCityById(Integer id);

	public List<City> getCitysByKeys(List<Integer> idList);

	public void delCity(Integer id);

	public void deleteByKeys(List<Integer> idList);

	public void updateCity(City city);

	public List<City> getCityList(CityQuery cityQuery);

}
