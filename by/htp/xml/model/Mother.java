package by.htp.xml.model;

public class Mother extends Parent{
	
private String midenName;
private int childrenCount;
private Children children;
	
public Mother() {
		super();
	}
public Mother (Children childen){
	super();
	this.children = children;
}

public Mother(String midenName) {
	super();
	this.midenName = midenName;
}

public String getMidenName() {
	return midenName;
}

public void setMidenName(String midenName) {
	this.midenName = midenName;
}

public int getChildrenCount() {
	return childrenCount;
}

public void setChildrenCount(int childrenCount) {
	this.childrenCount = childrenCount;
}
@Override
public String toString() {
	return super.toString() +"midenName=" + midenName +"childrenCount+"+ childrenCount;
}

public Children getChildren() {
	return children;
}

public void setChildren(Children children) {
	this.children = children;
}

}
