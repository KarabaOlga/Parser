package by.htp.xml.parser.dom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.htp.xml.model.Children;
import by.htp.xml.model.Family;
import by.htp.xml.model.Father;
import by.htp.xml.model.Mother;
import by.htp.xml.model.Parent;
import by.htp.xml.parser.Constant;



public class SimpleDomParser {
	
	
	private Family family;
	private Parent parent;
	public  List<Family> familiesList;

	public static void main(String[] args) {
		
    try {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("resource/Family.xml");
			
		List<Family> familiesList = null;
		 Element root = document.getDocumentElement();
			
			   //NodeList nodes = root.getChildNodes():
			
			// List<Parent> parentList = new ArrayList<Parent>();
			familiesList= new ArrayList<>();
			Family family =null;
			NodeList families = root.getElementsByTagName("family");
			
			for(int i=0; i<families.getLength();i++){
				//System.out.println(families.item(i).getNodeName());
				//System.out.println(families.item(i).getAttributes().getNamedItem("name"));
			
				family = new Family();
				familiesList.add(family);
				
				Element familyElement = (Element)families.item(i);
				
				family.setName(familyElement.getAttribute("name"));
				NodeList parents = familyElement.getChildNodes();
				
			for(int j=0; j<parents.getLength();j++){
				Node elementParent = parents.item(j);
				System.out.println(parents.item(j).getNodeName());
					
					
				if(elementParent.getNodeName().equals(Constant.MOTHER)){
					NodeList elements = elementParent.getChildNodes();
					Mother mother = new Mother();
					family.setMother(mother);
						
			for (int k=0; k<elements.getLength(); k++){
				String elementValue = null;
				Node element = elements.item(k);
				Node nodeChild = element.getFirstChild();
				if(nodeChild != null){
					elementValue = nodeChild.getNodeValue();
					System.out.println(element.getNodeName() +" "+elementValue);
					
					
					switch (element.getNodeName()){
					  case Constant.ATTRIBUTE_AGE : mother.setAge(Integer.parseInt(elementValue));
					      break;
					  case Constant.ATTRIBUTE_SURNAME : mother.setSurname(elementValue);
					      break;
					  case Constant.ATTRIBUTE_MAIDEN_NAME : mother.setMidenName(elementValue);
					      break;
					  case Constant.ATTRIBUTE_NAME : mother.setName(elementValue);
					      break;
					  default:
						  break;
					  }
				}else{
					if (element.getAttributes()!=null){
						int count = Integer.parseInt(((Element)element).getAttribute(Constant.ATTRIBUTE_COUNT));
						Children children =new Children(count);
						mother.setChildren(children);
					}
				  }
			     }			
			   }else if (elementParent.getNodeName().equals(Constant.FATHER)){
				   NodeList elements = elementParent.getChildNodes();
				   Father father = new Father();
				   family.setFather(father);
				
				   for (int k=0; k<elements.getLength(); k++){
						String elementValue = null;
						Node element = elements.item(k);
						Node nodeChild = element.getFirstChild();
						if(nodeChild != null){
							elementValue = nodeChild.getNodeValue();
							System.out.println(element.getNodeName() +" "+elementValue);
							
							switch (element.getNodeName()){
							  case Constant.ATTRIBUTE_AGE : father.setAge(Integer.parseInt(elementValue));
							      break;
							  case Constant.ATTRIBUTE_SURNAME : father.setSurname(elementValue);
							      break;						
							  case Constant.ATTRIBUTE_NAME : father.setName(elementValue);
							      break;
							  default:
								  break;
						 	  }
						   }
			            }
				     }
			     }
              }
			System.out.println(familiesList);
				
		/*		
				
			   
			    
			 for(int j=0; j<((NodeList)parents).getLength(); j++){
			//System.out.println(families.item(j).getNodeName());
			//System.out.println(families.item(j).getAttributes().getNamedItem("name")));
		         
				 Parent mother= new Mother();
		       // Parent father = new Father();
		        
		        Element parentElement = (Element)((NodeList)parents).item(j);
		        mother.setName(getSingleChild(parentElement,"name").getTextContent().trim());
		        mother.setSurname(getSingleChild(parentElement,"surname").getTextContent().trim());
		        mother.setAge(Integer.parseInt(parentElement.getAttribute("age")));
		        
		        parentList.add(mother);
				
			  }
			}
			
			
			for (Parent mother: parentList) {
		    	System.out.println( mother.getName()+ mother.getSurname() + mother.getAge());}
	         }
	         
	         */
	      
    }catch (ParserConfigurationException e){
			e.printStackTrace();
	           }catch(SAXException e){
	               e.printStackTrace();
	                  }catch (IOException e){
			                e.printStackTrace();
			                }
    
	}
}

	/*
			
		 private static Element getSingleChild(Element element, String childName){
		    	NodeList nList = element.getElementsByTagName(childName);
		    	Element child = (Element) nList.item(0);
		    	return child;
		    }
}
*/
		   
		 
