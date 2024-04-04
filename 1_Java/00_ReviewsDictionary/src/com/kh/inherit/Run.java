package com.kh.inherit;

// 실행을 위한 용도(클래스)
public class Run {
	
	// 자바 프로그램의 시작점. => main 메소드
	public static void main(String[] args) {
		
		// Child1 클래스가 상속을 잘 받았는 지 테스트
		Child1 chd1 = new Child1();
		chd1.printMsg();
		// chd1.x;				// 부모클래스(Parent)의 Private 변수로는 접근이 불가
		
		
		Parent p1 = new Parent();
		p1.printMsg();
		
		Parent p2 = new Child1();
		p2.printMsg();			// - 동적바인딩 : 오버라이딩 된 메소드가 실행됨.
								//				객체를 자식클래스로 생성하여 오버라이딩 된 메소드 내용으로 실행됨.
		
		// 참조변수 instanceof 클래스 : 참조변수가 해당 클래스로 인스턴스가 생성되어 있는가?
		//												객체를 생성했는가?
		//							결과 값: true / false => 조건식으로 사용
		if(p2 instanceof Child1) {
			
		
		// 클래스 형 변환 (다운캐스팅) : 자식클래스 내에 있는 멤버(변수, 메소드)에 접근하기 위해
		//							클래스 형 변환을 해줘야 함.
		//							* 참조변수의 타입이 부모클래스(Parent)로 되어 있어
		//							해당 멤버의 정보를 알 수 없기 때문에..
		((Child1)p2).printChild1();
		
		}
		
	}

}
