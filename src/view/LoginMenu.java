package view;

import java.util.Scanner;

import controller.UserController;

public class LoginMenu {
	
	private Scanner sc = new Scanner(System.in);
	private UserController uc = new UserController();
	public void mainMenu() {
		
		System.out.println("\r\n"
				+ " _____                ______            _      _       _      ______  _                                  \r\n"
				+ "|_   _|               |  _  \\          | |    (_)     | |     | ___ \\| |                                 \r\n"
				+ "  | |    ___   ______ | | | |  ___     | |     _  ___ | |_    | |_/ /| |  __ _  _ __   _ __    ___  _ __ \r\n"
				+ "  | |   / _ \\ |______|| | | | / _ \\    | |    | |/ __|| __|   |  __/ | | / _` || '_ \\ | '_ \\  / _ \\| '__|\r\n"
				+ "  | |  | (_) |        | |/ / | (_) |   | |____| |\\__ \\| |_    | |    | || (_| || | | || | | ||  __/| |   \r\n"
				+ "  \\_/   \\___/         |___/   \\___/    \\_____/|_||___/ \\__|   \\_|    |_| \\__,_||_| |_||_| |_| \\___||_|   \r\n"
				+ "                                                                                                         \r\n"
				+ "                                                                                                         \r\n"
				+ "");
		
		System.out.println();
		while(true) {
			System.out.println("<< 로그인 메뉴 >>");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 아이디 찾기");
			System.out.println("4. 비빌번호 찾기");
			System.out.println("0. 프로그램 종료");
			System.out.println("\n");
			System.out.print("메뉴를 선택하세요 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			if(menu == 1) {
				signUp();
			} else if(menu == 2) {
				logIn();
			} else if(menu == 3) {
				foundId();
			} else if(menu == 4) {
				foundPw();
			} else if(menu == 0) {
				System.out.println("프로그램을 종료합니다.");
				return;
			} else {
				System.out.println("메뉴 번호를 잘못 입력하셨습니다.");
				continue;
			}
		}
		
	}
	
	public void signUp() {
		 System.out.println("\n== 회원 가입 ==");
		 
		 System.out.print("이름을 입력하세요. : ");
		 String userName = sc.nextLine().trim().replace(" ", "");
		 
		 System.out.print("주민번호를 입력하세요. : ");
		 String ssn = sc.nextLine().trim().replace(" ", "").replace("-", "");
		 
		 System.out.print("사용하실 아이디를 입력하세요. : ");
		 String userId = sc.nextLine().trim().replace(" ", "");
		 
		 System.out.print("사용하실 비밀번호를 입력하세요. : ");
		 String userPw = sc.nextLine().trim().replace(" ", "");
		 
		 System.out.print("사용하실 닉네임을 입력하세요. : ");
		 String nickName = sc.nextLine();
		 
		 System.out.print("사용하실 이메일을 입력하세요. : ");
		 String email = sc.nextLine();
		 
		 System.out.print("전화번호를 입력하세요. : ");
		 String phone = sc.nextLine().trim().replace(" ", "").replace("-", "");
		 
		 System.out.print("주소를 입력하세요. : ");
		 String address = sc.nextLine();
		 
		 System.out.print("관심사를 입력하세요. : ");
		 String interest = sc.nextLine();
		 
		 System.out.print("회원 가입을 확정하시겠습니까?(확정 하시려면 'Y', 취소 하시려면 다른 키를 눌러주세요.) : ");
		 String confirm = sc.nextLine().toUpperCase().trim();
		 if(confirm.equals("Y")) {
		 uc.signUp(userId, userPw, userName, nickName, email, phone, ssn, address, interest);
		 } else {
			 return;
		 }
		 
		 
		 
	}
	
	public void logIn() {
		 System.out.println("\n== 로그인 ==");
		 while(true) {
				System.out.print("아이디를 입력하세요. : ");
				String userId = sc.nextLine();
				System.out.print("비밀번호를 입력하세요. : ");
				String userPw = sc.nextLine();
			 
			 if(userId.equals(uc.checkId(userId))) {
				 if(userPw.equals(uc.checkPw(userId))) {
					 System.out.println("\r\n"
					 		+ "==================================================================================================================================\n"
					 		+ " _       _____   _____   _____   _   _     _____   _   _   _____   _____   _____   _____   _____  _____ ______   _  _ \r\n"
					 		+ "| |     |  _  | |  __ \\ |_   _| | \\ | |   /  ___| | | | | /  __ \\ /  __ \\ |  ___| /  ___| /  ___||  ___||  _  \\ | || |\r\n"
					 		+ "| |     | | | | | |  \\/   | |   |  \\| |   \\ `--.  | | | | | /  \\/ | /  \\/ | |__   \\ `--.  \\ `--. | |__  | | | | | || |\r\n"
					 		+ "| |     | | | | | | __    | |   | . ` |    `--. \\ | | | | | |     | |     |  __|   `--. \\  `--. \\|  __| | | | | | || |\r\n"
					 		+ "| |____ \\ \\_/ / | |_\\ \\  _| |_  | |\\  |   /\\__/ / | |_| | | \\__/\\ | \\__/\\ | |___  /\\__/ / /\\__/ /| |___ | |/ /  |_||_|\r\n"
					 		+ "\\_____/  \\___/   \\____/  \\___/  \\_| \\_/   \\____/   \\___/   \\____/  \\____/ \\____/  \\____/  \\____/ \\____/ |___/   (_)(_)\r\n"
					 		+ "                                                                                                                      \r\n"
					 		+ "==================================================================================================================================\r\n"
					 		+ "");
					 
					 LoginAfterMenu.mainMenu(userId);
					 return;
					 
				 } else {
					 System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다. 최초 화면으로 돌아갑니다. \n");
					 return;
				 }
			 } else {
				 System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다. 최초 화면으로 돌아갑니다. \n");
				 return;
			 }
		 }
	}
	
	public void foundId() {
	 	System.out.println("\n == 회원 아이디 찾기 ==");
		System.out.print("회원님의 이름을 입력하세요. : ");
		String userName = sc.nextLine();
		System.out.print("가입하신 전화번호를 입력하세요(-빼고 입력).  : ");
		String phone = sc.nextLine();
		uc.foundId(userName, phone);
	}
	public void foundPw() {
	 	System.out.println("\n == 회원 비밀번호 찾기 ==");
		System.out.print("아이디를 입력하세요. : ");
		String userId = sc.nextLine();
		System.out.print("이메일을 입력하세요. : ");
		String email = sc.nextLine();
		System.out.print("주민번호를 입력하세요(반드시 '-'빼고 입력). : ");
		String ssn = sc.nextLine();
		uc.foundPw(userId, email, ssn);
	}
}
