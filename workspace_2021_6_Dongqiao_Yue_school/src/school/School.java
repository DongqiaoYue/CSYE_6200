package school;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class School<T> {
	
	private List<Person> personRoster = new ArrayList<>();
	private List<Student> studentRoster = new ArrayList<>();
	
	// add person to person
	public void addPerson(Student s) {
		
		personRoster.add(s);
		
	}
	
	// add student to student
	public void addStudent(Student s) {
		
		studentRoster.add(s);
		
	}
	
	public void sortPerson(List p) {
		
		Collections.sort(p);
		
	}

	// sort person
	public void sortPerson(Comparator p) {
		
		Collections.sort(personRoster, p);
		
	}
	
	public void sortStudents(List s) {
		
		Collections.sort(s);
		
	}
	
	// sort student
	public void sortStudents(Comparator s) {
		
		Collections.sort(studentRoster, s);
		
	}

	public void printObjects(List os) {
		
		for (Object o : os) {
			
			System.out.println(o);
			
		}
		
		System.out.println();
		
	}
	
	@Override
	public String toString() {
		
		String result = "---------------------------List of Person-----------------------\n";
		
		for (Object o : personRoster) {
			
			result = result + o +"\n";
			
		}
		
		result = result + "\n-------------------------List of Student----------------------\n";
		
		for (Object o : studentRoster) {
			
			result = result + o +"\n";
			
		}
	
		
		return result;
	}
	
	

	public void Demo() {
		
		addStudent(new Student(123, "Dongqiao", "Yue", 17, 3.91f));
		addStudent(new Student(456, "Zuyu", "Li", 15, 4.0f));
		addStudent(new Student(789, "Hao", "Fu", 25, 3.90f));
		addStudent(new Student(753, "Wen", "Li", 26, 2.50f));
		addStudent(new Student(951, "Fei", "Li", 24, 3.50f));
		
		addPerson(new Student(852, "Sheng", "Chen", 28, 3.50f));
		addPerson(new Student(741, "Guang", "Wu", 27, 3.50f));
		addPerson(new Student(963, "Fei", "Zhang", 24, 3.50f));
		addPerson(new Student(369, "Yun", "Ma", 19, 3.50f));
		addPerson(new Student(258, "Liang", "Ma", 20, 3.50f));
		
		
		System.out.println(toString());
		
		System.out.println("------------------Sort students to person-------------------");
		sortStudents(personRoster);
		printObjects(personRoster);
		
		System.out.println("------------------Sort students to student-------------------");
		sortStudents(studentRoster);
		printObjects(studentRoster);
		
		System.out.println("------------------------Sort by age-------------------------");
		sortStudents(new AgeComparator());
		printObjects(studentRoster);
		
		System.out.println("------------------------Sort by Id--------------------------");
		sortStudents(new IdComparator());
		printObjects(studentRoster);

		System.out.println("-------------------------Sort GPA---------------------------");
		sortStudents(new GpaComparator());
		printObjects(studentRoster);
		
		System.out.println("-----------------------Sort Last Name-----------------------");
		sortStudents(new LastNameComparator());
		printObjects(studentRoster);
		
	}

}

