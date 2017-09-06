package com.ll.core.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ll.core.bean.product.Img;
import com.ll.core.dao.product.ImgDao;
import com.ll.core.query.product.ImgQuery;

@Service
public class ImgService {
	@Autowired ImgDao imgDao;

	public void addImg(Img img){
		imgDao.addImg(img);
	}

	public Img getImgById(Integer id){
		return imgDao.getImgById(id);
	}
	
	public void delImg(Integer id){
		imgDao.delImg(id);
	}
	
	public void updateImg(Img img){
		imgDao.updateImg(img);
	}

	public List<Img> getImgList(ImgQuery imgQuery){
		return imgDao.getImgList(imgQuery);
	}

	
}
