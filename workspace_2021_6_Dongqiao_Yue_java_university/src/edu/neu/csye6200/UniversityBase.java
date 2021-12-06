package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class UniversityBase extends AbstractSchoolAPI
{
	List<AbstractPersonAPI> employees = new ArrayList<>();
	List<AbstractPersonAPI> students = new ArrayList<>();
	
	@Override
	public void addEmployee(AbstractPersonAPI employee) {
		employees.add(employee);
	}

	@Override
	public void addStudent(AbstractPersonAPI student) {
		// TODO Auto-generated method stub
		students.add(student);
	}

	@Override
	public String getEmployeesInfo() {
		// TODO Auto-generated method stub
		String str = "";
		for (AbstractPersonAPI object : employees) {
			str += "Employee [Wage=" + object.getWage() + ", Id=" + object.getId() + ", Age=" + object.getAge() + ", FirstName=" + object.getFirstName() + ", LastName=" + object.getLastName() + "]\n";
		}
		
		return str;
	}

	@Override
	public void showEmployees() {
		// TODO Auto-generated method stub
		UniversityBase base = new UniversityBase();
		System.out.println(base.getEmployeesInfo());
	}

	@Override
	public String getStudentsInfo() {
		// TODO Auto-generated method stub
		String str = "";
		for (AbstractPersonAPI object : students) {
			str += "Student [GPA=" + object.getGpa() + ", Id=" + object.getId() + ", Age=" + object.getAge() + ", FirstName=" + object.getFirstName() + ", LastName=" + object.getLastName() + "]\n";
		}
		
		return str;
	}

	@Override
	public void showStudents() {
		// TODO Auto-generated method stub
		UniversityBase base = new UniversityBase();
		System.out.println(base.getStudentsInfo());
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		UniversityBase base = new UniversityBase();
		String str = base.getStudentsInfo() + base.getEmployeesInfo();
		System.out.println(str);
	}

	@Override
	public void sortEmployees(Comparator<AbstractPersonAPI> c) {
		// TODO Auto-generated method stub
		Collections.sort(employees, c);
	}

	@Override
	public void sortStudents(Comparator<AbstractPersonAPI> c) {
		// TODO Auto-generated method stub
		Collections.sort(students, c);
	}
	
}

class AgeComparator implements Comparator<AbstractPersonAPI> {
	
	@Override
	public int compare(AbstractPersonAPI a, AbstractPersonAPI b) {
		return a.getAge() < b.getAge() ? -1 : a.getAge() == b.getAge() ? 0 : 1;
	}
	
}


class IdComparator implements Comparator<AbstractPersonAPI> {
	
	@Override
	public int compare(AbstractPersonAPI a, AbstractPersonAPI b) {
		return a.getId() < b.getId() ? -1 : a.getId() == b.getId() ? 0 : 1;
	}
	
}


class LastNameComparator implements Comparator<AbstractPersonAPI> {
	
	@Override
	public int compare(AbstractPersonAPI a, AbstractPersonAPI b) {
		return a.getLastName().compareTo(b.getLastName());
	}
	
}

class FirstNameComparator implements Comparator<AbstractPersonAPI> {
	
	@Override
	public int compare(AbstractPersonAPI a, AbstractPersonAPI b) {
		return a.getFirstName().compareTo(b.getFirstName());
	}
	
}

class GPAComparator implements Comparator<AbstractPersonAPI> {
	
	@Override
	public int compare(AbstractPersonAPI a, AbstractPersonAPI b) {
		return a.getGpa() < b.getGpa() ? -1 : a.getGpa() == b.getGpa() ? 0 : 1;
	}
	
}

class WageComparator implements Comparator<AbstractPersonAPI> {
	
	@Override
	public int compare(AbstractPersonAPI a, AbstractPersonAPI b) {
		return a.getWage() < b.getWage() ? -1 : a.getWage() == b.getWage() ? 0 : 1;
	}
	
}

