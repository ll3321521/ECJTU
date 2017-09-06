package com.ll.core.dao.country;

import java.util.List;

import com.ll.core.bean.country.Town;
import com.ll.core.query.country.TownQuery;

public interface TownDao {

	public void addTown(Town town);

	public Town getTownById(Integer id);

	public List<Town> getTownsByKeys(List<Integer> idList);

	public void delTown(Integer id);

	public void deleteByKeys(List<Integer> idList);

	public void updateTown(Town town);

	public List<Town> getTownList(TownQuery townQuery);

}
