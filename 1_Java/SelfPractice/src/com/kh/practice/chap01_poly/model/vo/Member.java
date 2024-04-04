package com.kh.practice.chap01_poly.model.vo;

// 회원 객체
public class Member {
	// 필드부
	private String name;		// 회원명
	private int age;			// 회원나이
	private char gender;		// 성별
	private int couponCount;	// 요리학원 쿠폰 개수 = 0 (int형 변수의 기본 값: 0)
	
	// 생성자부
	public Member() {} 		// 기본생성자
	public Member(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	// 메소드부
	@Override
	public String toString() {
		// 필드 정보를 문자열 반환
		return String.format("Member [name=%s, age=%d, gender=%c, couponCount=%d]", 
								name, age, gender, couponCount);
	}
	
	// Alt + Shift + S > R
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getCouponCount() {
		return couponCount;
	}
	public void setCouponCount(int couponCount) {
		this.couponCount = couponCount;
	}
	
	public void addCount() {
		couponCount++;
	}
}







