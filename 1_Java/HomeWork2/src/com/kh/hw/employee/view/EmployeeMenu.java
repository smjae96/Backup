package com.kh.hw.employee.view;

import java.util.Scanner;

import com.kh.hw.employee.controller.EmployeeController;

public class EmployeeMenu {
	private Scanner sc = new Scanner(System.in);
	
	private EmployeeController ec = new EmployeeController();
	
	//�����ں�
	public EmployeeMenu() {
		while(true) {
			System.out.println("1. ��� �߰�");
			System.out.println("2. ��� ����");
			System.out.println("3. ��� ����");
			System.out.println("4. ��� ���");
			System.out.println("9. ���α׷� ����");
			System.out.print("�޴� ��ȣ�� �������� : ");
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
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
		}	
	}
	//�޼ҵ��
	public void insertEmp() {
		System.out.print("��� ��ȣ : ");
		int num = sc.nextInt();
		System.out.print("��� �̸� : ");
		String name = sc.next();
		System.out.print("��� ���� : ");
		char gender = sc.next().charAt(0);
		System.out.print("��ȭ ��ȣ :");
		String phone = sc.next();
		ec.add(num, name, gender, phone);
		System.out.print("�߰� ������ �� �Է��Ͻðڽ��ϱ�?(y/n) : ");
		char yes = sc.next().charAt(0);
		if(yes == 'n' || yes == 'N' ) {
			ec.add(num, name, gender, phone);
			
		}
		else if( yes == 'y' || yes == 'Y') {
			System.out.print("��� �μ� : ");
			String dept = sc.next();
			System.out.print("��� ���� : ");
			int salary = sc.nextInt();
			System.out.print("���ʽ� �� : ");
			double bonus = sc.nextDouble();
			ec.add(num, name, gender, phone, dept, salary, bonus);
		}
		
	}
	public void updateEmp() {
		System.out.println("���� �ֽ��� ��� ������ �����ϰ� �˴ϴ�.");
		System.out.println("����� � ������ �����Ͻðڽ��ϱ�?");
		System.out.println("1. ��ȭ ��ȣ");
		System.out.println("2. ��� ����");
		System.out.println("3. ���ʽ� ��");
		System.out.println("9. ���ư���");
		System.out.print("�޴� ��ȣ�� �������� : ");
		int num = sc.nextInt();
		if(num ==1) {
			System.out.print("������ ��ȭ ��ȣ : ");
			String phone = sc.next();
			ec.modify(phone);
		}
		if(num ==2) {
			System.out.print("������ ��� ���� : ");
			int salary = sc.nextInt();
			ec.modify(salary);
		}
		if(num ==3) {
			System.out.print("������ ���ʽ��� : ");
			double bonus = sc.nextDouble();
			ec.modify(bonus);
		}
	}
	public void deleteEmp() {
		System.out.print("���� �����Ͻðڽ��ϱ�? (y/n) : ");
		char yn = sc.next().charAt(0);
		if(yn == 'y' || yn == 'Y') {
			ec.remove();
			System.out.println("������ ������ �����Ͽ����ϴ�.");
		}
		else {
			
		}
		
		
	}
	public void printEmp() {
		System.out.println(ec.inform());
		
	}
}
