package com.ll.core.controller.admin;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ll.common.web.Constants;
import com.ll.common.web.ResponseUtils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import net.fckeditor.response.UploadResponse;

/**
 * 上传图片	商品  品牌  商品介绍fck
 */
@Controller
public class UploadController {
	
	//上传图片
	@RequestMapping(value="/upload/uploadPic.do")
	public void uploadPic(@RequestParam(required=false) MultipartFile pic,HttpServletResponse response){
		//获取扩展名
		String ext=FilenameUtils.getExtension(pic.getOriginalFilename());
		//图片名称生成策略	毫秒级
		DateFormat df=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		//图片名称一部分
		String format=df.format(new Date());
		//随机三位数
		Random random=new Random();
		for(int i=0 ; i<3 ;i++){
			format += random.nextInt(10);
		}
		//实例化一个jersey
		Client client=new Client();
		//保存数据库
		String path="upload/"+format+"."+ext;
		//另一台服务器的请求路径
		String url=Constants.IMG_URL+path;
		//设置请求路径
		WebResource resource=client.resource(url);
		//发送请求
		try {
			resource.put(String.class, pic.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//返回两个路径
		JSONObject jo=new JSONObject();
		jo.put("url", url);
		jo.put("path", path);
		ResponseUtils.sendJson(response, jo.toString());
	}
	
	//上次Fck图片
	@RequestMapping(value="/upload/uploadFck.do")
	public void uploadFck(HttpServletRequest request,HttpServletResponse response) {
		//强转request		支持多个
		MultipartHttpServletRequest mh=(MultipartHttpServletRequest) request;
		//获取值	支持多个
		Map<String, MultipartFile> fileMap=mh.getFileMap();
		//遍历map
		Set<Entry<String, MultipartFile>> entrySet=fileMap.entrySet();
		for (Entry<String, MultipartFile> entry : entrySet) {
			//上传上来的图片
			MultipartFile pic=entry.getValue();
			//获取扩展名
			String ext=FilenameUtils.getExtension(pic.getOriginalFilename());
			//图片名称生成策略	毫秒级
			DateFormat df=new SimpleDateFormat("yyyyMMddHHmmssSSS");
			//图片名称一部分
			String format=df.format(new Date());
			//随机三位数
			Random random=new Random();
			for(int i=0 ; i<3 ;i++){
				format += random.nextInt(10);
			}
			//实例化一个jersey
			Client client=new Client();
			//保存数据库
			String path="upload/"+format+"."+ext;
			//另一台服务器的请求路径
			String url=Constants.IMG_URL+path;
			//设置请求路径
			WebResource resource=client.resource(url);
			//发送请求
			try {
				resource.put(String.class, pic.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			//返回url给Fck
			UploadResponse ok=UploadResponse.getOK(url);
			//response返回对象
			//write 字符流
			//print 字节流
			try {
				response.getWriter().print(ok);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	
}
