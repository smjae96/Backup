package com.kh.interface_practice;

public class SamsungPrint extends Print {
	// 추상클래스 상속 시 아래 항목 중 하나를 꼭 해야함!
	// 	- 자식 클래스도 추상클래스로 정의
	//	- 추상 메소드를 재정의(오버라이딩)
	
	@Override
	public void colorPrint() {
		System.out.println("Samsung Color Print");
	}

	@Override
	protected void printTest() {
		System.out.println("Samsung Print Test");
		
	}

	@Override
	void printTest2() {
		System.out.println("Samsung Print Test 2");
	}

}
