package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Rectangle;

public class RectangleController {
	private Rectangle r = new Rectangle();
	
	public String calcArea(int x, int y, int height, int width) {
		r = new Rectangle(x, y, height, width);
//		r.setX(x);
//		r.setY(y);
//		r.setHeight(height);
//		r.setWidth(width);
		int area = height*width;
		return r.toString() + " / " + area;
	}
	
	public String calcPerimeter(int x, int y, int height, int width) {
		r= new Rectangle(x, y, height, width);
//		r.setX(x);
//		r.setY(y);
//		r.setHeight(height);
//		r.setWidth(width);
		int perimeter = 2*(height+width);
		return r.toString() + " / " + perimeter;
		
	}
}
