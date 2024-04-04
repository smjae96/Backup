package com.kh.example.practice1.run;

import com.kh.example.practice1.model.vo.Member;

public class Run {
	
	
	//메소드부
	public static void main(String[] args) {
		// Member 클래스 선언 및 인스턴스 생성
		Member member1 = new Member();	// 기본 생성자: 클래스명()
		// changeName()을 이용해 값을 변경
		member1.changeName("홍길동");
		// printNAme()을 이용해 출력
		member1.printName();
		
	}

}
