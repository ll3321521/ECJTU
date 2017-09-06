package com.ll.core.dao.product;

import java.util.List;

import com.ll.core.bean.product.Type;
import com.ll.core.query.product.TypeQuery;

public interface TypeDao {

	public void addType(Type type);

	public Type getTypeById(Integer id);

	public List<Type> getTypesByKeys(List<Integer> idList);

	public void delType(Integer id);

	public void deleteByKeys(List<Integer> idList);

	public void updateType(Type type);

	public List<Type> getTypeList(TypeQuery typeQuery);

}
