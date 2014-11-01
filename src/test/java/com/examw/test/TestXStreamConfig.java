package com.examw.test;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;

import com.examw.configuration.ModuleParse;
import com.examw.configuration.ModuleSystemCollection;

/**
 * 测试配置的序列化与反序列化；
 * 
 * @author yangyong
 * @since 2014年11月1日
 */
public class TestXStreamConfig {
	@Test
	public void deserializer() throws Exception{
		File file = new File("/users/workspace/examw-netplatform/src/main/resources/mgr_menus.xml");
		System.out.println(file.getAbsolutePath());
		System.out.println("文件是否存在：" + file.exists());
		if(file.exists()){ 
			ModuleSystemCollection collection = ModuleParse.parse(new FileInputStream(file));
			if(collection == null){
				System.out.println("反序列化失败！");
				return;
			}
			System.out.println(collection);
		}
	}
}