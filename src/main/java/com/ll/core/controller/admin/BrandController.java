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
import com.ll.core.service.product.BrandService;

@Controller
public class BrandController {

	@Autowired
	private BrandService brandService;
	
	//品牌列表页面
	@RequestMapping(value="/brand/list.do")
	public String list(@RequestParam(value="pageNum",defaultValue="1")Integer pageNum,
				String name,Integer isDisplay,Model model) {
		Brand brand=new Brand();
		if(StringUtils.isNotBlank(name)){
			brand.setName(name);
		}
		brand.setIsDisplay(isDisplay);
		PageHelper.startPage(pageNum, 5);
		List<Brand> brands=brandService.getBrandListWithPage(brand);
		PageInfo page=new PageInfo(brands,5);
		model.addAttribute("page",page);
		model.addAttribute("name",name);
		model.addAttribute("isDisplay",isDisplay);
		return "brand/list";
	}
	
	//跳转品牌添加页面
	@RequestMapping(value="/brand/toAdd.do")
	public String toAdd() {
		return "brand/add";
	}
	
	//添加品牌
	@RequestMapping(value="/brand/add.do")
	public String addBrand(Brand brand) {
		//添加开始
		brandService.addBrand(brand);
		return "redirect:/brand/list.do";
	}
	
	//删除一个品牌
	@RequestMapping(value="brand/delete.do")
	public String deleteBrand(Integer id,String name,Integer isDisplay,Model model) {
		brandService.deleteBrand(id);
		if(StringUtils.isNotBlank(name)){
			model.addAttribute("name", name);
		}
		model.addAttribute("isDisplay", isDisplay);
		return "redirect:/brand/list.do";
	}
	
	//批量删除品牌
	@RequestMapping(value="/brand/deletes.do")
	public String deleteBrand(Integer[] ids,String name,Integer isDisplay,Model model) {
		brandService.deleteBrands(ids);
		if(StringUtils.isNotBlank(name)){
			model.addAttribute("name", name);
		}
		model.addAttribute("isDisplay", isDisplay);
		return "redirect:/brand/list.do";
	}
	
	//跳转修改页面
	@RequestMapping(value="/brand/toEdit.do")
	public String toEdit(Integer id,Model model) {
		Brand brand=brandService.getBrandById(id);
		model.addAttribute("brand", brand);
		return "brand/edit";
	}
	
	//修改品牌
	@RequestMapping(value="/brand/edit.do")
	public String editBrand(Brand brand,Model model) {
		brandService.updateBrand(brand);
		return "redirect:/brand/list.do";
	}
	
}
