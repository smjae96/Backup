package com.kh.hw.person.controller;

import com.kh.hw.person.model.vo.Employee;
import com.kh.hw.person.model.vo.Student;

public class PersonController {
	private Student[] s = new Student[3];
	private Employee[] e = new Employee[10];
	
	public int[] personCount() {
		int studentCount = 0;
		int employeeCount = 0;
		for(int i=0; i< s.length; i++) {
			if(s[i] != null) {
				studentCount++;
			}
		}
		for(int i=0; i<e.length; i++) {
			if(e[i] != null) {
				employeeCount++;
			}
		}
		int[] a = {studentCount, employeeCount};
		return a;
	}
	
	
	public void insertStudent(String name, int age, double height, double weight, 
								int grade, String major) {

//		s[0] = new Student(name, age, height, weight, grade, major);
//		s[1] = new Student(name, age, height, weight, grade, major);
//		s[2] = new Student(name, age, height, weight, grade, major);
		for(int i=0; i<s.length; i++) {
			if(s[i] == null) {
				s[i] = new Student(name, age, height, weight, grade, major);
				return;
			}
		}
	}
	
	public Student[] printStudent() {
		
		return s;
	}
	
	public void insertEmployee(String name, int age, double height, double weight,
								int salary, String dept) {
		for(int i=0; i<e.length; i++) {
			// e[i] 객체가 비어있는가?
			if(e[i] == null) { // e[i]가 비어 있을 때 값 null
				e[i] = new Employee(name, age, height, weight, salary, dept);
				return;
			}
		}
	}
	
	public Employee[] printEmployee() {
		return e;
	}
	
}	
