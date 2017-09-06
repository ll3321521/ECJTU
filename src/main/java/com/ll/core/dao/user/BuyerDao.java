package com.ll.core.dao.user;

import java.util.List;

import com.ll.core.bean.user.Buyer;
import com.ll.core.query.user.BuyerQuery;

public interface BuyerDao {

	public void addBuyer(Buyer buyer);

	public Buyer getBuyerByName(String username);

	public List<Buyer> getBuyersByKeys(List<String> idList);

	public void delBuyer(String username);

	public void deleteByKeys(List<String> idList);

	public void updateBuyer(Buyer buyer);

	public List<Buyer> getBuyerList(BuyerQuery buyerQuery);
	
}
