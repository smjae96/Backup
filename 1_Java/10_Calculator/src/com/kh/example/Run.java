package com.kh.example;

public class Run {

	public static void main(String[] args) {
		
		Calculator c = new Calculator();
		int num1 = 10;
		int num2 = 5;
		System.out.println("num1 : " +num1+ ", num2 : " +num2);
		System.out.println("���ϱ� ���: " + c.add(num1, num2));
		System.out.println("���� ���: " + c.substract(num1, num2));
		System.out.println("���ϱ� ���: " + c.times(num1, num2));
		System.out.println("������ ���: " + c.divide(num1, num2));
		
		System.out.println("������ ��� (10, 0) : " + c.divide(num1, 0));
	}

}
