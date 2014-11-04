package com.examw.service;
/**
 * 状态枚举。
 * 
 * @author yangyong
 * @since 2014年11月3日
 */
public enum Status {
	/**
	 * 启用。
	 */
	ENABLED(1),
	/**
	 * 停用。
	 */
	DISABLE(0);
	private int value;
	/**
	 * 构造函数。
	 * @param value
	 * 性别值。
	 */
	private Status(int value){
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
	public static Status conversion(Integer value){
		if(value == null) throw new RuntimeException(" 状态值为空！");
		for(Status status : Status.values()){
			if(status.getValue() == value) return status;
		}
		throw new RuntimeException(String.format("状态值［%d］未定义!", value));
	}
}