package com.kh.example.practice7.run;

import com.kh.example.practice7.model.vo.Employee;

public class Run {

	public static void main(String[] args) {
		Employee emp = new Employee();
		
		emp.setEmpNo(100);
		emp.setEmpName("홍길동");
		emp.setDept("영업부");
		emp.setJob("과장");
		emp.setAge(25);
		emp.setGender('남');
		emp.setSalary(2500000);
		emp.setBonusPoint(0.05);
		emp.setPhone("010-1234-5678");
		emp.setAddress("서울시 강남구");
		
		System.out.printf("empNo : %d, empName : %s, dept : %s\n, job : %s, age : %d, gender : %c\n, salary : %d, bonusPoint : %f\n, phone : %s, address : %s" ,emp.getEmpNo(), emp.getEmpName(), emp.getDept(), emp.getJob(), emp.getAge(), emp.getGender(), emp.getSalary(), emp.getBonusPoint(), emp.getPhone(), emp.getAddress());
		
	}

}
