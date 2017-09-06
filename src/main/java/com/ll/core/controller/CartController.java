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
 * 购物车
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
		//声明购物车
		Cart cart=null;
		//判断cookie中是否有购物车
		Cookie[] cookies=request.getCookies();
		if(cookies!=null && cookies.length>0){
			for (Cookie c : cookies) {
				if(Constants.CART_COOKIE.equals(c.getName())){
					//如果有，则使用此购物车
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
		//如果没有 创建购物车
		if(cart==null){
			cart=new Cart();
		}
		//SKU
		if(skuId!=null){
			Sku sku=new Sku();
			sku.setId(skuId);
			//购买限制
			if(buyLimit!=null){
				sku.setSkuUpperLimit(buyLimit);
			}
			//创建购物项
			BuyItem buyItem=new BuyItem();
			buyItem.setSku(sku);
			//数量
			buyItem.setNumber(number);
			//添加购物项
			cart.addItem(buyItem);
			System.out.println(cart);
			//最后一个商品的id
			if(productId!=null){
				cart.setProductId(productId);
			}
			//流
			StringWriter sw=new StringWriter();
			//对象转JSON 写的过程 JSON是字符串流
			try {
				om.writeValue(sw, cart);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//购物车放进cookie，对象转JSON
			Cookie cookie=new Cookie(Constants.CART_COOKIE, sw.toString());
			//关闭浏览器也要有cookie	默认：-1 表示关闭浏览器没有 	销毁：0 马上就没有
			cookie.setMaxAge(24*60*60);//一天
			//路径	默认/shop
			cookie.setPath("/");
			//发送
			response.addCookie(cookie);	
		}
		//装购物车
		List<BuyItem> items=cart.getItems();
		for (BuyItem item : items) {
			Sku s=skuService.getSkuById(item.getSku().getId());
			item.setSku(s);
		}
		model.addAttribute("cart", cart);
		return "/product/cart";
	}
	
	//清空购物车
	@RequestMapping(value="shop/clearCart.shtml")
	public String clearCart(HttpServletRequest request,HttpServletResponse response) {
		Cookie cookie=new Cookie(Constants.CART_COOKIE, null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		return "redirect:/shop/cart.shtml";
	}
	
	//从购物车中删除一款商品
	@RequestMapping(value="shop/delItem.shtml")
	public String delItem(HttpServletRequest request,HttpServletResponse response,Integer skuId,Model model) {
		ObjectMapper om = new ObjectMapper();
		om.setSerializationInclusion(null);
		//声明购物车
		Cart cart=null;
		//判断cookie中是否有购物车
		Cookie[] cookies=request.getCookies();
		if(cookies!=null && cookies.length>0){
			for (Cookie c : cookies) {
				if(Constants.CART_COOKIE.equals(c.getName())){
					//如果有，则使用此购物车
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
			//创建购物项
			BuyItem buyItem=new BuyItem();
			buyItem.setSku(sku);
			cart.delItem(buyItem);
			//流
			StringWriter sw=new StringWriter();
			//对象转JSON 写的过程 JSON是字符串流
			try {
				om.writeValue(sw, cart);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//购物车放进cookie，对象转JSON
			Cookie cookie=new Cookie(Constants.CART_COOKIE, sw.toString());
			//关闭浏览器也要有cookie	默认：-1 表示关闭浏览器没有 	销毁：0 马上就没有
			cookie.setMaxAge(24*60*60);//一天
			//路径	默认/shop
			cookie.setPath("/");
			//发送
			response.addCookie(cookie);
		}	
		return "redirect:/shop/cart.shtml";
	}
	
	//结算
	@RequestMapping(value="/buyer/trueBuy.shtml")
	public String trueBuy(HttpServletRequest request,HttpServletResponse response,Model model){
		//springmvc 
		ObjectMapper  om = new ObjectMapper();
		om.setSerializationInclusion(Include.NON_NULL);
		//声明购物车
		Cart cart=null;
		//判断cookie中是否有购物车
		Cookie[] cookies=request.getCookies();
		if(cookies!=null && cookies.length>0){
			for (Cookie c : cookies) {
				if(Constants.CART_COOKIE.equals(c.getName())){
					//如果有，则使用此购物车
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
		//如果购物车为空   刷新购物车页面
		if(cart!=null){
			List<BuyItem> items=cart.getItems();
			if(items!=null && items.size()>0){
				Integer i=items.size();
				//判断购物车中的商品是否有库存
				for (BuyItem it : items) {
					Sku sku=skuService.getSkuById(it.getSku().getId());
					//判断库存
					if(sku.getStockInventory()<it.getNumber()){
						//删除此商品
						cart.delItem(it);
					}
					//清理后商品项个数
					Integer j=items.size();
					//判断清理前后商品项个数
					if(i>j){
						//改变了   修改购物车中的数据	
						//流
						StringWriter sw=new StringWriter();
						//对象转JSON 写的过程 JSON是字符串流
						try {
							om.writeValue(sw, cart);
						} catch (Exception e) {
							e.printStackTrace();
						}
						//购物车放进cookie，对象转JSON
						Cookie cookie=new Cookie(Constants.CART_COOKIE, sw.toString());
						//关闭浏览器也要有cookie	默认：-1 表示关闭浏览器没有 	销毁：0 马上就没有
						cookie.setMaxAge(24*60*60);//一天
						//路径	默认/shop
						cookie.setPath("/");
						//发送
						response.addCookie(cookie);	
						return "redirect:/shop/cart.shtml";
					}else {
						//如果没改变  
						//加载收货地址
						Buyer buyer=(Buyer) sessionProvider.getAttribute(request,response,Constants.BUY_SESSION);
						AddrQuery addrQuery=new AddrQuery();
						//默认1，未删除
						addrQuery.setIsDef(1);
						addrQuery.setBuyerId(buyer.getUsername());
						List<Addr> addrs=addrService.getAddrList(addrQuery);
						model.addAttribute("addr", addrs.get(0));
						//装购物车
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
				//购物车无商品项
				return "redirect:/shop/cart.shtml";
			}
		}else{
			//购物车为空
			return "redirect:/shop/cart.shtml";
		}
		return "";
	}
	
}
