package com.kh.condition;

/*
 * 조건문 if
 * : 조건문 => 조건에 따라 흐름을 제어하는 문법
 * 
 * - 기본적인 흐름은 위에서 아래로, 왼쪽에서 오른쪽으로..
 * - 조건식을 기준으로 참인 경우, 거짓인 경우 프로그램 흐름을 제어
 * 
 * - 표현법
 * 	 if(조건식) {
 *  	// 조건식이 참(true)인 경우 수행할 코드
 * 	 }	
 * 
 * 	 ---------------------------------------
 * 	 if(조건식) {
 * 		// 조건식이 참(true)인 경우 수행할 코드
 * 	 } else {
 *   	// 조건식이 거짓(false)인 경우 수행할 코드
 *   }
 *   ---------------------------------------
 *   if(조건식1) {
 * 		// 조건식이 참(true)인 경우 수행할 코드
 * 	 }  else if(조건식2) {
 * 	  	// 조건식1이 거짓(false)이고, 조건식2가 참(true)인 경우 수행할 코드
 * 	 }	else {
 *   	// 조건식1, 조건식2 모두 거짓(false)인 경우 수행할 코드
 *   }
 *   
 *   // (+) 조건식1이 거짓이고, 조건식2가 참인 경우 수행할 코드
 *   if(!(조건식1) && 조건식2) { // !false => true
 *   	// !(조건식1) && 조건식2 의 결과 참(true)인 경우 수행할 코드
 *   }
 *   ---------------------------------------------
 *   if(조건식1) {
 *   	// 조건식1이 참인 경우 수행할 코드
 *   	if(조건식A) {
 *   		// 조건식1이 참이고, 조건식A도 참일 때 수행할 코드
 *   	} else {
 *   		// 조건식1이 참이고, 조건식A는 거짓일 때 수행할 코드
 *   	}
 *   } else {
 *   	// 조건식1이 거짓일 때 수행할 코드
 *   }
 */
public class A_If {

	public static void main(String[] args) {
		
		String name = "홍길동";
		// 성이 홍씨라면 "홍길동이 맞습니다." 출력
		// [문자열 값 또는 문자열 변수].charAt(index);
		// : 문자열에서 원하는 위치의 값을 문자형 타입으로 변환
		// : index는 0부터 시작! **
		char fir = name.charAt(0);
		if(fir == '홍') {
			// 성이 홍씨라면 "홍길동이 맞습니다." 출력
			// fir의 값이 '홍'이라는 값과 동일한 경우
			System.out.println("홍길동이 맞습니다.");
			
			// name 변수의 값이 "홍길동"과 일치하는 지 한 번 더 체크.
			// 문자열 동등 비교 : [문자열 값이나 변수].equals([비교할 문자열 값 또는 변수]); => true/false
			if(name.equals("홍길동")) {
				// name 변수의 값이 "홍길동" 동일한 경우
				System.out.println("홍길동이 맞습니다.");
			} else {
				// name 변수의 값이 "홍길동"이 아닌 경우
				System.out.println("홍길동이 아닙니다.");
			}
		} else {
			// 성이 홍씨가 아니라면 "홍길동이 아닙니다." 출력
			// fir의 값이 '홍'이라는 값과 다른 경우 => fir != '홍'
			System.out.println("홍길동이 아닙니다.");
		}
	}

}
