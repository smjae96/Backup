package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice1 {

	// �̸�, ����, ����, Ű�� ����ڿ��� �Է� �޾� ������ ���� ������ ��� ����ϼ���.
	//ex. �̸��� �Է��ϼ���: �ƹ���
	//	  ������ �Է��ϼ���(��/��): ��
	// 	  ���̸� �Է��ϼ���: 20
	// 	  Ű�� �Է��ϼ���(cm): 180.5
	
	public void example1() { 
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸��� �Է��ϼ���: ");
		String name = sc.nextLine(); // nextLine : ���ڿ��� �Է¹޴� �޼ҵ�
		System.out.print("������ �Է��ϼ���(��/��): ");
		// '��' , '��'
		// "����" -> '��' , '��'
		// "��", "��" -> '��', '��'
		String strGender = sc.next(); // next : ���ڿ��� �Է¹޴� �޼ҵ�, ���� ������
		char gender = strGender.charAt(0); // charAt(index) : ���ڿ����� index ��ġ�� ���� ���������� ������ ���� �޼ҵ�
		//sc.next().charAt(0); ���� �ᵵ �ȴ�.
		System.out.print("���̸� �Է��ϼ���: ");
		int age = sc.nextInt();
		System.out.print("Ű�� �Է��ϼ���(cm): ");
		double height = sc.nextDouble();
		System.out.println("Ű " + height + "cm�� " + age + "�� " + gender + "�� " + name + "�� �ݰ����ϴ�^^");
		System.out.printf("Ű %.1fcm�� %d�� %c�� %s�� �ݰ����ϴ�^^" , height, age, gender, name);
	}
	
	
	
	
}
