package com.ll.core.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ll.common.encode.Md5Pwd;
import com.ll.common.web.Constants;
import com.ll.common.web.ResponseUtils;
import com.ll.common.web.session.SessionProvider;
import com.ll.core.bean.country.City;
import com.ll.core.bean.country.Province;
import com.ll.core.bean.country.Town;
import com.ll.core.bean.user.Buyer;
import com.ll.core.query.country.CityQuery;
import com.ll.core.query.country.TownQuery;
import com.ll.core.service.country.CityService;
import com.ll.core.service.country.ProvinceService;
import com.ll.core.service.country.TownService;
import com.ll.core.service.user.BuyerService;
import com.octo.captcha.service.image.ImageCaptchaService;

/**
 * 跳转登录页面
 * 登录
 * 个人资料
 * 收货地址
 */
@Controller
public class ProfileController {
	@Autowired
	private SessionProvider sessionProvider;
	@Autowired
	private Md5Pwd md5Pwd;
	@Autowired
	private BuyerService buyerService;
	@Autowired
	private ImageCaptchaService imageCaptchaService;
	@Autowired
	private ProvinceService provinceService;
	@Autowired
	private CityService cityService;
	@Autowired
	private TownService townService;
	
	//跳转登录页
	@RequestMapping(value="/shop/login.shtml",method=RequestMethod.GET)
	public String toLogin() {
		return "/buyer/login";
	}
	
	//登录
	/**
	 * 1.验证验证码是否为null
	 * 2.验证验证码是否正确
	 * 3.验证用户名是否为null
	 * 4.验证密码是否为null
	 * 5.验证用户名是否正确
	 * 6.验证密码是否正确
	 */
	@RequestMapping(value="/shop/login.shtml",method=RequestMethod.POST)
	public String doLogin(Buyer buyer,String returnUrl,String captcha,Model model,
				HttpServletRequest request,HttpServletResponse response) {
		//1.验证验证码是否为null
		if(StringUtils.isNotBlank(captcha)){
			//JSESSIONID 验证码
			//2.验证验证码是否正确
			if(imageCaptchaService.validateResponseForID(sessionProvider.getSessionId(request,response), captcha)){
				//3.验证用户名是否为null
				if(buyer !=null && StringUtils.isNotBlank(buyer.getUsername())){
					//验证密码是否为null
					if(StringUtils.isNotBlank(buyer.getPassword())){
						Buyer b=buyerService.getBuyerByName(buyer.getUsername());
						//5.验证用户名是否正确
						if(b!=null){
							//6.验证密码是否正确
							if(md5Pwd.encode(b.getPassword()).equals(md5Pwd.encode(buyer.getPassword()))){
								//把用户对象放进Session
								sessionProvider.setAttribute(request, response, Constants.BUY_SESSION, b);
								System.out.println("返回路径2:"+request.getParameter("returnUrl"));
								if(StringUtils.isNotBlank(returnUrl)){
									return "redirect:" + returnUrl;
								}else {
									//个人中心
									return "redirect:/buyer/index.shtml";
								}
							}else{
								model.addAttribute("error", "密码错误");
							}
						}else{
							model.addAttribute("error", "用户名输入错误");
						}
					}else{
						model.addAttribute("error", "请输入密码");
					}
				}else{
					model.addAttribute("error", "请输入用户名");
				}
			}else{
				model.addAttribute("error", "验证码输入错误");
			}
		}else{
			model.addAttribute("error", "请填写验证码");
		}
		return "/buyer/login";
	}
	
	//个人中心
	@RequestMapping(value="/buyer/index.shtml")
	public String index() {
		return "/buyer/index";
	}
	
	//个人资料
	@RequestMapping(value="/buyer/profile.shtml")
	public String profile(HttpServletRequest request,HttpServletResponse response,Model model){
		//加载用户
		Buyer buyer=(Buyer) sessionProvider.getAttribute(request,response, Constants.BUY_SESSION);
		model.addAttribute("buyer", buyer);
		//省市县级联查询
		List<Province> provinces=provinceService.getProvinceList(null);
		model.addAttribute("provinces", provinces);
		//市
		CityQuery cityQuery=new CityQuery();
		cityQuery.setProvince(buyer.getProvince());
		List<City> cities=cityService.getCityList(cityQuery);
		model.addAttribute("cities", cities);
		//县
		TownQuery townQuery=new TownQuery();
		townQuery.setCity(buyer.getCity());
		List<Town> towns=townService.getTownList(townQuery);
		model.addAttribute("towns", towns);
		return "buyer/profile";
	}
	
	//重新查询市
	@RequestMapping(value = "/buyer/city.shtml")
	public void city(String code,HttpServletResponse response){
		CityQuery cityQuery = new CityQuery();
		cityQuery.setProvince(code);
		List<City> citys = cityService.getCityList(cityQuery);
		JSONObject jo = new JSONObject();
		jo.put("citys", citys);
		ResponseUtils.sendJson(response, jo.toString());
		
	}
	
	//重新查询县
	@RequestMapping(value = "/buyer/town.shtml")
	public void town(String code,HttpServletResponse response){
		TownQuery townQuery = new TownQuery();
		townQuery.setCity(code);
		List<Town> towns = townService.getTownList(townQuery);
		JSONObject jo = new JSONObject();
		jo.put("towns", towns);
		ResponseUtils.sendJson(response, jo.toString());	
	}
	
	//收获地址
	@RequestMapping(value="/buyer/deliver_address.shtml")
	public String address(){
		
		return "buyer/deliver_address";
	}
	
	//跳转修改密码
	@RequestMapping(value="/buyer/change_password.shtml")
	public String password(){
		return "buyer/change_password";
	}
	
	//修改密码
	@RequestMapping(value="/buyer/change_password.shtml",method=RequestMethod.POST)
	public String changePassword(){
		return "buyer/change_password";
	}
	
}
