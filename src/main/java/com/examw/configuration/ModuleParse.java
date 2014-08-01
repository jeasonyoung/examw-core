package com.examw.configuration;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.examw.utils.XmlUtil;

/**
 * 模块数据解析类。
 * @author young。
 * @since 2013-09-18。
 * */
public final class ModuleParse {
	private static final String CONST_ROOT = "ipower";
	private static final String CONST_SYS_NODE = "system", 
											CONST_SYS_NODE_ID = "id",
											CONST_SYS_NODE_SIGN = "sign",
											CONST_SYS_NODE_NAME = "name",
											CONST_SYS_NODE_DESC = "description";
	private static final String CONST_MODULE_NODE = "module",
											  CONST_MODULE_NODE_ID = "id",
											  CONST_MODULE_NODE_ICON  = "icon",
											  CONST_MODULE_NODE_NAME = "name",
											  CONST_MODULE_NODE_URI = "uri",
											  CONST_MODULE_NODE_ORDER = "order";
	/*
	 * 将Xml文件流解析为模块系统对象集合。
	 * @param inputStream
	 * 	xml文件流。
	 * @return
	 * 	模块系统对象集合。
	 * */
	public static ModuleSystemCollection parse(InputStream inputStream) throws SAXException, IOException, ParserConfigurationException{
		Document doc = XmlUtil.loadDocument(inputStream);
		if(doc != null){
			Element root = doc.getDocumentElement();
			if(root != null && root.getNodeName().equalsIgnoreCase(CONST_ROOT) && root.hasChildNodes()){
				ModuleSystemCollection systems = new ModuleSystemCollection();
				NodeList nodes = root.getChildNodes();
				for(int i = 0; i < nodes.getLength();i++){
					Node n = nodes.item(i);
					if(n.getNodeType() == Node.ELEMENT_NODE && n.getNodeName().equalsIgnoreCase(CONST_SYS_NODE)){
						ModuleSystem ms = parseToModuleSystem((Element)n);
						if(ms != null){
							systems.add(ms);
						}
					}
				}
				return (systems.size() > 0 ? systems : null);
			}
		}
		return null;
	}
	
	private static synchronized String loadElementAttribute(Element e, String attrName){
		if(e == null || attrName == null || attrName.trim().isEmpty()) return null;
		if(!e.hasAttributes()) return null;
		if(e.hasAttribute(attrName))
			return e.getAttribute(attrName);
		return null;
	}
	
	private static ModuleSystem parseToModuleSystem(Element element){
		if(element == null || !element.hasAttributes()) return null;
		ModuleSystem ms = new ModuleSystem();
		ms.setId(loadElementAttribute(element, CONST_SYS_NODE_ID));
		if(ms.getId() == null || ms.getId().trim().isEmpty()) return null;
		ms.setSign(loadElementAttribute(element, CONST_SYS_NODE_SIGN)); 
		ms.setName(loadElementAttribute(element, CONST_SYS_NODE_NAME));
		if(ms.getName() == null || ms.getName().trim().isEmpty()) return null;
		ms.setDescription(loadElementAttribute(element, CONST_SYS_NODE_DESC));
		
		if(element.hasChildNodes()){
			NodeList nodes = element.getChildNodes();
			for(int i = 0; i < nodes.getLength();i++){
				Node n = nodes.item(i);
				if(n.getNodeType() == Node.ELEMENT_NODE && n.getNodeName().equalsIgnoreCase(CONST_MODULE_NODE)){
					ModuleDefine md = parseModuleDefine((Element)n);
					if(md != null){
						ms.getModules().add(md);
					}
				}
			}
		}
		
		return ms;
	}
	
	private static ModuleDefine parseModuleDefine(Element element){
		if(element == null || !element.hasAttributes()) return null;
		ModuleDefine md = new ModuleDefine();
		md.setId(loadElementAttribute(element, CONST_MODULE_NODE_ID));
		if(md.getId() == null || md.getId().trim().isEmpty()) return null;
		md.setIcon(loadElementAttribute(element, CONST_MODULE_NODE_ICON));
		md.setName(loadElementAttribute(element, CONST_MODULE_NODE_NAME));
		md.setUri(loadElementAttribute(element, CONST_MODULE_NODE_URI));
		String order = loadElementAttribute(element, CONST_MODULE_NODE_ORDER);
		if(order == null || order.isEmpty())
			md.setOrderNo(0);
		else
			md.setOrderNo(Integer.parseInt(order));
		if(element.hasChildNodes()){
			NodeList nodes = element.getChildNodes();
			for(int i = 0; i < nodes.getLength();i++){
				Node n = nodes.item(i);
				if(n.getNodeType() == Node.ELEMENT_NODE && n.getNodeName().equalsIgnoreCase(CONST_MODULE_NODE)){
					ModuleDefine m = parseModuleDefine((Element)n);
					if(m != null){
						md.getModules().add(m);
					}
				}
			}
		}
		return md;
	}
}