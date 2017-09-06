package com.ll.core.dao.product;

import java.util.List;

import com.ll.core.bean.product.Color;
import com.ll.core.query.product.ColorQuery;

public interface ColorDao {

	public void addColor(Color color);//新增颜色
	
	public Color getColorById(Integer id);//根基id获取颜色

	public void delColor(Integer id);//根据id删除颜色

	public void updateColor(Color color);//更改颜色

	public List<Color> getColorList(ColorQuery colorQuery);//获取颜色列表
	
}
