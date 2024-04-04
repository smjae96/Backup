package com.kh.controller;

import java.util.Scanner;

import com.kh.model.vo.User;

public class Game3 {
	Scanner sc = new Scanner(System.in);
	// numBaseBall : 숫자 야구
	// xx		10 ~ 98 : 자릿수의 숫자들은 중복 없이
	//			기회) 5번
	//			(1) 숫자와 자릿수가 2개 모두 같으면 2스트라이크 (이김) => +100
	//			(2) 숫자와 자릿수가 1개만 같으면 1스트라이크 => +20	
	//			(2) 숫자만 같으면 볼	=> +5
	//			(3) 틀리면 아웃 => -10(세번 다 틀리면)
	public void numBaseBall(User user) {
		System.out.println("=== 숫자 야구 ===");
		System.out.println("기회는 5번입니다.");
		int random = (int)(Math.random()*89+10);
		if(random/10 == random%10) {
			numBaseBall(user);
		}
		for(int i=0; i<5; i++) {
			System.out.print("두 자리 숫자를 입력하세요!, 단 두 숫자가 같은 숫자이면 안됩니다! >> ");
			int num = sc.nextInt();
			if(num<10 || num >99 || num/10==num%10) {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
				numBaseBall(user);
			}
			
			if(random/10 == num/10) {
				if(random%10 == num%10) {
					System.out.println("2스트라이크! 정답입니다. +100점!");
					user.setScore(user.getScore()+100);
					break;
				}
				else {
					System.out.println("1스트라이크! +20점!");
					user.setScore(user.getScore()+20);
				}
			} else if(random%10 == num%10) {
				if(random/10 == num/10) {
					System.out.println("2스트라이크! 정답입니다. +100점!");
					user.setScore(user.getScore()+100);
					break;
				}
				else {
					System.out.println("1스트라이크! +20점!");
					user.setScore(user.getScore()+20);
				}
			} else if(random/10 == num%10) {
				if(random%10 == num/10) {
					System.out.println("2볼! +10점!");
					user.setScore(user.getScore()+10);
				} else {
					System.out.println("1볼! +5점!");
					user.setScore(user.getScore()+5);
				}
			} else if(random%10 == num/10) {
				if(random/10 == num%10) {
					System.out.println("2볼! + 10점!");
					user.setScore(user.getScore()+10);
				} else {
					System.out.println("1볼! +5점!");
					user.setScore(user.getScore()+5);
				}
			} else {
				System.out.println("아웃! -10점!");
				user.setScore(user.getScore()-10);
			}
		}
		System.out.println("정답은 "+random+ "입니다.");
	}
}
