package com.kh.example.practice4.model.vo;

public class Student {
	private static int grade;
	static { grade = 1;}
	private int classroom;
	{ classroom = 5;}
	private String name;
	{ name = "ȫ�浿"; }
	private double height;
	{ height = 180.5;}
	private char gender;
	{ gender = 'M'; }
	public Student() {
		
	}
	
	public void information() {
		System.out.println("���: " +grade+ ", ��: " +classroom+ ", �̸�: " +name+ ", Ű: " +height+ ", ���� : " +gender);
	}
}
