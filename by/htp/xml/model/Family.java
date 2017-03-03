package by.htp.xml.model;

import by.htp.xml.model.Father;
import by.htp.xml.model.Mother;

public class Family {
	
	private Mother mother;
	private Father father;
	private String name;
	
	
	public Family(){	
	}
	
	public Family(Mother mother, Father father){
		this.mother = mother;
		this.father = father;
	}
	public Family(Mother mother, Father father, String name){
		this.mother = mother;
		this.father = father;
		this.name =name;
	}

	
	public Family(String name) {
		this.name=name;
		// TODO Auto-generated constructor stub
	}

	public Mother getMother() {
		return mother;
	}


	public void setMother(Mother mother) {
		this.mother = mother;
	}


	public Father getFather() {
		return father;
	}


	public void setFather(Father father) {
		this.father = father;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Family [mother=" + mother + ", father=" + father + ", name=" + name + "]";
	}

}
