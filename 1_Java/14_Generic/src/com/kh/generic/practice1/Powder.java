package com.kh.generic.practice1;

// Material 클래스 상속
public class Powder extends Material{
	// 추상메소드 구현 필요..
	
	// Material 추상클래스 내 추상메소드 오버라이딩
	@Override
	public void doPrinting() {
		System.out.println("Powder 재료 출력");
	}

	// Object 클래스 내 toString 메소드 오버라이딩
	@Override
	public String toString() {
		return "재료 : powder";
	}
	

}
