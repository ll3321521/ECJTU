package com.ll.core.controller;

import java.io.StringWriter;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.common.web.Constants;
import com.ll.common.web.session.SessionProvider;
import com.ll.core.bean.BuyItem;
import com.ll.core.bean.Cart;
import com.ll.core.bean.product.Sku;
import com.ll.core.bean.user.Addr;
import com.ll.core.bean.user.Buyer;
import com.ll.core.query.user.AddrQuery;
import com.ll.core.service.product.SkuService;
import com.ll.core.service.user.AddrService;

/**
 * ���ﳵ
 */
@Controller
public class CartController {
	@Autowired
	private SkuService skuService;
	@Autowired
	private AddrService addrService;
	@Autowired
	private SessionProvider sessionProvider;
	
	@RequestMapping(value="/shop/cart.shtml")
	public String cart(Integer skuId,Integer number,Integer buyLimit,
				Integer productId,HttpServletRequest request,HttpServletResponse response,Model model) {
		//springmvc 
		ObjectMapper  om = new ObjectMapper();
		om.setSerializationInclusion(Include.NON_NULL);
		//�������ﳵ
		Cart cart=null;
		//�ж�cookie���Ƿ��й��ﳵ
		Cookie[] cookies=request.getCookies();
		if(cookies!=null && cookies.length>0){
			for (Cookie c : cookies) {
				if(Constants.CART_COOKIE.equals(c.getName())){
					//����У���ʹ�ô˹��ﳵ
					String value=c.getValue();
					try {
						cart=om.readValue(value, Cart.class);
					} catch (Exception e) {
						e.printStackTrace();
					} 
					break;
				}
			}
		}
		//���û�� �������ﳵ
		if(cart==null){
			cart=new Cart();
		}
		//SKU
		if(skuId!=null){
			Sku sku=new Sku();
			sku.setId(skuId);
			//��������
			if(buyLimit!=null){
				sku.setSkuUpperLimit(buyLimit);
			}
			//����������
			BuyItem buyItem=new BuyItem();
			buyItem.setSku(sku);
			//����
			buyItem.setNumber(number);
			//��ӹ�����
			cart.addItem(buyItem);
			System.out.println(cart);
			//���һ����Ʒ��id
			if(productId!=null){
				cart.setProductId(productId);
			}
			//��
			StringWriter sw=new StringWriter();
			//����תJSON д�Ĺ��� JSON���ַ�����
			try {
				om.writeValue(sw, cart);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//���ﳵ�Ž�cookie������תJSON
			Cookie cookie=new Cookie(Constants.CART_COOKIE, sw.toString());
			//�ر������ҲҪ��cookie	Ĭ�ϣ�-1 ��ʾ�ر������û�� 	���٣�0 ���Ͼ�û��
			cookie.setMaxAge(24*60*60);//һ��
			//·��	Ĭ��/shop
			cookie.setPath("/");
			//����
			response.addCookie(cookie);	
		}
		//װ���ﳵ
		List<BuyItem> items=cart.getItems();
		for (BuyItem item : items) {
			Sku s=skuService.getSkuById(item.getSku().getId());
			item.setSku(s);
		}
		model.addAttribute("cart", cart);
		return "/product/cart";
	}
	
	//��չ��ﳵ
	@RequestMapping(value="shop/clearCart.shtml")
	public String clearCart(HttpServletRequest request,HttpServletResponse response) {
		Cookie cookie=new Cookie(Constants.CART_COOKIE, null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		return "redirect:/shop/cart.shtml";
	}
	
	//�ӹ��ﳵ��ɾ��һ����Ʒ
	@RequestMapping(value="shop/delItem.shtml")
	public String delItem(HttpServletRequest request,HttpServletResponse response,Integer skuId,Model model) {
		ObjectMapper om = new ObjectMapper();
		om.setSerializationInclusion(null);
		//�������ﳵ
		Cart cart=null;
		//�ж�cookie���Ƿ��й��ﳵ
		Cookie[] cookies=request.getCookies();
		if(cookies!=null && cookies.length>0){
			for (Cookie c : cookies) {
				if(Constants.CART_COOKIE.equals(c.getName())){
					//����У���ʹ�ô˹��ﳵ
					String value=c.getValue();
					try {
						cart=om.readValue(value, Cart.class);
					} catch (Exception e) {
						e.printStackTrace();
					} 
					break;
				}
			}
		}
		if(cart!=null){
			Sku sku=new Sku();
			sku.setId(skuId);
			//����������
			BuyItem buyItem=new BuyItem();
			buyItem.setSku(sku);
			cart.delItem(buyItem);
			//��
			StringWriter sw=new StringWriter();
			//����תJSON д�Ĺ��� JSON���ַ�����
			try {
				om.writeValue(sw, cart);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//���ﳵ�Ž�cookie������תJSON
			Cookie cookie=new Cookie(Constants.CART_COOKIE, sw.toString());
			//�ر������ҲҪ��cookie	Ĭ�ϣ�-1 ��ʾ�ر������û�� 	���٣�0 ���Ͼ�û��
			cookie.setMaxAge(24*60*60);//һ��
			//·��	Ĭ��/shop
			cookie.setPath("/");
			//����
			response.addCookie(cookie);
		}	
		return "redirect:/shop/cart.shtml";
	}
	
	//����
	@RequestMapping(value="/buyer/trueBuy.shtml")
	public String trueBuy(HttpServletRequest request,HttpServletResponse response,Model model){
		//springmvc 
		ObjectMapper  om = new ObjectMapper();
		om.setSerializationInclusion(Include.NON_NULL);
		//�������ﳵ
		Cart cart=null;
		//�ж�cookie���Ƿ��й��ﳵ
		Cookie[] cookies=request.getCookies();
		if(cookies!=null && cookies.length>0){
			for (Cookie c : cookies) {
				if(Constants.CART_COOKIE.equals(c.getName())){
					//����У���ʹ�ô˹��ﳵ
					String value=c.getValue();
					try {
						cart=om.readValue(value, Cart.class);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
		//������ﳵΪ��   ˢ�¹��ﳵҳ��
		if(cart!=null){
			List<BuyItem> items=cart.getItems();
			if(items!=null && items.size()>0){
				Integer i=items.size();
				//�жϹ��ﳵ�е���Ʒ�Ƿ��п��
				for (BuyItem it : items) {
					Sku sku=skuService.getSkuById(it.getSku().getId());
					//�жϿ��
					if(sku.getStockInventory()<it.getNumber()){
						//ɾ������Ʒ
						cart.delItem(it);
					}
					//�������Ʒ�����
					Integer j=items.size();
					//�ж�����ǰ����Ʒ�����
					if(i>j){
						//�ı���   �޸Ĺ��ﳵ�е�����	
						//��
						StringWriter sw=new StringWriter();
						//����תJSON д�Ĺ��� JSON���ַ�����
						try {
							om.writeValue(sw, cart);
						} catch (Exception e) {
							e.printStackTrace();
						}
						//���ﳵ�Ž�cookie������תJSON
						Cookie cookie=new Cookie(Constants.CART_COOKIE, sw.toString());
						//�ر������ҲҪ��cookie	Ĭ�ϣ�-1 ��ʾ�ر������û�� 	���٣�0 ���Ͼ�û��
						cookie.setMaxAge(24*60*60);//һ��
						//·��	Ĭ��/shop
						cookie.setPath("/");
						//����
						response.addCookie(cookie);	
						return "redirect:/shop/cart.shtml";
					}else {
						//���û�ı�  
						//�����ջ���ַ
						Buyer buyer=(Buyer) sessionProvider.getAttribute(request,response,Constants.BUY_SESSION);
						AddrQuery addrQuery=new AddrQuery();
						//Ĭ��1��δɾ��
						addrQuery.setIsDef(1);
						addrQuery.setBuyerId(buyer.getUsername());
						List<Addr> addrs=addrService.getAddrList(addrQuery);
						model.addAttribute("addr", addrs.get(0));
						//װ���ﳵ
						List<BuyItem> buyItems=cart.getItems();
						for (BuyItem item : buyItems) {
							Sku s=skuService.getSkuById(item.getSku().getId());
							item.setSku(s);
						}
						model.addAttribute("cart", cart);
						return "product/productOrder";
					}
				}
			}else {
				//���ﳵ����Ʒ��
				return "redirect:/shop/cart.shtml";
			}
		}else{
			//���ﳵΪ��
			return "redirect:/shop/cart.shtml";
		}
		return "";
	}
	
}
