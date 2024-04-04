package com.kh.variable;

/*
 * 형변환 : 자료형의 종류를 변환
 * - 왜 일어나는가?
 * 	 컴퓨터에서 연산이 일어날 때 대상의 자료형이 동일해야 하는데,
 * 	 연산 대상의 자료형이 일치하지 않을 때 형 변환이 일어남(해야함)
 * 
 *  - 종류 2가지
 *    (1) 자동 형변환
 *    	  - 값의 범위가 작은 쪽에서 큰 쪽으로 형 변환이 일어남.
 *    	  - 정수형과 실수형의 연산에서는 정수형이 실수형으로 변환됨.
 *    	  byte(1B) - short(2B) - int(4B) - long(8B) - float(4B) - double(8B)
 *    				 char(2B)		
 *    (2) 강제 형변환		
 *    	  - 자동형변환이 되지 않을 때 직접 형변환을 하는 방법
 *    	  - 표현법
 *    				(변환할 자료형)변수명;
 *    				ex) int num = (int)3.14; // num에 저장되는 값: 3
 *    
 *    - 논리형(boolean) 자료형은 형변환이 불가!	
 */
public class B_Cast {

	public static void main(String[] args) {
		
		// 정수형 num 변수에 12라는 값을 대입하고, 
		int num = 12;
		// 실수형 dNum 변수에 대입
		double dNum =/*(double)*/num;		// 오류가 없는 이유: 자동 형변환
								// num 변수가 정수형(int)에서 실수형(double)으로
		
		double dNum2 = 3.3;
		double result = num + dNum2;	// num + dNum2 연산이 먼저 수행
										// (int) + (double)
										// (double)num + dNum2 => 12.0 + 3.3 = 15.3
										// 산술연산(+)이 수행될 때 num 변수가 정수형(int)에서 실수형(double)으로 자동 형변환
		
		// 정수형(long, 8B)에서 실수형(float, 4B)으로 형변환이 되는지...?
		// float은 실수형이라서 long(정수형)보다 표현 가능한 수의 범위가 더 크다.
		// 그렇기 때문에 long에서 float으로 자동형변환이 일어남.
		long lNum = 1000000L;
		float fNum = /*(float)*/lNum;		// lNum이 long형에서 float형으로 
											// 자동 형변환됨.
		
		// 문자형(char)과 정수형(int) 사이의 형변환
		int num5 = /*(int)*/'T';		// 문자형(char)에서 정수형(int)으로 자동 형변환이 됨.
		System.out.println("num5 변수의 값은: " +num5);
		System.out.println('A' + 3); // A3 ? D? 68?  result: 68
		// 'A' + 3 =>  'A' 라는 값이 문자형(char)에서 정수형(int)으로 형변환된 후
		// 산술연산자가 수행됨.
		char ch5 = /*(char)*/68;	// 대입연산자에서는 char <--> int 서로
									// 자동형변환이 됨.
		System.out.println("ch5 변수의 값은: " + ch5);
		
//		char ch6 = -20; // char은 0 ~ 65535 범위까지. 음수는 불가.
		
		// ---------------------------------------------------
		
		byte b1 = 5;
		byte b2 = 10;
		
		byte result3 = (byte)(b1 + b2);	// byte, short 연산을 수행하면 int로 자동 형변환.(byte끼리, short끼리 연산해도 int로 자동 형변환)
										// 그러므로 연산 결과를 괄호로 묶어서 강제 형변환해야 함.
		
		// byte 범위: -128 ~ 127
		int n1 = 290;
		byte b3 = (byte)n1;
		System.out.println("n1의 값 : " +n1);
		System.out.println("b3의 값 : " +b3);
		// 강제형변환 시 데이터 손실이 발생한다.(290-256=34)
		
		
	}

}
