package com.ll.common.encode;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class Md5PwdImpl implements Md5Pwd{
	
	//����
	public String encode(String password) {
		String algorithm="MD5";
		MessageDigest md=null;
		try {
			md=MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] digest=md.digest(password.getBytes());
		//ʮ�����Ƽ���
		char[] encodeHex=Hex.encodeHex(digest);
		return new String(encodeHex);
	}
	
}
