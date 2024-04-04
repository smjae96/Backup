package com.kh.variable;

/*
 * 키보드로 입력을 받는 기능: Scanner 
 * [준비과정]
 * 1. import java.util.Scanner;
 * 2. Scanner 객체 생성
 * 	  Scanner [객체명] = new Scanner(System.in);
 * 3. [객체명].nextXXX();
 * 	  -문자(열)을 입력받을 때 : next(), nextLine()
 * 		* next() : 공백 전까지 데이터를 입력받음
 * 		* nextLine() : 입력한 값을 모두 가지고 옴.
 * 					   \n을 기준으로 입력 여부를 판단.
 * 					   버퍼(임시공간)에 \n이 있으면 입력받은 것으로 판단.
 * 	 -정수형을 입력받을 때 : nextInt(), nextByte(), nextShort(), nextLong()
 *   -실수형을 입력받을 때 : nextDouble(), nextFloat()
 *   -논리형을 입력받을 때 : nextBoolean()	
 */
import java.util.Scanner;
public class C_KeyBoardInput {

	public static void main(String[] args) {
		
		// Scanner 객체 생성
		// Scanner [객체명] = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		
		// 나이를 입력받기
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		// int age;
		// age = sc.nextInt();
		
		sc.nextLine(); // 버퍼에서 \n을 제거
		
		// 이름을 입력받기
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();
	}

}
