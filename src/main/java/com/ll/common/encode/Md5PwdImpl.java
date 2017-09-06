package com.ll.common.encode;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class Md5PwdImpl implements Md5Pwd{
	
	//加密
	public String encode(String password) {
		String algorithm="MD5";
		MessageDigest md=null;
		try {
			md=MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] digest=md.digest(password.getBytes());
		//十六进制加密
		char[] encodeHex=Hex.encodeHex(digest);
		return new String(encodeHex);
	}
	
}
