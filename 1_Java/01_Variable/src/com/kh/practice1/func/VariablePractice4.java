package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice4 {

	// 영어 문자열 값을 키보드로 입력 받아 문자에서 앞에서 세 개를 출력하세요.
	/*
	 * ex.
	 * 문자열을 입력하세요 : apple
	 * 
	 * 첫 번째 문자: a
	 * 두 번째 문자: p
	 * 세 번째 문자: p
	 */
	
	public void example4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열을 입력하세요 : ");
		String word = sc.nextLine();
		System.out.println("첫 번째 문자 : " +word.charAt(0));
		System.out.println("두 번째 문자 : " +word.charAt(1));
		System.out.println("세 번째 문자 : " +word.charAt(2));
	}
}
