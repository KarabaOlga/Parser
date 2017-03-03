package by.htp.xml.parser;

public enum XmlElementStax {
	FAMILIES, FAMILY, MOTHER, FATHER, NAME, SURNAME, MAIDEN_NAME, AGE, CHILDREN, CHILDCOUNT;
	
	public static XmlElementStax getElementXml(String element){
		switch (element){
		case "failies":
			return FAMILIES;
		case "family":
			return FAMILY;
		case "mother" :
			return MOTHER;
		case "father" :
			return FATHER;
		case "name" :
			return NAME;
		case "surname":
			return SURNAME;	
		case "maiden_name" :
			return MAIDEN_NAME;
		case "age" :
			return AGE;	
		case "children" :
			return CHILDREN;
		case "childcount":
		    return CHILDCOUNT;
		default:
			throw new EnumConstantNotPresentException(by.htp.xml.parser.XmlElementStax.class, element);
	    }
	};
}