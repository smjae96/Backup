package com.kh.practice.student.model.vo;

public class Student {
	// 필드부(변수, 데이터)
	private String name;	// 이름
	private String subject; // 과목
	private int score;		// 점수
	
	// 생성자부(2)
	public Student() {
		
	}

	public Student(String name, String subject, int score) {
		this.name = name;
		this.subject = subject;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public String inform() {
		//return name + " " + subject + " " + score + " ";
		// String.format("문자열 형식(지시어 포함)", 지시어에 해당하는 변수, ...)
		return String.format("이름 : %s / 과목 : %s / 점수 : %d", name, subject, score);
	}
	
	
}
