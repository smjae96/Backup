package com.kh.example.practice3.model.vo;

public class Circle {

	private final double PI = 3.14;
	private int radius = 1;
	
	public Circle() {
		
	}
	
	public void incrementRadius() {
		this.radius = radius + 1;
	}
	public void getAreaOfCircle() {
		System.out.println("���� �ѷ�: " + 2*PI*radius);
	}
	public void getSizeOfCircle() {
		System.out.println("���� ����: " + PI*radius*radius);
	}
}
