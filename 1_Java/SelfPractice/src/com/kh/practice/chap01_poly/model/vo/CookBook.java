package com.kh.practice.chap01_poly.model.vo;

// Book 클래스 상속 받음
// 요리책 객체
public class CookBook extends Book {
	private boolean coupon;		// 요리학원 쿠폰유무
	
	// 생성자 (2) : 기본생성자, 매개변수 4개(title, author, publisher, coupon) 전달받은 생성자
	public CookBook() {}
	
	public CookBook(String title, String author, String publisher, boolean coupon) {
		super(title, author, publisher);
		this.coupon = coupon;
	}
	
	// 메소드 (1) : toString() - 부모클래스(Book) 필드와 현재 클래스(CookBook)의 필드 정보를 문자열 반환
	@Override
	public String toString() {
		return String.format("%s / %b", super.toString(), coupon);
	}

	public boolean isCoupon() {
		return coupon;
	}

	public void setCoupon(boolean coupon) {
		this.coupon = coupon;
	}
}
