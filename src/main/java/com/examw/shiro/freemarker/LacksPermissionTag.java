package com.examw.shiro.freemarker;
/**
 * 权限反选。
 * @author yangyong.
 * @since 2014-05-16.
 */
public class LacksPermissionTag extends PermissionTag {
	/*
	 * (non-Javadoc)
	 * @see com.examw.shiro.freemarker.PermissionTag#showTagBody(java.lang.String)
	 */
	@Override
	protected boolean showTagBody(String p) {
		return !this.isPermitted(p);
	}
}