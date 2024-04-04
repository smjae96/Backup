package com.kh.practice.chap02;

import java.util.Scanner;

public class LoopPractice {
	Scanner sc = new Scanner(System.in);
	public void practice1() {
		//ȭ�鿡 "1�̻��� ���ڸ� �Է��ϼ��� : " ���
		System.out.print("1�̻��� ���ڸ� �Է��ϼ��� : ");
		int num = sc.nextInt(); // ������ �����͸� �Է¹޾� ������ ����
		
		//��, �Է��� ���� 1���� ũ�ų� ���ƾ� �մϴ�.
		if(num>=1) {
			// 1���� num���� ���ڸ� ���
			/*
			 for(int i=1; i<=num; i++) {
				System.out.print(i + " ");
			}
			*/
			for(int i=0; i<num; i++) {
				System.out.print((i+1) + " ");
			}
		}
		else {	//num < 1
			// "1�̸��� ���� �ԷµǾ����ϴ�." ���
			System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
		}
		
		/*if(num<1) {
			System.out.println("1�̸��� ���� �ԷµǾ����ϴ�.");
		}
		else { // num>=1
			//1���� num���� ���ڸ� ���
		}
		*/
	}
	
	public void practice2() {
		int num;
		 do {
			//------------------------------------
			//ȭ�鿡 "1�̻��� ���ڸ� �Է��ϼ��� : " ���
			System.out.print("1�̻��� ���ڸ� �Է��ϼ��� : ");
			num = sc.nextInt(); // ������ �����͸� �Է¹޾� ������ ����
		
			//��, �Է��� ���� 1���� ũ�ų� ���ƾ� �մϴ�.
			if(num>=1) {
				// 1���� num���� ���ڸ� ���
			
				for(int i=1; i<=num; i++) {
					System.out.print(i + " ");
				}
			
			}
			else {	//num < 1
				// "1 �̻��� ���ڸ� �Է����ּ���." ���
				System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
				//practice2();
			}	
			//------------------------------------------
		 }while(num<1);
	}
	
	public void practice3() {
		//����ڷκ��� �� ���� ���� �Է� �޾� 1���� �� ���ڱ����� ��� ���ڸ� �Ųٷ� ����ϼ���.
		//��, �Է��� ���� 1���� ũ�ų� ���ƾ� �մϴ�.
		
		System.out.print("1�̻��� ���ڸ� �Է��ϼ��� : ");
		int num = sc.nextInt();
		if(num>=1) {
			
			for(int i=num; i>=1; i--) {
				System.out.print(i + " ");
			}
		}
		else {
			System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
		}
		
	}
	
	public void practice4() {
		
		System.out.print("1�̻��� ���ڸ� �Է��ϼ��� : ");
		int num = sc.nextInt();
		if(num>=1) {
			
			for(int i=num; i>=1; i--) {
				System.out.print(i + " ");
			}
		}
		else {
			System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
			practice4();
		}
	}
	
	public void practice5() {
		System.out.print("������ �ϳ� �Է��ϼ��� : ");
		int num = sc.nextInt();
		int sum = 0;
		for(int i=1; i<=num; i++) {
			sum +=i;
			System.out.print(i);
			
			if(i==num) {
				continue;
			}
			else {
				System.out.print(" + ");
			}
		}
		System.out.println(" = " +sum);
	}
	
	public void practice6() {
		System.out.print("ù ��° ���� : ");
		int num1 = sc.nextInt();
		System.out.print("�� ��° ���� : ");
		int num2 = sc.nextInt();
		
		if(num1<1 || num2<1) {
			System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
		}
		else if(num1>=num2){
			for(int i=num2; i<=num1; i++) {
				System.out.print(i + " ");
			}
		}
		else {
			for(int i=num1; i<=num2; i++) {
				System.out.print(i + " ");
			}
		}
	}
	
