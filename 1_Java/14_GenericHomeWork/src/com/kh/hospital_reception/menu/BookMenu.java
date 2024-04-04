package com.kh.hospital_reception.menu;

import java.util.Scanner;

import com.kh.hospital_reception.model.vo.BookManagement;

public class BookMenu {
	private Scanner sc= new Scanner(System.in);
	private BookManagement bm = new BookManagement();
	
	public void mainMenu() {
		while(true) {
			System.out.println("=== 메인 메뉴 ===");
			System.out.println("1. 도서 대출");
			System.out.println("2. 도서 반납");
			System.out.println("3. 대여목록 조회");
			System.out.println("4. 반납 기한이 임박한 도서 순서 조회");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호를 입력하세요 : ");
			int num = sc.nextInt();
			if(num==1) {
				rentMenu();
			}
			else if(num==2) {
				returnMenu();
			}
			else if(num==3) {
				checkList();
			}
			else if(num==4) {
				goGet();
			}
			else if(num==9) {
				System.out.println("프로그램 종료");
				break;
			}
			else {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			}
		}	
	}
	
	public void rentMenu() {
		bm.renting();
	}
	
	public void returnMenu() {
		bm.returning();
	}
//	
	public void checkList() {
		bm.check();
		System.out.println();
	}
	public void goGet() {
		bm.get();
	}
}
