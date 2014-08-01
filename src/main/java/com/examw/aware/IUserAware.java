package com.examw.aware;
/**
 * 用户信息接口。
 * @author yangyong.
 * @since 2014-05-15.
 */
public interface IUserAware {
	/**
	 * 设置用户ID。
	 * @param userId
	 * 用户ID。
	 */
	void setUserId(String userId);
	/**
	 * 设置用户姓名。
	 * @param userName
	 * 用户姓名。
	 */
	void setUserName(String userName);
	/**
	 * 设置用户昵称。
	 * @param userNickName
	 * 用户昵称。
	 */
	void setUserNickName(String userNickName);
}