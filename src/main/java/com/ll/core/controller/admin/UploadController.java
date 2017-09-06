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
 * �ϴ�ͼƬ	��Ʒ  Ʒ��  ��Ʒ����fck
 */
@Controller
public class UploadController {
	
	//�ϴ�ͼƬ
	@RequestMapping(value="/upload/uploadPic.do")
	public void uploadPic(@RequestParam(required=false) MultipartFile pic,HttpServletResponse response){
		//��ȡ��չ��
		String ext=FilenameUtils.getExtension(pic.getOriginalFilename());
		//ͼƬ�������ɲ���	���뼶
		DateFormat df=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		//ͼƬ����һ����
		String format=df.format(new Date());
		//�����λ��
		Random random=new Random();
		for(int i=0 ; i<3 ;i++){
			format += random.nextInt(10);
		}
		//ʵ����һ��jersey
		Client client=new Client();
		//�������ݿ�
		String path="upload/"+format+"."+ext;
		//��һ̨������������·��
		String url=Constants.IMG_URL+path;
		//��������·��
		WebResource resource=client.resource(url);
		//��������
		try {
			resource.put(String.class, pic.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//��������·��
		JSONObject jo=new JSONObject();
		jo.put("url", url);
		jo.put("path", path);
		ResponseUtils.sendJson(response, jo.toString());
	}
	
	//�ϴ�FckͼƬ
	@RequestMapping(value="/upload/uploadFck.do")
	public void uploadFck(HttpServletRequest request,HttpServletResponse response) {
		//ǿתrequest		֧�ֶ��
		MultipartHttpServletRequest mh=(MultipartHttpServletRequest) request;
		//��ȡֵ	֧�ֶ��
		Map<String, MultipartFile> fileMap=mh.getFileMap();
		//����map
		Set<Entry<String, MultipartFile>> entrySet=fileMap.entrySet();
		for (Entry<String, MultipartFile> entry : entrySet) {
			//�ϴ�������ͼƬ
			MultipartFile pic=entry.getValue();
			//��ȡ��չ��
			String ext=FilenameUtils.getExtension(pic.getOriginalFilename());
			//ͼƬ�������ɲ���	���뼶
			DateFormat df=new SimpleDateFormat("yyyyMMddHHmmssSSS");
			//ͼƬ����һ����
			String format=df.format(new Date());
			//�����λ��
			Random random=new Random();
			for(int i=0 ; i<3 ;i++){
				format += random.nextInt(10);
			}
			//ʵ����һ��jersey
			Client client=new Client();
			//�������ݿ�
			String path="upload/"+format+"."+ext;
			//��һ̨������������·��
			String url=Constants.IMG_URL+path;
			//��������·��
			WebResource resource=client.resource(url);
			//��������
			try {
				resource.put(String.class, pic.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			//����url��Fck
			UploadResponse ok=UploadResponse.getOK(url);
			//response���ض���
			//write �ַ���
			//print �ֽ���
			try {
				response.getWriter().print(ok);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	
}
