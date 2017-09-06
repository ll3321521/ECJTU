package com.ll.core.dao.order;

import java.util.List;

import com.ll.core.bean.order.Detail;
import com.ll.core.query.order.DetailQuery;

public interface DetailDao {

	public void addDetail(Detail detail);

	public Detail getDetailById(Integer id);

	public List<Detail> getDetailsByKeys(List<Integer> idList);

	public void delDetail(Integer id);

	public void deleteByKeys(List<Integer> idList);

	public void updateDetail(Detail detail);
	
	public List<Detail> getDetailList(DetailQuery detailQuery);

}
