package com.ll.core.dao.user;

import java.util.List;

import com.ll.core.bean.user.Addr;
import com.ll.core.query.user.AddrQuery;


public interface AddrDao {

	public void addAddr(Addr addr);

	public Addr getAddrById(Integer id);

	public List<Addr> getAddrsByKeys(List<Integer> idList);

	public void delAddr(Integer id);

	public void deleteByKeys(List<Integer> idList);

	public void updateAddr(Addr addr);
	
	public List<Addr> getAddrList(AddrQuery addrQuery);

}
