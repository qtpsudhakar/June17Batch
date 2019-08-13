package com.fl.handle;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXML {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		File xmlFile = new File("C:\\Users\\envy\\Desktop\\June17th\\books.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbuilder = dbf.newDocumentBuilder();
		Document doc = dbuilder.parse(xmlFile);
		
		System.out.println(doc.getDocumentElement().getNodeName());
		
		doc.getDocumentElement().getElementsByTagName("book");
		
		NodeList list =doc.getElementsByTagName("book");
		for(int i=0;i<list.getLength();i++) {
			System.out.println(list.item(i).getNodeName());
			System.out.println(list.item(i).getNodeValue());
			
			NamedNodeMap nMap=list.item(i).getAttributes();
			System.out.println(nMap.item(0));
			
			NodeList cList = list.item(i).getChildNodes();
			System.out.println(cList.getLength());
			for(int c=0;c<cList.getLength();c++) {
				System.out.println(cList.item(c).getNodeName());
				System.out.println(cList.item(c).getNodeValue());
			}
		}
		
		
	}

}
