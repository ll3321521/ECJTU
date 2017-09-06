package com.ll.core.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ll.core.bean.user.Addr;
import com.ll.core.dao.user.AddrDao;
import com.ll.core.query.user.AddrQuery;

@Service
public class AddrService {
	@Autowired
	private AddrDao addrDao;
	
	public void addAddr(Addr addr){
		addrDao.addAddr(addr);
	}

	public Addr getAddrById(Integer id){
		return addrDao.getAddrById(id);
	}
	
	public void delAddr(Integer id){
		addrDao.delAddr(id);
	}
	
	public void updateAddr(Addr addr){
		addrDao.updateAddr(addr);
	}

	public List<Addr> getAddrList(AddrQuery addrQuery){
		return addrDao.getAddrList(addrQuery);
	}

}
