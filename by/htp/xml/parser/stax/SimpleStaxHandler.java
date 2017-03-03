package by.htp.xml.parser.stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.stream.XMLStreamException;

public class SimpleStaxHandler {

	public static void main(String[] args){
		
		SimpleStaxParser parser = new SimpleStaxParser();
		InputStream input = null;
		try{
			input = new FileInputStream("resource/Family.xml");
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		try {parser.parse(input);
		}catch (XMLStreamException e){
			e.printStackTrace();
		}
	
	}
}
