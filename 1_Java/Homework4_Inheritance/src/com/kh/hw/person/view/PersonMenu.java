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
			System.out.println("�л��� �ִ� 3����� ������ �� �ֽ��ϴ�.");
			System.out.println("���� ����� �л��� " + count[0] + "���Դϴ�.");
			System.out.println("����� �ִ� 10����� ������ �� �ֽ��ϴ�.");
			System.out.println("���� ����� ����� " + count[1] + "���Դϴ�.");
			System.out.println();
			
			System.out.println("1. �л� �޴�");
			System.out.println("2. ��� �޴�");
			System.out.println("9. ������");
			System.out.print("�޴� ��ȣ : ");
			int num = sc.nextInt();
			if(num==1) {
				studentMenu();
			}
			else if(num==2) {
				employeeMenu();
			}
			else if(num==9) {
				System.out.println("�����մϴ�.");
				return;
			}
			else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}

	}
	
	public void studentMenu() {
		int[] sCount = pc.personCount();
		System.out.println("1. �л� �߰�");
		System.out.println("2. �л� ����");
		System.out.println("9. ��������");
		if(sCount[0]==3) {
			System.out.println("�л��� ���� �� �ִ� ������ �� á�� ������ �л� �߰� �޴��� �� �̻� Ȱ��ȭ ���� �ʽ��ϴ�.");
		}
		System.out.print("�޴� ��ȣ : ");
		int num = sc.nextInt();

		if(sCount[0]==3) {
			if(num == 1) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
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
			System.out.println("�������� ���ư��ϴ�.");
			mainMenu();
		}
		else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			studentMenu();
		}
	}
	
	public void employeeMenu() {
		int[] eCount = pc.personCount();
		System.out.println("1. ��� �߰�");
		System.out.println("2. ��� ����");
		System.out.println("9. ��������");
		if(eCount[1]==10) {
			System.out.println("����� ���� �� �ִ� ������ �� á�� ������ ��� �߰� �޴��� �� �̻� Ȱ��ȭ ���� �ʽ��ϴ�.");
		}
		System.out.print("�޴� ��ȣ : ");
		int num = sc.nextInt();

		if(eCount[0]==10) {
			if(num == 1) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
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
			System.out.println("�������� ���ư��ϴ�.");
			mainMenu();
		}
		else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			employeeMenu();
		}
	}
	
	public void insertStudent() {
		
		System.out.print("�л� �̸� : ");
		String name = sc.next();
		System.out.print("�л� ���� : ");
		int age = sc.nextInt();
		System.out.print("�л� Ű : ");
		double height = sc.nextDouble();
		System.out.print("�л� ������ : ");
		double weight = sc.nextDouble();
		System.out.print("�л� �г� : ");
		int grade = sc.nextInt();
		System.out.print("�л� ���� : ");
		String subject = sc.next();
		
		
		pc.insertStudent(name, age, height, weight, grade, subject);
		
		
//		sCount[0]++;
		int[] sCount = pc.personCount();
		
		if(sCount[0]==3) {
			System.out.println("�л��� ���� �� �ִ� ������ �� á�� ������ �л� �߰��� �����ϰ� �л� �޴��� ���ư��ϴ�.");
			System.out.println();
			studentMenu();
		}
		else {
			System.out.print("�׸��Ͻ÷��� N(�Ǵ� n), �̾��Ͻ÷��� �ƹ� Ű�� �������� : ");
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
		System.out.print("��� �̸� : ");
		String name = sc.next();
		System.out.print("��� ���� : ");
		int age = sc.nextInt();
		System.out.print("��� Ű : ");
		double height = sc.nextDouble();
		System.out.print("��� ������ : ");
		double weight = sc.nextDouble();
		System.out.print("��� �޿� : ");
		int salary = sc.nextInt();
		System.out.print("��� �μ� : ");
		String dept = sc.next();
		pc.insertEmployee(name, age, height, weight, salary, dept);
		eCount[1]++;
		if(eCount[1]==10) {
			System.out.println("����� ���� �� �ִ� ������ �� á�� ������ ��� �߰��� �����ϰ� ��� �޴��� ���ư��ϴ�.");
			System.out.println();
			studentMenu();
		}
		else {
			System.out.print("�׸��Ͻ÷��� N(�Ǵ� n), �̾��Ͻ÷��� �ƹ� Ű�� �������� : ");
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
