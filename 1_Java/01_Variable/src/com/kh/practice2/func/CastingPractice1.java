package com.kh.practice2.func;

import java.util.Scanner;

public class CastingPractice1 {

	// Ű����� ���� �ϳ��� �Է� �޾� �� ������ �����ڵ带 ����ϼ���.
	/* ex. 
	 * ���� : A
	 * A unicode : 65
	 */
	public void example1() {
		// import ���� Scanner ����ϴ� ���
	//	java.util.Scanner sc = new java.util.Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		//char word1 = sc.next().charAt(0); // �Է¹��� ���ڿ����� ù��° ���ڰ��� word1 ������ ����.
		String strWord1 = sc.nextLine();
		char word1 = strWord1.charAt(0);
		
		// ���� ����ȯ : ������(char) -> ������(int)
		System.out.println(word1 + " unicode : " +(int)word1);
		
		System.out.print("���� : ");
		String strWord2 = sc.nextLine();
		char word2 = strWord2.charAt(0);
		System.out.println(word2 + " unicode : " +(int)word2);
		
	}
}
