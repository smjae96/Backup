package com.kh.practice1.func;

import java.util.Calendar;
import java.util.Scanner;

public class VariablePractice0 {
	Scanner sc = new Scanner(System.in);
	/*
	 *  ���� 1)
	 *  ������ ����Ͽ� �Ʒ� �ڵ带 �����ϱ� ������ ��������.
	 *  - ������ �ش��ϴ� ���� ������(int) Ÿ���� year�̶�� �̸��� ������ ���� �� ����.
	 *  - ���̿� �ش��ϴ� ���� ������(int) Ÿ���� age��� �̸��� ������ ���� �� ����.
	 */
	
	public void example01() {
		// ������ ������� ���� ���
		System.out.println("[1]���� 2023���̰�, ���� ���� 36���Դϴ�.");
		
		// ���� ���� �� ����
		int year = 2023; // year ������ ���� ���� �� 2023 ���� ����
		int age = 36;	// age ������ ���� ���� �� 36 ���� ����
		// ������ ����Ͽ� ȭ�鿡 ���
		//1) System.out.print([����� ��(���ڿ�, ����, )]);
		System.out.print("[2]���� " + year + "���̰�, " +"���� ���� " + age + "���Դϴ�.");
		//2) System.out.println([����� ��(���ڿ�, ����, )]);
		System.out.println("[3]���� " + year + "���̰�, " +"���� ���� " + age + "���Դϴ�.");
		//3) System.out.printf("����� ����(���þ�1, ���þ�2, ...)" , ����1, ����2, ...);
		System.out.printf("[4]���� %d���̰�, ���� ���� %d���Դϴ�.", year, age);
		// ���� ������ ������ ���� ���ؿ� ������ ���̷� �����Ͽ� ���
		year = 2024;
		age = 28;
		System.out.println("[5]���� " + year + "���̰�, " +"���� ���� " + age + "���Դϴ�.");
		// ���� ������ ������ ���� ���� ����⵵�� ������ �� ���̷� �����Ͽ� ���
		year = 1996;
		age = 27;
		System.out.println("���� " + year + "����̰�, " + "���� �� " + age + "���Դϴ�." );
	}
	
	/*
	 * ���� 2) ������ ��� ��Ģ
	 * �߸� ���ǵ� ���� �̸��� Ȯ���Ͽ� �ּ��� ��ȣ �ȿ� ����Ģ �� � �κп� �ش��ϴ� ��
	 * ������ �� ������ �߻����� �ʵ��� �����غ���.
	 * [������ ��� ��Ģ]
	 * (1) ��ҹ��ڰ� ���еȴ�.
	 * (2) ���� ����� �� ����.
	 * (3) ���ڷ� ������ �� ����.
	 * (4) Ư������ '_'�� '$'�� ��� �����ϴ�.
	 * (5) ��Ÿǥ��� ����Ѵ�.
	 */
	public void example02() {
		// [1] ������ ��Ģ (3	) �ش�
		//int 1num = 10; -> ������ ���ڷ� ������ �� �����Ƿ� �������� num���� �������ش�.
		int num = 10;
		//System.out.println("1num�� ���� " + 1num + "�Դϴ�."); -> ���������� �������� 1num�� �ƴ� num���� �������ش�.
		System.out.println("[1]num�� ���� " + num + "�Դϴ�.");
		
		// [2] ������ ��Ģ (2	) �ش�
		//boolean break = true; -> break�� ������̹Ƿ� ���������� ����� �� ����. ���� �������� breaker�� �������ش�.
		boolean breaker = true;
		//System.out.printf("break�� ���� %b �Դϴ�." , break); -> ���������� �������� break�� �ƴ� breaker�� �������ش�.
		System.out.printf("[2]breaker�� ���� %b �Դϴ�." , breaker);
		
		// [3] ������ ��Ģ (1	) �ش�
		int age;
		int Age = 15;
		age = 20;
		System.out.printf("[3]���̿� �ش��ϴ� ���� �� Ȯ�� > %d, %d\n", age , Age);
		// ���� ��� ��� ? 
		// ���̿� �ش��ϴ� ���� �� Ȯ�� > 20, 15   <- ó�� �ֿܼ� ��µ� ���̴�.
		// ������ ��ҹ��ڸ� �����ϱ� ������ age��� ���������� ����� ������ Age��� ���������� ����� ������ ���� �ٸ� �����̴�.
		
		// [4] ������ ��Ģ (4	) �ش�
		// int d-day = 5; -> ������ ��� ������ Ư�����ڴ� '_'�� '$'���̴�. ���� '-'�� ������ �� �� ����.
		int d_day = 5; // ������ ��� ������ Ư������ '_'�� �������־���.
		//System.out.println("ũ������������ " + d-day + "�� ���ҽ��ϴ�."); -> ���������� �������� d-day�� �ƴ� d_day�� �������־�� �Ѵ�.
		System.out.println("[4]ũ������������ " + d_day + "�� ���ҽ��ϴ�.");
	}
	
	public void example02p1() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		cal2.get(Calendar.MONTH);
		cal2.set(Calendar.DATE, 25);
		
		int today = cal1.get(Calendar.DAY_OF_MONTH);
		int christmas = cal2.get(Calendar.DAY_OF_MONTH);
		
