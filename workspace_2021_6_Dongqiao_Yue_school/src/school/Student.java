package school;

import java.util.Comparator;



public class Student extends Person implements Comparable{
	
	private float gpa;
	
	public Student(int id, String firstName, String lastName, int age, float gpa) {
		super(id, firstName, lastName, age);
		this.gpa = gpa;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + getId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + ", age=" + getAge() + ", gpa=" + gpa + "]";	
	}

	
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	
	public float getGpa() {
		return this.gpa;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return this.getFirstName().compareTo(((Student) o).getFirstName());
	}
	
}


class AgeComparator implements Comparator<Student> {
	
	@Override
	public int compare(Student a, Student b) {
		return a.getAge() < b.getAge() ? -1 : a.getAge() == b.getAge() ? 0 : 1;
	}
	
}


class IdComparator implements Comparator<Student> {
	
	@Override
	public int compare(Student a, Student b) {
		return a.getId() < b.getId() ? -1 : a.getId() == b.getId() ? 0 : 1;
	}
	
}


class GpaComparator implements Comparator<Student> {
	
	@Override
	public int compare(Student a, Student b) {
		return a.getGpa() < b.getGpa() ? -1 : a.getGpa() == b.getGpa() ? 0 : 1;
	}
	
}


class LastNameComparator implements Comparator<Student> {
	
	@Override
	public int compare(Student a, Student b) {
		return a.getLastName().compareTo(b.getLastName());
	}
	
}