package com.kh.view;

import java.util.Scanner;

import com.kh.controller.Game1;
import com.kh.controller.Game2;
import com.kh.controller.Game3;
import com.kh.controller.PlayController;
import com.kh.model.vo.User;

public class DisplayMenu {
	Game1 g1 = new Game1();
	Game2 g2 = new Game2();
	Game3 g3 = new Game3();
	Scanner sc = new Scanner(System.in);
	PlayController pc = new PlayController();
	public User user = new User("심재윤");
	public void mainMenu() {
		while(true) {
			System.out.println("=====Console Game=====");
			System.out.println("1. Up & Down");	// 랜덤값을 뽑아서 3번 기회 안에 맞추면 점수 획득
			System.out.println("2. 가위바위보");	// 컴퓨터(랜덤값) 사용자 입력 값이랑 비교해서 이김 점수 획득
			System.out.println("3. 숫자 야구"); 	// 2자리 모두 맞추면 스트라이크!(점수획득), 숫자만 맞추면 볼(-), 5번 모두 틀리면 아웃(점수 차감)
			System.out.println("9. 점수 조회");	
			System.out.println("0. 게임 종료");
			System.out.println("======================");
			
			// 게임 선택 시 해당 게임을 진행할 수 있도록 -->
			System.out.print("게임 선택: ");
			int sel = sc.nextInt();
			if(sel ==1) {
				
				g1.UpDownGame(user);
			}
			else if(sel ==2) {
				
				g2.RSP(user);
			}
			else if(sel ==3) {
				
				g3.numBaseBall(user);
			}
			else if(sel ==9) {
				System.out.println(user.toString());
			}
			else if(sel ==0) {
				System.out.println("게임 종료");
				break;
			}
			else {
				mainMenu();
			}
			
		}
		System.out.println("=======================");

	}
}
