package com.ll.core.service.country;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ll.core.bean.country.Town;
import com.ll.core.dao.country.TownDao;
import com.ll.core.query.country.TownQuery;

@Service
public class TownService {
	@Autowired
	private TownDao townDao;
	
	public void addTown(Town town){
		townDao.addTown(town);
	}

	public Town getTownById(Integer id){
		return townDao.getTownById(id);
	}
	
	public void delTown(Integer id){
		townDao.delTown(id);
	}
	
	public void updateTown(Town town){
		townDao.updateTown(town);
	}

	public List<Town> getTownList(TownQuery townQuery){
		return townDao.getTownList(townQuery);
	}
	
}
