package by.htp.xml.parser.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.htp.xml.model.Family;
import by.htp.xml.model.Father;
import by.htp.xml.model.Mother;
import by.htp.xml.model.Parent;
import by.htp.xml.parser.XmlElement;

public class SimpleSaxHandler extends DefaultHandler {
	
	private String text;
	private StringBuilder builder;
	private Family family;
	private Mother mother;
	private Father father;
	private Parent parent;
	private List<Family> families;

	@Override
	public void characters(char[] buf, int start, int length) throws SAXException {
		
		
		//System.out.println(builder.append(buf,start,length).toString().trim());
		text = builder.append(buf,start,length).toString().trim().toUpperCase();
		//XmlElement element = XmlElement.valueOf(node);
		//switch (element){
		//}
	}

	@Override
	public void endDocument() throws SAXException {
		
		System.out.println(families);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("end element" + qName);
		
		XmlElement element = XmlElement.valueOf(qName.replace("-","_"));// change qName/text
		switch (element){
		case FAMILY:
			families.add(family);
			break;
		case MOTHER:
			family.setMother((Mother)parent);
			break;
		case FATHER:
			family.setFather((Father)parent);
			break;
		case NAME:
			parent.setName(text);
			break;
		case SURNAME:
			parent.setSurname(text);
			break;
		case MAIDEN_NAME:
			((Mother)parent).setMidenName(text);
			break;
		case AGE:
			parent.setAge(Integer.parseInt(text));
			break;
		case CHILDREN:
			((Mother)parent).setChildrenCount(Integer.parseInt(text));
			break;
		case FAMILIES:
			break;
		default:
			break;
		}
	}

	@Override
	public void startDocument() throws SAXException {
		
		families = new ArrayList<Family>();
		System.out.println("start document");
		
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atr) throws SAXException {
		
		builder = new StringBuilder();
		
		if ("family".equals(qName)){
			family = new Family();
			family.setName(atr.getValue("name"));
		}
		if("mother".equals(qName)){
			parent = new Mother();
		}
		if ("father".equals(qName)){
			parent = new Father();
		}
	}

	

}
