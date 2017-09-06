package com.ll.core.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ll.core.bean.user.Buyer;
import com.ll.core.dao.user.BuyerDao;
import com.ll.core.query.user.BuyerQuery;

@Service
public class BuyerService {
	@Autowired
	private BuyerDao buyerDao;
	
	public void addBuyer(Buyer buyer){
		buyerDao.addBuyer(buyer);
	}
	
	public Buyer getBuyerByName(String username){
		return buyerDao.getBuyerByName(username);
	}
	
	public void delBuyer(String username){
		buyerDao.delBuyer(username);
	}
	
	public void updateBuyer(Buyer buyer){
		buyerDao.updateBuyer(buyer);
	}
	
	public List<Buyer> getBuyerList(BuyerQuery buyerQuery){
		return buyerDao.getBuyerList(buyerQuery);
	}
	
}
