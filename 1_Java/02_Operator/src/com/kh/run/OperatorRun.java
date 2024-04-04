package com.kh.run;

import java.util.Scanner;
import com.kh.practice.func.*;
/*
 * 연산자 : 프로그램이 실행될 때 연산을 도와주는 것들.
 * - (우선순위	) 와 ( 결합 방향(연산방향) )이 중요함!
 * - [1] 직접 접근 연산자: [] .
 * 	 [2] 단항 연산자	 : 부호 연산자 : +, - / 증감연산자 : ++, -- / 형변환 : (type) / 부정 연산자 : !
 * 	 [3] 산술 연산자	 : + - * /(몫) %(나머지)
 * 	 [4] 비트 쉬프트 연산자: << >> (빈자리에 양수:0, 음수:1) >>> (빈자리에 0)
 * 	 [5] 비교(관계) 연산자: <(왼쪽이 오른쪽보다 작음) >(왼쪽이 오른쪽보다 큼) <= 
 * 			* A < B  : A가 B보다 작은가?  
 * 			* A <= B : A가 B보다 작거나 같은가?
 * 			* A == B : A와 B가 같은가?
 * 			* A != B : A와 B가 다른가?
 * 	 [6] 논리 연산자(비트 연산자)	 : && || & |
 * 	 [7] 삼항 연산자	 : (조건식) ? (조건식 결과가 참일 때 사용할 값) : (조건식 결과가 거짓일 때 사용할 값);
 * 	 [8] 대입 연산자	 : = += -= *= /= %= &= <<= >>= >>>=
 */

public class OperatorRun {
	public static void main(String[] args) {
//		practice1();
//		practice2();
//		practice3();
//		practice4();
//		practice5();
//		practice6();
		OperatorPractice op = new OperatorPractice();
	//	op.practice1();
		//op.practice2();
		//op.practice3();
		//op.practice4();
		//op.practice5();
		//op.practice6();
		//op.practice7();
		op.practice8();
		//op.practice9();
		//op.practice10();
		//op.practice11();
	}
	
	// 증감 연산자 : ++ --
	public static void practice1() {
		// 전위(증감 연산자가 변수 앞에 붙어있는)연산: ++(변수)
		int num = 10;
		System.out.println("연산을 수행하기 전 num: " + num); // 10
		System.out.println("1회 수행 후 num: " + ++num); // 11
		System.out.println("2회 수행 후 num: " + ++num); // 12
		System.out.println("3회 수행 후 num: " + ++num); // 13
		System.out.println("최종 num: " + num); // 13
		
		System.out.println("=========================");
		// 후위연산: (변수)++
		int num2 = 10;
		System.out.println("연산을 수행하기 전 num2: " + num2); //10
		System.out.println("1회 수행 후 num2: " + num2++); // 10 (출력을 먼저 한 뒤 증가.)
		System.out.println("2회 수행 후 num2: " + num2++); // 11
		System.out.println("3회 수행 후 num2: " + num2++); // 12
		System.out.println("최종 num2: " + num2); // 13
	}
	
	public static void practice2() {
		int num1 = 10;
		int num2 = 10;
		int result1 = ++num1 * 3; // num1: 11 result1: 11*3= 33
		int result2 = num2++ * 3; // result2: 10*3= 30, num2: 11
		System.out.printf("num1: %d, result1: %d\n", num1, result1); // num1: 11, result1: 33
		System.out.printf("num2: %d, result2: %d\n", num2, result2); // num2: 11, result2: 30
	}
	
	public static void practice3() {
		int a = 10;
		int b = 20;
		int c = 30;
		
		System.out.println(a++);					// 출력값: 10, 출력 후 a: 11 
		System.out.println((++a) + (b++));			// 출력값: 32, 출력 후 a: 12, b: 21
						//   ((++11) + (20++))
						//   ( 12 + (20++))
						//	 ( 12 + 20 )	// 20++ 해야함!
						//	 ( 32 )
		System.out.println((a++) + (--b) + (--c));	// 출력값: 61, 출력 후 a: 13, b: 20, c: 29
						//	 ((12++) + (--21) + (--30))    --> 전위연산 먼저해야 함. --21과 --30 먼저 연산.
						//   ((12++) + (20) + (29)) // b: 20, c: 29, a++
						//	 ((12 + 20 + 29)) = 61	// a: 13	
					
	}
	
