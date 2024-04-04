package com.kh.run;

import java.util.Scanner;
import com.kh.practice.func.*;
/*
 * ������ : ���α׷��� ����� �� ������ �����ִ� �͵�.
 * - (�켱����	) �� ( ���� ����(�������) )�� �߿���!
 * - [1] ���� ���� ������: [] .
 * 	 [2] ���� ������	 : ��ȣ ������ : +, - / ���������� : ++, -- / ����ȯ : (type) / ���� ������ : !
 * 	 [3] ��� ������	 : + - * /(��) %(������)
 * 	 [4] ��Ʈ ����Ʈ ������: << >> (���ڸ��� ���:0, ����:1) >>> (���ڸ��� 0)
 * 	 [5] ��(����) ������: <(������ �����ʺ��� ����) >(������ �����ʺ��� ŭ) <= 
 * 			* A < B  : A�� B���� ������?  
 * 			* A <= B : A�� B���� �۰ų� ������?
 * 			* A == B : A�� B�� ������?
 * 			* A != B : A�� B�� �ٸ���?
 * 	 [6] �� ������(��Ʈ ������)	 : && || & |
 * 	 [7] ���� ������	 : (���ǽ�) ? (���ǽ� ����� ���� �� ����� ��) : (���ǽ� ����� ������ �� ����� ��);
 * 	 [8] ���� ������	 : = += -= *= /= %= &= <<= >>= >>>=
 */

public class OperatorRun {
	public static void main(String[] args) {
//		practice1();
//		practice2();
//		practice3();
//		practice4();
//		practice5();
//		practice6();
		OperatorPractice op = new OperatorPractice();
	//	op.practice1();
		//op.practice2();
		//op.practice3();
		//op.practice4();
		//op.practice5();
		//op.practice6();
		//op.practice7();
		op.practice8();
		//op.practice9();
		//op.practice10();
		//op.practice11();
	}
	
	// ���� ������ : ++ --
	public static void practice1() {
		// ����(���� �����ڰ� ���� �տ� �پ��ִ�)����: ++(����)
		int num = 10;
		System.out.println("������ �����ϱ� �� num: " + num); // 10
		System.out.println("1ȸ ���� �� num: " + ++num); // 11
		System.out.println("2ȸ ���� �� num: " + ++num); // 12
		System.out.println("3ȸ ���� �� num: " + ++num); // 13
		System.out.println("���� num: " + num); // 13
		
		System.out.println("=========================");
		// ��������: (����)++
		int num2 = 10;
		System.out.println("������ �����ϱ� �� num2: " + num2); //10
		System.out.println("1ȸ ���� �� num2: " + num2++); // 10 (����� ���� �� �� ����.)
		System.out.println("2ȸ ���� �� num2: " + num2++); // 11
		System.out.println("3ȸ ���� �� num2: " + num2++); // 12
		System.out.println("���� num2: " + num2); // 13
	}
	
	public static void practice2() {
		int num1 = 10;
		int num2 = 10;
		int result1 = ++num1 * 3; // num1: 11 result1: 11*3= 33
		int result2 = num2++ * 3; // result2: 10*3= 30, num2: 11
		System.out.printf("num1: %d, result1: %d\n", num1, result1); // num1: 11, result1: 33
		System.out.printf("num2: %d, result2: %d\n", num2, result2); // num2: 11, result2: 30
	}
	
	public static void practice3() {
		int a = 10;
		int b = 20;
		int c = 30;
		
		System.out.println(a++);					// ��°�: 10, ��� �� a: 11 
		System.out.println((++a) + (b++));			// ��°�: 32, ��� �� a: 12, b: 21
						//   ((++11) + (20++))
						//   ( 12 + (20++))
						//	 ( 12 + 20 )	// 20++ �ؾ���!
						//	 ( 32 )
		System.out.println((a++) + (--b) + (--c));	// ��°�: 61, ��� �� a: 13, b: 20, c: 29
						//	 ((12++) + (--21) + (--30))    --> �������� �����ؾ� ��. --21�� --30 ���� ����.
						//   ((12++) + (20) + (29)) // b: 20, c: 29, a++
						//	 ((12 + 20 + 29)) = 61	// a: 13	
					
	}
	
