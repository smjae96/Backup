package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice4 {

	// ���� ���ڿ� ���� Ű����� �Է� �޾� ���ڿ��� �տ��� �� ���� ����ϼ���.
	/*
	 * ex.
	 * ���ڿ��� �Է��ϼ��� : apple
	 * 
	 * ù ��° ����: a
	 * �� ��° ����: p
	 * �� ��° ����: p
	 */
	
	public void example4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڿ��� �Է��ϼ��� : ");
		String word = sc.nextLine();
		System.out.println("ù ��° ���� : " +word.charAt(0));
		System.out.println("�� ��° ���� : " +word.charAt(1));
		System.out.println("�� ��° ���� : " +word.charAt(2));
	}
}
