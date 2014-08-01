package com.examw.shiro.freemarker;
/**
 * 检查是否有权限。
 * @author yangyong.
 * @since 2014-05-15.
 */
public class HasPermissionTag extends PermissionTag {
	/*
	 * 当前用户是否有权限。
	 * @see com.examw.shiro.freemarker.PermissionTag#showTagBody(java.lang.String)
	 */
	@Override
	protected boolean showTagBody(String p) {
		return this.isPermitted(p);
	}

}