	public static void practice4() {
		int a =5;
		int b = 10;
		
		int c = (++a) + b; // 6+10 == 16, a�� 6
		int d = c / a; // 16/6 == 2
		int e = c % a; // 16%6 == 4 
		
		// a: 6, b: 10, c: 16, d: 2, e: 4
		
		int f = e++; // 4, e�� 5
		
		int g = (--b) + (d--); // 9+2 == 11, b�� 9 , d�� 1
		int h = 2;
		
		// a: 6, b: 9, c: 16, d: 1, e: 5, f: 4, g: 11, h: 2 
		
		int i = (a++) + b / (--c / f) * (g-- - d) % (++e + h); 
		// (a++) + b / (15 / 4) * (g-- - 1) % (6 + 2) 		// c: 15, e: 6
		// (a++) + b / 3 * (11-1) % 8 						// g: 10
		// (a++) + b / 3 * 10 % 8
		// (a++) + 9 / 3 * 10 % 8
		// (a++) + 3 * 10 % 8
		// (a++) + 30 % 8
		// (a++) + 6
		// 6+6												// a: 7
		// 12
		
		System.out.println("a: " +a); // 7
		System.out.println("b: " +b); // 9
		System.out.println("c: " +c); // 15
		System.out.println("d: " +d); // 1
		System.out.println("e: " +e); // 6
		System.out.println("f: " +f); // 4
		System.out.println("g: " +g); // 10
		System.out.println("h: " +h); // 2
		System.out.println("i: " +i); // 12
	}
	
	// ��������/��(����)������
	public static void practice5() {
		// ����ڷκ��� 1 ~ 10 ������ ������ �Է¹��� ��� true�� ����ϰ�,
		// �׷��� ���� ��� false ���.
		Scanner sc = new Scanner(System.in);
		
		// ȭ�鿡 "1 ~ 10 ������ ������ �Է�: " ���(�ٹٲ� ����)
		System.out.print("1~10 ������ ������ �Է�: ");
		int num = sc.nextInt();
		
		// num�� ���� 1, 2, 3, 4, 5, ..., 9, 10 => true
		// num�� �ּ� ���� 1�̰�, �ִ밪�� 10�̸� true
		// num�� ���� 1���� ũ�ų� ����, 10���� �۰ų� ������ true
		boolean result = (num >= 1) && (num<=10);
		
		System.out.printf("�Է��� �� %d�� 1 ~ 10 ������ �����Դϱ�? %b", num , result);
		
	}
	
	public static void practice6() {
		// ����ڷκ��� ����(a ~ z, A ~ Z)�� �ϳ� �Է� �޾�
		// �빮������ �ҹ������� ���
		// ��� ����) �Է��� ���� [a]�� �ҹ����Դϴ�.
		//			�Է��� ���� [A]�� �ҹ��ڰ� �ƴմϴ�.
		//  * [ASCII] a: 97, A: 65
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڸ� �Է�: ");
		String str= sc.nextLine();		// �Է¹��� ���� ���ڿ� Ÿ������ ������ ����
		char alphabet = str.charAt(0);	// ���ڿ����� ù��° ��ġ�� ���� ����Ÿ������
		
		// �Է� ���� ��(ch)�� �ҹ��� ������ ���ԵǴ� �� : 97 ~ 122
		String result = (97 <= alphabet) && (alphabet <= 122) ? "�ҹ����Դϴ�." : "�ҹ��ڰ� �ƴմϴ�."; // ���� �������� ����� ���ڿ��̹Ƿ�, ���� result�� �ڷ����� String���� �Ѵ�.
		 String info = ((alphabet >= 65) && (alphabet <97)) ? "�ҹ��ڰ� �ƴմϴ�" : "�ҹ����Դϴ�.";
		 
		 System.out.println("[1] �Է��� ���� [" + alphabet + "]�� " + info);
		 
		 String result2 = ('a' <= alphabet) && (alphabet <= 'z') ? "�ҹ��� �Դϴ�." : "�ҹ��ڰ� �ƴմϴ�.";
		 System.out.println("[2] �Է� �� " + alphabet + "�� " + result2);
		 
		 String result3 = ('a' <= alphabet) && (alphabet <= 'z') ? "�ҹ��� �Դϴ�." :
			 				((('A' <= alphabet) && (alphabet <= 'Z')) ? "�빮�� �Դϴ�." : "���ĺ��� �ƴմϴ�.");
		 System.out.println("[3] �Է� �� " + alphabet + "�� " + result3);
			 				
		 
	
	}
	
	public static void practice6a() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڸ� �Է�: ");
		
		char alphabet = sc.next().charAt(0);
		
		if((alphabet>= 65) && (alphabet < 97)) {
			System.out.println("�Է��� ���� [" + alphabet + "]�� �ҹ��ڰ� �ƴմϴ�.");
		}
		else {
			System.out.println("�Է��� ���� [" + alphabet + "]�� �ҹ����Դϴ�.");
		}
	}
	
	public static void practice6b() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڸ� �Է�: ");
		
		char alphabet = sc.nextLine().charAt(0);
		
		 String info1 = ((alphabet >= 65) && (alphabet <97)) ? "�ҹ��ڰ� �ƴմϴ�" : "�ҹ����Դϴ�.";
		
	}
}
