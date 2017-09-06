package com.ll.core.service.product;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ll.core.bean.product.Img;
import com.ll.core.bean.product.Product;
import com.ll.core.bean.product.Sku;
import com.ll.core.dao.product.ProductDao;
import com.ll.core.query.product.ImgQuery;
import com.ll.core.query.product.ProductQuery;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Resource
	private ProductDao productDao;
	@Autowired
	private ImgService imgService;
	@Autowired
	private SkuService skuService;

	@Transactional(readOnly = true)
	public List<Product> getProductList(ProductQuery productQuery) {
		return productDao.getProductList(productQuery);
	}

	public Integer addProduct(Product product) {
		//������Ʒ���
		DateFormat df=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String no=df.format(new Date());
		product.setNo(no);
		//���ʱ��
		product.setCreateTime(new Date());
		Integer i=productDao.addProduct(product);
		System.out.println("��Ʒid"+product.getId());
		//����ͼƬ ��Ʒid
		product.getImg().setProductId(product.getId());
		product.getImg().setIsDef(1);
		imgService.addImg(product.getImg());
		//����sku 
		Sku sku=new Sku();
		//��Ʒid
		sku.setProductId(product.getId());
		//�˷�
		sku.setDeliveFee(10.00);
		//�ۼ�
		sku.setSkuPrice(0.00);
		//�г���
		sku.setMarketPrice(0.00);
		//���
		sku.setStockInventory(0);
		//��������
		sku.setSkuUpperLimit(0);
		//���ʱ��
		sku.setCreateTime(new Date());
		//�Ƿ�����
		sku.setLastStatus(1);
		//�Ƿ�Ϊ��Ʒ
		sku.setSkuType(1);
		//����
		sku.setSales(0);
		for (String color : product.getColor().split(",")) {
			//��ɫid
			sku.setColorId(Integer.valueOf(color));
			for (String size : product.getSize().split(",")) {
				//����
				sku.setSize(size);
				//����sku
				skuService.addSku(sku);
			}
		}
		return i;
	}

	public void delProduct(Integer id) {
		// TODO Auto-generated method stub

	}

	public void delProducts(Integer[] ids) {
		// TODO Auto-generated method stub

	}

	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

	public Product getProductById(Integer id) {
		Product product = productDao.getProductById(id);
		ImgQuery imgQuery = new ImgQuery();
		imgQuery.setProductId(product.getId());
		imgQuery.setIsDef(1);
		List<Img> imgs = imgService.getImgList(imgQuery);
		product.setImg(imgs.get(0));
		return product;
	}

}
