package com.kh.controller;

import java.util.Scanner;

import com.kh.model.vo.User;

public class Game2 {
	Scanner sc = new Scanner(System.in);
	
	public void RSP(User user) {
		System.out.println("=== 가위바위보 게임 ===");
		System.out.println("총 가위바위보 횟수는 5번입니다.");
		for(int i=0; i<5; i++) {
			int random = (int)(Math.random()*3+1);
			String rsp = null;
			if(random == 1) {
				rsp = "가위";
			}
			else if (random == 2) {
				rsp = "바위";
			}
			else {
				rsp = "보";
			}
			
			System.out.print("가위/바위/보 입력 : ");
			String my = sc.next();
			if(my.equals("가위")) {
				if(rsp.equals("가위")) {
					System.out.println("비겼습니다.");
					user.setScore(user.getScore());
				}
				else if(rsp.equals("바위")) {
					System.out.println("졌습니다. -10점!");
					user.setScore(user.getScore()-10);
				}
				else {
					System.out.println("이겼습니다. +20점!");
					user.setScore(user.getScore() +20);
				}
			} else if(my.equals("바위")) {
				if(rsp.equals("가위")) {
					System.out.println("이겼습니다. +20점!");
					user.setScore(user.getScore()+20);
				}
				else if(rsp.equals("바위")) {
					System.out.println("비겼습니다.");
					user.setScore(user.getScore());
				}
				else {
					System.out.println("졌습니다. -10점!");
					user.setScore(user.getScore() -10);
				}
			} else if(my.equals("보")) {
				if(rsp.equals("가위")) {
					System.out.println("졌습니다. -10점!");
					user.setScore(user.getScore()-10);
				}
				else if(rsp.equals("바위")) {
					System.out.println("이겼습니다.");
					user.setScore(user.getScore() +20);
				}
				else {
					System.out.println("비겼습니다.");
					user.setScore(user.getScore());
				}
			} else {
				System.out.println("잘못 입력했습니다. 다시 입력하세요.");
				RSP(user);
			}
		}
	}
}
