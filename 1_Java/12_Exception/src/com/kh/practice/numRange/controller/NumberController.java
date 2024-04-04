package com.kh.practice.numRange.controller;

import com.kh.practice.numRange.exception.NumRangeException;

public class NumberController {

	public NumberController() {
		
	}
	
	public boolean checkDouble(int num1, int num2) throws NumRangeException{
		boolean b = false;
		
		if(1<=num1 && num1<=100 && 1<=num2 && num2<=100) {
			if(num1%num2==0) {
				b = true;
			} else {
				b = false;
			}
		} else {
			throw new NumRangeException("1���� 100 ������ ���� �ƴմϴ�.");
		}
		return b;
		
	}
}
