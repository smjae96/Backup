package com.kh.practice.point.model.vo;

public class Circle extends Point {

	private int radius;
	
	public Circle() {
		
	}
	
	public Circle(int x, int y, int radius) {
		// x�� y ���� ��� �ʱ�ȭ? �θ�Ŭ������ �����ڸ� �������.
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
		// �ʵ忡 ��� �޼ҵ带 ��ȯ�ϴ� �޼ҵ�
		//	�ʵ� : (3) x, y, radius
		return super.toString() + ", " + radius;
	}
}
