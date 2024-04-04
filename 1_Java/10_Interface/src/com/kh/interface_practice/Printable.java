package com.kh.interface_practice;

// 인터페이스는 다중 상속 가능.
//	- 다중 상속 시 (,)로 구분하여 나열
public interface Printable extends TestIf1, TestIf2{
	//	colorPrint() 추상메소드
	// * 표현법 : public abstract 반환타입 메소드명();
	public abstract void colorPrint();
}
