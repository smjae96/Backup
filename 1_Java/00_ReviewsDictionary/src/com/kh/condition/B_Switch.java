package com.kh.condition;

/*
 * 조건문 switch
 *  - 동등비교 시 많이 사용
 *  
 *  - 표현법
 *  
 *  		switch(조건식-비교대상) {
 *  			case 값1: 
 *  				// 비교대상 == 값1인 경우 수행할 코드
 *  				break;
 *  			case 값2:
 *  				// 비교대상 == 값2인 경우 수행할 코드
 *  				break;
 *  			default: 
 *  				// 위의 case에 값들이 모두 해당되지 않는 경우 수행할 코드
 *  				// 생략 가능.
 *  		}
 */
public class B_Switch {

	public static void main(String[] args) {
		
		// month 별로 계절 표현
		// 	- 겨울: 12, 1, 2
		//	- 봄: 3, 4, 5
		// 	- 여름: 6, 7, 8
		// 	- 가을: 9, 10, 11
		int month = 12;
		
		
		switch(month) {
		case 12, 1, 2:
			System.out.println("겨울");
			break;
		case 3, 4, 5:
			System.out.println("봄");
			break;
		case 6, 7, 8:
			System.out.println("여름");
			break;
		case 9, 10, 11:
			System.out.println("가을");
			break;
			default:
			System.out.println("계절 정보를 알 수 없음.");
		}
	}

}
