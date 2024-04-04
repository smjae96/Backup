package com.kh.practice.chap01_poly.view;

import java.util.Scanner;

import com.kh.practice.chap01_poly.controller.LibraryController;
import com.kh.practice.chap01_poly.model.vo.Book;
import com.kh.practice.chap01_poly.model.vo.Member;

public class LibraryMenu {
	private LibraryController lc = new LibraryController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		System.out.print("성별 : ");
		char gender = sc.next().charAt(0);
		
		Member m = new Member(name, age, gender);
		// LibrarayController 의 insertMember() 메소드로
		// 생성한 Member 객체를 전달
		lc.insertMember(m); 
		
		// ----------------------------------------------
		// 무한반복
		//  - while(true) {}
		//	- do {   } while(true);
		//  - for(; ;) {}
		
		while(true) {
			
			System.out.println("===== 메뉴 =====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 전체 조회");	
			System.out.println("3. 도서 검색");	// 기능 생략...
			System.out.println("4. 도서 대여하기");
			System.out.println("9. 프로그램 종료하기");
			
			System.out.print("메뉴 번호 : ");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				System.out.println(lc.myInfo().toString());	
				break;
			case 2:
				selectAll();
				break;
			case 3:
				searchBook();
				break;
			case 4:
				rentBook();
				break;
			case 9:
				return;
			}
		}

	}
	
	public void selectAll() {
		// LibraryController 클래스의 selectAll 메소드 호출 후
		// Book 객체배열을 전달받아 bList에 대입
		Book[] bList = lc.selectAll();
		
		// 해당 객체배열의 처음 위치부터(0) 배열의 길이만큼 반복문을 실행
		for(int i=0; i<bList.length; i++) {
			// 도서 목록 정보를 출력
			// ex) 0번도서 : 백종원의 집밥 / 백종원 / tvN / true
			System.out.printf("%d번도서 : %s \n", i, bList[i].toString());
		}
	}
	
	public void searchBook() {
		System.out.print("검색할 제목 키워드: ");
		String keyword = sc.next();
		Book[] b1 = lc.searchBook(keyword);
		for(int i=0; i<b1.length; i++) {
			if(b1[i] != null) {
				System.out.println(b1[i].toString());
			} // 단일 if문만 써주면 nullpointerException 없이 출력 가능.
		}
	}
	
	public void rentBook() {
		selectAll();		// selectAll 메소드 호출
		
		System.out.print("대여할 도서 번호 선택 : ");
		int index = sc.nextInt();
		
		// LibrarayController 클래스의 rentBook 메소드로 인덱스 정보를 전달(호출)
		int result = lc.rentBook(index); // 그 결과 값을 result로 받고
		
		switch(result) {
		case 0:
			System.out.println("성공적으로 대여되었습니다.");
			break;
		case 1:
			System.out.println("나이 제한으로 대여 불가능입니다.");
			break;
		case 2:
			System.out.println("성공적으로 대여되었습니다. "
					+ "요리학원 쿠폰이 발급되었으니 마이페이지에서 확인하세요.");
			break;
		}
		
	}
	
	
}
