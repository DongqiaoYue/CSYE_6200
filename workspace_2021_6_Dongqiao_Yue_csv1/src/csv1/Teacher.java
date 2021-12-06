package csv1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teacher extends Person{
	
	private int hourlyWage;

	public int getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(int hourlyWage) {
		this.hourlyWage = hourlyWage;
	}
	
	
	
	public Teacher(int ID, int age, String firstName, String lastName, String parentFirstName, String parentLastName, int hourlyWage) {
		super(ID, age, firstName, lastName, parentFirstName, parentLastName);
		this.hourlyWage = hourlyWage;
	}
	
	public Teacher() {
	}
	
	public List<Teacher> createTeacher(List<String> list) {
		
		List<Teacher> teachers = new ArrayList<Teacher>();
		
		for (String teacher : list) {
			Scanner in = new Scanner(teacher);
			in.useDelimiter(",");
			
			int ID = in.nextInt();
			int age = in.nextInt();
			String firstName = in.next();
			String lastName = in.next();
			String parentFirstName = in.next();
			String parentLastName = in.next();
			int hourlyWage = in.nextInt();
			
			teachers.add(new Teacher (ID, age, firstName, lastName, parentFirstName, parentLastName, hourlyWage));
			in.close();
		}
		
		return teachers;
	}
	
	public void printTeacher(List<Teacher> teachers) {
		
		for (Teacher teacher : teachers) {
			String str = "Teacher [HourlyWage=" + teacher.getHourlyWage() + ", Age=" + teacher.getAge()
			+ ", FirstName=" + teacher.getFirstName() + ", LastName=" + teacher.getLastName() + "]";
			System.out.println(str);
		}
		
	}

	@Override
	public String toString() {
		return "Teacher [hourlyWage=" + hourlyWage + ", Age=" + getAge()
				+ ", FirstName=" + getFirstName() + ", LastName=" + getLastName() + "]";
	}

	public static void demo() {
		
		Teacher teacher = new Teacher();
		
		List<String> lists = new ArrayList<String>();
		lists.add("87686,34,Dundun,Yue,Paozheng,Liu,8000");
		lists.add("82345,34,De,Tue,Pao,Liu,9000");
		lists.add("12326,34,Du,Tue,zheng,Li,7000");
		lists.add("64546,34,Den,Yu,Peng,Lu,8700");
		
		List<Teacher> teachers = teacher.createTeacher(lists);
		
		
		teacher.printTeacher(teachers);
	}
 	
}
