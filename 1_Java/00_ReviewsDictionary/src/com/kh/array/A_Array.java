package com.kh.array;

import java.util.Arrays;

public class A_Array {
	/*
	 * 배열 (1차원 배열)
	 * : "같은 자료형"의 "여러 개의 데이터"를 저장하는 공간
	 * 
	 * - 선언 방법
	 * 
	 * 		자료형[] 참조변수명;		// 선호하는 방식!
	 * 		자료형 참조변수명[];
	 * 
	 * - 할당(생성) 방법
	 * 
	 * 		참조변수명 = new 자료형[배열 길이];
	 * 
	 * - 값을 대입/참조
	 * 
	 * 		* 대입 : 참조변수명[인덱스] = 값;	// 인덱스: 위치를 의미. 0부터 시작!**
	 * 		* 참조 : 참조변수명[인덱스]
	 * 
	 *  - 배열 초기화(값을 최초로 대입)
	 *  
	 *  	* 자료형[] 참조변수명 = new 참조변수명[배열길이];
	 *  	  참조변수명[0] = 값1;
	 *  	  참조변수명[1] = 값2;
	 *  
	 *  	* 자료형[] 참조변수명 = new 참조변수명[]{값1, 값2, 값3};
	 *  	
	 *  	* 자료형[] 참조변수명 = {값1, 값2, 값3};
	 *  
	 *  - 배열 복사
	 *  
	 *  	* 얕은 복사: 배열의 주소 값만 복사하여 실제 데이터가 한 곳에서 관리
	 *  			
	 *  				[복사할 배열] = [원본 배열명];
	 *  			ex) int[] org = new int[3];		// 정수형 배열의 초기값은 0
	 *  				int[] copy = org;			// 얕은 복사
	 *  				copy[0] = 10;
	 *  				System.out.println(org[0]); // 결과 : 10
	 *  	
	 *  	* 깊은 복사: 새로운 배열 객체를 생성해서 기존 배열의 데이터를 복사
	 *  			
	 *  				* 배열A: 원본 배열, 배열B: 복사할 배열
	 *  				-반복문 사용
	 *  				for(int i=0; i<배열길이; i++) {
	 *  					// i: 0, 1, 2, ..., 배열길이-1
	 *  					배열B[i] = 배열A[i];	// 배열A의 i번째 위치의 데이터를
	 *  										// 배열B의 i번째 위치에 대입(복사)
	 *  				}
	 *  			
	 *  				- clone() 사용
	 *  					배열B = 배열A.clone();
	 *  
	 *  				- Arrays.copyOf() 사용
	 *  					배열B = Arrays.copyOf(배열A, 복사할 데이터 길이); 
	 *  								// 복사할 데이터 길이 자리에는 보통 배열A의 길이만큼 들어가므로 배열A.length 사용하는 경우가 많음.
	 *  
	 *  				- System.arraycopy() 사용
	 *  					System.arraycopy(배열A, 배열A 복사할 시작 위치(0), 배열B, 배열B 복사할 시작 위치(0), 복사할 데이터 길이);
	 *  
	 *   - 반복문 foreach문(향상된 for문)
	 *   	* 일반적인 for문 : for(초기식; 조건식; 증감식) {}
	 *   	* foreach문	  
	 *   					 for(자료형 변수명:배열명) {
	 *							 // 변수명 : 배열의 첫번째 위치의 데이터부터 마지막 위치의 데이터를 사용할 수 있다.
	 *						 }			    
	 *
	 *						 ex) int[] arr = {10, 20, 30};
	 *							 for(int item : arr) {
	 *								System.out.print(item + " ");
	 *							 }
	 *							 // 결과: 10 20 30	
	 *
	 *  
	 */
	public static void main(String[] args) {
		
		
		// 자동 정렬 : ctrl + shift + f
		
		// foreach문 사용하여 배열의 첫번째 데이터부터 마지막 데이터까지 출력
		int[] arr = { 10, 20, 30 };
		for (int item : arr) {
			System.out.print(item + " ");
		}
		System.out.println();
		System.out.println("================================================");
		
		// 배열 복사
		int[] a = { 1, 3, 5, 7};
		int[] b = new int[a.length];
		
		System.out.println("a 배열의 주소: " +a + ", b 배열의 주소: " +b);
		// -얕은 복사
		b= a;
		System.out.println("얕은 복사 후 주소");
		System.out.println("a 배열의 주소: " +a + ", b 배열의 주소: " +b);
		System.out.println("b 배열의 데이터: " + Arrays.toString(b));
		
		// a 배열의 3번째 위치에 값에 10을 더하기
		a[2] = a[2] + 10;					// Q. 복합 대입연산자를 사용하면? a[2] += 10;
		System.out.println("a 배열의 데이터: " + Arrays.toString(a));
		System.out.println("b 배열의 데이터: " + Arrays.toString(b));
		
		// - 깊은 복사
		int[] c = new int[a.length];
		// [1] 반복문
		System.out.println("a 배열의 주소: " +a + ", c 배열의 주소: " +c);
		
		for(int i=0; i<c.length; i++) {
			c[i] = a[i];
		}
		System.out.println("반복문으로 깊은 복사 후 주소");
		System.out.println("a 배열의 주소: " +a + ", c 배열의 주소: " +c);
		System.out.println("a 배열의 데이터: " + Arrays.toString(a));
		System.out.println("c 배열의 데이터: " + Arrays.toString(c));
		
		c[1] = c[1]-10;		//Q. 복합 대입연산자 사용하면? c[1] -= 10;
		System.out.println("a[1] : " +a[1]);	// 결과 ? 3	
		System.out.println("c[1] : " +c[1]);	// 결과 ? 3 - 10 = -7
		
		// [2] clone() 사용
		int[] d = new int[a.length];
		System.out.println("[복사 전] a 배열의 주소: " +a + ", d 배열의 주소: " +d);
		d = a.clone();
		System.out.println("[복사 후] a 배열의 주소: " +a + ", d 배열의 주소: " +d);
		a[0] = 9;
		
		System.out.println("a 배열의 데이터: " +Arrays.toString(a));
		System.out.println("d 배열의 데이터: " +Arrays.toString(d));
		
		// [3] Arrays.copyOf 사용
		int[] e = new int[a.length];
		System.out.println("[복사 전] a 배열의 주소: " +a + ", e 배열의 주소: " +e);
		e = Arrays.copyOf(a, a.length);
		System.out.println("[복사 후] a 배열의 주소: " +a + ", e 배열의 주소: " +e);
		
		e[0] = e[0] * 2;			// Q.복합 대입연산자 사용? e[0] *= 2;
		System.out.println("a 배열의 데이터: " +Arrays.toString(a));
		System.out.println("e 배열의 데이터: " +Arrays.toString(e));
		
		// [4] System.arraycopy() 사용 			// 복사한 후에도 주소가 바뀌지 않음. 따로 객체가 생성되지 않는다.
		int[] f = new int[a.length];
		System.out.println("[복사 전] a 배열의 주소: " +a + ", f 배열의 주소: " +f);
		System.arraycopy(a, 0, f, 0, a.length); // a 배열의 첫번째 위치부터 a 배열 길이만큼
												// f 배열의 첫번째 위치부터 복사
		System.out.println("[복사 후] a 배열의 주소: " +a + ", f 배열의 주소: " +f);
		
		System.out.println("a 배열의 데이터: " +Arrays.toString(a));
		System.out.println("f 배열의 데이터: " +Arrays.toString(f));
		
	}

}
