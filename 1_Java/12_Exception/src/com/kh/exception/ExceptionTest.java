package com.kh.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {
	public static void main(String[] args) {
		System.out.println("===== ���α׷��� �����մϴ�. =====");
		
		arithmeticTest();
		
		inputMismatchTest();
		
		try {
			System.out.println("[1]");
			nullPointerTest();				// �ٷ� catch������
			System.out.println("[2]");		// ���� �߻��� ���� �� ��� �ȵ�.
		} catch(NullPointerException e) {
			System.out.println("NullPointerException ����");
		}
		//	����� ���� ���� �׽�Ʈ ------------------
		try {
			customExceptionTest();
		} catch(Exception e) {
			System.out.println(e);
			System.out.println("CustomException �����Դϴ�.");
		}
		
		
		System.out.println("===== ���α׷��� �����մϴ�. =====");
	}
	
	public static void arithmeticTest() {
		// ArithmeticException : ������� ����Ŭ����
		int n1 = 10;
		int n2 = 0;
		
		// 1) if ��(���ǹ�) ����Ͽ� ����ó��
//		if (n2 > 0) {
//			System.out.println(n1/n2);
//		} else {
//			System.out.println("0���� ���� �� �����ϴ�.");
//		}
		// 2) try ~ catch ��
		try {
			System.out.println(n1 / n2);
		} catch(ArithmeticException e) {
			System.out.println("ArithmeticException �����Դϴ�.");
		}
	}
	
	public static void inputMismatchTest() {
		// InputMismatchException : �Է��� �߸��� ��� ���� Ŭ����
		Scanner sc = new Scanner(System.in);
		System.out.print("�ڿ����� �Է��ϼ��� : ");
		
		try{
			int num = sc.nextInt();
			if(num<1) {
				//System.out.println("�ڿ����� �ƴ� ������ �Է��ϼ̽��ϴ�.");
				throw new InputMismatchException();	// ���ܸ� �߻���Ű�� throw new ����Ŭ����������();
			}
			System.out.println("�Է��� ���� " +num+ "�Դϴ�.");
			
		} catch(InputMismatchException e){
			System.out.println("InputMismatchException �����Դϴ�.");
		} 
	}
	public static void nullPointerTest() throws NullPointerException{
		//NullPointerException : null ���� ���� Ŭ���� (�������� ���� ��ü���� ���� ��..)
		String name = null;
		
		System.out.println(name);	// name.toString() 
									// toString() : Object Ŭ���� �޼ҵ�. Ŭ���� ������ �ؽ���(�ּҰ�)�� ��ȯ
									// String Ŭ���� �������� ��� �� ����� ���� ��µ� => �������̵�..
		//1.  try ~ catch �� ���
//		try {
//			System.out.println("name ������ ���̴� " + name.length() + "�Դϴ�.");
//		} catch(NullPointerException e) {
//			System.out.println("NullPointerException �����Դϴ�.");
//		}
		
		//2. thorws ���
		System.out.println("(3)");
		System.out.println("name ������ ���̴� " +name.length() + "�Դϴ�.");			// ���� �߻� throws
		System.out.println("(4)");	// ���� �߻��� ���� �� ��� �ȵ�.
		
	}
	
	public static void customExceptionTest() throws CustomException{
		// CustomException ���� �߻�	: throw new ����Ŭ����������;
		
		throw new CustomException("���� ���� ����! ");
	}
}
