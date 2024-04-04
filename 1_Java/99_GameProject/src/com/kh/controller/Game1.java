package com.kh.controller;

import java.util.Scanner;

import com.kh.model.vo.User;

public class Game1{
	
	Scanner sc = new Scanner(System.in);
	public void UpDownGame (User user) {	// 메소드를 만들 때 User 타입 매개변수 가지도록 설정!
		System.out.println("===== Up&Down 게임 =====");
		System.out.println("1~50 사이의 숫자 맞추기");
		
		int random = (int)(Math.random()*50+1);
		
		for(int i=0; i<3; i++) {
			System.out.print("번호를 입력하세요: ");
			int num = sc.nextInt();

			if(random> num) {
				System.out.println("=== Up! ===");
			}
			else if(random < num) {
				System.out.println("=== Down! ===");
			}
			else {
				System.out.println(" === Catch! +100점!!===");
				user.setScore(user.getScore()+100);
				break;
			}
			
		}
		System.out.println("정답은 " + random + "입니다.");
	}
}
