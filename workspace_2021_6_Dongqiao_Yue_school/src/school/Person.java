package school;

import java.util.Comparator;


public class Person implements Comparable{
	
	private int id;
	private int age;
	private String firstName;
	private String lastName;
	

	public Person(int id, String firstName, String lastName, int age) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		
	}
	
	
	@Override
	public String toString() {
		
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	
	}
	

	public long getId() {
		
		return id;
		
	}
	
	
	public String getFirstName() {
		
		return firstName;
		
	}
	

	public String getLastName() {
		
		return lastName;
		
	}
	
	
	public int getAge() {
		
		return age;
		
	}
	

	public void setAge(int age) {
		
		this.age = age;
		
	}
	
	
	public void setLastName(String lastName) {
		
		this.lastName = lastName;
		
	}
	
	
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
		
	}
	
	
	public void setId(int id) {
		
		this.id = id;
		
	}


	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return this.getFirstName().compareTo(((Person) o).getFirstName());
	}
	
}