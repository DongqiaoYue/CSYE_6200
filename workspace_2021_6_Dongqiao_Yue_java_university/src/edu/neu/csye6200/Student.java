package edu.neu.csye6200;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student extends Person
{
	private float gPA;
	
	public float getGpa() {
		return gPA;
	}
	
	public void setGpa(float gPA) {
		gPA = gPA;
	}
	
	public Student(int ID, int age, String firstName, String lastName, float GPA) {
		super(ID, firstName, lastName, age);
		this.gPA = GPA;
	}

	@Override
	public String toString() {
		return "Student [ID=" + getId() + ", Age=" + getAge() + ", FirstName=" + getFirstName() + ", LastName=" + getLastName() + "]";
	}
	
	public void printStudent(List<Student> students) {
		
		for (Student student : students) {
			String str = "Student [GPA=" + student.getGpa() + ", Age=" + student.getAge()
			+ ", FirstName=" + student.getFirstName() + ", LastName=" + student.getLastName() + "]";
			System.out.println(str);
		}
		
	}

}

