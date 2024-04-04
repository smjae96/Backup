package com.kh.practice1.func;

import java.util.Calendar;
import java.util.Scanner;

public class VariablePractice0 {
	Scanner sc = new Scanner(System.in);
	/*
	 *  예제 1)
	 *  변수를 사용하여 아래 코드를 이해하기 쉽도록 변경하자.
	 *  - 연도에 해당하는 값을 정수형(int) 타입의 year이라는 이름의 변수로 선언 및 대입.
	 *  - 나이에 해당하는 값을 정수형(int) 타입의 age라는 이름의 변수로 선언 및 대입.
	 */
	
	public void example01() {
		// 변수를 사용하지 않은 경우
		System.out.println("[1]현재 2023년이고, 나는 올해 36살입니다.");
		
		// 변수 선언 및 대입
		int year = 2023; // year 정수형 변수 선언 후 2023 값을 대입
		int age = 36;	// age 정수형 변수 선언 후 36 값을 대입
		// 변수를 사용하여 화면에 출력
		//1) System.out.print([출력할 값(문자열, 숫자, )]);
		System.out.print("[2]현재 " + year + "년이고, " +"나는 올해 " + age + "살입니다.");
		//2) System.out.println([출력할 값(문자열, 숫자, )]);
		System.out.println("[3]현재 " + year + "년이고, " +"나는 올해 " + age + "살입니다.");
		//3) System.out.printf("출력할 내용(지시어1, 지시어2, ...)" , 변수1, 변수2, ...);
		System.out.printf("[4]현재 %d년이고, 나는 올해 %d살입니다.", year, age);
		// 위에 선언한 변수의 값을 올해와 본인의 나이로 변경하여 출력
		year = 2024;
		age = 28;
		System.out.println("[5]현재 " + year + "년이고, " +"나는 올해 " + age + "살입니다.");
		// 위에 선언한 변수의 값을 본인 출생년도와 본인의 만 나이로 변경하여 출력
		year = 1996;
		age = 27;
		System.out.println("나는 " + year + "년생이고, " + "올해 만 " + age + "세입니다." );
	}
	
	/*
	 * 예제 2) 변수명 명명 규칙
	 * 잘못 정의된 변수 이름을 확인하여 주석의 괄호 안에 명명규칙 중 어떤 부분에 해당하는 지
	 * 기입한 후 오류가 발생하지 않도록 변경해보자.
	 * [변수명 명명 규칙]
	 * (1) 대소문자가 구분된다.
	 * (2) 예약어를 사용할 수 없다.
	 * (3) 숫자로 시작할 수 없다.
	 * (4) 특수문자 '_'와 '$'만 사용 가능하다.
	 * (5) 낙타표기법 사용한다.
	 */
	public void example02() {
		// [1] 변수명 규칙 (3	) 해당
		//int 1num = 10; -> 변수는 숫자로 시작할 수 없으므로 변수명을 num으로 변경해준다.
		int num = 10;
		//System.out.println("1num의 값은 " + 1num + "입니다."); -> 마찬가지로 변수명을 1num이 아닌 num으로 변경해준다.
		System.out.println("[1]num의 값은 " + num + "입니다.");
		
		// [2] 변수명 규칙 (2	) 해당
		//boolean break = true; -> break는 예약어이므로 변수명으로 사용할 수 없다. 따라서 변수명을 breaker로 변경해준다.
		boolean breaker = true;
		//System.out.printf("break의 값은 %b 입니다." , break); -> 마찬가지로 변수명을 break가 아닌 breaker로 변경해준다.
		System.out.printf("[2]breaker의 값은 %b 입니다." , breaker);
		
		// [3] 변수명 규칙 (1	) 해당
		int age;
		int Age = 15;
		age = 20;
		System.out.printf("[3]나이에 해당하는 변수 값 확인 > %d, %d\n", age , Age);
		// 위의 출력 결과 ? 
		// 나이에 해당하는 변수 값 확인 > 20, 15   <- 처럼 콘솔에 출력될 것이다.
		// 변수는 대소문자를 구분하기 때문에 age라는 변수명으로 선언된 변수와 Age라는 변수명으로 선언된 변수는 서로 다른 변수이다.
		
		// [4] 변수명 규칙 (4	) 해당
		// int d-day = 5; -> 변수명에 사용 가능한 특수문자는 '_'와 '$'뿐이다. 따라서 '-'는 변수명에 들어갈 수 없다.
		int d_day = 5; // 변수명에 사용 가능한 특수문자 '_'로 변경해주었다.
		//System.out.println("크리스마스까지 " + d-day + "일 남았습니다."); -> 마찬가지로 변수명을 d-day가 아닌 d_day로 변경해주어야 한다.
		System.out.println("[4]크리스마스까지 " + d_day + "일 남았습니다.");
	}
	
	public void example02p1() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		cal2.get(Calendar.MONTH);
		cal2.set(Calendar.DATE, 25);
		
		int today = cal1.get(Calendar.DAY_OF_MONTH);
		int christmas = cal2.get(Calendar.DAY_OF_MONTH);
		
