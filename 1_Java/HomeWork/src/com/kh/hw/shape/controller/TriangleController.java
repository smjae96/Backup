package com.kh.hw.shape.controller;

import com.kh.hw.shape.model.vo.Shape;

public class TriangleController {
	private Shape s = new Shape();
	
	// 기본 생성자 생략
	
	// 메소드부
	public double calcArea(double height, double width) {
		s.getType();
		s.setHeight(height);
		s.setWidth(width);
		return s.getWidth()*s.getHeight()/2;
	}
	
	public void paintColor(String color) {
		s.setColor(color);
	}
	
	public String print() {
		return String.format("삼각형 " + s.information());
	}
}
