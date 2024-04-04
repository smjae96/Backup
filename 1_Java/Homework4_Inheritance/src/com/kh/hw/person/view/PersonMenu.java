package com.kh.hw.person.view;

import java.util.Scanner;

import com.kh.hw.person.controller.PersonController;
import com.kh.hw.person.model.vo.Employee;
import com.kh.hw.person.model.vo.Student;

public class PersonMenu {
	private Scanner sc = new Scanner(System.in);
	private PersonController pc = new PersonController();
	
	public void mainMenu() {
		int[] count = pc.personCount();
		while(true) {
			System.out.println("학생은 최대 3명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 학생은 " + count[0] + "명입니다.");
			System.out.println("사원은 최대 10명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 사원은 " + count[1] + "명입니다.");
			System.out.println();
			
			System.out.println("1. 학생 메뉴");
			System.out.println("2. 사원 메뉴");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int num = sc.nextInt();
			if(num==1) {
				studentMenu();
			}
			else if(num==2) {
				employeeMenu();
			}
			else if(num==9) {
				System.out.println("종료합니다.");
				return;
			}
			else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}

	}
	
	public void studentMenu() {
		int[] sCount = pc.personCount();
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 보기");
		System.out.println("9. 메인으로");
		if(sCount[0]==3) {
			System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가 메뉴는 더 이상 활성화 되지 않습니다.");
		}
		System.out.print("메뉴 번호 : ");
		int num = sc.nextInt();

		if(sCount[0]==3) {
			if(num == 1) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				studentMenu();
			}
		}
		if(num==1) {
			System.out.println();
			insertStudent();
		}
		else if(num==2) {
			System.out.println();
			printStudent();
		}
		else if(num==9) {
			System.out.println("메인으로 돌아갑니다.");
			mainMenu();
		}
		else {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			studentMenu();
		}
	}
	
	public void employeeMenu() {
		int[] eCount = pc.personCount();
		System.out.println("1. 사원 추가");
		System.out.println("2. 사원 보기");
		System.out.println("9. 메인으로");
		if(eCount[1]==10) {
			System.out.println("사원을 담을 수 있는 공간이 꽉 찼기 때문에 사원 추가 메뉴는 더 이상 활성화 되지 않습니다.");
		}
		System.out.print("메뉴 번호 : ");
		int num = sc.nextInt();

		if(eCount[0]==10) {
			if(num == 1) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				employeeMenu();
			}
		}
		if(num==1) {
			System.out.println();
			insertEmployee();
		}
		else if(num==2) {
			System.out.println();
			printEmployee();
		}
		else if(num==9) {
			System.out.println("메인으로 돌아갑니다.");
			mainMenu();
		}
		else {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			employeeMenu();
		}
	}
	
	public void insertStudent() {
		
		System.out.print("학생 이름 : ");
		String name = sc.next();
		System.out.print("학생 나이 : ");
		int age = sc.nextInt();
		System.out.print("학생 키 : ");
		double height = sc.nextDouble();
		System.out.print("학생 몸무게 : ");
		double weight = sc.nextDouble();
		System.out.print("학생 학년 : ");
		int grade = sc.nextInt();
		System.out.print("학생 전공 : ");
		String subject = sc.next();
		
		
		pc.insertStudent(name, age, height, weight, grade, subject);
		
		
//		sCount[0]++;
		int[] sCount = pc.personCount();
		
		if(sCount[0]==3) {
			System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가를 종료하고 학생 메뉴로 돌아갑니다.");
			System.out.println();
			studentMenu();
		}
		else {
			System.out.print("그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
			String any = sc.next();
			if(any.equals("N") || any.equals("n")) {
				studentMenu();
			}
			else {
				insertStudent();
			}
		}
	}
	
	public void printStudent() {
		Student[] sd = pc.printStudent();
		for(int i=0; i<sd.length; i++) {
			if(sd[i] != null) {
				System.out.println(sd[i]);
			}
			else {
				System.out.println("");
			}
		}
		System.out.println();
		this.studentMenu();
	}
	
	public void insertEmployee() {
		int[] eCount = pc.personCount();
		System.out.print("사원 이름 : ");
		String name = sc.next();
		System.out.print("사원 나이 : ");
		int age = sc.nextInt();
		System.out.print("사원 키 : ");
		double height = sc.nextDouble();
		System.out.print("사원 몸무게 : ");
		double weight = sc.nextDouble();
		System.out.print("사원 급여 : ");
		int salary = sc.nextInt();
		System.out.print("사원 부서 : ");
		String dept = sc.next();
		pc.insertEmployee(name, age, height, weight, salary, dept);
		eCount[1]++;
		if(eCount[1]==10) {
			System.out.println("사원을 담을 수 있는 공간이 꽉 찼기 때문에 사원 추가를 종료하고 사원 메뉴로 돌아갑니다.");
			System.out.println();
			studentMenu();
		}
		else {
			System.out.print("그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
			String any = sc.next();
			if(any.equals("N") || any.equals("n")) {
				employeeMenu();
			}
			else {
				insertEmployee();
			}
		}
		
	}
	
	public void printEmployee() {
		Employee[] eo = pc.printEmployee();
		for(int i=0; i<eo.length; i++) {
			if(eo[i]!= null) {
				System.out.println(eo[i]);
			}
			else {
				System.out.println("");
			}
		}
		employeeMenu();
	}
}
