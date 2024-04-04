package view;

import java.util.Scanner;

import controller.UserController;

public class LoginAfterMenu {
	
	private static Scanner sc = new Scanner(System.in);
	private static UserController uc = new UserController();
	
	
	public static void mainMenu(String userId) {
		System.out.println("로그인 성공!");
		System.out.println("\n===== " + uc.checkNickName(userId) + "님 환영합니다!! =====\n");
		
		while(true) {
			System.out.println("<<<<< 메뉴 선택 >>>>>\n");
			System.out.println("1. 오늘의 계획 작성하기");
			System.out.println("2. 작성한 계획 확인하기");
			System.out.println("3. 회원 정보 변경");
			System.out.println("4. 회원 탈퇴");
			System.out.println("0. 로그아웃");
			System.out.print("메뉴를 선택하세요 : ");
			int choice = sc.nextInt();
			sc.nextLine();
			if(choice == 1) {
				planWriter();
			} else if(choice == 2) {
				showPlans();
			} else if(choice == 3) {
				updateMember(userId);
				break;
			} else if(choice == 4) {
				deleteMember(userId);
				break;
			}else if(choice == 0) {
				return;
			} else {
				System.out.println("메뉴 번호를 잘못 선택하셨습니다. 다시 선택해 주세요.");
				continue;
			}
		}
		
	}
	
	public static void planWriter() {
		
	}
	
	public static void showPlans() {
		
	}
	
	public static void updateMember(String userId) {
		 System.out.println("\n== 회원 정보 변경 ==");
		 System.out.println("아이디 혹은 비밀번호를 5회 잘못 입력하실 시 자동으로 로그아웃되며 초기화면으로 돌아갑니다!!\n");
		 int i=0;
		 while(true) {
			 System.out.print("회원 정보 변경을 원하시면 회원님의 아이디를 입력하세요 : ");
			 String inputId = sc.nextLine();
			 
			 System.out.print("회원님의 비밀번호를 입력하세요 : ");
			 String userPw = sc.nextLine();
			 
			 if(inputId.equals(uc.checkId(userId))) {
				 if(userPw.equals(uc.checkPw(userId))) {
					 System.out.print("변경할 비밀번호 : ");
					 String newPw = sc.nextLine().trim().replace(" ", "");
					 
					 System.out.print("변경할 닉네임 : ");
					 String nickName = sc.nextLine();
					 
					 System.out.print("변경할 전화번호(-빼고 입력) : ");
					 String phone = sc.nextLine().trim().replace(" ", "").replace("-", "");
					 
					 System.out.print("변경할 이메일 : ");
					 String email = sc.nextLine();
					 
					 System.out.print("변경할 주소 : ");
					 String address = sc.nextLine();
					 
					 System.out.print("변경할 관심사 : ");
					 String interest = sc.nextLine();
					 
					 

					 uc.updateMember(userId, newPw, nickName, phone, email, address, interest);
					 
					 System.out.println("\n** 회원 정보 변경 성공!! **\n자동으로 로그아웃되며 초기화면으로 돌아갑니다!\n");
					 return;	 
				 } else {
					 i++;
					 if(i<5) {
						 System.out.println("\n**아이디 혹은 비밀번호를 잘못 입력하셨습니다. 다시 입력하십시오.\n");
						 continue;
					 } else {
						 System.out.println("\n***** 경고!! *****");
						 System.out.println("아이디 혹은 비밀번호를 5회 잘못 입력하셨습니다. 자동으로 로그아웃되며 초기화면으로 돌아갑니다!");
						 return;
					 }
				 }
			 } else {
				 i++;
				 if(i<5) {
					 System.out.println("\n**아이디 혹은 비밀번호를 잘못 입력하셨습니다. 다시 입력하십시오.\n");
					 continue;
				 } else {
					 System.out.println("\n***** 경고!! *****");
					 System.out.println("아이디 혹은 비밀번호를 5회 잘못 입력하셨습니다. 자동으로 로그아웃되며 초기화면으로 돌아갑니다!");
					 return;
				 }
				 
			 }
		 }
	}
	
	public static void deleteMember(String userId) {
		 System.out.println("\n == 회원 탈퇴 ==");
		 System.out.println("아이디 혹은 비밀번호를 5회 잘못 입력하실 시 자동으로 로그아웃되며 초기화면으로 돌아갑니다!!\n");
		 int i= 0;
		 while(true) {
			 System.out.print("탈퇴를 원하시면 회원님의 아이디를 입력하세요 : ");
			 String inputId = sc.nextLine();
			 
			 System.out.print("회원님의 비밀번호를 입력하세요 : ");
			 String userPw = sc.nextLine();
			 
			 if(inputId.equals(uc.checkId(userId))) {
				 if(userPw.equals(uc.checkPw(userId))) {
					 System.out.print("\n정말로 탈퇴하시겠습니까? ('Y' 입력 시 탈퇴 확정 / 다른 키 입력 시 탈퇴 취소) : ");
					 String del = sc.nextLine().toUpperCase();
					 if(del.equals("Y")) {
					 uc.deleteMember(userId, userPw);
					 return;
					 } else {
						 System.out.println("\n탈퇴를 취소하셨으므로 자동으로 로그아웃되며 초기화면으로 돌아갑니다!");
						 return;
					 }
				 }else {
					 i++;
					 if(i < 5) {
					 System.out.println("\n**아이디 혹은 비밀번호를 잘못 입력하셨습니다. 다시 입력하세요.\n");
					 }
					 else {
						 System.out.println("\n***** 경고!! *****");
						 System.out.println("아이디 혹은 비밀번호를 5회 잘못 입력하셨습니다. 자동으로 로그아웃되며 초기화면으로 돌아갑니다!");
						 return;
					 }
					 continue;
				 }
			 }else {
				 i++;
				 if(i < 5) {
				 System.out.println("\n**아이디 혹은 비밀번호를 잘못 입력하셨습니다. 다시 입력하세요.\n");
				 }
				 else {
					 System.out.println("\n***** 경고!! *****");
					 System.out.println("아이디 혹은 비밀번호를 5회 잘못 입력하셨습니다. 자동으로 로그아웃되며 초기화면으로 돌아갑니다");
					 return;
				 }
				 continue;
			 }

		 }
	}
}
