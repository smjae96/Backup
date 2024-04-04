package com.kh.example.practice6.model.vo;

public class Book {
	// 필드부
	private String title;
	private String publisher;
	private String author;
	private int price;
	private double discountRate;
	
	// 생성자부 (3) : 오버로딩
	// 기본 생성자
	public Book() {
		
	}
	// 매개변수 3개를 받는 생성자
	public Book(String title, String publisher, String author) {
		this.title = title;
		this.publisher = publisher;
		this.author = author;
	}
	// 매개변수 5개를 받는 생성자
	public Book(String title, String publisher, String author, int price, double discountRate) {
//		this.title = title;
//		this.publisher = publisher;
//		this.author = author;
		// this([매개변수]) : 클래스 내의 생성자를 호출 , 다른 메소드에서는 사용할 수 없고 생성자 안에서만 사용 가능!
		this(title, publisher, author); // this()는 메소드 가장 상단에 작성! 
		
		this.price = price;
		this.discountRate = discountRate;
	}
	// 메소드부 (1)
	public void inform() {
		System.out.printf("%s, %s, %s, %d, %.2f" , title, publisher, author, price, discountRate);
	}
}
