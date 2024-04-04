package com.kh.practice.chap01_poly.model.vo;

// Book 클래스를 상속받음
// 만화책
public class AniBook extends Book {
	// 멤버 변수: (3)
	private int accessAge;	// 제한 나이
	
	// 생성자: (0) + (2) = (2) 
	// - 기본 생성자, 매개변수가 4개인 생성자(title, author, publisher, accessAge)
	public AniBook() {
		
	}
	public AniBook(String title, String author, String publisher, int accessAge) {
		super(title, author, publisher);
		this.accessAge = accessAge;
	}
	
	// 메소드: (1) - toString() 메소드 재정의(오버라이딩)
	//				부모클래스의 멤버변수 정보와 현재클래스(AniBook)의 멤버변수 정보를 모두 문자열 반환				
	@Override
	public String toString() {
		return "AniBook " +super.toString() +", accessAge=" +accessAge + "]";
	}
	
	public int getAccessAge() {
		return accessAge;
	}
	public void setAccessAge(int accessAge) {
		this.accessAge = accessAge;
	}
	
}
