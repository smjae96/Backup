package com.kh.practice;
/*
 * <변수명 명명 규칙>
 * [1] 대소문자 구분되고, 길이 제한 없음
 * [2] 예약어를 변수명으로 사용할 수 없음(예약어: 용도가 정해져 있는 이름들)
 * [3] 숫자로 시작할 수 없음
 * [4] 특수문자는 '_' 와 '$'만 사용 가능
 * [5] 낙타표기법 : 소문자로 시작해서, 여러 개의 단어를 쓸 경우 대문자로 구분
 */
public class Practice01 {

	public static void main(String[] args) { //String 자료형의 args라는 이름의 변수
		// [1] 대소문자를 구별한다.
		// 정수형(int) 자료형의 "num" 이름으로 변수 선언
		int num = 10;
		int Num = 50;
		int nuM = 90;
		int NUM = 20;
		System.out.println("==== [1] 대소문자 구별 확인 ====");
		System.out.println("num: " + num + ", Num: " + Num);
		// 예상 결과) num: 10, Num: 50
		System.out.println("nuM: " + nuM + ", NUM: " + NUM);
		// 예상 결과) nuM: 90, NUM: 20
		
		// [2] 예약어를 변수명으로 사용할 수 없음
		/*
		//예약어 사용 불가
		int int;
		int boolean;
		int if;
		int while;
		*/
		/////
		/// 예약어가 아닌 경우 사용 가능
		int String = 10;
		String Practice01;
		
		
		// [3] 숫자로 시작할 수 없음
		/* 숫자로 시작할 경우 변수 선언 불가!
		int 3user;
		String 1str;
		double 9round;
		*/
		
		// [4] 특수문자는 ( _ ) 와 ( $ ) 만 사용 가능
		int _int;
		int $int;
		/* _와 $ 외에는 사용 불가.
		int #aaa;
		int @bbb;
		int (ddd);
		*/
		
		// [5] 낙타표기법(camelcase) 사용 (관례)
		//		:소문자로 시작해서 다음 단어의 시작은 대문자로!
		// 고객명	: customer name "홍길동" , "아이유"
		// 고객번호 : customer no/num
		// 고객id/pw : customer id/pw "hong12" / "q12w!@#"
		String customerName;
		int customerNo;
		String customerId;
		String customerPw;
		
		
	}

}
