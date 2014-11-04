package com.examw.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.util.DigestUtils;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

/**
 * MD5工具类.
 * @author 杨勇.
 * @since 2013-11-29.
 * */
public final class MD5Util {
	/**
	 * 将字符串md5加密. 
	 * @param source
	 * 	字符串。
	 * @return 密文.
	 * */
	public final static String MD5(String source){
		 if(StringUtils.isEmpty(source)) return null;
		 return DigestUtils.md5DigestAsHex(source.getBytes(Charset.forName(AESUtil.charsetName)));
	}
	/**
	 * 对输入流进行md5加密。
	 * @param stream
	 * 	输入流。
	 * @return 密文。
	 * */
	public final static String MD5(InputStream stream){
		if(stream == null) return null;
		try {
			return DigestUtils.md5DigestAsHex(StreamUtils.copyToByteArray(stream));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}