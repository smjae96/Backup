package com.kh.controller;

import java.util.Scanner;

import com.kh.model.vo.User;

public class PlayController {
	Scanner sc = new Scanner(System.in);
	User user = new User("������");
	// method01 : ������(1~50)�� �̾Ƽ�, ����ڷκ��� �Է��� ���� ��
	// 			  �� ���� ���������� ũ�� "Down" ���
	//			  				������ "Up" ���
	//			  ���� ���̸� "Catch!" ��� User�� score += 10;
	//			  ��, 5���� ��ȸ �ȿ� �����ؾ� ���� ȹ��!
	
	public void method01() {
		System.out.println("===== Up&Down =====");
		System.out.println(" 1 ~ 50 ������ ���� ���߱�");
		// Math.random() * (�������� ��������) + (���۹�ȣ)
		int random = (int)(Math.random()*50+1);
		
		// ----------------
		for(int i=0; i<5; i++) {
			System.out.print("��ȣ�� �Է��ϼ��� : ");
			int num = sc.nextInt();
			
			if(num > random) {
				System.out.println(" ** Down! ** ");
			}
			else if(num < random) {
				System.out.println(" ** Up! ** ");
			}
			else {
				// num == random
				System.out.println(" ** Catch! ** ");
				user.setScore(user.getScore() +10);
				break;
			}
		
		}
		System.out.println("������ " +random+ "�Դϴ�!");
		
		// ------------------
		
	}
	
	// method02 : ���������� ����
	//			  �������� �̾Ƽ� 1�� ��� ����,
	//						  2�� ��� ����,
	//						  3�� ��� ��. ��� ��Ģ�� ���س���.
	
	//			  ����ڷκ��� �Է��� �޾�, ������ �������� ���� ���� �� ����� ���
	//			  ���� < ���� | ���� > �� | ���� < �� | 
	//				����ڰ� �Է��� �������� "�¸� (+10)", "�й�(-10)", "���"
	
	public void method02() {
		System.out.println("===== ���������� =====");
		for(int i=0; i<5; i++) {
			int random = (int)(Math.random()*3+1);
			String game = null;
			if(random == 1) {
				game = "����";
			}
			else if(random == 2) {
				game = "����";
			}
			else {
				game = "��";
			}
			System.out.print("���� �Է��ϼ���: ");
			String str = sc.next();
			
			if(str.equals("����")) {
				if(game.equals("����")) {
					System.out.println("�й�(-10)");
					user.setScore(user.getScore()-10);
				}
				else if(game.equals("��")) {
					System.out.println("�¸�(+10)");
					user.setScore(user.getScore()+10);
				}
				else {
					System.out.println("���");
					user.setScore(user.getScore());
				}
			}
			else if(str.equals("����")) {
				if(game.equals("����")) {
					System.out.println("���");
					user.setScore(user.getScore());
				}
				else if(game.equals("��")) {
					System.out.println("�й�(-10)");
					user.setScore(user.getScore()-10);
				}
				else {
					System.out.println("�¸�(+10)");
					user.setScore(user.getScore()+10);
				}
			}
			else {
				if(game.equals("����")) {
					System.out.println("�¸�(+10)");
					user.setScore(user.getScore()+10);
				}
				else if(game.equals("��")) {
					System.out.println("���");
					user.setScore(user.getScore());
				}
				else {
					System.out.println("�й�(-10)");
					user.setScore(user.getScore()-10);
				}
			}
		}
	}
	
	// method03 : ���� �߱�
	// xx		10 ~ 98 : �ڸ����� ���ڵ��� �ߺ� ����
	//			��ȸ) 3��
	//			(1) ���ڿ� �ڸ����� ��� ������ ��Ʈ����ũ (�̱�) => +10
	//			(2) ���ڸ� ������ ��	=> +3
	//			(3) Ʋ���� �ƿ� => -5 (���� �� Ʋ����)
	public void method03() {
		System.out.println("===== ���� �߱� =====");
		int random = (int)(Math.random()*89+10);
		if(random/10 == random%10) {
			method03();
		}
		for(int i=0; i<10; i++) {
			System.out.print("���ڸ� �Է��ϼ��� : ");
			int num = sc.nextInt();
			if(num<10 || num>98 || num/10==num%10) {
				System.out.println("���ڸ� �߸� �Է��߽��ϴ�. �ٽ� �Է��ϼ���.");
				continue;
			}
			String random1 = Integer.toString(random);
			String num1 = Integer.toString(num);
			char tenR =random1.charAt(0);
			char oneR =random1.charAt(1);
			char tenN =num1.charAt(0);
			char oneN =num1.charAt(1);
			
			if(tenR==tenN) {
				if(oneR==oneN) {
					System.out.println("2��Ʈ����ũ! �����Դϴ�!");
					user.setScore(100);
					break;
				}
				else {
					System.out.println("1��Ʈ����ũ");
					user.setScore(user.getScore()+10);
				}

			}
			else if(tenR==oneN) {
				if(oneR==tenN) {
					System.out.println("2��");
					user.setScore(user.getScore()+6);
				}
				else {
					System.out.println("1��");
					user.setScore(user.getScore()+3);
				}
			}
			else if(oneR==tenN) {
				if(tenR==oneN) {
					System.out.println("2��");
					user.setScore(user.getScore()+6);
				}
				else {
					System.out.println("1��");
					user.setScore(user.getScore()+3);
				}
			}
			else {
				System.out.println("�ƿ�");
				user.setScore(user.getScore()-5);
			}
		}
		if(user.getScore()==100) {
			System.out.println("�����մϴ�!");
		}
		else {
			System.out.println("��û�ϱ���!");
		}
		
	}
	// getUserINfo : ������� ���� ��ȸ
	public void getUserInfo() {
		System.out.println(user.toString());
	}
}
