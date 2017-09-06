package com.ll.core.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ll.core.bean.order.Detail;
import com.ll.core.dao.order.DetailDao;
import com.ll.core.query.order.DetailQuery;

@Service
@Transactional
public class DetailService {
	
	@Autowired
	private DetailDao detailDao;
	
	public void addDetail(Detail detail){
		detailDao.addDetail(detail);
	}

	public Detail getDetailById(Integer id){
		return detailDao.getDetailById(id);
	}
	
	public void delDetail(Integer id){
		detailDao.delDetail(id);
	}
	
	public void updateDetail(Detail detail){
		detailDao.updateDetail(detail);
	}

	public List<Detail> getDetailList(DetailQuery detailQuery){
		return detailDao.getDetailList(detailQuery);
	}
	
}
