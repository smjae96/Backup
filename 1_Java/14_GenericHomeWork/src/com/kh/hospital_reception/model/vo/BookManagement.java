package com.kh.hospital_reception.model.vo;

import java.util.Scanner;

public class BookManagement {
	StringArray2<String> strA = new StringArray2<>();
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
	
	public void get() {
				System.out.println();
				System.out.println("=== 반납 해야 할 순서 ===");
				System.out.print("책 번호를 입력하세요. 번호가 작을수록 반납 기한이 임박한 책입니다.(1~10) : ");
				int num = sc.nextInt();
				if(strA.get(num-1)!= null) {
					System.out.println(num +"번째로 반납하셔야 할 책은 '"+strA.get(num-1)+"' 입니다.");
				} else {
					System.out.println("대여한 도서 수를 초과한 번호입니다. 다시 입력하세요.");
					get();
				}
				
			
			
		
		
	}
}
