package com.kh.operator;

/*
 * 연산자: 프로그램 내에서 연산을 수행하는 기호
 * - 우선순위, 결합방향(연산방향, default: 왼쪽>오른쪽)
 * - 우선순위
 * [1] 직접 접근 연산자 : () . [] 
 * [2] 단항 연산자 : 부호(+ -), 부정(!), 증감(++ --), (type) 형변환
 * 				  ex) +10, -10, -num
 * [3] 산술 연산자 : + - *(곱하기) /(나누기 몫) %(나누기 나머지)
 * 				  우선순위 : * / % > + -
 * [4] 비교 연산자 : > >= <= <
 * 						   : A가 B보다 작은가 ? A < B
 * 					동등비교 : A와 B가 같은가 ? A == B
 * 							 A와 B가 다른가 ? A != B
 * [5] 논리 연산자 : && || 
 * 				- A && B : 그리고
 * 							A	B	 A && B
 * 						 true  true   true 
 * 						 true  false  false
 * 						 false true   false
 * 						 false false  false 	
 * 					*SCE ? B 연산이 수행되지 않는 경우 => A가 false일때
 * 					- A || B: 또는, ~거나
 * 							  A		B		A || B
 * 							true   true      true
 * 							true   false     true
 * 							false  true		 true
 * 							false  false	 false
 * 					*SCE ? B 연산이 수행되지 않는 경우 => A가 true일때
 * [6]  삼항연산자
 * 			[표현법] (조건식) ? (조건식이 참일 때 사용할 값/식) : (조건식이 거짓일 때 사용할 값/식)
 * 
 * 				ex) String result = (a > 0) ? "양수" : "양수가 아니다";   // 참일 때와 거짓일 때의 자료형은 동일해야 함.
 * [7]	대입 연산자 : = 복합대입연산자(+= -= *= /= %=)
 * 			
 */
public class Operator {

	public static void main(String[] args) {
		
		// 논리 연산자 (SCE)
		int num = 10;
		boolean bResult = (num < 10) && (num++ > 10); // num<10이 false이므로 뒤에 있는 num++ > 10 연산은 수행되지 않음.
		System.out.println("bResult: " + bResult + ", num: " + num); // 따라서 num의 값이 변경되지 않음.
		// num < 10 : false이므로 뒤에 num++ > 10 연산이 수행되지 않음. (SCE)
		// bResult: false, num: 10? 11? => 10
		
		boolean bResult2 = (num == 10) || (num++ > 10); // num==10이 true이므로 뒤에 있는 num++ > 10 연산은 수행되지 않음.
		System.out.println("bResult2: " +bResult2+ ", num: " + num); // 따라서 num의 값이 변경되지 않음.
		// num == 10 : true이므로 뒤에 num++ > 10 연산이 수행되지 않음. (SCE)
		// bResult2: true, num: 10
		
		// 삼항 연산자
		// (조건식) ? (조건식이 참일 때 사용할 값/식) : (조건식이 거짓일 때 사용할 값/식)
		int n1 = 10;
		
		// n1의 값이 짝수이면 "짝수" , 홀수이면 "홀수"를 출력
		// (짝수를 구하는 조건식) n1 % 2 == 0 
		String result = n1%2==0 ? "짝수" : "홀수";
		System.out.println("n1은 " + result + "입니다.");
	}

}
