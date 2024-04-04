package com.kh.example;

public class Calculator implements Calc {

	@Override
	public int add(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int substract(int num1, int num2) {
		return num1 - num2;
	}

	@Override
	public int times(int num1, int num2) {
		return num1*num2;
	}
	
	// ������ ���� ���: divide
	//			- �ι�° �Ű������� 0�̸� ERROR ��ȯ
	@Override
	public int divide(int num1, int num2) {
		int d = 0;
		if(num2==0) {
			d = ERROR;	// this.ERROR ���� / super.ERROR �Ұ���: �������̽��� �����Ѱ���, �θ�Ŭ������ ��ӹ��� ���� �ƴ�.
		}
		else {
			d = num1/num2;
		}
		return d;
	}
	
}
