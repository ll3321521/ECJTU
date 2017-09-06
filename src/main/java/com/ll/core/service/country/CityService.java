package com.ll.core.service.country;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ll.core.bean.country.City;
import com.ll.core.dao.country.CityDao;
import com.ll.core.query.country.CityQuery;

@Service
public class CityService {
	@Autowired
	private CityDao cityDao;
	
	public void addCity(City city){
		cityDao.addCity(city);
	}

	public City getCityById(Integer id){
		return cityDao.getCityById(id);
	}
	
	public void delCity(Integer id){
		cityDao.delCity(id);
	}
	
	public void updateCity(City city){
		cityDao.updateCity(city);
	}

	public List<City> getCityList(CityQuery cityQuery){
		return cityDao.getCityList(cityQuery);
	}
	
}
