package com.kh.hw.shape.controller;

import com.kh.hw.shape.model.vo.Shape;

public class SquareController {
	private Shape s= new Shape();
	
	//�⺻ ������ ����
	
	//�޼ҵ��
	public double calcPerimether(double height, double width) {
		s.getType();
		s.setHeight(height);
		s.setWidth(width);
		return s.getWidth()*2 + s.getHeight()*2;
	}
	public double calcArea(double height, double width) {
		s.getType();
		s.setHeight(height);
		s.setWidth(width);
		return s.getWidth()*s.getHeight();
	}
	public void paintColor(String color) {
		s.setColor(color);
	}
	public String print() {
		return String.format("�簢�� " + s.information());
	}
}
