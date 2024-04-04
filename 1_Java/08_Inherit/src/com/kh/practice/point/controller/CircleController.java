package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Circle;

public class CircleController {
	private Circle c = new Circle();
	
	public String calcArea(int x, int y, int radius) {
		// 매개변수로 전달받은 값을 초기화
		c = new Circle(x, y, radius);
//		c.setX(x);
//		c.setY(y);
//		c.setRadius(radius);
		//면적의 값을 계산
		// 	면적 : Math.PI*반지름*반지름
		double area = Math.PI*radius*radius;
		//초기화한 정보와 면적 정보를 문자열로 결과를 반환
		// - c.toString() 메소드를 통해 초기화한 정보(x, y, radius)
		// - area는 면적 계산을 하여 저장한 변수
		return c.toString() + " / " + area;
	}
	
	public String calcCircum(int x, int y, int radius) {
		c = new Circle(x, y, radius);
//		c.setX(x);
//		c.setY(y);
//		c.setRadius(radius);
		//둘레의 값을 계산
		//	둘레 : Math.PI*반지름*2
		double circum = Math.PI*radius*2;
		return c.toString() + " / " + circum;
	}
}
