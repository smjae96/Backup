package com.kh.practice.run;
import java.util.Scanner;

import com.kh.practice.func.OperatorPractice;
public class Run {

	public static void main(String[] args) {
		OperatorPractice op = new OperatorPractice();
		//op.practice1();
		//op.practice2();
		//op.practice3();
		//op.practice4();
		//op.practice5();
		//op.practice6();
		//op.practice7();
		//op.practice8();
		//op.practice9();
		//op.practice10();
		//op.practice11();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("rps���� �Է��ϼ���: ");
		int rps = sc.nextInt();
//		if(rps==0) {
//			System.out.println("����");
//		}
//		else if(rps==1) {
//			System.out.println("����");
//		}
//		else if(rps==2) {
//			System.out.println("��");
//		}
//		else {
//			System.out.println("�˼� ����");
//		}
		
		switch(rps) {
			case 0:
				System.out.println("����");
				break;
			case 1:
				System.out.println("����");
				break;
			case 2:
				System.out.println("��");
				break;
			default:
				System.out.println("�� �� ����");
				break;
		}
	}

}
