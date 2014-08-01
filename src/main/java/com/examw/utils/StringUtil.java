package com.examw.utils;

import org.springframework.util.StringUtils;

/**
 * 字符串工具类。
 * @author yangyong.
 * @since 2014-06-26.
 */
public final class StringUtil {
	/**
	 * 拼接字符串。
	 * @param arrays
	 * 字符串数据。
	 * @param split
	 * 分隔符。
	 * @return
	 */
	public static String join(String[] arrays, Character split){
		if(arrays == null || arrays.length == 0) return null;
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < arrays.length; i++){
			if(StringUtils.isEmpty(arrays[i])) continue;
			if(builder.length() > 0) builder.append(split);
			builder.append(arrays[i]);
		}
		return builder.toString();
	}
}