//------------------Show the state of NortheasternU object-------------------
//Employee [Wage=3500.0, Id=852, Age=28, FirstName=Sheng, LastName=Chen]
//Employee [Wage=3600.0, Id=741, Age=27, FirstName=Guang, LastName=Wu]
//Employee [Wage=3700.0, Id=963, Age=24, FirstName=Fei, LastName=Zhang]
//
//Student [GPA=3.91, Id=123, Age=17, FirstName=Yue, LastName=Dongqiao]
//Student [GPA=4.0, Id=456, Age=15, FirstName=Li, LastName=Zuyu]
//Student [GPA=3.9, Id=789, Age=25, FirstName=Fu, LastName=Hao]
//
//-------------------Sort Students by NATURAL ORDER----------------
//Student [GPA=3.91, Id=123, Age=17, FirstName=Yue, LastName=Dongqiao]
//Student [GPA=4.0, Id=456, Age=15, FirstName=Li, LastName=Zuyu]
//Student [GPA=3.9, Id=789, Age=25, FirstName=Fu, LastName=Hao]
//
//------------------Sort Employees by NATURAL ORDER----------------
//Employee [Wage=3500.0, Id=852, Age=28, FirstName=Sheng, LastName=Chen]
//Employee [Wage=3600.0, Id=741, Age=27, FirstName=Guang, LastName=Wu]
//Employee [Wage=3700.0, Id=963, Age=24, FirstName=Fei, LastName=Zhang]
//
//------------------------Sort by Age-------------------------
//Student [GPA=4.0, Id=456, Age=15, FirstName=Li, LastName=Zuyu]
//Student [GPA=3.91, Id=123, Age=17, FirstName=Yue, LastName=Dongqiao]
//Student [GPA=3.9, Id=789, Age=25, FirstName=Fu, LastName=Hao]
//
//Employee [Wage=3700.0, Id=963, Age=24, FirstName=Fei, LastName=Zhang]
//Employee [Wage=3600.0, Id=741, Age=27, FirstName=Guang, LastName=Wu]
//Employee [Wage=3500.0, Id=852, Age=28, FirstName=Sheng, LastName=Chen]
//
//------------------------Sort by Id--------------------------
//Student [GPA=3.91, Id=123, Age=17, FirstName=Yue, LastName=Dongqiao]
//Student [GPA=4.0, Id=456, Age=15, FirstName=Li, LastName=Zuyu]
//Student [GPA=3.9, Id=789, Age=25, FirstName=Fu, LastName=Hao]
//
//Employee [Wage=3600.0, Id=741, Age=27, FirstName=Guang, LastName=Wu]
//Employee [Wage=3500.0, Id=852, Age=28, FirstName=Sheng, LastName=Chen]
//Employee [Wage=3700.0, Id=963, Age=24, FirstName=Fei, LastName=Zhang]
//
//-------------------------Sort Last Name---------------------------
//Student [GPA=3.91, Id=123, Age=17, FirstName=Yue, LastName=Dongqiao]
//Student [GPA=3.9, Id=789, Age=25, FirstName=Fu, LastName=Hao]
//Student [GPA=4.0, Id=456, Age=15, FirstName=Li, LastName=Zuyu]
//
//Employee [Wage=3500.0, Id=852, Age=28, FirstName=Sheng, LastName=Chen]
//Employee [Wage=3600.0, Id=741, Age=27, FirstName=Guang, LastName=Wu]
//Employee [Wage=3700.0, Id=963, Age=24, FirstName=Fei, LastName=Zhang]
//
//-----------------------Sort First Name-----------------------
//Student [GPA=3.9, Id=789, Age=25, FirstName=Fu, LastName=Hao]
//Student [GPA=4.0, Id=456, Age=15, FirstName=Li, LastName=Zuyu]
//Student [GPA=3.91, Id=123, Age=17, FirstName=Yue, LastName=Dongqiao]
//
//Employee [Wage=3700.0, Id=963, Age=24, FirstName=Fei, LastName=Zhang]
//Employee [Wage=3600.0, Id=741, Age=27, FirstName=Guang, LastName=Wu]
//Employee [Wage=3500.0, Id=852, Age=28, FirstName=Sheng, LastName=Chen]
//
//-----------------------Sort GPA-----------------------
//Student [GPA=3.9, Id=789, Age=25, FirstName=Fu, LastName=Hao]
//Student [GPA=4.0, Id=456, Age=15, FirstName=Li, LastName=Zuyu]
//Student [GPA=3.91, Id=123, Age=17, FirstName=Yue, LastName=Dongqiao]
//
//-----------------------Sort Wage-----------------------
//Employee [Wage=3700.0, Id=963, Age=24, FirstName=Fei, LastName=Zhang]
//Employee [Wage=3600.0, Id=741, Age=27, FirstName=Guang, LastName=Wu]
//Employee [Wage=3500.0, Id=852, Age=28, FirstName=Sheng, LastName=Chen]
//
