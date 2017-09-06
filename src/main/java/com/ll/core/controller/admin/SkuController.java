package com.ll.core.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ll.core.bean.product.Sku;
import com.ll.core.query.product.SkuQuery;
import com.ll.core.service.product.SkuService;

/**
 * ������
 */
@Controller
public class SkuController {
	@Autowired
	private SkuService skuService;
	
	//����б�
	@RequestMapping(value="/sku/list.do")
	public String list(Integer productId,String productNo,Model model) {
		//��Ʒ��Ż���
		model.addAttribute("productNo", productNo);
		//��С���۵�Ԫ
		SkuQuery skuQuery=new SkuQuery();
		skuQuery.setProductId(productId);
		List<Sku> skus=skuService.getSkuList(skuQuery);
		model.addAttribute("skus", skus);
		return "sku/list";
	}
	
	//����sku������
	@RequestMapping(value="/sku/update.do")
	@ResponseBody
	public void save(Sku sku,Model model) {
		skuService.updateSku(sku);
	}
	
}
