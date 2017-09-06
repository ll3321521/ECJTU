package com.ll.core.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ll.core.bean.product.Type;
import com.ll.core.dao.product.TypeDao;
import com.ll.core.query.product.TypeQuery;

@Service
public class TypeService {
	@Autowired
	private TypeDao typeDao;

	public void addType(Type type) {
		typeDao.addType(type);
	}

	public Type getTypeById(Integer id) {
		return typeDao.getTypeById(id);
	}

	public void delType(Integer id) {
		typeDao.delType(id);
	}

	public void updateType(Type type) {
		typeDao.updateType(type);
	}

	public List<Type> getTypeList(TypeQuery typeQuery) {
		return typeDao.getTypeList(typeQuery);
	}

}
