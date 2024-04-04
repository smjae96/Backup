package com.kh.loop;

/*
 *  반복문 for
 *  - 조건에 따라 반복적으로 특정 코드를 수행
 *  
 *  - 기억할 3가지
 *    (1) 변수	: 초기화 		int num =1;
 *    (2) 연산자	: 증감연산자 	num++, num--
 *    (3) 조건문	: 조건식		num < 10
 *  - 표현법
 *  		for(초기식; 조건식; 증감식) {
 *				// 반복적으로 수행할 코드  		
 *  		}
 *  		* 초기식: 반복문이 수행될 때 "최초 한번만 실행하는 구문"
 *  		* 조건식: 반복문을 수행할 조건
 *  				- 조건식이 true이면 반복적으로 수행할 코드 실행
 *  				- 조건식이 false이면 반복문을 종료
 *  		* 증감식: 반복문을 제어하는 변수의 값을 변화시키는 구문 
 *  		------------------------------------------
 *  	- 반복문 수행 흐름
 *  		초기식 -> 조건식 -> 조건식이 참(true)인 경우 -> 반복적으로 수행할 코드 -> 증감식
 *  			 -> 조건식 -> 조건식이 참(true)인 경우 -> 반복적으로 수행할 코드 -> 증감식
 *  			---------- 계속 반복 ------------(조건식이 참인 동안)	
 *  			 -> 조건식 -> 조건식이 거짓(false)인 경우 -> 반복문 종료	
 *  
 *   - 초기식, 조건식, 증감식 생략
 *   	세미콜론(;)은 꼭 작성해야 함.
 *   	* 초기식 생략 : for(;조건식;증감식) {}
 *   	* 조건식 생략 : for(초기식;;증감식) {}
 *   	* 증감식 생략 : for(초기식;조건식;) {}
 *   	for(;;증감식) {} // 초기식, 조건식 생략	
 * 
 */
public class A_For {

	public static void main(String[] args) {
		
		// "Loop" 문자열의 한 글자씩 출력
		// 문자열 길이 : [문자열 변수 또는 값].length()
		// 문자열 원하는 위치의 문자 : [문자열 변수 또는 값].charAt(index)
		String loop = "Loop";
		int len = loop.length(); // 길이만큼 반복문을 사용하려고
		char ch = loop.charAt(0);
		
		// 초기식;조건식;증감식에서 사용할 변수를 index의 값으로 사용
		for(int i=0; i<len; i++) {
			// i(index) => 0, 1, 2, 3
			// len => 4
			ch = loop.charAt(i);
			System.out.printf("index(%d), %d번째 위치의 값 %c\n", i, (i+1), ch);
		//	System.out.println(i+ ") " + ch);
		}
		
		// 총 합 구하기 ( 1 ~ n까지)
		/*
		 * 랜덤 값 : Math.Random()
		 * 		   0.0 ~ 0.999999 ( 0<= n <1)
		 * ex) 1~10 까지 랜덤 값
		 * 	  : (int)(Math.Random()*10+1)
		 * 			0.0 ~ 0.999999 * 10 +1
		 * 			=> 0.0 ~ 9.999999 + 1
		 * 			=> 1 ~ 10
		 */
		// 1 ~ 10까지 랜덤 값을 변수에 저장하고, 1부터 그 값까지의 총 합
		int random = (int)(Math.random()*10+1);
		int result = 0;
		System.out.println("random : " +random);
		System.out.println(" == result + i = result ==");
		for(int i=1; i<=random; i++) {
			// 1 + 2 + 3 + 4 + 5 + .... + n
			System.out.printf("%d + %d = ", result, i );
			result += i;		// result = result + i
			System.out.print(result + "\n");
			
		}
		
//		for(int i=random; i>=1; i--) {
//			System.out.printf("%d + %d = ", result, i );
//			result += i;		// result = result + i
//			System.out.print(result + "\n");
//		}
	}

}
