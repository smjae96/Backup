package com.kh.practice.chap02;

import java.util.Scanner;

public class LoopPractice {
	Scanner sc = new Scanner(System.in);
	public void practice1() {
		//화면에 "1이상의 숫자를 입력하세요 : " 출력
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt(); // 정수형 데이터를 입력받아 변수에 대입
		
		//단, 입력한 수는 1보다 크거나 같아야 합니다.
		if(num>=1) {
			// 1부터 num까지 숫자를 출력
			/*
			 for(int i=1; i<=num; i++) {
				System.out.print(i + " ");
			}
			*/
			for(int i=0; i<num; i++) {
				System.out.print((i+1) + " ");
			}
		}
		else {	//num < 1
			// "1미만의 값이 입력되었습니다." 출력
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}
		
		/*if(num<1) {
			System.out.println("1미만의 값이 입력되었습니다.");
		}
		else { // num>=1
			//1부터 num까지 숫자를 출력
		}
		*/
	}
	
	public void practice2() {
		int num;
		 do {
			//------------------------------------
			//화면에 "1이상의 숫자를 입력하세요 : " 출력
			System.out.print("1이상의 숫자를 입력하세요 : ");
			num = sc.nextInt(); // 정수형 데이터를 입력받아 변수에 대입
		
			//단, 입력한 수는 1보다 크거나 같아야 합니다.
			if(num>=1) {
				// 1부터 num까지 숫자를 출력
			
				for(int i=1; i<=num; i++) {
					System.out.print(i + " ");
				}
			
			}
			else {	//num < 1
				// "1 이상의 숫자를 입력해주세요." 출력
				System.out.println("1 이상의 숫자를 입력해주세요.");
				//practice2();
			}	
			//------------------------------------------
		 }while(num<1);
	}
	
	public void practice3() {
		//사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 모든 숫자를 거꾸로 출력하세요.
		//단, 입력한 수는 1보다 크거나 같아야 합니다.
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		if(num>=1) {
			
			for(int i=num; i>=1; i--) {
				System.out.print(i + " ");
			}
		}
		else {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}
		
	}
	
	public void practice4() {
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		if(num>=1) {
			
			for(int i=num; i>=1; i--) {
				System.out.print(i + " ");
			}
		}
		else {
			System.out.println("1 이상의 숫자를 입력해주세요.");
			practice4();
		}
	}
	
	public void practice5() {
		System.out.print("정수를 하나 입력하세요 : ");
		int num = sc.nextInt();
		int sum = 0;
		for(int i=1; i<=num; i++) {
			sum +=i;
			System.out.print(i);
			
			if(i==num) {
				continue;
			}
			else {
				System.out.print(" + ");
			}
		}
		System.out.println(" = " +sum);
	}
	
	public void practice6() {
		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();
		
		if(num1<1 || num2<1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}
		else if(num1>=num2){
			for(int i=num2; i<=num1; i++) {
				System.out.print(i + " ");
			}
		}
		else {
			for(int i=num1; i<=num2; i++) {
				System.out.print(i + " ");
			}
		}
	}
	
	public void practice7() {
		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();
		
		if(num1<1 || num2<1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
			practice7();
		}
		else if(num1>=num2){
			for(int i=num2; i<=num1; i++) {
				System.out.print(i + " ");
			}
		}
		else {
			for(int i=num1; i<=num2; i++) {
				System.out.print(i + " ");
			}
		}
	}
	
	public void practice8() {
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		System.out.println("===== "+num+"단 =====");
		
		for(int i=1; i<10; i++) {
			System.out.println(num+" * " +i+ " = " +(num*i));
		}
	}
	
	public void practice9() {
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		
		if(num>9) {
			System.out.println("9 이하의 숫자만 입력해주세요.");
		}
		else {
			for(int j=num; j<10; j++) {
				System.out.println("===== " +j+"단 =====");
				for(int i=1; i<10; i++) {
					System.out.println(j+" * " +i+ " = " +(j*i));
				}
			}
		}
	}
	
	public void practice10() {
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		
		if(num>9) {
			System.out.println("9 이하의 숫자만 입력해주세요.");
			practice10();
		}
		else {
			for(int j=num; j<10; j++) {
				System.out.println("===== " +j+"단 =====");
				for(int i=1; i<10; i++) {
					System.out.println(j+" * " +i+ " = " +(j*i));
				}
			}
		}
	}
	
	public void practice11() {
		System.out.print("시작 숫자 : ");
		int startNum = sc.nextInt();
		System.out.print("공차 : ");
		int tolerance = sc.nextInt();
		
		
		for(int i=0; i< 10; i++) {
			System.out.print(startNum + " ");
			startNum += tolerance;
			
		}
	}
	
	public void practice12() {
		while(true) {
			System.out.print("연산자(+, -, *, /, %) : ");
			String operator = sc.next();
		
			if(operator.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			System.out.print("정수1 : ");
			int num1 = sc.nextInt();
			System.out.print("정수2 : ");
			int num2 = sc.nextInt();
		
			if((operator.equals("/") && num2==0)) {
				System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
				practice12();
			}

			if(operator.equals("+")) {
				System.out.println(num1+ " + " + num2 + " = " + (num1+num2));
				break;
			}
			else if(operator.equals("-")) {
				System.out.println(num1+ " - " + num2 + " = " + (num1-num2));
				break;
			}	
			else if(operator.equals("*")) {
				System.out.println(num1+ " * " + num2 + " = " + (num1*num2));
				break;
			}
			else if(operator.equals("/")) {
				System.out.println(num1+ " / " + num2 + " = " + (num1/num2));
				break;
			}
			else if(operator.equals("%")) {
				System.out.println(num1+ " % " + num2 + " = " + (num1%num2));
				break;
			}
			else {
				System.out.println("없는 연산자입니다. 다시 입력해주세요.");
				practice12();
			}
			
		}	

	}
	
	public void practice13() {
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		int starCount = 1;
		int spaceCount = num-1;
		int lineCount = num;
		
		for(int i=0; i<lineCount; i++) {
			for(int j=0; j<starCount; j++) {
				System.out.print("*");
			}
			for(int j=0; j<spaceCount; j++) {
				System.out.print(" ");
			}
			spaceCount--;
			starCount++;
			System.out.println();
		}
	}
	
	public void practice14() {
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		int starCount = num;
		int spaceCount = 0;
		int lineCount = num;
		
		for(int i=0; i<lineCount; i++) {
			for(int j=0; j<starCount; j++) {
				System.out.print("*");
			}
			for(int j=0; j<spaceCount; j++) {
				System.out.print(" ");
			}
			starCount--;
			spaceCount++;
			System.out.println();
		}
	}
}
