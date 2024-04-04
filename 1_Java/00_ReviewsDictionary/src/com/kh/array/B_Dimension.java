package com.kh.array;

import java.util.Arrays;

/*
 * 배열 (2차원 배열)
 * : 자료형이 같은 1차원 배열의 묶음
 * 	 배열 안에 배열이 존재
 * 	 인덱스 ( 2 )개 필요. **(인덱스 시작번호: 0)**
 * 
 * - 선언 방법
 * 
 * 			자료형[][] 참조변수명;
 * 
 * - 할당(생성)
 * 
 * 			참조변수명 = new 자료형[행크기(2차원배열길이)][열크기(1차원배열길이)];
 * 
 * 			* 가변길이의 배열 할당: 열 크기를 지정하지 않고, 각 다른 길이의 1차원 배열을 생성
 * 				참조변수명 = new 자료형[행크기(2차원배열길이)][];
 * 
 * - 값을 대입
 * 			
 * 			참조변수명[행 인덱스] = {값1, 값2, 값3}; // 행 인덱스 위치에 있는 1차원 배열에 접근
 * 			참조변수명[행 인덱스][열 인덱스] = 값;
 * 
 * - 값을 참조
 * 			
 * 			참조변수명[행 인덱스];				// 행 인덱스 위치에 배열로 접근(참조)
 * 											// 배열 길이: 참조변수명[행 인덱스].length
 * 											// 배열 데이터 확인: Arrays.toString(참조변수명[행 인덱스]);
 * 			
 * 			참조변수명[행 인덱스][열 인덱스];		// 행 인덱스, 열 인덱스 위치의 데이터 접근
 * 
 * - 배열 초기화
 * 		
 * 			자료형[][] 참조변수명 = { 1차원 배열1, 1차원 배열2, 1차원 배열3, ...};
 * 							 = { {값1, 값2, 값3}, {값4, 값5, 값6}, ...};
 * 
 * 			참조변수명[0] = {값1, 값2, 값3};
 * 			참조변수명[1] = {값4, 값5, 값6};		// 값5 접근: 참조변수명[1][1]
 * 			참조변수명[n-1] = {값a, 값b, 값c};
 * 
 * 	
 * 
 */
public class B_Dimension {

	public static void main(String[] args) {
		
		// 문자열 2차원 배열 선언 및 할당
		// [초기값]
		/*{
			{"김지연", "정필교", "유지민"},
			{"박민영", "최성희", "최지우"},
			{"공지철", "김동현", "소지섭"}
		  }
		 */
		String[][] arr = {
				{"김지연", "정필교", "유지민"},
				{"박민영", "최성희", "최지우"},
				{"공지철", "김동현", "소지섭"}
  			};
		// 출력 : 반복문 몇 개 필요? 인덱스 개수만큼.. 2개
		/*
		 * foreach 문
		 * 				for(자료형 변수명:배열명) { // 변수명으로 데이터 접근 가능! }
		 * 				 이 때 변수명은 내 맘대로 정하면 된다.	
		 */
			int index =0; // 향상된 for문 사용할 경우 조를 표시해주기 위해 index 변수 선언 및 초기화
			for( String[] names : arr) {
				System.out.print((++index) + "조 : ");
				for(String name : names) {
					System.out.print(name + " ");
				}
				System.out.println();
			}
			
//			for(int i=0; i<arr.length; i++) {
//				System.out.print(i+1 + "조: ");
//				for(int j=0; j<arr[i].length; j++) {
//					System.out.print(arr[i][j] + " ");
//				}
//				System.out.println();
//			}
		/*
		 * 1조 : 김지연 정필교 유지민
		 * 2조 : 박민영 최성희 최지우
		 * 3조 : 공지철 김동현 소지섭
		 */
		
		// 각 조별로 오름차순 정렬 후 다시 출력
		for(int i=0; i<arr.length; i++) {
			Arrays.sort(arr[i]);
		}
		System.out.println("-----------------------------");
		for(int i=0; i<arr.length; i++) {
			System.out.print(i+1 + "조 : ");
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		
/*		index =0;
		for( String[] names : arr) {
			System.out.print((++index) + "조 : ");
			for(String name : names) {
				System.out.print(name + " ");
			}
			System.out.println();
		}
*/		
			

	
		
		
		
	}

}
