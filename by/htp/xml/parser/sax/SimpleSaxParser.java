package by.htp.xml.parser.sax;

import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SimpleSaxParser {
	
	public static void main(String[] args){
		
		 try{
			 SimpleSaxHandler handler= new SimpleSaxHandler();
			 XMLReader reader = XMLReaderFactory.createXMLReader();
			 
			 reader.setContentHandler(handler);
			 
			 reader.parse("resource/Family.xml");
		 } catch (SAXException e){
			 e.printStackTrace();
		 } catch (IOException e) {
			e.printStackTrace();
		}
	}

}