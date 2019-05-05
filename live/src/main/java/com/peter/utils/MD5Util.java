package com.peter.utils;

import org.springframework.util.DigestUtils;

public class MD5Util {

	private MD5Util() {
	}
	public static String getMD5(String passwd,String name) {
		String base=name+"/"+passwd;
		return DigestUtils.md5DigestAsHex(base.getBytes());
	}
}
