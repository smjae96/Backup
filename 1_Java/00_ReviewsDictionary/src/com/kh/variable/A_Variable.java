package com.kh.variable;
/*
 * 변수 : 메모리에서 어떤 값을 저장(보관)하기 위한 공간
 * 
 * 선언
 * 		[자료형] [변수명];
 * 
 * 대입
 * 		[변수명] = [값];
 * 
 * 자료형 종류
 * 		(1) 문자 관련 자료형
 * 			- 문자형 : char (2B), '가' , 'a' , '0' , 'abc'(x)
 * 				     데이터가 한글자씩 작은따옴표로 표현.
 * 			- 문자열 : String, "가" , "가나다", "abc", "10"
 * 					 데이터가 한글자부터 N개의 글자까지 큰 따옴표로 표현.
 * 		(2) 숫자 관련 자료형
 * 			- 정수형 : int (4B), byte (1B) , short (2B) , long (8B)
 * 					 딱 떨어지는 수. 1, 10, -5, 0, ...
 * 			- 실수형 : double (8B) , float (4B)
 * 					 소수점으로 표현되는 수. 3.1415, 0.08, -2.123, ...
 * 		(3) 논리형
 * 			- 참/거짓, true/false
 * 			- boolean
 * 
 * 변수명 명명 규칙
 * 		(1) 대소문자가 구분된다.
 * 			- 클래스는 대문자로 시작하고, 변수/메소드 등은 소문자로 시작하기 (관례) 
 * 		(2) 예약어 사용 불가
 * 			- 예약어: 용도가 정해져있는 이름들
 * 		(3) 숫자로 시작할 수 없다.
 * 		(4) 특수문자는 '_'와 '$'만 사용 가능하다.
 * 		(5)	낙타표기법(camelcase) (관례)
 * 			- apple pie => applePie
 * 			- user name => userName
 * 
 * 상수 : 대입한 후에 값을 변경할 수 없는 공간
 * 		- final 키워드(예약어)를 사용하여 선언
 * 		  final [자료형] [변수명];
 * 
 * 		- 변수명 명명 규칙
 * 		  (1) 모든 문자는 대문자로 표현
 * 		  (2) 단어 연결은 '_'를 사용
 * 			  - apple pie => APPLE_PIE
 * 			  - user name => USER_NAME
 * 
 * 	 	 	
 */
public class A_Variable {
	public static void main(String[] args) {
		
		// 문자형 ch라는 이름의 변수를 선언하고, h 라는 값을 대입
		// [자료형] [변수명];
		char ch;		// 변수 선언
		// [변수명] = [값];
		ch = 'h';
		
		// ch 변수의 값을 출격
		System.out.println("문자형 ch 변수의 값: " +ch);
		
		// hi 라는 값을 변수에 저장
		String str = "hi";
		// str 변수의 값을 출력
		System.out.println("문자열 str 변수의 값: " +str);
		System.out.printf("문자열 str 변수의 값: %s\n",str);
		
		// 0.36 데이터를 변수에 저장 (선언+대입)
		double num = 0.36;
		
		float num2;
		num2 = 0.36f;		// 실수형은 double이 기본 자료형이므로
							// float 자료형의 경우 값 오른쪽에 f를 붙여야 함.
		
		//int num;			// 변수의 이름을 기준으로 데이터를 가져오므로 위에서 선언한 num이라는 이름의 변수가 있으므로 같은 이름의 변수를 새로 선언할 수 없다.
		int num3 = 10;
		long num4 = 10l;	// long 자료형의 경우 값 오른쪽에 L을 붙여줘야 함. 
							// long num4 = 10;으로 써도 오류가 나지 않음. => 자동형변환 된 것이기 때문. long num4 = (long)10;
							// 10 이라고 대입했을 때는 int형에서 long형으로 자동형변환이 되어 오류 발생하지 않음.
		
		// 논리형
		boolean isTrue;		// 변수 선언
		isTrue = true;		// 대입
		
		boolean isFalse;
		isFalse = 1> 3+2;	// 비교 연산자를 사용하여 값을 대입
							// 1 > 3 + 2 : 1이라는 값이 3+2보다 큰가?
							// 결과: false
		System.out.println("isTrue의 값은: " +isTrue);
		System.out.printf("isFalse의 값은: %b\n", isFalse);
		
		// ---------------------------------------------------
		
		// 상수: 변하지 않는 값을 보관
		// 정수형 나이에 해당하는 값을 보관
		final int AGE = 10;  // 이 값을 고정.
		
		System.out.println(AGE);
		
		//AGE = 20;		// 값을 한 번 대입한 후에는 변경할 수 없음.
		
		// 대표적인 상수. 자바에서 제공하는 상수.
		System.out.println("PI의 값은: " +Math.PI);
		
	}
}
