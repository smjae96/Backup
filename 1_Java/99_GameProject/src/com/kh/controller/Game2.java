package com.kh.controller;

import java.util.Scanner;

import com.kh.model.vo.User;

public class Game2 {
	Scanner sc = new Scanner(System.in);
	
	public void RSP(User user) {
		System.out.println("=== ���������� ���� ===");
		System.out.println("�� ���������� Ƚ���� 5���Դϴ�.");
		for(int i=0; i<5; i++) {
			int random = (int)(Math.random()*3+1);
			String rsp = null;
			if(random == 1) {
				rsp = "����";
			}
			else if (random == 2) {
				rsp = "����";
			}
			else {
				rsp = "��";
			}
			
			System.out.print("����/����/�� �Է� : ");
			String my = sc.next();
			if(my.equals("����")) {
				if(rsp.equals("����")) {
					System.out.println("�����ϴ�.");
					user.setScore(user.getScore());
				}
				else if(rsp.equals("����")) {
					System.out.println("�����ϴ�. -10��!");
					user.setScore(user.getScore()-10);
				}
				else {
					System.out.println("�̰���ϴ�. +20��!");
					user.setScore(user.getScore() +20);
				}
			} else if(my.equals("����")) {
				if(rsp.equals("����")) {
					System.out.println("�̰���ϴ�. +20��!");
					user.setScore(user.getScore()+20);
				}
				else if(rsp.equals("����")) {
					System.out.println("�����ϴ�.");
					user.setScore(user.getScore());
				}
				else {
					System.out.println("�����ϴ�. -10��!");
					user.setScore(user.getScore() -10);
				}
			} else if(my.equals("��")) {
				if(rsp.equals("����")) {
					System.out.println("�����ϴ�. -10��!");
					user.setScore(user.getScore()-10);
				}
				else if(rsp.equals("����")) {
					System.out.println("�̰���ϴ�.");
					user.setScore(user.getScore() +20);
				}
				else {
					System.out.println("�����ϴ�.");
					user.setScore(user.getScore());
				}
			} else {
				System.out.println("�߸� �Է��߽��ϴ�. �ٽ� �Է��ϼ���.");
				RSP(user);
			}
		}
	}
}
