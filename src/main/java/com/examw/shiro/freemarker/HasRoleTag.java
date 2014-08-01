package com.examw.shiro.freemarker;

import org.apache.shiro.subject.Subject;

/**
 * 用户是否有角色。
 * @author yangyong.
 * @since 2014-05-16.
 */
public class HasRoleTag extends RoleTag {
	/*
	 * 当前用户是否有角色。
	 * @see com.examw.shiro.freemarker.RoleTag#showTagBody(java.lang.String)
	 */
	@Override
	protected boolean showTagBody(String role) {
		Subject subject = this.getSubject();
		if(subject != null){
			return subject.hasRole(role);
		}
		return false;
	}
}