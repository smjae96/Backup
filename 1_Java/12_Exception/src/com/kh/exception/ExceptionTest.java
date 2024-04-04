package com.kh.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {
	public static void main(String[] args) {
		System.out.println("===== 프로그램을 시작합니다. =====");
		
		arithmeticTest();
		
		inputMismatchTest();
		
		try {
			System.out.println("[1]");
			nullPointerTest();				// 바로 catch문으로
			System.out.println("[2]");		// 예외 발생한 이후 것 출력 안됨.
		} catch(NullPointerException e) {
			System.out.println("NullPointerException 오류");
		}
		//	사용자 정의 예외 테스트 ------------------
		try {
			customExceptionTest();
		} catch(Exception e) {
			System.out.println(e);
			System.out.println("CustomException 오류입니다.");
		}
		
		
		System.out.println("===== 프로그램을 종료합니다. =====");
	}
	
	public static void arithmeticTest() {
		// ArithmeticException : 산술관련 예외클래스
		int n1 = 10;
		int n2 = 0;
		
		// 1) if 문(조건문) 사용하여 예외처리
//		if (n2 > 0) {
//			System.out.println(n1/n2);
//		} else {
//			System.out.println("0으로 나눌 수 없습니다.");
//		}
		// 2) try ~ catch 문
		try {
			System.out.println(n1 / n2);
		} catch(ArithmeticException e) {
			System.out.println("ArithmeticException 오류입니다.");
		}
	}
	
	public static void inputMismatchTest() {
		// InputMismatchException : 입력이 잘못된 경우 예외 클래스
		Scanner sc = new Scanner(System.in);
		System.out.print("자연수를 입력하세요 : ");
		
		try{
			int num = sc.nextInt();
			if(num<1) {
				//System.out.println("자연수가 아닌 정수를 입력하셨습니다.");
				throw new InputMismatchException();	// 예외를 발생시키기 throw new 예외클래스생성자();
			}
			System.out.println("입력한 값은 " +num+ "입니다.");
			
		} catch(InputMismatchException e){
			System.out.println("InputMismatchException 오류입니다.");
		} 
	}
	public static void nullPointerTest() throws NullPointerException{
		//NullPointerException : null 관련 예외 클래스 (생성되지 않은 객체로의 접근 시..)
		String name = null;
		
		System.out.println(name);	// name.toString() 
									// toString() : Object 클래스 메소드. 클래스 정보와 해쉬값(주소값)을 반환
									// String 클래스 변수에서 사용 시 저장된 값이 출력됨 => 오버라이딩..
		//1.  try ~ catch 문 사용
//		try {
//			System.out.println("name 변수의 길이는 " + name.length() + "입니다.");
//		} catch(NullPointerException e) {
//			System.out.println("NullPointerException 오류입니다.");
//		}
		
		//2. thorws 사용
		System.out.println("(3)");
		System.out.println("name 변수의 길이는 " +name.length() + "입니다.");			// 예외 발생 throws
		System.out.println("(4)");	// 예외 발생한 이후 것 출력 안됨.
		
	}
	
	public static void customExceptionTest() throws CustomException{
		// CustomException 예외 발생	: throw new 예외클래스생성자;
		
		throw new CustomException("내가 만든 예외! ");
	}
}
