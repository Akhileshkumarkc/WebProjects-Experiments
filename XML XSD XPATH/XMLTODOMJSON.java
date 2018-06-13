import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLTODOMJSON {

	public static void main(String[] args) {
		File xmlFile;
		if(args.length != 0){
			xmlFile = new File(args[0]);
		}
		else{
		xmlFile = new File("sample.xml");
		}
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			try {
				DocumentBuilder builder = dbFactory.newDocumentBuilder();
				Document doc = builder.parse(xmlFile);
				doc.getDocumentElement().normalize();
				
				
				System.out.println("{");
				
				Node Dom = doc.getDocumentElement();
				System.out.println("\"" + Dom.getNodeName() + "\":{");
				NodeList childNodes = Dom.getChildNodes();
				
				for (int temp = 1; temp < childNodes.getLength(); temp += 2) {

					Node elem = childNodes.item(temp);
					if(elem.getChildNodes().getLength() > 2){
						System.out.println("\"" + elem.getNodeName() + "\":{");
//						if(elem.hasAttributes()){
//							NamedNodeMap nodemap = elem.getAttributes();
//							for(int a = 0;a < nodemap.getLength();a++){
//								Node attribute = nodemap.item(a);
//								System.out.println("\"-" + attribute.getNodeName() + "\"" + ":" +  "\"" + attribute.getNodeValue() + "\",");
//							}
//						}
						NodeList subList = elem.getChildNodes();
						for(int i=1;i < subList.getLength();i += 2){
							Node nodes = subList.item(i);
							if(nodes.getChildNodes().getLength() > 2){
								System.out.println("\"" + nodes.getNodeName() + "\":{");
								if(nodes.hasAttributes()){
									NamedNodeMap nodemap = nodes.getAttributes();
									for(int a = 0;a < nodemap.getLength();a++){
										Node attribute = nodemap.item(a);
										System.out.println("\"-" + attribute.getNodeName() + "\"" + ":" +  "\"" + attribute.getNodeValue() + "\",");
									}
								}
								NodeList ssitem = nodes.getChildNodes();
								for(int j=1;j < ssitem.getLength();j += 2){
									Node Snodes = ssitem.item(j);
									if(Snodes.getChildNodes().getLength() > 2){
										System.out.println("\"" + Snodes.getNodeName() + "\":{");
										if(Snodes.hasAttributes()){
											NamedNodeMap nodemap = Snodes.getAttributes();
											for(int a = 0;a < nodemap.getLength();a++){
												Node attribute = nodemap.item(a);
												System.out.println("\"-" + attribute.getNodeName() + "\"" + ":" +  "\"" + attribute.getNodeValue() + "\",");
											}
										}
										NodeList sub3List = Snodes.getChildNodes();
										for(int k=1;k < sub3List.getLength();k += 2){
											Node node3 = sub3List.item(k);
											if(node3.getChildNodes().getLength() > 2){
												System.out.println("\"" + node3.getNodeName() + "\":{");
												if(node3.hasAttributes()){
													NamedNodeMap nodemap = node3.getAttributes();
													for(int a = 0;a < nodemap.getLength();a++){
														Node attribute = nodemap.item(a);
														System.out.println("\"-" + attribute.getNodeName() + "\"" + ":" +  "\"" + attribute.getNodeValue() + "\",");
													}
												}
												NodeList item4 = node3.getChildNodes();
												for(int l=1;l < item4.getLength();l += 2){
													Node sub4Node = item4.item(l);
													if(sub4Node.getChildNodes().getLength() > 2){
														System.out.println("\"" + sub4Node.getNodeName() + "\":{");
														System.out.println("}");
													}else{
														if(sub4Node.hasAttributes()){
															System.out.print("\"" + sub4Node.getNodeName() + "\":{");
															NamedNodeMap nodemap = sub4Node.getAttributes();
															for(int a = 0;a < nodemap.getLength();a++){
																Node attribute = nodemap.item(a);
																System.out.println("\"-" + attribute.getNodeName() + "\"" + ":" +  "\"" + attribute.getNodeValue() + "\"}");
															}
														}else{
															System.out.println("\"" + sub4Node.getNodeName() + "\":" + "\"" + sub4Node.getTextContent() + "\",");
														}
													}
												}
												System.out.println("}");
											}else{
												if(node3.hasAttributes()){
													System.out.print("\"" + node3.getNodeName() + "\":{");
													NamedNodeMap nodemap = node3.getAttributes();
													for(int a = 0;a < nodemap.getLength();a++){
														Node attribute = nodemap.item(a);
														System.out.println("\"-" + attribute.getNodeName() + "\"" + ":" +  "\"" + attribute.getNodeValue() + "\"}");
													}
												}else{
													System.out.println("\"" + node3.getNodeName() + "\":" + "\"" + node3.getTextContent() + "\",");
												}
											}
										}
										System.out.println("}");
									}else{
										if(Snodes.hasAttributes()){
											System.out.print("\"" + Snodes.getNodeName() + "\":{");
											NamedNodeMap nodemap = Snodes.getAttributes();
											for(int a = 0;a < nodemap.getLength();a++){
												Node attribute = nodemap.item(a);
												System.out.println("\"-" + attribute.getNodeName() + "\"" + ":" +  "\"" + attribute.getNodeValue() + "\"}");
											}
											
										}else{
											System.out.println("\"" + Snodes.getNodeName() + "\":" + "\"" + Snodes.getTextContent() + "\",");
										}
									}
								}
								System.out.println("}");
							}else{
								if(nodes.hasAttributes()){
									System.out.print("\"" + nodes.getNodeName() + "\":{");
									NamedNodeMap nodemap = nodes.getAttributes();
									for(int a = 0;a < nodemap.getLength();a++){
										Node attribute = nodemap.item(a);
										System.out.println("\"-" + attribute.getNodeName() + "\"" + ":" +  "\"" + attribute.getNodeValue() + "\"}");
									}
								}else{
									System.out.println("\"" + nodes.getNodeName() + "\":" + "\"" + nodes.getTextContent() + "\",");
								}
							}
						}
						System.out.println("}");
					}else{
						if(elem.hasAttributes()){
							System.out.print("\"" + elem.getNodeName() + "\":{");
							NamedNodeMap nodemap = elem.getAttributes();
							for(int a = 0;a < nodemap.getLength();a++){
								Node attribute = nodemap.item(a);
								System.out.println("\"-" + attribute.getNodeName() + "\"" + ":" +  "\"" + attribute.getNodeValue() + "\"}");
							}
						}else{
							System.out.println("\"" + elem.getNodeName() + "\":" + "\"" + elem.getTextContent() + "\",");
						}
					}
				}
				System.out.println("}");
				System.out.println("}");
			} catch (ParserConfigurationException | SAXException | IOException e) {
				e.printStackTrace();
			}
	}

}