		int d_day = christmas - today;
		System.out.println("ũ������������ " + d_day + "�� ���ҽ��ϴ�.");
	}
	// 12�� 31�� ��¥�� ������ �ϳ� �� �������༭ ����� �غ���.
	public void example02p2() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		cal2.set(Calendar.YEAR, 2024);
		cal2.set(Calendar.MONTH, Calendar.DECEMBER);
		cal2.set(Calendar.DATE, 25);
		
		int today = cal1.get(Calendar.DAY_OF_YEAR);
		int christmas = cal2.get(Calendar.DAY_OF_YEAR);
		
		int d_day = christmas - today;
		System.out.println(christmas + ", " + today);
		System.out.println("���� ũ������������ " +d_day+ "�� ���ҽ��ϴ�.");
	}
	/*
	 * ���� 3) 
	 * 	Ű�� ������ ���� �����ϱ� ���� ���� Ű�� double���� height��� �̸�����,
	 * 	�����Դ� int���� weight��� �̸����� ������ ����.
	 * 
	 * 	���� ���ϴ� Ű�� �������� ���� ������ ����.
	 * 
	 * 	�Ʒ��� ���� ����غ���.
	 * 	��� ����) "���� ���ϴ� Ű�� 168.2cm�̰�, �����Դ� 48kg�Դϴ�."
	 */
	public void example03() {
		// ���� ����
		double height;
		int weight;
		height = 177.3;
		weight = 65;
		System.out.println("[1]���� ���ϴ� Ű�� " + height + "cm�̰�, �����Դ� " + weight + "kg�Դϴ�.");
		System.out.printf("[2]���� ���ϴ� Ű�� %.1fcm�̰�, �����Դ� %dkg�Դϴ�." , height, weight);

	
	}
	/*
	 * ���� 4) ���
	 * ���̵��꿡 �ִ� ���̱ⱸ�� ž�� ����.
	 * ���� �����Կ� ���� ���� ����� ����.
	 * "�����԰� 80kg �̻��� ��� ž���� ���մϴ�."
	 */
	public void example04() {
		// ��� ����
		final int LIMIT_WEIGHT = 80;
		//LIMIT_WEIGHT = 99; // ����� ���� ������ �� ����.
		// ���
		System.out.printf("�����԰� %dkg �̻��� ��� ž���� ���մϴ�." , LIMIT_WEIGHT);
	}
	
	public void example04p() {
		int limitWeight = 68;
		if(limitWeight>80) {
			System.out.printf("�����԰� %dkg�Դϴ�. �����԰� 80kg�� �ʰ��ϴ� ��� ž���� �� �����ϴ�." , limitWeight);
		}
		else {
			System.out.printf("�����԰� %dkg�Դϴ�. �����԰� 80kg ������ ��� ž���� �� �� �ֽ��ϴ�." , limitWeight);
		}
	}
	/*
	 * ���� 5) ����ȯ
	 * 	������ �� �� �ڷ����� ������ �ٸ� ��� �� ��ȯ�� �߻��ϴµ�,
	 * 	�Ʒ� ��Ģ�� ���� �� ��ȯ�� �߻��Ѵ�.
	 * 	1) �ڷ����� ���� ������ (����) ���⿡�� (ū) �������� ����ȯ �߻�.
	 * 	2) �������� �Ǽ����� ���� �� (����) �ڷ������� (�Ǽ�) �ڷ������� ����ȯ 
	 */
	public void example05() {
		int num1 = 10;
		double dNum1 = 5.5;
		
		//�ڵ� ����ȯ
		System.out.println(num1 + dNum1); 	// ���	? 15.5
		//���� ����ȯ
		System.out.println(num1 + (int)dNum1); // ���	? 15
		
		char ch = 'A';
		System.out.println(ch);	//���	? A
		//���� ����ȯ
		System.out.println((int)ch); //���	? 65	
		//�ڵ� ����ȯ
		System.out.println(ch+3); //���	? 68
		// ch + 3 > (int)ch +3 > 65 + 3 > 68
		
		//���� ����ȯ
		System.out.println((char)(ch+3));	//���	? D
		//	(ch+3) > (char)68 > D?
	}
	/*
	 * ���� 6) �Է¸޼ҵ� : Scanner
	 *  [���� 3]�� Ű�� �����Կ� ���� �����ߴ� ���� ����ڷκ��� �Է¹޵��� �����Ͽ�
	 *  ����� ����غ���.
	 *  [Scanner ����ϱ� ���� �غ� ����]
	 *  1) import java.util.Scanner;
	 *  2) Scanner ����
	 */
	public void example06() {
		// Scanner ����
		Scanner sc = new Scanner(System.in);
		
		// Ű�� ���� ���� �Է¹޵���
		System.out.print("���ϴ� Ű�� �Է��Ͻÿ�: ");
		// ����ڷκ��� �Է¹��� ���� height ������ ����
		double height = sc.nextDouble();
		// �����Կ� ���� ���� �Է¹޵��� ȭ�鿡 ����ϰ�
		System.out.print("���ϴ� �����Ը� �Է��Ͻÿ�: ");
		// ����ڷκ��� �������� ���� �Է¹޾� ������ weight ������ ����
		int weight = sc.nextInt();
		//��� ����) "���� ���ϴ� Ű�� 177.7cm�̰�, �����Դ� 77kg�Դϴ�.
		System.out.printf("���� ���ϴ� Ű�� %.1fcm�̰�, �����Դ� %dkg�Դϴ�." , height, weight);
		System.out.println();
		System.out.println("���� ���ϴ� Ű�� " + height + "cm�̰�, �����Դ� " + weight + "kg�Դϴ�.");
	}
	

	


}
