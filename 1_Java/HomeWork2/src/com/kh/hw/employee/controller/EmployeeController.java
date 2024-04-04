package com.kh.hw.employee.controller;

import com.kh.hw.employee.model.vo.Employee;

public class EmployeeController {
	
	private Employee e = new Employee();
	
	// 기본생성자 생략
	
	//메소드부
	public void add(int empNo, String name, char gender, String phone) {
		e.setEmpNo(empNo);
		e.setName(name);
		e.setGender(gender);
		e.setPhone(phone);
		
	}
	
	public void add(int empNo, String name, char gender, String phone, String dept, int salary, double bonus) {
		e.setEmpNo(empNo);
		e.setName(name);
		e.setGender(gender);
		e.setPhone(phone);
		e.setDept(dept);
		e.setSalary(salary);
		e.setBonus(bonus);
	
	}
	
	public void modify(String phone) {
		e.setPhone(phone);
		
	}
	
	public void modify(int salary) {
		e.setSalary(salary);
	}
	
	public void modify(double bonus) {
		e.setBonus(bonus);
	}
	
	public Employee remove() {
		e.setBonus(0);
		e.setDept(null);
		e.setEmpNo(0);
		e.setGender('0');
		e.setName(null);
		e.setPhone(null);
		e.setSalary(0);
		return e;
	}
	
	public String inform() {
		return String.format(e.printEmployee());
	}
}
