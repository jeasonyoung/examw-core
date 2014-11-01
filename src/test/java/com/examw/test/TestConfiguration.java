package com.examw.test;

import org.junit.Test;

import com.examw.configuration.IPowerSystem;
import com.examw.configuration.ModuleDefine;
import com.examw.configuration.ModuleSystem;
import com.thoughtworks.xstream.XStream;

public class TestConfiguration {
	@Test
	public void test(){
		IPowerSystem ipower = new IPowerSystem("1.0");
		ModuleSystem ms = new ModuleSystem();
		ms.setId("NPM000000");
		ms.setSign("ipower.wechat");
		ms.setName("网校平台后台管理系统");
		ms.setDescription("网校平台后台管理系统");
		ModuleDefine m = new ModuleDefine();
		m.setId("NPM000001");
		m.setIcon("icon");
		m.setName("系统管理");
		m.setUri("/admin/security/menu");
		m.setOrder(1);
		m.addChild(new ModuleDefine("NPM000002","icon2","系统管理2","/admin/security/menu2",11));
		ms.add(m);
		ipower.add(ms);
		XStream stream = new XStream();
		stream.autodetectAnnotations(true);
		System.out.println(stream.toXML(ipower));
	}
}