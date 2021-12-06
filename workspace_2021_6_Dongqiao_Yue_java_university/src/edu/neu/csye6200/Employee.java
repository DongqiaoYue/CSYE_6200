package edu.neu.csye6200;

public class Employee extends Person
{
	private float wage;
	
	public Employee(int id, String firstName, String lastName, int age, float wage) {
		super(id, firstName, lastName, age);
		this.wage = wage;
		// TODO Auto-generated constructor stub
	}
	
	public void setWage(int wage) {
		this.wage = wage;
	}
	
	public float getWage() {
		return wage;
	}
}
