package com.kh.interface_10;

/*
 *  인터페이스 = 상수 + 추상메소드
 *  : 상수의 모음집
 *  : 메소드 정의 문서 (표준 문서)
 *  
 */
public interface TestInterface {
	// 상수		: 변하지 않는 값을 저장하는 공간 (final)
	/*
	 * [표현식]
	 * 		[public static final] 자료형 변수명 = 값; 
	 */
	int ERROR = -999999999;			// 접근제한자와 예약어 생략 가능.
	
	
	// 추상메소드
	/*
	 *	[표현식]
	 *		[public abstract] 반환타입 메소드명([매개변수]); 		
	 */
	int getNumber();				// 접근제한자와 예약어 생략 가능.
									//	* 인터페이스를 구현할 클래스에서 메소드 재정의 시 접근제한자를 "public"으로 정의해야 함!
}
