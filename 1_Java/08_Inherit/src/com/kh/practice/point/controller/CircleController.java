package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Circle;

public class CircleController {
	private Circle c = new Circle();
	
	public String calcArea(int x, int y, int radius) {
		// �Ű������� ���޹��� ���� �ʱ�ȭ
		c = new Circle(x, y, radius);
//		c.setX(x);
//		c.setY(y);
//		c.setRadius(radius);
		//������ ���� ���
		// 	���� : Math.PI*������*������
		double area = Math.PI*radius*radius;
		//�ʱ�ȭ�� ������ ���� ������ ���ڿ��� ����� ��ȯ
		// - c.toString() �޼ҵ带 ���� �ʱ�ȭ�� ����(x, y, radius)
		// - area�� ���� ����� �Ͽ� ������ ����
		return c.toString() + " / " + area;
	}
	
	public String calcCircum(int x, int y, int radius) {
		c = new Circle(x, y, radius);
//		c.setX(x);
//		c.setY(y);
//		c.setRadius(radius);
		//�ѷ��� ���� ���
		//	�ѷ� : Math.PI*������*2
		double circum = Math.PI*radius*2;
		return c.toString() + " / " + circum;
	}
}
