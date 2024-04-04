package com.kh.hw.employee.run;

import com.kh.hw.employee.view.EmployeeMenu;

public class Run {

	public static void main(String[] args) {

	//	EmployeeMenu em = new EmployeeMenu();
		
		char ch = 'a';
		System.out.println(Character.isUpperCase(ch));
		String result = Character.isUpperCase(ch) ? "대문자입니다." : "대문자가 아닙니다.";
		System.out.println(result);
		System.out.println(Character.toUpperCase(ch));
		java.util.Scanner sc = new java.util.Scanner(System.in);
		String result2 = ch>='A' && ch<='Z' ? "대문자입니다." : "대문자가 아닙니다.";
		System.out.println(result2);
				
	}

}
