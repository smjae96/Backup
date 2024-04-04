package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice1 {

	// 이름, 성별, 나이, 키를 사용자에게 입력 받아 각각의 값을 변수에 담고 출력하세요.
	//ex. 이름을 입력하세요: 아무개
	//	  성별을 입력하세요(남/여): 남
	// 	  나이를 입력하세요: 20
	// 	  키를 입력하세요(cm): 180.5
	
	public void example1() { 
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요: ");
		String name = sc.nextLine(); // nextLine : 문자열을 입력받는 메소드
		System.out.print("성별을 입력하세요(남/여): ");
		// '남' , '여'
		// "남자" -> '남' , '자'
		// "남", "여" -> '남', '여'
		String strGender = sc.next(); // next : 문자열을 입력받는 메소드, 공백 전까지
		char gender = strGender.charAt(0); // charAt(index) : 문자열에서 index 위치의 값을 문자형으로 가지고 오는 메소드
		//sc.next().charAt(0); 으로 써도 된다.
		System.out.print("나이를 입력하세요: ");
		int age = sc.nextInt();
		System.out.print("키를 입력하세요(cm): ");
		double height = sc.nextDouble();
		System.out.println("키 " + height + "cm인 " + age + "살 " + gender + "자 " + name + "님 반갑습니다^^");
		System.out.printf("키 %.1fcm인 %d살 %c자 %s님 반갑습니다^^" , height, age, gender, name);
	}
	
	
	
	
}
