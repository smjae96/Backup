package com.kh.controller;

import java.util.Scanner;

import com.kh.model.vo.User;

public class Game3 {
	Scanner sc = new Scanner(System.in);
	// numBaseBall : ���� �߱�
	// xx		10 ~ 98 : �ڸ����� ���ڵ��� �ߺ� ����
	//			��ȸ) 5��
	//			(1) ���ڿ� �ڸ����� 2�� ��� ������ 2��Ʈ����ũ (�̱�) => +100
	//			(2) ���ڿ� �ڸ����� 1���� ������ 1��Ʈ����ũ => +20	
	//			(2) ���ڸ� ������ ��	=> +5
	//			(3) Ʋ���� �ƿ� => -10(���� �� Ʋ����)
	public void numBaseBall(User user) {
		System.out.println("=== ���� �߱� ===");
		System.out.println("��ȸ�� 5���Դϴ�.");
		int random = (int)(Math.random()*89+10);
		if(random/10 == random%10) {
			numBaseBall(user);
		}
		for(int i=0; i<5; i++) {
			System.out.print("�� �ڸ� ���ڸ� �Է��ϼ���!, �� �� ���ڰ� ���� �����̸� �ȵ˴ϴ�! >> ");
			int num = sc.nextInt();
			if(num<10 || num >99 || num/10==num%10) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
				numBaseBall(user);
			}
			
			if(random/10 == num/10) {
				if(random%10 == num%10) {
					System.out.println("2��Ʈ����ũ! �����Դϴ�. +100��!");
					user.setScore(user.getScore()+100);
					break;
				}
				else {
					System.out.println("1��Ʈ����ũ! +20��!");
					user.setScore(user.getScore()+20);
				}
			} else if(random%10 == num%10) {
				if(random/10 == num/10) {
					System.out.println("2��Ʈ����ũ! �����Դϴ�. +100��!");
					user.setScore(user.getScore()+100);
					break;
				}
				else {
					System.out.println("1��Ʈ����ũ! +20��!");
					user.setScore(user.getScore()+20);
				}
			} else if(random/10 == num%10) {
				if(random%10 == num/10) {
					System.out.println("2��! +10��!");
					user.setScore(user.getScore()+10);
				} else {
					System.out.println("1��! +5��!");
					user.setScore(user.getScore()+5);
				}
			} else if(random%10 == num/10) {
				if(random/10 == num%10) {
					System.out.println("2��! + 10��!");
					user.setScore(user.getScore()+10);
				} else {
					System.out.println("1��! +5��!");
					user.setScore(user.getScore()+5);
				}
			} else {
				System.out.println("�ƿ�! -10��!");
				user.setScore(user.getScore()-10);
			}
		}
		System.out.println("������ "+random+ "�Դϴ�.");
	}
}
