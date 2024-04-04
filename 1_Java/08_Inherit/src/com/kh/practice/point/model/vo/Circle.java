package com.kh.practice.point.model.vo;

public class Circle extends Point {

	private int radius;
	
	public Circle() {
		
	}
	
	public Circle(int x, int y, int radius) {
		// x와 y 값을 어떻게 초기화? 부모클래스의 생성자를 사용하자.
		super(x, y);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	@Override
	public String toString() {
		// 필드에 담긴 메소드를 반환하는 메소드
		//	필드 : (3) x, y, radius
		return super.toString() + ", " + radius;
	}
}
