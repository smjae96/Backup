package com.kh.example;

// ��� ���� �������̽�
public interface Calc {
	// ���
	// PI: double = 3.14
	// ERROR: int = -999_999_999
	
	public static final double PI = 3.14;
	public static final int ERROR = -999_999_999;
	
	// �߻�޼ҵ�
	// add(num1:int, num2:int) : int
	// substract(num1:int, num2:int) : int
	// times(num1:int, num2:int) : int
	// divide(num1:int, num2:int) : int
	
	// public abstract ���� ����
	public abstract int add(int num1, int num2);
	public abstract int substract(int num1, int num2);
	int times(int num1, int num2);
	int divide(int num1, int num2);
}
