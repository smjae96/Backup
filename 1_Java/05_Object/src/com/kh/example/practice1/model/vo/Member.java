package com.kh.example.practice1.model.vo;

public class Member {
	// 필드부 : 데이터 정의, 변수
	private String memberld;	// 아이디
	private String memberPwd;	// 비밀번호
	private String memberName;	// 이름
	private int age;			// 나이
	private char gender;		// 성별
	private String phone;		// 연락처
	private String email;		// 이메일
	
	// 생성자부
	public Member() {
		
	}
	

	// 메소드부 : 기능 정의
	// changeName : setName 의 역할
	public void changeName(String name) {
		memberName = name;
	}
	// printName : 이름(memberName)의 값을 출력
	public void printName() {
		System.out.println(memberName);
	}
	
	
}
