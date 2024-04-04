package com.kh.practice2.func;

import java.util.Scanner;

public class CastingPractice2 {
	// 실수형으로 국어, 영어, 수학 세 과목의 점수를 입력 받아 총점과 평균을 출력하세요.
	// 이 때 총점과 평균은 정수형으로 처리하세요.
	
	/* ex.
	 * 국어 : 90.0
	 * 영어 : 90.0
	 * 수학 : 90.0
	 * 
	 * 총점 : 270
	 * 평균 : 90
	 */
	public void example2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어: ");
		double score1 = sc.nextDouble();
		System.out.print("영어: ");
		double score2 = sc.nextDouble();
		System.out.print("수학: ");
		double score3 = sc.nextDouble();
		
		int total = (int)(score1+score2+score3);
		int average = (int)(total/3);
		System.out.println("총점: " + total);
		System.out.println("평균: " + average);
	}
}
