package by.htp.xml.parser.stax;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;

import by.htp.xml.model.Children;
import by.htp.xml.model.Family;
import by.htp.xml.model.Father;
import by.htp.xml.model.Mother;
import by.htp.xml.model.Parent;
import by.htp.xml.parser.XmlElementStax;

public class SimpleStaxParser {
	
	private List<Family> families;
	private Family family;
	private Parent parent;
	private XmlElementStax currentNode;
	
	public void parse(InputStream input) throws XMLStreamException{ 
	
		XMLInputFactory inputFactory= XMLInputFactory.newInstance();
		XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
		process(reader);
		System.out.println(families);	
	}

	public void process(XMLStreamReader reader) 
		throws XMLStreamException {
		while(reader.hasNext()){
				int type = reader.next();
				switch (type) {
				case XMLStreamConstants.START_ELEMENT:
					startElement(reader);
					break;
				case XMLStreamConstants.CHARACTERS:
					characters(reader);
					break;
					
				}
			}
	    }
	private void startElement(XMLStreamReader reader){
		
		String name = reader.getLocalName();
		currentNode = XmlElementStax.valueOf(name.toUpperCase());
		 switch (currentNode){
		 case FAMILIES:
			 families = new ArrayList<Family>();
			 break;
		 case FAMILY:
			 family = new Family(reader.getAttributeValue(null,XmlElementStax.NAME.name().toLowerCase()));
			 families.add(family);
			 break;
		 case MOTHER:
			 parent = new Mother();
			 family.setMother((Mother)parent);
			 break;
		 case FATHER:
			 parent = new Father();
			 family.setFather((Father)parent);
			 break;
		 case CHILDREN:
			 Children children = new Children(Integer.parseInt(reader.getAttributeValue(null,XmlElementStax.CHILDCOUNT.name().toLowerCase())));
			 ((Mother)parent).setChildren(children);
			 break;
			 default:
				 break;
		 }	
	}
	
					
	private void characters(XMLStreamReader reader){
		String text = reader.getText().trim();
		if (text!=null&&!text.equals("")){
							
					switch (currentNode) {
					case AGE:
						parent.setAge(Integer.parseInt(text));
						break;
					case SURNAME:
						parent.setSurname(text);
						break;
					case MAIDEN_NAME:
						((Mother)parent).setMidenName(text);
						break;
					case NAME:
					     parent.setName(text);
						break;
					default:
						break;
					}
	       }
	}
}
					