package com.kh.practice.chap01;

import java.util.Scanner;

public class ControlPractice {
	Scanner sc = new Scanner(System.in);
	public void practice1() {
		//아래 예시와 같이 메뉴를 출력하고 메뉴 번호를 누르면 "OO메뉴입니다."를,
		//종료 번호를 누르면 "프로그램이 종료됩니다."를 출력하세요.
		
		/*
		 * ex.
		 * 1. 입력
		 * 2. 수정
		 * 3. 조회
		 * 4. 삭제
		 * 7. 종료
		 * 메뉴 번호를 입력하세요 : 3
		 * 조회 메뉴입니다.
		 */
		
		Scanner sc = new Scanner(System.in);
		//메뉴를 화면에 출력
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회");
		System.out.println("4. 삭제");
		System.out.println("7. 종료");
		//"메뉴 번호를 입력하세요 : " 화면에 출력
		System.out.print("메뉴 번호를 입력하세요 : ");
		int menuNum = sc.nextInt();
		
		switch(menuNum) {
		case 1: 
			System.out.println("입력 메뉴입니다.");
			break;
		case 2:
			System.out.println("수정 메뉴입니다.");
			break;
		case 3:
			System.out.println("조회 메뉴입니다.");
			break;
		case 4: 
			System.out.println("삭제 메뉴입니다.");
			break;
		case 7:
			System.out.println("종료 메뉴입니다.");
			break;
		default:
			System.out.println("해당 메뉴는 없습니다.");
		}
	}
	
	public void practice2() {
		//키보드로 정수를 입력 받은 정수가 양수이면서 짝수일 때만 "짝수다"를 출력하고
		//짝수가 아니면 "홀수다"를 출력하세요.
		//양수가 아니면 "양수만 입력해주세요."를 출력하세요.
		
		/*ex.
		 * 숫자를 한 개 입력하세요 : -8
		 * 양수만 입력해주세요.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 한 개 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num>0) {
			if(num%2==0) {
				System.out.println("짝수다");
			}
			else { 
				System.out.println("홀수다");
			}
		}
		else {
			System.out.println("양수만 입력해주세요.");
		}
	}
	
	public void practice3() {
		/*국어 영어 수학 세 과목의 점수를 키보드로 입력 받고 합계와 평균을 계산하고
		 * 합계와 평균을 이용하여 합격 / 불합격 처리하는 기능을 구현하세요.
		 * (합격 조건 : 세 과목의 점수가 각각 40점 이상이면서 평균이 60점 이상일 경우)
		 * 합격 했을 경우 과목 별 점수와 합계, 평균, "축하합니다,합격입니다!"를 출력하고
		 * 불합격인 경우에는 "불합격입니다."를 출력하세요.
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("국어점수 : ");
		int scoreK = sc.nextInt();
		System.out.print("수학점수 : ");
		int scoreM = sc.nextInt();
		System.out.print("영어점수 : ");
		int scoreE = sc.nextInt();
		
		//총합
		int total = scoreK + scoreM + scoreE;
		//평균
		double average = (double)total/3;
		
		if(scoreK>=40 && scoreM>=40 && scoreE>=40) {
			if(average>=60) {
				System.out.println("국어 : " +scoreK);
				System.out.println("수학 : "+scoreM);
				System.out.println("영어 : "+scoreE);
				System.out.println("합계 : "+total);
				System.out.println("평균 : "+average);
				System.out.println("축하합니다, 합격입니다!");
			}
			else {
				System.out.println("불합격입니다");
			}
		}
		else { 
			System.out.println("불합격입니다");
		}
	}
	
	public void practice4() {
		//수업 자료(7pg)에서 if문으로 되어있는 봄, 여름, 가을, 겨울 예제를 switch문으로 바꿔서 출력하세요.
		
		System.out.print("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();
		String season;
		switch(month) {
		case 1,2,12 : 
			System.out.println(month+"월은 겨울입니다.");
			break;
		case 3,4,5 :
			System.out.println(month+"월은 봄입니다.");
			break;
		case 6,7,8 :
			System.out.println(month+"월은 여름입니다.");
			break;
		case 9,10,11 :
			System.out.println(month+"월은 가을입니다.");
			break;
		default :
			System.out.println(month+"월은 잘못 입력된 달입니다.");
		}
		
	}
	
	public void practice5() {
		/*
		 * - 아이디: user1
		 * - 비밀번호: 1234qwer!!
		 * 
		 *  [문자열].equals([문자열])
		 */
		
		String id = "user1";
		String pw = "1234qwer!!";
		
		System.out.print("아이디: ");
		String inputID = sc.nextLine();
		System.out.print("비밀번호: ");
		String inputPW = sc.nextLine();
		
//		if(id.equals("user01")) {
//			if(pw.equals("1234qwer!!")) {
//				System.out.println("로그인 성공");
//			}
//			else {
//				System.out.println("비밀번호가 틀렸습니다.");
//			}
//		}
//		else { 
//			System.out.println("아이디가 틀렸습니다.");
//		}
		
		if(inputID.equals(id) // equals: inputID 값과 id 값이 같은지 
			&& inputPW.equals(pw)) {
			System.out.println("로그인 성공!");	
		} else if (!inputID.equals(id)) {
			// id: user01, inputId: qqqq | inputId.equals(id) => false
			//						!(inputId.equals(id)) -> !false -> true
			System.out.println("아이디가 틀렸습니다.");
		} 
		else {
			System.out.println("비밀번호가 틀렸습니다.");
		}
	}	
		
//	
//		// (+) 비밀번호 : 최소 6자리 이상, 대문자 + 소문자 + 특수문자
	/* 정규표현식: String regExp
	 * 
	 */
	
