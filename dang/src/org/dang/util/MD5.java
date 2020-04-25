package org.dang.util;

import java.security.MessageDigest;
import java.sql.Date;

import sun.misc.BASE64Encoder;


public class MD5 {
	public static String md5(String str) {
		try {
		    MessageDigest md = MessageDigest.getInstance("MD5");
		    byte[] b1 = md.digest(str.getBytes());
		    BASE64Encoder encoder = new BASE64Encoder();
		    return encoder.encode(b1);
		} catch(Exception e) {
			return null;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(md5("abc"));
		long s=System.currentTimeMillis();
		Date lasttime=new Date(s);
		System.out.println(lasttime);
	}
}
