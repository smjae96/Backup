package com.kh.practice2.func;

import java.util.Scanner;

public class CastingPractice1 {

	// 키보드로 문자 하나를 입력 받아 그 문자의 유니코드를 출력하세요.
	/* ex. 
	 * 문자 : A
	 * A unicode : 65
	 */
	public void example1() {
		// import 없이 Scanner 사용하는 방법
	//	java.util.Scanner sc = new java.util.Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		System.out.print("문자 : ");
		//char word1 = sc.next().charAt(0); // 입력받은 문자열에서 첫번째 문자값을 word1 변수에 저장.
		String strWord1 = sc.nextLine();
		char word1 = strWord1.charAt(0);
		
		// 강제 형변환 : 문자형(char) -> 정수형(int)
		System.out.println(word1 + " unicode : " +(int)word1);
		
		System.out.print("문자 : ");
		String strWord2 = sc.nextLine();
		char word2 = strWord2.charAt(0);
		System.out.println(word2 + " unicode : " +(int)word2);
		
	}
}
