package com.kh.practice.numRange.view;

import java.util.Scanner;

import com.kh.practice.numRange.controller.NumberController;
import com.kh.practice.numRange.exception.NumRangeException;

public class NumberMenu {
	NumberController nc = new NumberController();
	public void menu() {
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("정수 1 : ");
			int num1 = sc.nextInt();
			System.out.print("정수 2 : ");
			int num2 = sc.nextInt();
			try {
				System.out.print(num1+ "은(는) "+num2+"의 배수인가 ? "+nc.checkDouble(num1, num2));
			} catch(NumRangeException e) {
				//printStackTrace() : 예외 발생 위치와 호출된 메소드 정보 출력
				//	* Throwable 클래스로부터 상속받음 (Throwable: Exception 클래스가 상속중..)
				e.printStackTrace();
				return;
			}
			System.out.println();
			System.out.println();
			System.out.println("또는");
			System.out.println();
			
		}

	}
}
