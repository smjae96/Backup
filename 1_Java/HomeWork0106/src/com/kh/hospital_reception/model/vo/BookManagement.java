package com.kh.hospital_reception.model.vo;

import java.util.Scanner;

public class BookManagement {
	StringArray strA = new StringArray();
	Scanner sc = new Scanner(System.in);
	// 대여하는 메소드
	public void renting() {
		String str = null;
		System.out.print("대출할 도서명을 입력하세요 : ");
		str = sc.next();
		strA.add(str);
//			if(st[i] == null) {
//				st[i] = book;
//			}
	}
		
	
	// 반납하는 메소드
	public void returning() {
		System.out.print("반납할 도서명을 입력하세요 : ");
		String name = sc.next();
		strA.remove(name);
	}	
	
	// 대여목록 조회하는 메소드
	public void check() {
		String[] st = new String[10];
		System.out.println("===  대여목록 ===");
		strA.print();
//		for(int i=0; i<st.length; i++) {
//			System.out.println(strA.print());
//		}
//		for(int i=0; i<strA.arr.length; i++) {
//			if(strA.arr[i] == book) {
//				
//			}
//		}
		
	}
}
