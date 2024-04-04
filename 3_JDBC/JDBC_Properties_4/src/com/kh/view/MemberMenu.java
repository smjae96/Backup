package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.MemberController;
import com.kh.model.vo.Member;

/*
 *  View : 사용자가 보게 될 시각적인 요소(화면) 출력 및 입력
 */
public class MemberMenu {
	 // 필드 : 입력용 객체(Scanner), Controller 객체
	 // 입력용 객체 - Scanner	(전역변수, 바로 입력받을 수 있도록 선언)
	 private Scanner sc = new Scanner(System.in);
	 // Controller 객체 (전역변수, 전반적으로 바로 요청할 수 있도록 선언)
	 private MemberController mc = new MemberController();
	 
	 // 생성자 생략.. -> 기본 생성자만 사용
	 
	 // 메소드 -> 메뉴, 화면 출력, 입력받거나 기능들을 수행할 메소드
	 /**
	  *  사용자가 보게 될 첫 화면 (메인 화면)
	  */
	 public void mainMenu() {
		 
		 while(true) {	// 사용자가 종료하기 전까지 메뉴를 계속 출력
			 
			 System.out.println("\n==회원 관리 프로그램==");
			 System.out.println("1. 회원 추가");
			 System.out.println("2. 회원 전체 조회");
			 System.out.println("3. 회원 아이디 검색");
			 System.out.println("4. 회원 이름으로 키워드 검색");
			 System.out.println("5. 회원 정보 변경");
			 System.out.println("6. 회원 탈퇴");
			 System.out.println("0. 프로그램 종료");
			 
			 System.out.print(">> 메뉴 선택 : ");
			 int menu = sc.nextInt();
			 
			 sc.nextLine();		// 버퍼 비우기!
			 
			 switch(menu) {
			 case 1:
				 inputMember();
				 break;
			 case 2:
				 mc.selectAllList();
				 break;
			 case 3:
				 searchId();
				 break;
			 case 4:
				 searchByName();
				 break;
			 case 5:
				updateMember();
				 break;
			 case 6:
				 deleteMember();
				 break;
			 case 0:
				 return;	// 프로그램 종료 => 메소드 종료
			 default:
				 System.out.println("잘못 선택했습니다. 다시 선택해주세요.");
			 }
		 }
	 }
	 
	 /**
	  * 회원 추가 창(서브 화면). 추가하고자 하는 회원의 정보를 입력받아 회원을 추가 요청하는 창
	  */
	 public void inputMember() {
		 System.out.println("\n== 회원 추가 ==");
		 
		 System.out.print("아이디 : ");
		 String userId = sc.nextLine();
		 
		 System.out.print("비밀번호 : ");
		 String userPw = sc.nextLine();
		 
		 System.out.print("이름 : ");
		 String userName = sc.nextLine();
		 
		 System.out.print("성별(남 또는 여) : ");
		 String gender = sc.nextLine();
		 
		 System.out.print("나이 : ");
		 int age;
		 String str = sc.nextLine();
		 age = Integer.parseInt(str);
		 
		 System.out.print("이메일 : ");
		 String email = sc.nextLine();
		 
		 System.out.print("전화번호 (-빼고 입력) : ");
		 String phone = sc.nextLine();
		 
		 System.out.print("주소 : ");
		 String address = sc.nextLine();
		 
		 System.out.print("취미 (,로 구분하여 여러 개 작성 가능) : ");
		 String hobby = sc.nextLine();
		 
		 // 사용자에게 입력받은 정보를 MemberController에 전달해야 한다!
		 mc.insertMember(userId, userPw, userName, gender, age, email, phone, address, hobby);
	 }
	 
	 /**
	  * 회원 아이디 검색 시 보게될 화면
	  */
	 public void searchId() {
			//Scanner sc = new Scanner(System.in);
			System.out.print("검색할 아이디를 입력하세요. : ");
			String userId = sc.nextLine();
			mc.searchId(userId);
			
	 }
	 /**
	  * 회원 이름 키워드로 검색 시 보게될 화면
	  */
	 public void searchByName() {
		 System.out.print("검색할 키워드를 입력하세요. : ");
		 String userKeyWord = sc.nextLine();
		 mc.searchByName(userKeyWord);
	 }
	 
