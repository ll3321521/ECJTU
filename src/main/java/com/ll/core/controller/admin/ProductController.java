package com.ll.core.controller.admin;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ll.core.bean.product.Brand;
import com.ll.core.bean.product.Color;
import com.ll.core.bean.product.Feature;
import com.ll.core.bean.product.Img;
import com.ll.core.bean.product.Product;
import com.ll.core.bean.product.Type;
import com.ll.core.query.product.BrandQuery;
import com.ll.core.query.product.ColorQuery;
import com.ll.core.query.product.FeatureQuery;
import com.ll.core.query.product.ImgQuery;
import com.ll.core.query.product.ProductQuery;
import com.ll.core.query.product.TypeQuery;
import com.ll.core.service.product.BrandService;
import com.ll.core.service.product.ColorService;
import com.ll.core.service.product.FeatureService;
import com.ll.core.service.product.ImgService;
import com.ll.core.service.product.ProductService;
import com.ll.core.service.product.TypeService;

/**
 * 后台商品管理	列表 添加 上架
 */
@Controller
public class ProductController {
	
	@Autowired
	private BrandService brandService;
	@Autowired
	private ProductService productService;
	@Autowired
	private TypeService typeService;
	@Autowired
	private ColorService colorService;
	@Autowired
	private FeatureService featureService;
	@Autowired
	private ImgService imgService;
	
	//商品列表
	@RequestMapping(value="/product/list.do")
	public String list(@RequestParam(value="pageNum",defaultValue="1")Integer pageNum,
				String name,Integer brandId,Integer isShow,Model model) {
		//品牌条件
		BrandQuery brandQuery=new BrandQuery();
		brandQuery.setFields("id,name");
		brandQuery.setIsDisplay(1);
		//加载品牌
		List<Brand> brands=brandService.getBrandList(brandQuery);
		model.addAttribute("brands", brands);
		//商品条件
		ProductQuery productQuery=new ProductQuery();
		//判断名称
		if(StringUtils.isNotBlank(name)){
			productQuery.setName(name);
			//模糊查询
			productQuery.setNameLike(true);
			model.addAttribute("name", name);
		}
		//判断品牌
		if(brandId!=null){
			productQuery.setBrandId(brandId);
			model.addAttribute("brandId", brandId);
		}
		//判断上下架
		if(isShow!=null){
			productQuery.setIsShow(isShow);
			model.addAttribute("isShow", isShow);
		}else{
			productQuery.setIsShow(0);
			model.addAttribute("isShow", 0);
		}
		//按照id倒排
		productQuery.orderbyId(false);
		PageHelper.startPage(pageNum, 5);
		List<Product> products=productService.getProductList(productQuery);
		for (Product product : products) {
			ImgQuery imgQuery=new ImgQuery();
			imgQuery.setProductId(product.getId());
			List<Img> imgs=imgService.getImgList(imgQuery);
			product.setImg(imgs.get(0));
		}
		PageInfo page=new PageInfo(products,5);
		model.addAttribute("page", page);
		return "product/list";
	}
	
	//跳转添加页面
	@RequestMapping(value="/product/toAdd.do")
	public String toAdd(Model model) {
		//1.加载商品类型
		TypeQuery typeQuery=new TypeQuery();
		//指定查询字段
		typeQuery.setFields("id,name");
		typeQuery.setIsDisplay(1);
		typeQuery.setParentId(0);
		//加载类型
		List<Type> types=typeService.getTypeList(typeQuery);
		model.addAttribute("types", types);
		//2.加载商品品牌
		//品牌条件
		BrandQuery brandQuery=new BrandQuery();
		brandQuery.setFields("id,name");
		brandQuery.setIsDisplay(1);
		//加载品牌
		List<Brand> brands=brandService.getBrandList(brandQuery);
		model.addAttribute("brands", brands);
		//3.加载商品属性
		FeatureQuery featureQuery=new FeatureQuery();
		List<Feature> features=featureService.getFeatureList(featureQuery);
		model.addAttribute("features", features);
		//4.加载颜色
		ColorQuery colorQuery=new ColorQuery();
		colorQuery.setParentId(0);
		List<Color> colors=colorService.getColorList(colorQuery);
		model.addAttribute("colors", colors);
		return "product/add";
	}
	
	//添加商品
	@RequestMapping(value="/product/add.do")
	public String addProduct(Product product,Img img) {
		//1:商品 表   图片表   SKu表
		product.setImg(img);
		//传商品对象到Servcie
		productService.addProduct(product);
		return "redirect:/product/list.do";
	}
	
	//商品上架
	@RequestMapping(value="/product/isShow.do")
	public String isShow(Integer[] ids,Integer pageNum,String name,Integer brandId,Integer isShow,Model model) {
		//实例化商品
		Product product=new Product();
		product.setIsShow(1);
		//上架
		if(ids!=null && ids.length>0){
			for (Integer id : ids) {
				product.setId(id);
				//修改上架状态
				productService.updateProduct(product);
			}
		}
		
		//判断参数
		if(pageNum!=null){
			model.addAttribute("pageNum", pageNum);
		}
		if(StringUtils.isNotBlank(name)){
			model.addAttribute("name", name);
		}
		if(pageNum!=null){
			model.addAttribute("brandId", brandId);
		}
		if(pageNum!=null){
			model.addAttribute("isShow", isShow);
		}
		return "redirect:/product/list.do";
	}
	
}
