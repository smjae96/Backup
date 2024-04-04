package com.kh.practice.func;

import java.util.Scanner;

public class OperatorPractice {
	
	public void practice1() {
		//키보드로 입력 받은 하나의 정수가 양수이면 "양수다", 양수가 아니면 "양수가 아니다"를 출력하세요.
		/* ex.
		 * 정수 : -9
		 * 양수가 아니다.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		String result = (num>0) ? "양수이다." : "양수가 아니다.";
		
		System.out.println(result);
		
	}
	
	public void practice2() {
		//키보드로 입력 받은 하나의 정수가 양수이면 "양수다", 양수가 아닌 경우 중에서 0이면 "0이다", 0이 아니면 "음수다"를 출력하세요.
		/* ex.
		 * 정수 : -9
		 * 음수다.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		String result = (num>0) ? "양수이다." : 
							((num==0) ? "0이다" : "음수다");
		
		System.out.println(result);
	}
	
	public void practice3() {
		// 키보드로 입력 받은 하나의 정수가 짝수이면 "짝수다", 짝수가 아니면 "홀수다"를 출력하세요.
		/* ex.
		 * 정수 : 5
		 * 홀수다
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		String result = (num%2==1) ? "홀수이다." : "짝수이다.";
		
		System.out.println(result);
	}
	
	public void practice4() {
		// 모든 사람이 사탕을 골고루 나눠가지려고 한다. 인원 수와 사탕 개수를 키보드로 입력 받고
		// 1인당 동일하게 나눠가진 사탕 개수와 나눠주고 남은 사탕의 개수를 출력하세요.
		/*ex.
		 * 인원 수 : 29
		 * 사탕 개수 : 100
		 * 
		 * 1인당 사탕 개수 : 3
		 * 남는 사탕 개수 : 13
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인원 수: ");
		int people = sc.nextInt();
		System.out.print("사탕 개수: ");
		int candy = sc.nextInt();
		
		int divided = candy/people;
		int left = candy%people;
		System.out.println("1인당 사탕 개수: " +divided );
		System.out.println("남는 사탕 개수: " +left);
		
	}
	
	public void practice5() {
		// 키보드로 입력 받은 값들을 변수에 기록하고 저장된 변수 값을 화면에 출력하여 확인하세요.
		// 이 때 성별이 'M'이면 남학생, 'M'이 아니면 여학생으로 출력 처리 하세요.
		
		/* ex.
		 * 이름 : 박신우
		 * 학년(숫자만) : 3
		 * 반(숫자만) : 4
		 * 번호(숫자만) : 15
		 * 성별(M/F) : F
		 * 성적(소수점 아래 둘째자리까지) : 85.75
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("이름: ");
		String name = sc.next();
		System.out.print("학년(숫자만): ");
		int grade = sc.nextInt();
		System.out.print("반(숫자만): ");
		int classno = sc.nextInt();
		System.out.print("번호(숫자만): ");
		int studentno = sc.nextInt();
		System.out.print("성별(M/F): ");
		char gender = sc.next().charAt(0);
		System.out.print("성적(소수점 아래 둘째자리까지) : ");
		double score = sc.nextDouble();
		
		String result = (gender == 'F') ? "여학생" : "남학생";
		
		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f이다.", grade, classno, studentno, name, result, score );
	}
	
	public void practice6() {
		//나이를 키보드로 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지,
		//성인(19세 초과)인지 출력하세요.
		
		/* ex.
		 * 나이 :
		 * 청소년
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("나이: ");
		int age = sc.nextInt();
		String result = (age<=13) ? "어린이" : 
						(age>19) ? "성인" : "청소년";
		System.out.println(result);
	}
	
	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어: ");
		int score1 = sc.nextInt();
		System.out.print("영어: ");
		int score2 = sc.nextInt();
		System.out.print("수학: ");
		int score3 = sc.nextInt();
		
		int total = score1 + score2 + score3;
		System.out.println("합계: " +total);
		System.out.println("평균: " +total/3.0);
		String result = ((total/3.0)>=60.0) ? "합격" : "불합격"; 
		System.out.println(result);
		
	}
	
	public void practice8() {
		//주민번호를 이용하여 남자인지 여자인지 구분하여 출력하세요.
		
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호를 입력하세요(- 포함): ");
		String num = sc.nextLine();
		
		// [문자열].charAt(index);	: 문자열에서 index 위치의 문자를 반환
		char gender = num.charAt(7);
		
		//char (2바이트) int (4바이트)
		// 남자: 1,3 / 여자: 2,4
		String result = (num.charAt(7) == '2' || num.charAt(7) == '4') ? "여자" : "남자";
		// 132456-9123456 => 알 수 없음
		System.out.println((gender == '2' || gender == '4') ? "여자" : 
							((gender == '1' || gender == '3') ? "남자" : "알 수 없음"));
		//System.out.println(result);
	}
	
	public void practice9() {
		// 키보드로 정수 두 개를 입력 받아 각각 변수(num1, num2)에 저장하세요.
		// 그리고 또 다른 정수를 입력 받아 그 수가 num1 이하거나 num2 초과이면 true를 출력하세요.
		// 아니면 false를 출력하세요.
		// (단, num1은 num2보다 작아야 함)
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수1: ");
		int num1 = sc.nextInt();
		System.out.print("정수2: ");
		int num2 = sc.nextInt();
		System.out.print("입력: ");
		int inputting = sc.nextInt();
		
		// 입력받은 값이 num1 이하거나 입력받은 값이 num2 초과 : inputting <= num1 || inputting > num2
		// 단, num1이 num2보다 작아야 한다. : num1<num2
		// num1<num2가 false이면 (inputting<=num1 || inputting>num2)를 연산할 필요가 없이 결과는 false이다.
		System.out.println((num1<num2) && (inputting<=num1 || inputting>num2));
		boolean result = ((num1<num2) && (inputting<=num1 || inputting>num2)) ? true: false;
		//System.out.println(result);
		
	}
	
	public void practice10() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력1: ");
		int num1 = sc.nextInt();
		System.out.print("입력2: ");
		int num2 = sc.nextInt();
		System.out.print("입력3: ");
		int num3 = sc.nextInt();
		
		boolean result = (num1==num2 && num2==num3 && num1==num3) ? true : false;
		System.out.println(result);
	}
	
	public void practice11() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("A사원의 연봉: ");
		int sal1 = sc.nextInt();
		System.out.print("B사원의 연봉: ");
		int sal2 = sc.nextInt();
		System.out.print("C사원의 연봉: ");
		int sal3 = sc.nextInt();
		
		String aSal = (sal1+sal1*0.4>=3000) ? "3000 이상" : "3000 미만";
		String bSal = (sal2>=3000) ? "3000 이상" : "3000 미만";
		String cSal = (sal3+sal3*0.15>=3000) ? "3000 이상" : "3000 미만";
		
		System.out.println("A사원 연봉/연봉+a: "+sal1+"/"+(sal1+sal1*0.4));
		System.out.println(aSal);
		System.out.println("B사원 연봉/연봉+a: "+sal2+"/"+(double)(sal2));
		System.out.println(bSal);
		System.out.printf("C사원 연봉/연봉+a: %d/%.13f\n", sal3 , sal3*(1+0.15));
		System.out.println(cSal);
		
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("A사원의 연봉: ");
//		int salA = sc.nextInt();
//		System.out.print("B사원의 연봉: ");
//		int salB = sc.nextInt();
//		System.out.print("C사원의 연봉: ");
//		int salC = sc.nextInt();
//		
//		//인센티브
//		double incA = 0.4;
//		double incB = 0.0;
//		double incC = 0.15;
//		
//		//인센티브 포함 연봉
//		double incSalA = salA*(1+incA);
//		double incSalB = salB*(1+incB);
//		double incSalC = salC*(1+incC);
//		
//		// 3000 이상 or 미만
//		String resultA = (incSalA>=3000) ? "3000 이상" : "3000 미만";
//		String resultB = (incSalB>=3000) ? "3000 이상" : "3000 미만";
//		String resultC = (incSalC>=3000) ? "3000 이상" : "3000 미만";
//		
//		System.out.println("A사원 연봉/연봉+a: " + salA+"/"+incSalA);
//		System.out.println(resultA);
//		System.out.println("B사원 연봉/연봉+a: " + salB+"/"+incSalB);
//		System.out.println(resultB);
//		System.out.println("C사원 연봉/연봉+a: " + salC+"/"+incSalC);
//		System.out.println(resultC);
//		
				
		
	}
}