		int d_day = christmas - today;
		System.out.println("크리스마스까지 " + d_day + "일 남았습니다.");
	}
	// 12월 31일 날짜를 변수로 하나 더 설정해줘서 계산을 해보자.
	public void example02p2() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		cal2.set(Calendar.YEAR, 2024);
		cal2.set(Calendar.MONTH, Calendar.DECEMBER);
		cal2.set(Calendar.DATE, 25);
		
		int today = cal1.get(Calendar.DAY_OF_YEAR);
		int christmas = cal2.get(Calendar.DAY_OF_YEAR);
		
		int d_day = christmas - today;
		System.out.println(christmas + ", " + today);
		System.out.println("내년 크리스마스까지 " +d_day+ "일 남았습니다.");
	}
	/*
	 * 예제 3) 
	 * 	키와 몸무게 값을 저장하기 위해 각각 키는 double형의 height라는 이름으로,
	 * 	몸무게는 int형의 weight라는 이름으로 변수를 선언.
	 * 
	 * 	내가 원하는 키와 몸무게의 값을 변수에 대입.
	 * 
	 * 	아래와 같이 출력해보자.
	 * 	출력 예시) "내가 원하는 키는 168.2cm이고, 몸무게는 48kg입니다."
	 */
	public void example03() {
		// 변수 선언
		double height;
		int weight;
		height = 177.3;
		weight = 65;
		System.out.println("[1]내가 원하는 키는 " + height + "cm이고, 몸무게는 " + weight + "kg입니다.");
		System.out.printf("[2]내가 원하는 키는 %.1fcm이고, 몸무게는 %dkg입니다." , height, weight);

	
	}
	/*
	 * 예제 4) 상수
	 * 놀이동산에 있는 놀이기구의 탑승 제한.
	 * 제한 몸무게에 대한 값을 상수로 선언.
	 * "몸무게가 80kg 이상인 경우 탑승을 못합니다."
	 */
	public void example04() {
		// 상수 선언
		final int LIMIT_WEIGHT = 80;
		//LIMIT_WEIGHT = 99; // 상수는 값을 변경할 수 없다.
		// 출력
		System.out.printf("몸무게가 %dkg 이상인 경우 탑승을 못합니다." , LIMIT_WEIGHT);
	}
	
	public void example04p() {
		int limitWeight = 68;
		if(limitWeight>80) {
			System.out.printf("몸무게가 %dkg입니다. 몸무게가 80kg을 초과하는 경우 탑승할 수 없습니다." , limitWeight);
		}
		else {
			System.out.printf("몸무게가 %dkg입니다. 몸무게가 80kg 이하인 경우 탑승을 할 수 있습니다." , limitWeight);
		}
	}
	/*
	 * 예제 5) 형변환
	 * 	연산을 할 때 자료형의 종류가 다른 경우 형 변환이 발생하는데,
	 * 	아래 규칙에 따라 형 변환이 발생한다.
	 * 	1) 자료형의 값의 범위가 (작은) 방향에서 (큰) 방향으로 형변환 발생.
	 * 	2) 정수형과 실수형의 연산 시 (정수) 자료형에서 (실수) 자료형으로 형변환 
	 */
	public void example05() {
		int num1 = 10;
		double dNum1 = 5.5;
		
		//자동 형변환
		System.out.println(num1 + dNum1); 	// 결과	? 15.5
		//강제 형변환
		System.out.println(num1 + (int)dNum1); // 결과	? 15
		
		char ch = 'A';
		System.out.println(ch);	//결과	? A
		//강제 형변환
		System.out.println((int)ch); //결과	? 65	
		//자동 형변환
		System.out.println(ch+3); //결과	? 68
		// ch + 3 > (int)ch +3 > 65 + 3 > 68
		
		//강제 형변환
		System.out.println((char)(ch+3));	//결과	? D
		//	(ch+3) > (char)68 > D?
	}
	/*
	 * 예제 6) 입력메소드 : Scanner
	 *  [예제 3]에 키와 몸무게에 값을 대입했던 것을 사용자로부터 입력받도록 변경하여
	 *  결과를 출력해보자.
	 *  [Scanner 사용하기 위해 준비 과정]
	 *  1) import java.util.Scanner;
	 *  2) Scanner 생성
	 */
	public void example06() {
		// Scanner 생성
		Scanner sc = new Scanner(System.in);
		
		// 키에 대한 값을 입력받도록
		System.out.print("원하는 키를 입력하시오: ");
		// 사용자로부터 입력받은 값을 height 변수에 대입
		double height = sc.nextDouble();
		// 몸무게에 대한 값을 입력받도록 화면에 출력하고
		System.out.print("원하는 몸무게를 입력하시오: ");
		// 사용자로부터 몸무게의 값을 입력받아 정수형 weight 변수에 대입
		int weight = sc.nextInt();
		//출력 예시) "내가 원하는 키는 177.7cm이고, 몸무게는 77kg입니다.
		System.out.printf("내가 원하는 키는 %.1fcm이고, 몸무게는 %dkg입니다." , height, weight);
		System.out.println();
		System.out.println("내가 원하는 키는 " + height + "cm이고, 몸무게는 " + weight + "kg입니다.");
	}
	

	


}
