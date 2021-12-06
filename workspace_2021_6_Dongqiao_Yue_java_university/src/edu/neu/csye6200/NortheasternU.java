package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NortheasternU extends UniversityBase
{
	public void Demo() {
		
		Student stu1 = new Student(123, 17, "Yue", "Dongqiao", 3.91f);
		Student stu2 = new Student(456, 15, "Li", "Zuyu", 4.0f);
		Student stu3 = new Student(789, 25, "Fu", "Hao", 3.90f);
		
		Employee emp1 = new Employee(852, "Sheng", "Chen", 28, 3500);
		Employee emp2 = new Employee(741, "Guang", "Wu", 27, 3600);
		Employee emp3 = new Employee(963, "Fei", "Zhang", 24, 3700);
		
		NortheasternU northeastern = new NortheasternU();
		UniversityBase university = new UniversityBase();
		
		northeastern.addStudent(stu1);
		northeastern.addStudent(stu2);
		northeastern.addStudent(stu3);
		northeastern.addEmployee(emp1);
		northeastern.addEmployee(emp2);
		northeastern.addEmployee(emp3);
		
		System.out.println("------------------Show the state of NortheasternU object-------------------");
		System.out.println(northeastern.getEmployeesInfo());
		System.out.println(northeastern.getStudentsInfo());
		
		System.out.println("-------------------Sort Students by NATURAL ORDER----------------");
		Collections.sort(university.students);
		System.out.println(northeastern.getStudentsInfo());
		
		System.out.println("------------------Sort Employees by NATURAL ORDER----------------");
		Collections.sort(university.employees);
		System.out.println(northeastern.getEmployeesInfo());
		
		System.out.println("------------------------Sort by Age-------------------------");
		northeastern.sortStudents(new AgeComparator());
		northeastern.sortEmployees(new AgeComparator());
		System.out.println(northeastern.getStudentsInfo());
		System.out.println(northeastern.getEmployeesInfo());
		
		System.out.println("------------------------Sort by Id--------------------------");
		northeastern.sortStudents(new IdComparator());
		northeastern.sortEmployees(new IdComparator());
		System.out.println(northeastern.getStudentsInfo());
		System.out.println(northeastern.getEmployeesInfo());
		
		System.out.println("-------------------------Sort Last Name---------------------------");
		northeastern.sortStudents(new LastNameComparator());
		northeastern.sortEmployees(new LastNameComparator());
		System.out.println(northeastern.getStudentsInfo());
		System.out.println(northeastern.getEmployeesInfo());
		
		System.out.println("-----------------------Sort First Name-----------------------");
		northeastern.sortStudents(new FirstNameComparator());
		northeastern.sortEmployees(new FirstNameComparator());
		System.out.println(northeastern.getStudentsInfo());
		System.out.println(northeastern.getEmployeesInfo());
		
		System.out.println("-----------------------Sort GPA-----------------------");
		northeastern.sortStudents(new FirstNameComparator());
		System.out.println(northeastern.getStudentsInfo());
		
		System.out.println("-----------------------Sort Wage-----------------------");
		northeastern.sortEmployees(new FirstNameComparator());
		System.out.println(northeastern.getEmployeesInfo());
		
		
	}
}
