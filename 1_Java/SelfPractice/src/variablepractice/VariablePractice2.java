package variablepractice;

import java.util.Scanner;

public class VariablePractice2 {

	// Ű����� ���� �� ���� �Է� �޾� �� ���� ��, ��, ��, �������� ���� ����ϼ���.
	
	/*ex.
	 * ù ��° ���� : 23
	 * �� ��° ���� : 7
	 * 
	 * ���ϱ� ��� : 30
	 * ���� ��� : 16
	 * ���ϱ� ��� : 161
	 * ������ �� ��� : 3
	 */
	
	public void example2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ù ��° ���� : ");
		int first = sc.nextInt();
		System.out.print("�� ��° ���� : ");
		int second = sc.nextInt();
		System.out.println("���ϱ� ��� : " + (first+second));
		System.out.println("���� ��� : " + (first-second));
		System.out.println("���ϱ� ��� : " + (first*second));
		System.out.println("������ �� ��� : " + (first/second));
	}
}
