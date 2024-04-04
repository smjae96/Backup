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
		System.out.print("rps값을 입력하세요: ");
		int rps = sc.nextInt();
//		if(rps==0) {
//			System.out.println("가위");
//		}
//		else if(rps==1) {
//			System.out.println("바위");
//		}
//		else if(rps==2) {
//			System.out.println("보");
//		}
//		else {
//			System.out.println("알수 없음");
//		}
		
		switch(rps) {
			case 0:
				System.out.println("가위");
				break;
			case 1:
				System.out.println("바위");
				break;
			case 2:
				System.out.println("보");
				break;
			default:
				System.out.println("알 수 없음");
				break;
		}
	}

}
