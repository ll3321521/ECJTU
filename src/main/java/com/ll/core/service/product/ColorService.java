package com.ll.core.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ll.core.bean.product.Color;
import com.ll.core.dao.product.ColorDao;
import com.ll.core.query.product.ColorQuery;

@Service
public class ColorService{
	@Autowired
	private ColorDao colorDao;

	public void addColor(Color color) {
		colorDao.addColor(color);
	}

	public Color getColorById(Integer id) {
		return colorDao.getColorById(id);
	}

	public void delColor(Integer id) {
		colorDao.delColor(id);
	}

	public void updateColor(Color color) {
		colorDao.updateColor(color);
	}

	public List<Color> getColorList(ColorQuery colorQuery) {
		return colorDao.getColorList(colorQuery);
	}
	
	
	
}