	public void practice7() {
		System.out.print("ù ��° ���� : ");
		int num1 = sc.nextInt();
		System.out.print("�� ��° ���� : ");
		int num2 = sc.nextInt();
		
		if(num1<1 || num2<1) {
			System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
			practice7();
		}
		else if(num1>=num2){
			for(int i=num2; i<=num1; i++) {
				System.out.print(i + " ");
			}
		}
		else {
			for(int i=num1; i<=num2; i++) {
				System.out.print(i + " ");
			}
		}
	}
	
	public void practice8() {
		System.out.print("���� : ");
		int num = sc.nextInt();
		System.out.println("===== "+num+"�� =====");
		
		for(int i=1; i<10; i++) {
			System.out.println(num+" * " +i+ " = " +(num*i));
		}
	}
	
	public void practice9() {
		System.out.print("���� : ");
		int num = sc.nextInt();
		
		if(num>9) {
			System.out.println("9 ������ ���ڸ� �Է����ּ���.");
		}
		else {
			for(int j=num; j<10; j++) {
				System.out.println("===== " +j+"�� =====");
				for(int i=1; i<10; i++) {
					System.out.println(j+" * " +i+ " = " +(j*i));
				}
			}
		}
	}
	
	public void practice10() {
		System.out.print("���� : ");
		int num = sc.nextInt();
		
		if(num>9) {
			System.out.println("9 ������ ���ڸ� �Է����ּ���.");
			practice10();
		}
		else {
			for(int j=num; j<10; j++) {
				System.out.println("===== " +j+"�� =====");
				for(int i=1; i<10; i++) {
					System.out.println(j+" * " +i+ " = " +(j*i));
				}
			}
		}
	}
	
	public void practice11() {
		System.out.print("���� ���� : ");
		int startNum = sc.nextInt();
		System.out.print("���� : ");
		int tolerance = sc.nextInt();
		
		
		for(int i=0; i< 10; i++) {
			System.out.print(startNum + " ");
			startNum += tolerance;
			
		}
	}
	
	public void practice12() {
		while(true) {
			System.out.print("������(+, -, *, /, %) : ");
			String operator = sc.next();
		
			if(operator.equals("exit")) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
			System.out.print("����1 : ");
			int num1 = sc.nextInt();
			System.out.print("����2 : ");
			int num2 = sc.nextInt();
		
			if((operator.equals("/") && num2==0)) {
				System.out.println("0���� ���� �� �����ϴ�. �ٽ� �Է����ּ���.");
				practice12();
			}

			if(operator.equals("+")) {
				System.out.println(num1+ " + " + num2 + " = " + (num1+num2));
				break;
			}
			else if(operator.equals("-")) {
				System.out.println(num1+ " - " + num2 + " = " + (num1-num2));
				break;
			}	
			else if(operator.equals("*")) {
				System.out.println(num1+ " * " + num2 + " = " + (num1*num2));
				break;
			}
			else if(operator.equals("/")) {
				System.out.println(num1+ " / " + num2 + " = " + (num1/num2));
				break;
			}
			else if(operator.equals("%")) {
				System.out.println(num1+ " % " + num2 + " = " + (num1%num2));
				break;
			}
			else {
				System.out.println("���� �������Դϴ�. �ٽ� �Է����ּ���.");
				practice12();
			}
			
		}	

	}
	
	public void practice13() {
		System.out.print("���� �Է� : ");
		int num = sc.nextInt();
		
		int starCount = 1;
		int spaceCount = num-1;
		int lineCount = num;
		
		for(int i=0; i<lineCount; i++) {
			for(int j=0; j<starCount; j++) {
				System.out.print("*");
			}
			for(int j=0; j<spaceCount; j++) {
				System.out.print(" ");
			}
			spaceCount--;
			starCount++;
			System.out.println();
		}
	}
	
	public void practice14() {
		System.out.print("���� �Է� : ");
		int num = sc.nextInt();
		
		int starCount = num;
		int spaceCount = 0;
		int lineCount = num;
		
		for(int i=0; i<lineCount; i++) {
			for(int j=0; j<starCount; j++) {
				System.out.print("*");
			}
			for(int j=0; j<spaceCount; j++) {
				System.out.print(" ");
			}
			starCount--;
			spaceCount++;
			System.out.println();
		}
	}
}
