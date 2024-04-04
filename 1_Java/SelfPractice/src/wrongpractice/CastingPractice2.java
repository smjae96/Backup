package wrongpractice;

import java.util.ArrayList;
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
		double[] score = new double[3];
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		ArrayList<String> subs = new ArrayList<String>();
		subs.add("국어");
		subs.add("수학");
		subs.add("영어");
		
		for(int i=0; i<score.length; i++) {
//			System.out.print("");
//			String subject = sc.next();
			System.out.print(subs.get(i) + ":");
			score[i]=sc.nextDouble();
			sum = sum+(int)score[i];
		}
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " +(sum)/score.length);
	} 

	
}
