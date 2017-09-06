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
 * ��ת��¼ҳ��
 * ��¼
 * ��������
 * �ջ���ַ
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
	
	//��ת��¼ҳ
	@RequestMapping(value="/shop/login.shtml",method=RequestMethod.GET)
	public String toLogin() {
		return "/buyer/login";
	}
	
	//��¼
	/**
	 * 1.��֤��֤���Ƿ�Ϊnull
	 * 2.��֤��֤���Ƿ���ȷ
	 * 3.��֤�û����Ƿ�Ϊnull
	 * 4.��֤�����Ƿ�Ϊnull
	 * 5.��֤�û����Ƿ���ȷ
	 * 6.��֤�����Ƿ���ȷ
	 */
	@RequestMapping(value="/shop/login.shtml",method=RequestMethod.POST)
	public String doLogin(Buyer buyer,String returnUrl,String captcha,Model model,
				HttpServletRequest request,HttpServletResponse response) {
		//1.��֤��֤���Ƿ�Ϊnull
		if(StringUtils.isNotBlank(captcha)){
			//JSESSIONID ��֤��
			//2.��֤��֤���Ƿ���ȷ
			if(imageCaptchaService.validateResponseForID(sessionProvider.getSessionId(request,response), captcha)){
				//3.��֤�û����Ƿ�Ϊnull
				if(buyer !=null && StringUtils.isNotBlank(buyer.getUsername())){
					//��֤�����Ƿ�Ϊnull
					if(StringUtils.isNotBlank(buyer.getPassword())){
						Buyer b=buyerService.getBuyerByName(buyer.getUsername());
						//5.��֤�û����Ƿ���ȷ
						if(b!=null){
							//6.��֤�����Ƿ���ȷ
							if(md5Pwd.encode(b.getPassword()).equals(md5Pwd.encode(buyer.getPassword()))){
								//���û�����Ž�Session
								sessionProvider.setAttribute(request, response, Constants.BUY_SESSION, b);
								System.out.println("����·��2:"+request.getParameter("returnUrl"));
								if(StringUtils.isNotBlank(returnUrl)){
									return "redirect:" + returnUrl;
								}else {
									//��������
									return "redirect:/buyer/index.shtml";
								}
							}else{
								model.addAttribute("error", "�������");
							}
						}else{
							model.addAttribute("error", "�û����������");
						}
					}else{
						model.addAttribute("error", "����������");
					}
				}else{
					model.addAttribute("error", "�������û���");
				}
			}else{
				model.addAttribute("error", "��֤���������");
			}
		}else{
			model.addAttribute("error", "����д��֤��");
		}
		return "/buyer/login";
	}
	
	//��������
	@RequestMapping(value="/buyer/index.shtml")
	public String index() {
		return "/buyer/index";
	}
	
	//��������
	@RequestMapping(value="/buyer/profile.shtml")
	public String profile(HttpServletRequest request,HttpServletResponse response,Model model){
		//�����û�
		Buyer buyer=(Buyer) sessionProvider.getAttribute(request,response, Constants.BUY_SESSION);
		model.addAttribute("buyer", buyer);
		//ʡ���ؼ�����ѯ
		List<Province> provinces=provinceService.getProvinceList(null);
		model.addAttribute("provinces", provinces);
		//��
		CityQuery cityQuery=new CityQuery();
		cityQuery.setProvince(buyer.getProvince());
		List<City> cities=cityService.getCityList(cityQuery);
		model.addAttribute("cities", cities);
		//��
		TownQuery townQuery=new TownQuery();
		townQuery.setCity(buyer.getCity());
		List<Town> towns=townService.getTownList(townQuery);
		model.addAttribute("towns", towns);
		return "buyer/profile";
	}
	
	//���²�ѯ��
	@RequestMapping(value = "/buyer/city.shtml")
	public void city(String code,HttpServletResponse response){
		CityQuery cityQuery = new CityQuery();
		cityQuery.setProvince(code);
		List<City> citys = cityService.getCityList(cityQuery);
		JSONObject jo = new JSONObject();
		jo.put("citys", citys);
		ResponseUtils.sendJson(response, jo.toString());
		
	}
	
	//���²�ѯ��
	@RequestMapping(value = "/buyer/town.shtml")
	public void town(String code,HttpServletResponse response){
		TownQuery townQuery = new TownQuery();
		townQuery.setCity(code);
		List<Town> towns = townService.getTownList(townQuery);
		JSONObject jo = new JSONObject();
		jo.put("towns", towns);
		ResponseUtils.sendJson(response, jo.toString());	
	}
	
	//�ջ��ַ
	@RequestMapping(value="/buyer/deliver_address.shtml")
	public String address(){
		
		return "buyer/deliver_address";
	}
	
	//��ת�޸�����
	@RequestMapping(value="/buyer/change_password.shtml")
	public String password(){
		return "buyer/change_password";
	}
	
	//�޸�����
	@RequestMapping(value="/buyer/change_password.shtml",method=RequestMethod.POST)
	public String changePassword(){
		return "buyer/change_password";
	}
	
}
