package com.kh.example.practice3.run;

import com.kh.example.practice3.model.vo.Circle;

public class Run {

	public static void main(String[] args) {
		Circle c1 = new Circle();
		System.out.println("incrementRadius() �޼ҵ� ��� �� ���� �ѷ� & ����");
		c1.getAreaOfCircle();
		c1.getSizeOfCircle();
		System.out.println("incrementRadius() �޼ҵ� ��� �� ���� �ѷ� & ����");
		c1.incrementRadius();
		c1.getAreaOfCircle();
		c1.getSizeOfCircle();
	}

}