	 /**
	  * 회원 정보 변경 창(서브 화면). 변경하고자 하는 회원의 정보를 입력받아 회원 정보를 변경하는 창
	  * 
	  */
	 public void updateMember() {
		 System.out.println("\n== 회원 정보 변경 ==");
		 while(true) {
			 System.out.print("변경할 회원의 아이디를 입력하세요 : ");
			 String userId = sc.nextLine();
			 
			 System.out.print("변경할 회원의 비밀번호를 입력하세요 : ");
			 String userPw = sc.nextLine();
			 
			 if(userId.equals(mc.checkId(userId))) {
				 if(userPw.equals(mc.checkPw(userId))) {
					 System.out.print("변경할 비밀번호 : ");
					 String newPw = sc.nextLine();
					 
					 System.out.print("변경할 이메일 : ");
					 String email = sc.nextLine();
					 
					 System.out.print("변경할 전화번호 (-빼고 입력) : ");
					 String phone = sc.nextLine();
					 
					 System.out.print("변경할 주소 : ");
					 String address = sc.nextLine();
					 
					 mc.updateMember(userId, newPw, email, phone, address);
					 return;
					 
				 } else {
					 System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다. 다시 입력하십시오.");
					 continue;
				 }
			 } else {
				 System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다. 다시 입력하십시오.");
				 continue;
			 }
		 }
	 }
	 
	 public void deleteMember() {
		 System.out.println("\n == 회원 탈퇴 ==");
		 while(true) {
			 System.out.print("탈퇴할 회원의 아이디를 입력하세요 : ");
			 String userId = sc.nextLine();
			 
			 System.out.print("탈퇴할 회원의 비밀번호를 입력하세요 : ");
			 String userPw = sc.nextLine();
			 
			 if(userId.equals(mc.checkId(userId))) {
				 if(userPw.equals(mc.checkPw(userId))) {
					 mc.deleteMember(userId, userPw);
					 return;
				 }
				 else {
					 System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다. 다시 입력하세요.");
					 continue;
				 }
			 }else {
				 System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다. 다시 입력하세요.");
				 continue;
			 }
		 }
	 }
	 
	 
	 
	 
	 
	 // --------------------------------------- 응답화면 -------------------------------------------
	 /**
	  * 요청 처리 후 성공했을 경우 사용자가 보게될 화면
	  * @param message : 객체 별 성공 메시지
	  */
	 public void displaySuccess(String message) {
		 System.out.println("\n요청 성공 : " +message);
	 }
	 
	 /**
	  * 요청 처리 후 실패했을 경우 사용자가 보게될 화면
	  * @param message : 객체 별 실패 메시지
	  */
	 public void displayFailed(String message) {
		 System.out.println("\n요청 실패 : " +message);
	 }
	 
	 /**
	  * 조회 요청 후 조회 결과가 없을 때 사용자가 보게될 화면
	  * @param message : 객체 별 조회 결과에 대한 메시지
	  */
	 public void displayNoData(String message) {
		 System.out.println("\n결과 없음 : " +message);
	 }
	 
	 /**
	  * 조회 요청 후 조회 결과가 있을 때 사용자가 보게될 화면
	  * @param list : 조회된 결과 목록이 담겨진 리스트 객체
	  */
	 public void displayList(ArrayList<Member> list) {
		 System.out.println("\n조회된 결과는 다음과 같습니다.");
		 
		 for(Member m : list) {
			 System.out.println(m);
		 }
	 }
	 
	 
	 /**
	  * 회원 정보에 대한 결과를 사용자가 보게될 화면
	  * @param m: 회원 정보를 담고 있는 Member 객체
	  */
	 public void displayId(Member m) {
		 System.out.println(m);
	 }
	 

}	
