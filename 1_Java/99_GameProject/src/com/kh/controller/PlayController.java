package com.kh.controller;

import java.util.Scanner;

import com.kh.model.vo.User;

public class PlayController {
	Scanner sc = new Scanner(System.in);
	User user = new User("심재윤");
	// method01 : 랜덤값(1~50)을 뽑아서, 사용자로부터 입력을 받은 뒤
	// 			  그 값이 랜덤값보다 크면 "Down" 출력
	//			  				작으면 "Up" 출력
	//			  같은 값이면 "Catch!" 출력 User의 score += 10;
	//			  단, 5번의 기회 안에 성공해야 점수 획득!
	
	public void method01() {
		System.out.println("===== Up&Down =====");
		System.out.println(" 1 ~ 50 사이의 숫자 맞추기");
		// Math.random() * (랜덤값이 범위개수) + (시작번호)
		int random = (int)(Math.random()*50+1);
		
		// ----------------
		for(int i=0; i<5; i++) {
			System.out.print("번호를 입력하세요 : ");
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
		System.out.println("정답은 " +random+ "입니다!");
		
		// ------------------
		
	}
	
	// method02 : 가위바위보 게임
	//			  랜덤값을 뽑아서 1인 경우 가위,
	//						  2인 경우 바위,
	//						  3인 경우 보. 라고 규칙을 정해놓자.
	
	//			  사용자로부터 입력을 받아, 랜덤값 기준으로 가위 바위 보 결과를 출력
	//			  가위 < 바위 | 가위 > 보 | 바위 < 보 | 
	//				사용자가 입력한 기준으로 "승리 (+10)", "패배(-10)", "비김"
	
	public void method02() {
		System.out.println("===== 가위바위보 =====");
		for(int i=0; i<5; i++) {
			int random = (int)(Math.random()*3+1);
			String game = null;
			if(random == 1) {
				game = "가위";
			}
			else if(random == 2) {
				game = "바위";
			}
			else {
				game = "보";
			}
			System.out.print("값을 입력하세요: ");
			String str = sc.next();
			
			if(str.equals("가위")) {
				if(game.equals("바위")) {
					System.out.println("패배(-10)");
					user.setScore(user.getScore()-10);
				}
				else if(game.equals("보")) {
					System.out.println("승리(+10)");
					user.setScore(user.getScore()+10);
				}
				else {
					System.out.println("비김");
					user.setScore(user.getScore());
				}
			}
			else if(str.equals("바위")) {
				if(game.equals("바위")) {
					System.out.println("비김");
					user.setScore(user.getScore());
				}
				else if(game.equals("보")) {
					System.out.println("패배(-10)");
					user.setScore(user.getScore()-10);
				}
				else {
					System.out.println("승리(+10)");
					user.setScore(user.getScore()+10);
				}
			}
			else {
				if(game.equals("바위")) {
					System.out.println("승리(+10)");
					user.setScore(user.getScore()+10);
				}
				else if(game.equals("보")) {
					System.out.println("비김");
					user.setScore(user.getScore());
				}
				else {
					System.out.println("패배(-10)");
					user.setScore(user.getScore()-10);
				}
			}
		}
	}
	
	// method03 : 숫자 야구
	// xx		10 ~ 98 : 자릿수의 숫자들은 중복 없이
	//			기회) 3번
	//			(1) 숫자와 자릿수가 모두 같으면 스트라이크 (이김) => +10
	//			(2) 숫자만 같으면 볼	=> +3
	//			(3) 틀리면 아웃 => -5 (세번 다 틀리면)
	public void method03() {
		System.out.println("===== 숫자 야구 =====");
		int random = (int)(Math.random()*89+10);
		if(random/10 == random%10) {
			method03();
		}
		for(int i=0; i<10; i++) {
			System.out.print("숫자를 입력하세요 : ");
			int num = sc.nextInt();
			if(num<10 || num>98 || num/10==num%10) {
				System.out.println("숫자를 잘못 입력했습니다. 다시 입력하세요.");
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
					System.out.println("2스트라이크! 정답입니다!");
					user.setScore(100);
					break;
				}
				else {
					System.out.println("1스트라이크");
					user.setScore(user.getScore()+10);
				}

			}
			else if(tenR==oneN) {
				if(oneR==tenN) {
					System.out.println("2볼");
					user.setScore(user.getScore()+6);
				}
				else {
					System.out.println("1볼");
					user.setScore(user.getScore()+3);
				}
			}
			else if(oneR==tenN) {
				if(tenR==oneN) {
					System.out.println("2볼");
					user.setScore(user.getScore()+6);
				}
				else {
					System.out.println("1볼");
					user.setScore(user.getScore()+3);
				}
			}
			else {
				System.out.println("아웃");
				user.setScore(user.getScore()-5);
			}
		}
		if(user.getScore()==100) {
			System.out.println("축하합니다!");
		}
		else {
			System.out.println("멍청하군요!");
		}
		
	}
	// getUserINfo : 사용자의 점수 조회
	public void getUserInfo() {
		System.out.println(user.toString());
	}
}
