package com.kh.practice2.func;

import java.util.Scanner;

public class CastingPractice2 {
	// �Ǽ������� ����, ����, ���� �� ������ ������ �Է� �޾� ������ ����� ����ϼ���.
	// �� �� ������ ����� ���������� ó���ϼ���.
	
	/* ex.
	 * ���� : 90.0
	 * ���� : 90.0
	 * ���� : 90.0
	 * 
	 * ���� : 270
	 * ��� : 90
	 */
	public void example2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("����: ");
		double score1 = sc.nextDouble();
		System.out.print("����: ");
		double score2 = sc.nextDouble();
		System.out.print("����: ");
		double score3 = sc.nextDouble();
		
		int total = (int)(score1+score2+score3);
		int average = (int)(total/3);
		System.out.println("����: " + total);
		System.out.println("���: " + average);
	}
}
