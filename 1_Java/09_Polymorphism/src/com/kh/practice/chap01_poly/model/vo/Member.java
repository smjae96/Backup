package com.kh.practice.chap01_poly.model.vo;

// 회원 객체
public class Member {
	private String name;
	private int age;
	private char gender;
	private int couponCount = 0;
	
	public Member() {}
	public Member(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	@Override
	public String toString() {
		// 필드정보를 문자열 반환
		return String.format("Member [name=%s, age=%d, gender=%c, couponCount=%d]", name, age, gender, couponCount);
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
