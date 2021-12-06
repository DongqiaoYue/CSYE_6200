package csv1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtil {
	
	public List<Student> readStudentCSV() {
		
		List<Student> students = new ArrayList<Student>();
		
		try {
			Scanner inLine = new Scanner(new BufferedReader(new FileReader("./src/csv1/students.txt")));
			while (inLine.hasNextLine()) {
				String inputLine = inLine.nextLine();
				Scanner in = new Scanner(inputLine);
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
			
			inLine.close();   
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();   
		}
		
		return students;
		
	}
	
	public List<Teacher> readTeacherCSV() {
		
		List<Teacher> teachers = new ArrayList<Teacher>();
		
		try {
			Scanner inLine = new Scanner(new BufferedReader(new FileReader("./src/csv1/teachers.txt")));
			while (inLine.hasNextLine()) {
				String inputLine = inLine.nextLine();
				Scanner in = new Scanner(inputLine);
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
			
			inLine.close();   
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();   
		}
		
		return teachers;
		
	}
	
	public void writeCSV(List<String> list, String str) {
		
		try {
			FileWriter fw = new FileWriter(str);
			BufferedWriter out= new BufferedWriter(fw);
			for (String strs : list) {
				out.write(strs);
				out.newLine();
			}
			out.flush();
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public static void demo() {
		
		List<String> studentList = new ArrayList<String>();
		studentList.add("75467,34,Hou,Liu,Wu,Wu,74565,3.92");
		studentList.add("34567,24,Liu,Yang,Peng,Fei,15645,3.85");
		studentList.add("65154,13,Shang,Ou,Yu,Huang,65641,3.95");
		studentList.add("98416,27,Hang,Yu,Qiu,Fei,25656,3.45");
		
		List<String> teacherList = new ArrayList<String>();
		teacherList.add("16545,26,Lang,Ou,Feng,Liu,6000");
		
		FileUtil util = new FileUtil();
		
		util.writeCSV(studentList, "./src/csv1/students.txt");
		util.writeCSV(teacherList, "./src/csv1/teachers.txt");
		
		List<Student> students = util.readStudentCSV();
		
		System.out.println("--------------------------List of Student------------------------");
		for (Student student : students) {
			String str = "Student [studentID=" + student.getStudentID() + ", GPA=" + student.getGPA() + ", ID=" + student.getID()
			+ ", Age=" + student.getAge() + ", FirstName=" + student.getFirstName() + ", LastName=" + student.getLastName()
			 + ", ParentFirstName=" + student.getParentFirstName() + ", ParentLastName=" + student.getParentLastName() + "]";
			System.out.println(str);
		}
		
		List<Teacher> teachers = util.readTeacherCSV();
		
		System.out.println("--------------------------List of Teacher------------------------");
		for (Teacher teacher : teachers) {
			String str = "Teacher [hourlyWage=" + teacher.getHourlyWage() + ", ID=" + teacher.getID()
			+ ", Age=" + teacher.getAge() + ", FirstName=" + teacher.getFirstName() + ", LastName=" + teacher.getLastName()
			 + ", ParentFirstName=" + teacher.getParentFirstName() + ", ParentLastName=" + teacher.getParentLastName() + "]";
			System.out.println(str);
		}
		
	}
}
	


