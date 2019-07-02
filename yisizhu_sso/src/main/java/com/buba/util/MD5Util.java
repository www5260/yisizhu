package com.buba.util;

import java.security.MessageDigest;
import java.util.UUID;

public class MD5Util  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 16λMD5
	 */
	public static String encodeByMd5(String plainText) {
		StringBuffer buf = new StringBuffer("");
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i = 0;
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buf.toString().substring(8,24); // ����32λMD5
	}
	
	/**
	 * 32λMD5
	 */
	public static String encodeByMd5_32(String plainText) {
		StringBuffer buf = new StringBuffer("");
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i = 0;
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buf.toString(); // 返回生成的32λMD5
	}
	
	/**
	 * 生成UUID
	 */
	public static String getUUID() {
		// 去除“-”的UUID
		String uuid =(String) UUID.randomUUID().toString().replaceAll("-", "");
		return uuid;
	}
	
	
}
