package com.kh.practice.numRange.view;

import java.util.Scanner;

import com.kh.practice.numRange.controller.NumberController;
import com.kh.practice.numRange.exception.NumRangeException;

public class NumberMenu {
	NumberController nc = new NumberController();
	public void menu() {
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("���� 1 : ");
			int num1 = sc.nextInt();
			System.out.print("���� 2 : ");
			int num2 = sc.nextInt();
			try {
				System.out.print(num1+ "��(��) "+num2+"�� ����ΰ� ? "+nc.checkDouble(num1, num2));
			} catch(NumRangeException e) {
				//printStackTrace() : ���� �߻� ��ġ�� ȣ��� �޼ҵ� ���� ���
				//	* Throwable Ŭ�����κ��� ��ӹ��� (Throwable: Exception Ŭ������ �����..)
				e.printStackTrace();
				return;
			}
			System.out.println();
			System.out.println();
			System.out.println("�Ǵ�");
			System.out.println();
			
		}

	}
}
