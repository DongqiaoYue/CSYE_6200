package csv1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Student extends Person{
	
	private int studentID;
	private float GPA;
	
	public int getStudentID() {
		return studentID;
	}
	
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	public float getGPA() {
		return GPA;
	}
	
	public void setGPA(float gPA) {
		GPA = gPA;
	}
	
	public List<Student> sortStudentBy(List<Student> s, Comparator<Student> p) {	
		Collections.sort(s, p);
		return s;
	}

	public List<Student> createStudent(List<String> list) {
		
		List<Student> students = new ArrayList<>();
		
		for (String student : list) {
			Scanner in = new Scanner(student);
			in.useDelimiter(",");
			
			int ID = in.nextInt();
			int age = in.nextInt();
			String firstName = in.next();
			String lastName = in.next();
			String parentFirstName = in.next();
			String parentLastName = in.next();
			int studentID = in.nextInt();
			float GPA = in.nextFloat();
			
			students.add(new Student (ID, age, firstName, lastName, parentFirstName, parentLastName, studentID, GPA));
			in.close();
		}
		
		return students;
	}
	
	public void printStudent(List<Student> students) {
		
		for (Student student : students) {
			String str = "Student [GPA=" + student.getGPA() + ", Age=" + student.getAge()
			+ ", FirstName=" + student.getFirstName() + ", LastName=" + student.getLastName() + "]";
			System.out.println(str);
		}
		
	}
	
	public Student(int ID, int age, String firstName, String lastName, String parentFirstName, String parentLastName, int studentID, float GPA) {
		super(ID, age, firstName, lastName, parentFirstName, parentLastName);
		this.studentID = studentID;
		this.GPA = GPA;
	}
	
	public Student() {
	}
	
	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", GPA=" + GPA + ", ID=" + getID() + ", Age=" + getAge()
				+ ", FirstName=" + getFirstName() + ", LastName=" + getLastName() + ", ParentFirstName="
				+ getParentFirstName() + ", ParentLastName=" + getParentLastName() + "]";
	}
	
	public static void demo() {
		Student student = new Student();
		
		List<String> lists = new ArrayList<String>();
		lists.add("98234,23,Dongqiao,Yue,Xinya,Cao,98416,3.60");
		lists.add("64573,56,Xunuo,Yuan,Kun,Yun,67546,3.87");
		lists.add("67857,67,Sheng,Yuan,Yang,Liu,54344,3.45");
		lists.add("46576,45,Li,Li,Xing,Peng,56876,3.57");
		
		List<Student> students = student.createStudent(lists);
		
		
		student.printStudent(students);
		
		System.out.println("----------------------------Sort by ID----------------------------");
		students = student.sortStudentBy(students, new IDComparator());
		student.printObjects(students);
		System.out.println("--------------------------Sort by StudentID-----------------------");
		students = student.sortStudentBy(students, new studentIDComparator());
		student.printObjects(students);
		System.out.println("--------------------------Sort by Last Name-----------------------");
		students = student.sortStudentBy(students, new lastNameComparator());
		student.printObjects(students);
		System.out.println("--------------------------Sort by First Name----------------------");
		students = student.sortStudentBy(students, new firstNameComparator());
		student.printObjects(students);
		System.out.println("----------------------------Sort by GPA---------------------------");
		students = student.sortStudentBy(students, new GPAComparator());
		student.printObjects(students);
	}
	
}

class IDComparator implements Comparator<Student> {
	
	@Override
	public int compare(Student a, Student b) {
		return a.getID() < b.getID() ? -1 : a.getID() == b.getID() ? 0 : 1;
	}
	
}

class studentIDComparator implements Comparator<Student> {
	
	@Override
	public int compare(Student a, Student b) {
		return a.getStudentID() < b.getStudentID() ? -1 : a.getStudentID() == b.getStudentID() ? 0 : 1;
	}
	
}

class lastNameComparator implements Comparator<Student> {
	
	@Override
	public int compare(Student a, Student b) {
		return a.getLastName().compareTo(b.getLastName());
	}
	
}

class firstNameComparator implements Comparator<Student> {
	
	@Override
	public int compare(Student a, Student b) {
		return a.getFirstName().compareTo(b.getFirstName());
	}
	
}

class GPAComparator implements Comparator<Student> {
	
	@Override
	public int compare(Student a, Student b) {
		return a.getGPA() < b.getGPA() ? -1 : a.getGPA() == b.getGPA() ? 0 : 1;
	}
	
}
