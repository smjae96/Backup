package com.kh.hw.employee.view;

import java.util.Scanner;

import com.kh.hw.employee.controller.EmployeeController;

public class EmployeeMenu {
	private Scanner sc = new Scanner(System.in);
	
	private EmployeeController ec = new EmployeeController();
	
	//생성자부
	public EmployeeMenu() {
		while(true) {
			System.out.println("1. 사원 추가");
			System.out.println("2. 사원 수정");
			System.out.println("3. 사원 삭제");
			System.out.println("4. 사원 출력");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호를 누르세요 : ");
			int num = sc.nextInt();
			if(num == 1) {
				insertEmp();
				
			}
			else if(num ==2) {
				updateEmp();
				
			}
			else if(num ==3) {
				deleteEmp();
				
			}
			else if(num ==4) {
				printEmp();
				
			}
			else if(num ==9) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}	
	}
	//메소드부
	public void insertEmp() {
		System.out.print("사원 번호 : ");
		int num = sc.nextInt();
		System.out.print("사원 이름 : ");
		String name = sc.next();
		System.out.print("사원 성별 : ");
		char gender = sc.next().charAt(0);
		System.out.print("전화 번호 :");
		String phone = sc.next();
		ec.add(num, name, gender, phone);
		System.out.print("추가 정보를 더 입력하시겠습니까?(y/n) : ");
		char yes = sc.next().charAt(0);
		if(yes == 'n' || yes == 'N' ) {
			ec.add(num, name, gender, phone);
			
		}
		else if( yes == 'y' || yes == 'Y') {
			System.out.print("사원 부서 : ");
			String dept = sc.next();
			System.out.print("사원 연봉 : ");
			int salary = sc.nextInt();
			System.out.print("보너스 율 : ");
			double bonus = sc.nextDouble();
			ec.add(num, name, gender, phone, dept, salary, bonus);
		}
		
	}
	public void updateEmp() {
		System.out.println("가장 최신의 사원 정보를 수정하게 됩니다.");
		System.out.println("사원의 어떤 정보를 수정하시겠습니까?");
		System.out.println("1. 전화 번호");
		System.out.println("2. 사원 연봉");
		System.out.println("3. 보너스 율");
		System.out.println("9. 돌아가기");
		System.out.print("메뉴 번호를 누르세요 : ");
		int num = sc.nextInt();
		if(num ==1) {
			System.out.print("수정할 전화 번호 : ");
			String phone = sc.next();
			ec.modify(phone);
		}
		if(num ==2) {
			System.out.print("수정할 사원 연봉 : ");
			int salary = sc.nextInt();
			ec.modify(salary);
		}
		if(num ==3) {
			System.out.print("수정할 보너스율 : ");
			double bonus = sc.nextDouble();
			ec.modify(bonus);
		}
	}
	public void deleteEmp() {
		System.out.print("정말 삭제하시겠습니까? (y/n) : ");
		char yn = sc.next().charAt(0);
		if(yn == 'y' || yn == 'Y') {
			ec.remove();
			System.out.println("데이터 삭제에 성공하였습니다.");
		}
		else {
			
		}
		
		
	}
	public void printEmp() {
		System.out.println(ec.inform());
		
	}
}
