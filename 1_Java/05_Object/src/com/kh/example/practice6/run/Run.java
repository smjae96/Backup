package com.kh.example.practice6.run;

import com.kh.example.practice6.model.vo.Book;

public class Run {

	public static void main(String[] args) {
		
		//Book b1;	// Book 클래스 어떤 데이터? 어떤 메소드?
		//Book b1 = new Book(); // 어떻게 프로그램을 만든건지 할당하는 것.
		

		
		Book[] bArr = new Book[3];
		/* 객체배열을 선언 및 할당 후에는 아래와 같은 상태
		   Book b1;
		   Book b2;
		   Book b3;
		*/
		bArr[0] = new Book();
		bArr[1] = new Book(" ", " ", " ");
		bArr[2] = new Book();
		
		// 객체 배열은 인스턴스 생성으로 초기화 필요!..
		for(Book b: bArr) {
			b = new Book();
		}
		
		// 기본생성자로 Book 객체 생성
		Book book1 = new Book();
		// 매개변수가 3개인 생성자로 Book 객체 생성
		Book book2 = new Book("어린왕자" , "출판사1", "생 텍쥐페리");
		// 매개변수가 5개인 생성자로 Book 객체 생성
		Book book3 = new Book("운수 좋은 날" , "출판사2" , "현진건", 5000, 0.2);
		
		book1.inform();
		System.out.println();
		book2.inform();
		System.out.println();
		book3.inform();
	}

}
