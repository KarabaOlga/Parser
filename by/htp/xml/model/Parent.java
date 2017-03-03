package by.htp.xml.model;

public class Parent {

	private String name;
	private String surname;
	private int age;
	
	public Parent(){
		
	}
	public Parent(String name, String surname, int age) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return "Parent [name=" + name + ", surname=" + surname + ", age=" + age + "]";
	}
}