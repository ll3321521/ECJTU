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
		//生成商品编号
		DateFormat df=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String no=df.format(new Date());
		product.setNo(no);
		//添加时间
		product.setCreateTime(new Date());
		Integer i=productDao.addProduct(product);
		System.out.println("商品id"+product.getId());
		//设置图片 商品id
		product.getImg().setProductId(product.getId());
		product.getImg().setIsDef(1);
		imgService.addImg(product.getImg());
		//生成sku 
		Sku sku=new Sku();
		//商品id
		sku.setProductId(product.getId());
		//运费
		sku.setDeliveFee(10.00);
		//售价
		sku.setSkuPrice(0.00);
		//市场价
		sku.setMarketPrice(0.00);
		//库存
		sku.setStockInventory(0);
		//购买限制
		sku.setSkuUpperLimit(0);
		//添加时间
		sku.setCreateTime(new Date());
		//是否最新
		sku.setLastStatus(1);
		//是否为赠品
		sku.setSkuType(1);
		//销量
		sku.setSales(0);
		for (String color : product.getColor().split(",")) {
			//颜色id
			sku.setColorId(Integer.valueOf(color));
			for (String size : product.getSize().split(",")) {
				//尺码
				sku.setSize(size);
				//保存sku
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
