package com.ll.core.dao.product;

import java.util.List;

import com.ll.core.bean.product.Img;
import com.ll.core.query.product.ImgQuery;

public interface ImgDao {

	public void addImg(Img img);

	public Img getImgById(Integer id);

	public List<Img> getImgsByKeys(List<Integer> idList);

	public void delImg(Integer id);

	public void deleteByKeys(List<Integer> idList);

	public void updateImg(Img img);

	public List<Img> getImgList(ImgQuery imgQuery);

}
