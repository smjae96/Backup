package com.kh.practice.book.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.kh.practice.book.controller.BookController;
import com.kh.practice.book.model.vo.Book;


public class BookMenu {
	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	private Book[] bArr;
	
	public BookMenu() {
		bc.makeFile();
		bArr = bc.fileRead();
	}
	
	public void mainMenu() {
		while(true) {
			System.out.println("1. 도서 추가 저장");
			System.out.println("2. 저장 도서 출력");
			System.out.println("9. 프로그램 끝내기");
			System.out.print("메뉴 번호 : ");
			int num = sc.nextInt();
			sc.nextLine();
			if(num==1) {
				fileSave();
			} else if(num==2) {
				fileRead();
			} else if(num==9) {
				System.out.println("프로그램 종료");
				return;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}	
	}
	
	public void fileSave() {
		System.out.print("도서 명 : ");
		String bookname = sc.nextLine();
		System.out.print("저자 명 : ");
		String author = sc.nextLine();
		System.out.print("도서 가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		System.out.print("출판 날짜(yyyy-mm-dd) : ");
		String str = sc.nextLine();
		String[] strS = str.split("-");
		int year = Integer.parseInt(strS[0]);
		int month = Integer.parseInt(strS[1]);
		int day = Integer.parseInt(strS[2]);
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);
		System.out.println("할인율 : ");
		double discount = sc.nextDouble();
		sc.nextLine();
		Book b= new Book(bookname, author, price, cal, discount); 
		for(int i=0; i<bArr.length; i++) {
			if(bArr == null) {
				bArr[i] = b;
				break;
			}
		}
		bc.fileSave(bArr);

		mainMenu();
	}
	
	public void fileRead() {
		System.out.println(bc.fileRead());
		mainMenu();
	}
}
