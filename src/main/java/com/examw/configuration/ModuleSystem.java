package com.examw.configuration;

import java.io.Serializable;
/**
 * 模块系统信息。
 * @author young.
 * @since 2013-09-18.
 * */
public class ModuleSystem implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id,sign,name,description;
	private ModuleDefineCollection modules;
	/**
	 * 构造函数。
	 * */
	public ModuleSystem(){
		this.setModules(new ModuleDefineCollection());
	}
	/**
	 * 获取系统ID。
	 * @return 系统ID。
	 * */
	public String getId() {
		return id;
	}
	/**
	 * 设置系统ID。
	 * @param id
	 * 	系统ID。
	 * */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取系统标示。
	 * @return 系统标示。
	 * */
	public String getSign() {
		return sign;
	}
	/**
	 * 设置系统标示。
	 * @param sign
	 * 	系统标示。
	 * */
	public void setSign(String sign) {
		this.sign = sign;
	}
	/**
	 * 获取系统名称。
	 * @return 系统名称。
	 * */
	public String getName() {
		return name;
	}
	/**
	 * 设置系统名称。
	 * @param name
	 * 	系统名称。
	 * */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取系统描述。
	 * @return 系统描述。
	 * */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置系统描述。
	 * @param description
	 * 	系统描述。
	 * */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取模块集合。
	 * @return 系统集合。
	 * */
	public ModuleDefineCollection getModules() {
		return modules;
	}
	/**
	 * 设置模块集合。
	 * @param 模块集合。
	 * */
	public void setModules(ModuleDefineCollection modules) {
		this.modules = modules;
	}
}