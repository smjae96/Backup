package com.kh.example.practice4.model.vo;

public class Student {
	private static int grade;
	static { grade = 1;}
	private int classroom;
	{ classroom = 5;}
	private String name;
	{ name = "홍길동"; }
	private double height;
	{ height = 180.5;}
	private char gender;
	{ gender = 'M'; }
	public Student() {
		
	}
	
	public void information() {
		System.out.println("등급: " +grade+ ", 반: " +classroom+ ", 이름: " +name+ ", 키: " +height+ ", 성별 : " +gender);
	}
}