	public void practice5a() {	
		System.out.print("패스워드를 입력하세요: ");
		String inputPW = sc.next();
		String regExp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{6,}$";
		
		if(inputPW.length()>=6) {
			if(inputPW.matches(regExp)) {
				System.out.println("비밀번호가 맞습니다.");
			}
			else {
				System.out.println("비밀번호에 영어 대문자,소문자,특수문자 중 안 들어간 것이 있습니다.");
			}
		}
		else {
			System.out.println("비밀번호 자리 수가 틀립니다.");
		}
		
	}
	
	public void practice6() {
		System.out.print("권한을 확인하고자 하는 회원 등급: ");
		String grade = sc.nextLine();
		
		switch(grade) {
		case "관리자": 
			System.out.println("회원관리, 게시글 관리 게시글 작성, 댓글 작성 게시글 조회");
			break;
		case "회원" :
			System.out.println("게시글 작성, 게시글 조회, 댓글 작성");
			break;
		case "비회원" :
			System.out.println("게시글 조회");
			break;
		default :
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void practice7() {
		System.out.print("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();
		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double weight = sc.nextDouble();
		
		double bmi = weight / (height*height);
		System.out.println("BMI 지수 : " +bmi );
		
		
		if(bmi<18.5) {
			System.out.println("저체중");
		}
		else if(18.5<=bmi && bmi<23) {
			System.out.println("정상체중");
		}
		else if(23<=bmi && bmi<25) {
			System.out.println("과체중");
		}
		else if(25<=bmi && bmi<30) {
			System.out.println("비만");
		}
		else if(bmi>=30) {
			System.out.println("고도 비만");
		}
		else {
			System.out.println("값을 잘못 입력하셨습니다.");
		}
	}
	
	public void practice8() {
		System.out.print("피연산자1 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("피연산자2 입력 : ");
		int num2 = sc.nextInt();
		System.out.print("연산자를 입력(+,-,*,/,%) : ");
		String opr = sc.next();
		//덧셈
		double opr1 = (double)(num1+num2);
		double opr2 = (double)(num1-num2);
		double opr3 = (double)num1*num2;
		double opr4 = (double)num1/num2;
		double opr5 = (double)num1%num2;
		
		
		if(num1>0 && num2>0) {
			switch(opr) {
				case "+": 
					System.out.printf("%d + %d = %.6f\n",num1,num2,opr1);
					break;
				case "-" :
					System.out.printf("%d - %d = %.6f\n",num1,num2,opr2);
					break;
				case "*" :
					System.out.printf("%d * %d = %.6f\n",num1,num2,opr3);
					break;
				case "/" :
					System.out.printf("%d / %d = %.6f\n",num1,num2,opr4);
					break;
				case "%" :
					System.out.printf("%d % %d = %.6f\n",num1,num2,opr5);
					break;
				default :
					System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
			}
		} 
		else {
			System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
		}
				
	}
	
	public void practice9() {
		System.out.print("중간 고사 점수 : ");
		int midexam = sc.nextInt();
		System.out.print("기말 고사 점수 : ");
		int finalexam = sc.nextInt();
		System.out.print("과제 점수 : ");
		int assignment = sc.nextInt();
		System.out.print("출석 회수 : ");
		int attend = sc.nextInt();
		System.out.println("============결과============");
		
		double me = midexam * 0.2;
		double fe = finalexam * 0.3;
		double as = assignment * 0.3;
		// 총 강의 횟수 20회
		int lectures = 20;
		// 출석점수
		double at = (double)attend/lectures*20; 
		
		//총점
		double total = me+fe+as+at;
		
//		System.out.println("중간 고사 점수(20) : " +me);
//		System.out.println("기말 고사 점수(30) : " +fe);
//		System.out.println("과제 점수      (30) : " +as);
//		System.out.println("출석 점수      (20) : " +at);
//		System.out.println("총점 : " +total);
		
		if(lectures == 20) {
			if(at<=lectures*0.7) {
				System.out.println("Fail [출석 회수 부족 ("+attend+"/20)]");
			}
			else {
				System.out.println("중간 고사 점수(20) : " +me);
				System.out.println("기말 고사 점수(30) : " +fe);
				System.out.println("과제 점수      (30) : " +as);
				System.out.println("출석 점수      (20) : " +at);
				System.out.println("총점 : " +total);
				if(total>=70) {

					System.out.println("PASS");
				}
				else {

					System.out.println("Fail [점수 미달]");
				}
			}
		}
				
	}
	
	public void practice10() {
		System.out.println("실행할 기능을 선택하세요.");
		System.out.println("1. 메뉴 출력");
		System.out.println("2. 짝수/홀수");
		System.out.println("3. 합격/불합격");
		System.out.println("4. 계절");
		System.out.println("5. 로그인");
		System.out.println("6. 권한 확인");
		System.out.println("7. BMI");
		System.out.println("8. 계산기");
		System.out.println("9. P/F");
		System.out.print("선택 : ");

		int select = sc.nextInt();
		
		switch(select) {
			case 1: 
				practice1();
			break;
			case 2: 
				practice2();
			break;
			case 3: 
				practice3();
			break;
			case 4:
				practice4();
			break;
			case 5: 
				practice5();
			break;
			case 6: 
				practice6();
			break;
			case 7: 
				practice7();
			break;
			case 8: 
				practice8();
			break;
			case 9: 
				practice9();
			break;
			default: System.out.println("잘못 입력하셨습니다.");
		}
				
	}
	
	public void practice11() {
		System.out.print("비밀번호 입력(1000~9999) : ");
		String pw = sc.next();
		char fNum = pw.charAt(0); 
		char sNum = pw.charAt(1);
		char tNum = pw.charAt(2);
		char frNum = pw.charAt(3);
				
		
		// 4자리 정수를 입력 받아 각 자리 수에 중복되는 값이 없을 경우 '생성 성공' , 중복 값이 있으면 '중복 값 있음'
		// 자리수가 안 맞으면 '자리 수 안 맞음' 출력.
		if('1'<=fNum && fNum<='9') {
			if(pw.length()==4) {
				if(fNum!=sNum && fNum!=tNum && fNum!=frNum && sNum!=tNum && sNum!=frNum && tNum!=frNum) {
					System.out.println("생성 성공");
				}
				else {
					System.out.println("중복 값 있음");
				}
			}
			else {
				System.out.println("자리 수 안 맞음");
			}

		}
		else {
			System.out.println("실패");
		}

	
	}
	
}
