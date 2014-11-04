package com.examw.service;
/**
 * 性别枚举。
 * 
 * @author yangyong
 * @since 2014年11月3日
 */
public enum Gender {
	/**
	 * 未知。
	 */
	NONE(0),
	/**
	 * 男性。
	 */
	MALE(1),
	/**
	 * 女性。
	 */
	FEMALE(2);
	private int value;
	/**
	 * 构造函数。
	 * @param value
	 * 性别值。
	 */
	private Gender(int value){
		this.value = value;
	}
	/**
	 * 获取性别值。
	 * @return 性别值。
	 */
	public int getValue() {
		return value;
	}
	/**
	 * 性别枚举转换。
	 * @param value
	 * 性别值。
	 * @return
	 * 枚举对象。
	 */
	public static Gender conversion(Integer value){
		if(value == null) throw new RuntimeException(" 性别值为空！");
		for(Gender gender : Gender.values()){
			if(gender.getValue() == value) return gender;
		}
		throw new RuntimeException(String.format("性别值［%d］未定义!", value));
	}
}