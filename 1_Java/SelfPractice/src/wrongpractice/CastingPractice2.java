package wrongpractice;

import java.util.ArrayList;
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
		double[] score = new double[3];
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		ArrayList<String> subs = new ArrayList<String>();
		subs.add("����");
		subs.add("����");
		subs.add("����");
		
		for(int i=0; i<score.length; i++) {
//			System.out.print("");
//			String subject = sc.next();
			System.out.print(subs.get(i) + ":");
			score[i]=sc.nextDouble();
			sum = sum+(int)score[i];
		}
		System.out.println("���� : " + sum);
		System.out.println("��� : " +(sum)/score.length);
	} 

	
}
