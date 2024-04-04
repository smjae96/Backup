package com.kh.practice.chap02_abstractNInterface.model.vo;

public interface CellPhone extends Phone, Camera{
	// 상수 : 없음
	//	- 상속을 통해 Phone 인터페이스의 상수(NUMBERPAD)를 본인 것처럼 정의된 상태로 봄.
	
	// 추상메소드
	//  - 상속을 통해 Phone 인터페이스의 makeCall(), takeCall() 메소드와
	//			  Camera 인터페이스의 picture() 메소드를 정의가 된 상태
	//	- 충전 방식 기능
	String charge();
}
