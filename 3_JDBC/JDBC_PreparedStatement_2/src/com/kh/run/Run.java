package com.kh.run;

import com.kh.view.MemberMenu;

// run : 프로그램 실행 담당 (사용자가 보게 될 첫 화면을 띄워주기)
public class Run {

	public static void main(String[] args) {
		
		// MemberMenu 인스턴스 생성 후 mainMenu 메소드 호출
		new MemberMenu().mainMenu();	// 아래와 같은 의미이다.
		/*		
		MemberMenu menu = new MemberMenu();
		menu.mainMenu();
		 */
	}

}
