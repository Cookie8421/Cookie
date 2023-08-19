import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import junit.framework.Assert;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMTest {
	private File f = new File("D:/Workspace/_Practise4SE/contacts.xml");
	
	@Test
	public void test1() throws Exception{  //查询xml中的元素
		
		//1)获取Document对象
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(f);
		//2)获取XML根元素
		Element rootele = doc.getDocumentElement();
		//3)获取其子元素
		NodeList list= rootele.getChildNodes();
		NodeList list1 = rootele.getElementsByTagName("linkman");
		//System.out.println(list1.getLength());
		//4)获取子孙元素
		Element linkman2 = (Element) list1.item(1);
		Element linkman2Name = (Element) linkman2.getElementsByTagName("name").item(0);
		Assert.assertEquals("出错了!", "Stef", linkman2Name.getTextContent());
		
	}
	
	@Test
	public void test2() throws Exception{   //修改xml中的元素
		
		//1)获取Document对象
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(f);
		//2)获取XML根元素
		Element rootele = doc.getDocumentElement();
		//3)获取其子元素
		NodeList list1 = rootele.getElementsByTagName("linkman");
		//System.out.println(list1.getLength());
		//4)获取子孙元素
		Element linkman2 = (Element) list1.item(1);
		Element linkman2Name = (Element) linkman2.getElementsByTagName("name").item(0);
		//5)修改元素文本内容
		linkman2Name.setTextContent("Ali");
		//6)同步操作:内存-->磁盘
		Transformer tran = TransformerFactory.newInstance().newTransformer();
		tran.transform(new DOMSource(doc), new StreamResult(f));
		
		}
	
	@Test	
	public void test3() throws Exception{   //增加xml中的元素
		
		//1)获取Document对象
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(f);
		//2)获取XML根元素
		Element rootele = doc.getDocumentElement();
		//3)创建多个元素并设置文本
		Element link = (Element) doc.createElement("linkman");
		link.setAttribute("id", "3");
		Element linkName = (Element) doc.createElement("name");
		linkName.setTextContent("COokie");
		Element linkEmail = (Element) doc.createElement("e-mail");
		linkEmail.setTextContent("562234938@qq.com");
		Element linkAdd = (Element) doc.createElement("address");
		linkAdd.setTextContent("NJ");
		Element linkGroup = (Element) doc.createElement("group");
		linkGroup.setTextContent("JS");
		//4)建立新建元素之间的层次关系
		link.appendChild(linkName);
		link.appendChild(linkEmail);
		link.appendChild(linkAdd);
		link.appendChild(linkGroup);
		rootele.appendChild(link);
		//6)同步操作:内存-->磁盘
		Transformer tran = TransformerFactory.newInstance().newTransformer();
		tran.transform(new DOMSource(doc), new StreamResult(f));
		
		}
	
	@Test	
	public void test4() throws Exception{   //删除xml中的元素
		//1)获取Document对象
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(f);
		//2)获取XML根元素
		Element rootele = doc.getDocumentElement();
		//3)获取第三个linkman
		Element ele = (Element) rootele.getElementsByTagName("linkman").item(2);
		//4)用父元素对象来删除子元素
		rootele.removeChild(ele);
		//5)同步操作:内存-->磁盘
		Transformer tran = TransformerFactory.newInstance().newTransformer();
		tran.transform(new DOMSource(doc), new StreamResult(f));
	}
	
	
}
