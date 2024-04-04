package com.kh.exception;

// 사용자 정의 예외 클래스
//	- 예외 클래스 조상 : Exception (상속)
//	[1] Exception 클래스를 상속받는다.
public class CustomException extends Exception{
	
	// [2] 생성자 : 매개변수 1개 (문자열 타입) -> 예외 정보
	public CustomException(String msg) {
		//부모클래스의 생성자 호출. 전달받은 값을 부모클래스 생성자에게 전달.
		super(msg);
	}
	
}
