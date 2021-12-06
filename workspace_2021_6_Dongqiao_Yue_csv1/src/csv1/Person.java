package csv1;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	private int ID;
	private int age;
	private String firstName;
	private String lastName;
	private String parentFirstName;
	private String parentLastName;
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getParentFirstName() {
		return parentFirstName;
	}
	
	public void setParentFirstName(String parentFirstName) {
		this.parentFirstName = parentFirstName;
	}
	
	public String getParentLastName() {
		return parentLastName;
	}
	
	public void setParentLastName(String parentLastName) {
		this.parentLastName = parentLastName;
	}
	
	public void printObjects(List os) {
		
		for (Object o : os) {
			
			System.out.println(o);
			
		}
		
	}

	public Person(int ID, int age, String firstName, String lastName, String parentFirstName, String parentLastName) {
		super();
		this.ID = ID;
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.parentFirstName = parentFirstName;
		this.parentLastName = parentLastName;
	}
	
	public Person() {
		
	}
	
	public static void demo() {
		
		System.out.println(new Person(45367,13,"Wang","Wang","Pao","Liu").toString());
		
	}

	@Override
	public String toString() {
		return "Person [ID=" + ID + ", age=" + age + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", parentFirstName=" + parentFirstName + ", parentLastName=" + parentLastName + "]";
	}
}
