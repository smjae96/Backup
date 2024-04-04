package com.kh.practice.chap01_poly.model.vo;

// 부모 클래스
// 책 객체
public class Book {
	// 필드부 (3)
	private String title;		// 도서명
	private String author;		// 저자명
	private String publisher;	// 출판사
	
	// 생성자 (2) : 기본생성자, 매개변수 3개를 받는 생성자(title, author, publisher)
	public Book() {}
	
	public Book(String title, String author, String publisher) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}
	
	// 메소드 (1) : 클래스 내 필드 정보를 문자열로 반환 (toString())
	@Override
	public String toString() {
		return String.format("%s / %s / %s", title, author, publisher);
	}
}
