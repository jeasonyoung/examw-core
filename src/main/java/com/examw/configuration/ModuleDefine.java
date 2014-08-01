package com.examw.configuration;

import java.io.Serializable;
/**
 * 模块系统信息。
 * @author young。
 * @since 2013-09-18。
 * */
public class ModuleDefine implements Serializable {
	private static final long serialVersionUID = 1L;	
	private String id,icon, name, uri;
	private Integer order = 0;
	private ModuleDefineCollection modules;
	/**
	 * 构造函数。
	 * */
	public ModuleDefine(){
		this.setModules(new ModuleDefineCollection());
	}
	/**
	 * 获取模块ID。
	 * @return 模块ID。
	 * */
	public String getId() {
		return id;
	}
	/**
	 * 设置模块ID。
	 * @param id
	 * 	模块ID。
	 * */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取图标。
	 * @return 图标。
	 * */
	public String getIcon() {
		return icon;
	}
	/**
	 *  设置图标
	 * @param icon
	 * 图标。
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * 获取模块名称。
	 * @return 模块名称。
	 * */
	public String getName() {
		return name;
	}
	/**
	 * 设置模块名称。
	 * @param name
	 * 	模块名称。
	 * */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取模块URI。
	 * @return 模块URI。
	 * */
	public String getUri() {
		return uri;
	}
	/**
	 * 设置模块URI。
	 * @param uri
	 * 	模块URI。
	 * */
	public void setUri(String uri) {
		this.uri = uri;
	}
	/**
	 * 获取排序号。
	 * @return 排序号。
	 * */
	public Integer getOrder() {
		return order;
	}
	/**
	 * 设置排序号。
	 * @param order
	 * 	排序号。
	 * */
	public void setOrderNo(Integer order) {
		this.order = order;
	}
	/**
	 * 获取子模块集合。
	 * @return 子模块集合。
	 * */
	public ModuleDefineCollection getModules() {
		return modules;
	}
	/**
	 * 设置子模块集合。
	 * @param modules
	 * 	子模块集合。
	 * */
	public void setModules(ModuleDefineCollection modules) {
		this.modules = modules;
	}
}