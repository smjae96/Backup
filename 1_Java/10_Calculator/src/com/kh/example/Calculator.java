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
	
	// 나누기 연산 기능: divide
	//			- 두번째 매개변수가 0이면 ERROR 반환
	@Override
	public int divide(int num1, int num2) {
		int d = 0;
		if(num2==0) {
			d = ERROR;	// this.ERROR 가능 / super.ERROR 불가능: 인터페이스를 구현한거지, 부모클래스를 상속받은 것이 아님.
		}
		else {
			d = num1/num2;
		}
		return d;
	}
	
}
