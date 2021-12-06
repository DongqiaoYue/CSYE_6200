package edu.neu.csye6200;

import java.util.List;

public class Person extends AbstractPersonAPI
{
	private int id;
	private int age;
	private String firstName;
	private String lastName;
	private float wage;
	private float gPA;
	

	public Person(int id, String firstName, String lastName, int age) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	@Override
	public float getWage() {
		// TODO Auto-generated method stub
		return this.wage;
	}
	
	@Override
	public float getGpa() {
		// TODO Auto-generated method stub
		return this.gPA;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return this.firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return this.lastName;
	}

	@Override
	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		this.lastName = lastName;
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return this.age;
	}

	@Override
	public void setAge(int age) {
		// TODO Auto-generated method stub
		this.age = age;
	}
	
	@Override
	public String toString() {
		
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	
	}
	
	public void printObjects(List os) {
		for (Object o : os) {
			System.out.println(o);
		}
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		Person person = new Person(id, firstName, lastName, age);
		System.out.println(person.toString());
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}


