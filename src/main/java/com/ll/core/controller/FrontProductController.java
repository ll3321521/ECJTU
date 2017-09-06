package com.ll.core.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ll.common.web.session.SessionProvider;
import com.ll.core.bean.product.Brand;
import com.ll.core.bean.product.Color;
import com.ll.core.bean.product.Feature;
import com.ll.core.bean.product.Img;
import com.ll.core.bean.product.Product;
import com.ll.core.bean.product.Sku;
import com.ll.core.bean.product.Type;
import com.ll.core.query.product.BrandQuery;
import com.ll.core.query.product.FeatureQuery;
import com.ll.core.query.product.ImgQuery;
import com.ll.core.query.product.ProductQuery;
import com.ll.core.query.product.TypeQuery;
import com.ll.core.service.product.BrandService;
import com.ll.core.service.product.ColorService;
import com.ll.core.service.product.FeatureService;
import com.ll.core.service.product.ImgService;
import com.ll.core.service.product.ProductService;
import com.ll.core.service.product.SkuService;
import com.ll.core.service.product.TypeService;

/**
 * ǰ̨��Ʒҳ��
 */
@Controller
public class FrontProductController {
	@Autowired
	private BrandService brandService;
	@Autowired
	private ProductService productService;
	@Autowired
	private TypeService typeService;
	@Autowired
	private FeatureService featureService;
	@Autowired
	private ImgService imgService;
	@Autowired
	private SkuService skuService;
	@Autowired
	private ColorService colorService;
	@Autowired
	private SessionProvider sessionProvider;
	
	//��Ʒ�б�ҳ��
	@RequestMapping(value="/product/display/list.shtml")
	public String list(@RequestParam(value="pageNum",defaultValue="1")Integer pageNum,Model model,
			Integer brandId,String brandName,Integer typeId,String typeName,Integer featureId,String featureName) {
		//����
		ProductQuery productQuery=new ProductQuery();
		//��ʼ��������ѡ����
		boolean flag=false;
		//����map����
		Map<String, String> querys=new LinkedHashMap<String, String>();
		//ѡ����������������
		//Ʒ��
		if(brandId!=null){
			productQuery.setBrandId(brandId);
			flag=true;
			//���ݵ�ǰ̨
			model.addAttribute("brandId", brandId);
			model.addAttribute("brandName", brandName);
			querys.put("Ʒ��", brandName);
		}else {
			//2.������ƷƷ��
			//Ʒ������
			BrandQuery brandQuery=new BrandQuery();
			brandQuery.setFields("id,name");
			brandQuery.setIsDisplay(1);
			//����Ʒ��
			List<Brand> brands=brandService.getBrandList(brandQuery);
			model.addAttribute("brands", brands);
		}
		//��Ʒ����
		if(typeId!=null){
			productQuery.setTypeId(typeId);
			flag=true;
			//���ݵ�ǰ̨
			model.addAttribute("typeId", typeId);
			model.addAttribute("typeName", typeName);
			querys.put("����", typeName);
		}else {
			//1.������Ʒ����
			TypeQuery typeQuery=new TypeQuery();
			//ָ����ѯ�ֶ�
			typeQuery.setFields("id,name");
			typeQuery.setIsDisplay(1);
			typeQuery.setParentId(0);
			//��������
			List<Type> types=typeService.getTypeList(typeQuery);
			model.addAttribute("types", types);
		}
		//��Ʒ����
		if(featureId!=null){
			productQuery.setTypeId(featureId);
			flag=true;
			//���ݵ�ǰ̨
			model.addAttribute("featureId", featureId);
			model.addAttribute("featureName", featureName);
			querys.put("����", featureName);
		}else {
			//3.������Ʒ����
			FeatureQuery featureQuery=new FeatureQuery();
			List<Feature> features=featureService.getFeatureList(featureQuery);
			model.addAttribute("features", features);
		}
		model.addAttribute("flag", flag);
		model.addAttribute("querys", querys);
		PageHelper.startPage(pageNum, 8);
		List<Product> products=productService.getProductList(productQuery);
		for (Product product : products) {
			ImgQuery imgQuery=new ImgQuery();
			imgQuery.setProductId(product.getId());
			List<Img> imgs=imgService.getImgList(imgQuery);
			product.setImg(imgs.get(0));
		}
		PageInfo page=new PageInfo(products,5);
		model.addAttribute("page", page);
		return "product/product";
	}
	
	//��ת��Ʒ����ҳ
	@RequestMapping(value="/product/toDetail.shtml")
	public String toDetail(Integer productId,Model model) {
		//������Ʒ
		Product product=productService.getProductById(productId);
		model.addAttribute("product", product);
		//����Sku ������0
		List<Sku> skus=skuService.getStock(productId);
		model.addAttribute("skus", skus);
		//ɸѡȥ��
		List<Color> colors=new ArrayList<Color>();
		
		//����sku
		for (Sku sku : skus) {
			if(!colors.contains(sku.getColor())){
				colors.add(sku.getColor());
			}
		}
		model.addAttribute("colors", colors);
		return "product/productDetail";
	}
	
}
