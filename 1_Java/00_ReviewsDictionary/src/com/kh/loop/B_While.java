package com.kh.loop;

/*
 * 반복문 while
 * 
 * - 표현식
 * 
 * 			[초기식]
 * 			while(조건식) {
 * 				// 반복적으로 수행할 코드
 * 				[증감식] 
 * 			}	
 * 
 * - 동작 흐름
 * 			조건식 -> 조건식이 참(true)인 경우 -> 반복적으로 수행할 코드 
 * 		->	조건식 -> 조건식이 참(true)인 경우 -> 반복적으로 수행할 코드
 * 		-> 	조건식 -> 조건식이 거짓(false)인 경우 -> 반복문 종료 
 * 
 * - do~while문
 * 
 * 	* 표현식
 *				[초기식]
 * 				do {
 * 					// 반복적으로 수행할 코드
 * 					[증감식]
 * 				} while(조건식);
 * 
 * 	* 동작 흐름 : 									반복적으로 수행할 코드 실행 
 * 			->	조건식 -> 조건식이 참(true)인 경우 -> 반복적으로 수행할 코드 실행
 * 			-> 	조건식 -> 조건식이 참(true)인 경우 -> 반복적으로 수행할 코드 실행
 * 			-> 	조건식 -> 조건식이 거짓(false)인 경우 -> 반복문 종료
 *
 */
public class B_While {

	public static void main(String[] args) {
		
		int num = 1;
		while (num == 0) {
			System.out.println(num);
		}
		// 결과 : 출력되는 값이 없다.
		
		do {
			System.out.println(num);
		}while(num ==0);
		// 결과 : 1
		
		int sel = 9;
		do {
			System.out.println("1) 짝수 입력");
			System.out.println("2) 홀수 입력");
			System.out.println("9) 종료");
			
			// Scanner.. 입력받음
			
			if(sel != 1 && sel != 2 && sel !=9) {
				System.out.println("입력한 메뉴는 없습니다. 다시 입력하시오.");
				//break;		// 반복문 종료
				continue;		// 아래 코드를 수행하지 않고, 처음부터 다시 반복
			}
			
			// .... 1입력 시 짝수이다. 2입력 시 홀수이다....
		} while(sel != 9);
	
		
		do {
			if(sel == 9) {
				break;		//sel의 값이 9인 경우 반복문 종료
			}
		}while(true);
		
		String num1 = "10";
		String num2 = "10";
		System.out.println(num1.hashCode());
		System.out.println(num2.hashCode());
		
		num1 = "100";
		System.out.println(num1.hashCode());
		
		num1 = "10";
		System.out.println(num1.hashCode());
		
		int[] arr = new int[3];
		int[] arr2 = new int[3];
		
		System.out.println(arr);
		System.out.println(arr2);
		System.out.println(arr.hashCode());
		System.out.println(arr2.hashCode());
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
	}

}
