package com.kh.practice.func;

import java.util.Scanner;

public class OperatorPractice {
	
	public void practice1() {
		//Ű����� �Է� ���� �ϳ��� ������ ����̸� "�����", ����� �ƴϸ� "����� �ƴϴ�"�� ����ϼ���.
		/* ex.
		 * ���� : -9
		 * ����� �ƴϴ�.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		int num = sc.nextInt();
		
		String result = (num>0) ? "����̴�." : "����� �ƴϴ�.";
		
		System.out.println(result);
		
	}
	
	public void practice2() {
		//Ű����� �Է� ���� �ϳ��� ������ ����̸� "�����", ����� �ƴ� ��� �߿��� 0�̸� "0�̴�", 0�� �ƴϸ� "������"�� ����ϼ���.
		/* ex.
		 * ���� : -9
		 * ������.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		int num = sc.nextInt();
		
		String result = (num>0) ? "����̴�." : 
							((num==0) ? "0�̴�" : "������");
		
		System.out.println(result);
	}
	
	public void practice3() {
		// Ű����� �Է� ���� �ϳ��� ������ ¦���̸� "¦����", ¦���� �ƴϸ� "Ȧ����"�� ����ϼ���.
		/* ex.
		 * ���� : 5
		 * Ȧ����
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		int num = sc.nextInt();
		
		String result = (num%2==1) ? "Ȧ���̴�." : "¦���̴�.";
		
		System.out.println(result);
	}
	
	public void practice4() {
		// ��� ����� ������ ���� ������������ �Ѵ�. �ο� ���� ���� ������ Ű����� �Է� �ް�
		// 1�δ� �����ϰ� �������� ���� ������ �����ְ� ���� ������ ������ ����ϼ���.
		/*ex.
		 * �ο� �� : 29
		 * ���� ���� : 100
		 * 
		 * 1�δ� ���� ���� : 3
		 * ���� ���� ���� : 13
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ο� ��: ");
		int people = sc.nextInt();
		System.out.print("���� ����: ");
		int candy = sc.nextInt();
		
		int divided = candy/people;
		int left = candy%people;
		System.out.println("1�δ� ���� ����: " +divided );
		System.out.println("���� ���� ����: " +left);
		
	}
	
	public void practice5() {
		// Ű����� �Է� ���� ������ ������ ����ϰ� ����� ���� ���� ȭ�鿡 ����Ͽ� Ȯ���ϼ���.
		// �� �� ������ 'M'�̸� ���л�, 'M'�� �ƴϸ� ���л����� ��� ó�� �ϼ���.
		
		/* ex.
		 * �̸� : �ڽſ�
		 * �г�(���ڸ�) : 3
		 * ��(���ڸ�) : 4
		 * ��ȣ(���ڸ�) : 15
		 * ����(M/F) : F
		 * ����(�Ҽ��� �Ʒ� ��°�ڸ�����) : 85.75
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸�: ");
		String name = sc.next();
		System.out.print("�г�(���ڸ�): ");
		int grade = sc.nextInt();
		System.out.print("��(���ڸ�): ");
		int classno = sc.nextInt();
		System.out.print("��ȣ(���ڸ�): ");
		int studentno = sc.nextInt();
		System.out.print("����(M/F): ");
		char gender = sc.next().charAt(0);
		System.out.print("����(�Ҽ��� �Ʒ� ��°�ڸ�����) : ");
		double score = sc.nextDouble();
		
		String result = (gender == 'F') ? "���л�" : "���л�";
		
		System.out.printf("%d�г� %d�� %d�� %s %s�� ������ %.2f�̴�.", grade, classno, studentno, name, result, score );
	}
	
	public void practice6() {
		//���̸� Ű����� �Է� �޾� ���(13�� ����)����, û�ҳ�(13�� �ʰ� ~ 19�� ����)����,
		//����(19�� �ʰ�)���� ����ϼ���.
		
		/* ex.
		 * ���� :
		 * û�ҳ�
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("����: ");
		int age = sc.nextInt();
		String result = (age<=13) ? "���" : 
						(age>19) ? "����" : "û�ҳ�";
		System.out.println(result);
	}
	
	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("����: ");
		int score1 = sc.nextInt();
		System.out.print("����: ");
		int score2 = sc.nextInt();
		System.out.print("����: ");
		int score3 = sc.nextInt();
		
		int total = score1 + score2 + score3;
		System.out.println("�հ�: " +total);
		System.out.println("���: " +total/3.0);
		String result = ((total/3.0)>=60.0) ? "�հ�" : "���հ�"; 
		System.out.println(result);
		
	}
	
	public void practice8() {
		//�ֹι�ȣ�� �̿��Ͽ� �������� �������� �����Ͽ� ����ϼ���.
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�ֹι�ȣ�� �Է��ϼ���(- ����): ");
		String num = sc.nextLine();
		
		// [���ڿ�].charAt(index);	: ���ڿ����� index ��ġ�� ���ڸ� ��ȯ
		char gender = num.charAt(7);
		
		//char (2����Ʈ) int (4����Ʈ)
		// ����: 1,3 / ����: 2,4
		String result = (num.charAt(7) == '2' || num.charAt(7) == '4') ? "����" : "����";
		// 132456-9123456 => �� �� ����
		System.out.println((gender == '2' || gender == '4') ? "����" : 
							((gender == '1' || gender == '3') ? "����" : "�� �� ����"));
		//System.out.println(result);
	}
	
	public void practice9() {
		// Ű����� ���� �� ���� �Է� �޾� ���� ����(num1, num2)�� �����ϼ���.
		// �׸��� �� �ٸ� ������ �Է� �޾� �� ���� num1 ���ϰų� num2 �ʰ��̸� true�� ����ϼ���.
		// �ƴϸ� false�� ����ϼ���.
		// (��, num1�� num2���� �۾ƾ� ��)
		Scanner sc = new Scanner(System.in);
		
		System.out.print("����1: ");
		int num1 = sc.nextInt();
		System.out.print("����2: ");
		int num2 = sc.nextInt();
		System.out.print("�Է�: ");
		int inputting = sc.nextInt();
		
		// �Է¹��� ���� num1 ���ϰų� �Է¹��� ���� num2 �ʰ� : inputting <= num1 || inputting > num2
		// ��, num1�� num2���� �۾ƾ� �Ѵ�. : num1<num2
		// num1<num2�� false�̸� (inputting<=num1 || inputting>num2)�� ������ �ʿ䰡 ���� ����� false�̴�.
		System.out.println((num1<num2) && (inputting<=num1 || inputting>num2));
		boolean result = ((num1<num2) && (inputting<=num1 || inputting>num2)) ? true: false;
		//System.out.println(result);
		
	}
	
	public void practice10() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�Է�1: ");
		int num1 = sc.nextInt();
		System.out.print("�Է�2: ");
		int num2 = sc.nextInt();
		System.out.print("�Է�3: ");
		int num3 = sc.nextInt();
		
		boolean result = (num1==num2 && num2==num3 && num1==num3) ? true : false;
		System.out.println(result);
	}
	
	public void practice11() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("A����� ����: ");
		int sal1 = sc.nextInt();
		System.out.print("B����� ����: ");
		int sal2 = sc.nextInt();
		System.out.print("C����� ����: ");
		int sal3 = sc.nextInt();
		
		String aSal = (sal1+sal1*0.4>=3000) ? "3000 �̻�" : "3000 �̸�";
		String bSal = (sal2>=3000) ? "3000 �̻�" : "3000 �̸�";
		String cSal = (sal3+sal3*0.15>=3000) ? "3000 �̻�" : "3000 �̸�";
		
		System.out.println("A��� ����/����+a: "+sal1+"/"+(sal1+sal1*0.4));
		System.out.println(aSal);
		System.out.println("B��� ����/����+a: "+sal2+"/"+(double)(sal2));
		System.out.println(bSal);
		System.out.printf("C��� ����/����+a: %d/%.13f\n", sal3 , sal3*(1+0.15));
		System.out.println(cSal);
		
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("A����� ����: ");
//		int salA = sc.nextInt();
//		System.out.print("B����� ����: ");
//		int salB = sc.nextInt();
//		System.out.print("C����� ����: ");
//		int salC = sc.nextInt();
//		
//		//�μ�Ƽ��
//		double incA = 0.4;
//		double incB = 0.0;
//		double incC = 0.15;
//		
//		//�μ�Ƽ�� ���� ����
//		double incSalA = salA*(1+incA);
//		double incSalB = salB*(1+incB);
//		double incSalC = salC*(1+incC);
//		
//		// 3000 �̻� or �̸�
//		String resultA = (incSalA>=3000) ? "3000 �̻�" : "3000 �̸�";
//		String resultB = (incSalB>=3000) ? "3000 �̻�" : "3000 �̸�";
//		String resultC = (incSalC>=3000) ? "3000 �̻�" : "3000 �̸�";
//		
//		System.out.println("A��� ����/����+a: " + salA+"/"+incSalA);
//		System.out.println(resultA);
//		System.out.println("B��� ����/����+a: " + salB+"/"+incSalB);
//		System.out.println(resultB);
//		System.out.println("C��� ����/����+a: " + salC+"/"+incSalC);
//		System.out.println(resultC);
//		
				
		
	}
}
