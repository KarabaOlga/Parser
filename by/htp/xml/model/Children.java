package by.htp.xml.model;

public class Children {

private int childcount;

public Children(int childcount) {
	super();
	this.childcount = childcount;
}

public int getChildcount() {
	return childcount;
}

public void setChildcount(int childcount) {
	this.childcount = childcount;
}

@Override
public String toString() {
	return "Children [childcount=" + childcount + "]";
}


}
