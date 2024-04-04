package com.kh.interface_run;

import com.kh.interface_practice.Print;
import com.kh.interface_practice.SamsungPrint;

public class Run extends SamsungPrint {
	
	public static void main(String[] args) {
		Run r = new Run();
		// 추상 클래스 관련 테스트
		
		// (1) 추상 클래스는 객체 생성 불가.
		// Print p = new Print();		// 추상 클래스로는 인스턴스 생성 불가
		
		// (2) 추상 클래스를 상속 받은 SamsungPrint 클래스 선언 및 객체 생성
		SamsungPrint sPrt = new SamsungPrint();
		sPrt.printTest3();
		sPrt.colorPrint();
		
		// (3) 추상 클래스가 참조변수 타입으로 사용 가능.
		Print prt2 = new SamsungPrint();
		prt2.colorPrint();			// 동적바인딩이 적용됨.	(SamsungPrint 클래스에서 재정의된 내용이 실행됨)
		//prt2.printTest2();			// printTest2()	: 접근제한자(default)- 같은 패키지 내에서 접근(사용)
									// 	현재 Run 클래스의 패키지 경로가 SamsungPrint와 다르기 때문에 사용 불가
		//prt2.printTest();			// printTest() : 접근제한자(protected) - 같은 패키지 내 또는 상속관계
									//	Run 클래스의 패키지 경로도 다르고, 상속관계도 아니므로 사용 불가
		
		r.printTest();
	}
	
	
	
}