	public static void practice4() {
		int a =5;
		int b = 10;
		
		int c = (++a) + b; // 6+10 == 16, a값 6
		int d = c / a; // 16/6 == 2
		int e = c % a; // 16%6 == 4 
		
		// a: 6, b: 10, c: 16, d: 2, e: 4
		
		int f = e++; // 4, e값 5
		
		int g = (--b) + (d--); // 9+2 == 11, b값 9 , d값 1
		int h = 2;
		
		// a: 6, b: 9, c: 16, d: 1, e: 5, f: 4, g: 11, h: 2 
		
		int i = (a++) + b / (--c / f) * (g-- - d) % (++e + h); 
		// (a++) + b / (15 / 4) * (g-- - 1) % (6 + 2) 		// c: 15, e: 6
		// (a++) + b / 3 * (11-1) % 8 						// g: 10
		// (a++) + b / 3 * 10 % 8
		// (a++) + 9 / 3 * 10 % 8
		// (a++) + 3 * 10 % 8
		// (a++) + 30 % 8
		// (a++) + 6
		// 6+6												// a: 7
		// 12
		
		System.out.println("a: " +a); // 7
		System.out.println("b: " +b); // 9
		System.out.println("c: " +c); // 15
		System.out.println("d: " +d); // 1
		System.out.println("e: " +e); // 6
		System.out.println("f: " +f); // 4
		System.out.println("g: " +g); // 10
		System.out.println("h: " +h); // 2
		System.out.println("i: " +i); // 12
	}
	
	// 논리연산자/비교(관계)연산자
	public static void practice5() {
		// 사용자로부터 1 ~ 10 사이의 정수를 입력받은 경우 true를 출력하고,
		// 그렇지 않은 경우 false 출력.
		Scanner sc = new Scanner(System.in);
		
		// 화면에 "1 ~ 10 사이의 정수를 입력: " 출력(줄바꿈 없이)
		System.out.print("1~10 사이의 정수를 입력: ");
		int num = sc.nextInt();
		
		// num의 값이 1, 2, 3, 4, 5, ..., 9, 10 => true
		// num의 최소 값이 1이고, 최대값이 10이면 true
		// num의 값이 1보다 크거나 같고, 10보다 작거나 같으면 true
		boolean result = (num >= 1) && (num<=10);
		
		System.out.printf("입력한 값 %d는 1 ~ 10 사이의 정수입니까? %b", num , result);
		
	}
	
	public static void practice6() {
		// 사용자로부터 문자(a ~ z, A ~ Z)를 하나 입력 받아
		// 대문자인지 소문자인지 출력
		// 출력 예시) 입력한 문자 [a]는 소문자입니다.
		//			입력한 문자 [A]는 소문자가 아닙니다.
		//  * [ASCII] a: 97, A: 65
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자를 입력: ");
		String str= sc.nextLine();		// 입력받은 값을 문자열 타입으로 가지고 오고
		char alphabet = str.charAt(0);	// 문자열에서 첫번째 위치의 값을 문자타입으로
		
		// 입력 받은 값(ch)이 소문자 범위에 포함되는 지 : 97 ~ 122
		String result = (97 <= alphabet) && (alphabet <= 122) ? "소문자입니다." : "소문자가 아닙니다."; // 삼항 연산자의 결과가 문자열이므로, 변수 result의 자료형을 String으로 한다.
		 String info = ((alphabet >= 65) && (alphabet <97)) ? "소문자가 아닙니다" : "소문자입니다.";
		 
		 System.out.println("[1] 입력한 문자 [" + alphabet + "]는 " + info);
		 
		 String result2 = ('a' <= alphabet) && (alphabet <= 'z') ? "소문자 입니다." : "소문자가 아닙니다.";
		 System.out.println("[2] 입력 값 " + alphabet + "는 " + result2);
		 
		 String result3 = ('a' <= alphabet) && (alphabet <= 'z') ? "소문자 입니다." :
			 				((('A' <= alphabet) && (alphabet <= 'Z')) ? "대문자 입니다." : "알파벳이 아닙니다.");
		 System.out.println("[3] 입력 값 " + alphabet + "는 " + result3);
			 				
		 
	
	}
	
	public static void practice6a() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자를 입력: ");
		
		char alphabet = sc.next().charAt(0);
		
		if((alphabet>= 65) && (alphabet < 97)) {
			System.out.println("입력한 문자 [" + alphabet + "]는 소문자가 아닙니다.");
		}
		else {
			System.out.println("입력한 문자 [" + alphabet + "]는 소문자입니다.");
		}
	}
	
	public static void practice6b() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자를 입력: ");
		
		char alphabet = sc.nextLine().charAt(0);
		
		 String info1 = ((alphabet >= 65) && (alphabet <97)) ? "소문자가 아닙니다" : "소문자입니다.";
		
	}
}
