package com.kh.practice.dimension;

import java.util.Arrays;
import java.util.Scanner;

public class DimensionPractice {
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		// 3�� 3��¥�� ���ڿ� �迭�� ���� �� �Ҵ�(����)
		// �ڷ���[][] ���������� = new �ڷ���[�� ũ��][�� ũ��];
		int r = 3;
		int c = 3;
		String[][] arr =  new String[3][3];
		
		// 0�� 0������ 2�� 2������ "(0, 0)"�� ���� �������� ���� �� ���
		for(int i=0; i<arr.length; i++) {	// �ٱ��� for��: �� �ε��� ó��
			// i: 0 1 2
			for(int j=0; j<arr[i].length; j++) {	// ���� for��: �� �ε��� ó��
				// j: 0 1 2
				// arr[0][0] / arr[0][1] / arr[0][2]
				// arr[1][0] / arr[1][1] / arr[1][2]
				// arr[2][0] / arr[2][1] / arr[2][2]
				arr[i][j] = "(" + i + ", " + j + ")";
				
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void practice2() {
		// 4�� 4��¥�� ������ �迭�� ���� �� �Ҵ�(����)
		int[][] arr = new int[4][4];
		// (1) ������ ���� ������ �����Ͽ� ó��
		int num = 0;
		// 1 ~ 16���� ���� ���ʴ�� ����.
		for(int i=0; i<arr.length; i++ ) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = ++num;
				
				//System.out.print(arr[i][j] +" ");
				System.out.printf("%3d" , arr[i][j]);	// %3d : ���� 3ĭ �����Ͽ� ������ �����Ͽ� ���
			}
			System.out.println();
		}
		//----------------------------------------------
		// [2] ���
		// 1 ~ 16���� ���� ���ʴ�� ����
//		for(int i=0; i<arr.length; i++ ) {
//			for(int j=0; j<arr[i].length; j++) {
//				// 1 2 3 4 => j: 0 1 2 3 => j+1: 1 2 3 4
//				// 5 6 7 8 => (4+1) (4+2) (4+3) (4+4)
//				// 9 10 11 12 => (8+1) (8+2) (8+3) (8+4)
//				// 13 14 15 16 => (12+1) (12+2) (12+3) (12+4)
//				arr[i][j] = (i*4) + (j+1);
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
	
	public void practice3() {
		// 4�� 4��¥�� ������ �迭 ���� �� �Ҵ�(����)
		int[][] arr = new int[4][4];
		int num = 16;
		// 16~1���� �Ųٷ� ���� ����.
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = num--;
				System.out.printf("%3d" , arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void practice4() {
		// 4�� 4�� 2���� �迭�� �����Ͽ� 0�� 0������ 2�� 2�������� 1~10������ ������ ���� �� ����
		// 3�� 0������ 0�� ������ ��, 3�� 1������ 1�� ������ ��, 3�� 2������ 2�� ������ ��, 0�� 3������ 0�� ������ ��
		// 0�� 3������ 0�� ������ ��, 1�� 3������ 1�� ������ ��, 2�� 3������ 2�� ������ ��, 3�� 3������ ���� ���� ��
		
		int[][] arr = new int[4][4];
		int sum1 = 0;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(i<=2 && j<=2) {
					arr[i][j] = (int)(Math.random()*10+1);
				}
				else if(i==3 && j!=3) {
					 
					arr[i][j] = arr[0][j] + arr[1][j] + arr[2][j]; 
				}
				else if(j==3 && i!=3) {
					arr[i][j] = arr[i][0] + arr[i][1] + arr[i][2];
				}
				else if(j==3 && i ==3){
					arr[i][j] = arr[0][3] + arr[1][3] + arr[2][3] + arr[3][0] + arr[3][1] + arr[3][2];
				}
				System.out.printf("%4d" , arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void practice5() {
		System.out.print("�� ũ�� : ");
		int row = sc.nextInt();
		System.out.print("�� ũ�� : ");
		int col = sc.nextInt();
		//�Է¹��� ���� ũ��� ���� ũ��� 2���� �迭 ���� �� �Ҵ�
		char[][] arr = new char[row][col];
		while(true) {
			// 1 ~ 10 ������ ���ڰ� �Էµ��� �ʾ��� ��� �޽��� ��� �� �ٽ� �Է��ϵ���
			// [1] ((row<1 || row>10) || (col<1 || col>10)) // row �Ǵ� col�� ������ 1 ~ 10�� ���
			// [2] (!(row>=1 && row<=10) || !(col>=1 && col<=10))
			if((row<1 || row>10) || (col<1 || col>10)) {
				System.out.println("�ݵ�� 1~10 ������ ������ �Է��ؾ� �մϴ�.");
				continue; // �ݺ��� �� �� ȿ���� ����, ���ǹ��� ������ ��� continue �Ʒ��� ���� x
			}
			
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr[i].length; j++) {
					// �迭 �ȿ� ���� �빮�ڸ� �������� ����
					// A: 65
					// 0 <= n < 1
					// Math.random() * (�ʿ��� ����) + (���۹�ȣ)
					arr[i][j] = (char)(Math.random()*26+65);
					System.out.print(arr[i][j]+ " ");
				}
				System.out.println();
			}
			break; // while���� break�ؼ� ������������.
		}	
	}
	
	public void practice6() {
		String[][] strArr = new String[][] {{"��", "��", "��", "��", "��"}, {"��", "��", "��", "��", "��"}, {"��" ,
		"��", "��", "��", "��"}, {"��", "��", "��", "��", "��"}, {"��", "��", "! ", "��", "!! "}};	
		
		for(int i=0; i<strArr.length; i++) {
			for(int j=0; j<strArr[i].length; j++) {
				System.out.print(strArr[j][i] +" ");
			}
			System.out.println();
		}
	}
	
	public void practice7() {
		
		// ����ڿ��� ���� ũ�⸦ �Է¹ް�
		System.out.print("���� ũ��: ");
		int row = sc.nextInt();
		
		
		// ������ ���� �迭(2����)�� ���� �� �Ҵ�
		char[][] arr = new char[row][];
		
		// �� ����ŭ �ݺ��ؼ� ���� ũ�⵵ �Է� �޾�
		for(int i=0; i<arr.length; i++) {
			System.out.print(i+"���� �� ũ�� : ");
			int col = sc.nextInt();
			// i:0 arr[0] = new char[col];
			// i:1 arr[1] = new char[col];
			// ...
			arr[i] = new char[col];
		}
		char alp = 'a';
		// (0,0) ~ (row-1, col..) ���� 'a' ~ .. ����.
		// * �ε����� 2�� �ʿ� : �࿡ ���� �ε���, ���� ���� �ε���
		for(int i=0; i<arr.length; i++) {	// 2���� �迭(arr)�� ���̸�ŭ == ���� ũ��
			for(int j=0; j<arr[i].length; j++) {	// �� �迭�� ���̸�ŭ == �� �� ���� ũ��
				// arr[i] -> 1���� �迭
				arr[i][j] = alp++;		// alp = alp + 1;
										//	   = (char)alp + (int)1;
										// 	   = [int](alp+1)
										//	   = (char)[int](alp+1)		// �ڵ�����ȯ
				
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void practice8() {
		// 1���� �迭�� 12���� �л����� �⼮�� ������ �ʱ�ȭ.
		// 2�� 3������ 2���� �迭 2���� �̿��Ͽ� �д��� ����
		// 1�д� ���ʺ��� ������, 1�࿡�� �Ʒ� �� ������ �ڸ� ��ġ.
		String[][] arr1 = {{"���ǰ�", "������"} , {"�����", "�����"} , {"���̹�", "�ں���"}};
		String[][] arr2 = {{"�ۼ���", "������"} , {"������" , "��õ��"} , {"��ǳǥ", "ȫ����"}};
		
		System.out.println("== 1�д� ==");
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr1[i].length; j++) {
				System.out.print(arr1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("== 2�д� ==");
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	public void practice9() {
		String[][] arr1 = {{"���ǰ�", "������"} , {"�����", "�����"} , {"���̹�", "�ں���"}};
		String[][] arr2 = {{"�ۼ���", "������"} , {"������" , "��õ��"} , {"��ǳǥ", "ȫ����"}};
		
		System.out.println("== 1�д� ==");
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr1[i].length; j++) {
				System.out.print(arr1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("== 2�д� ==");
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("================================");
		System.out.print("�˻��� �л� �̸��� �Է��ϼ��� : ");
		String name = sc.next();
		
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr1[i].length; j++) {
				if(arr1[i][j].equals(name)) {

					if(j==0) {
						System.out.println("�˻��Ͻ� "+name+ "�л��� 1�д� " +(i+1)+ " ��° �� "+ "���ʿ� �ֽ��ϴ�.");
					}
					else {
						System.out.println("�˻��Ͻ� "+name+ "�л��� 1�д� " +(i+1)+ " ��° �� "+ "�����ʿ� �ֽ��ϴ�.");
					}
				}
			}
		}
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				if(arr2[i][j].equals(name)) {
					
					if(j==0) {
						System.out.println("�˻��Ͻ� "+name+ "�л��� 2�д� " +(i+1)+ " ��° �� " + "���ʿ� �ֽ��ϴ�.");
					}
					else {
						System.out.println("�˻��Ͻ� "+name+ "�л��� 2�д� " +(i+1)+ " ��° �� " + "�����ʿ� �ֽ��ϴ�.");
					}
				}
			}
		}
	}
	
	public void practice10() {
		String[][] arr = new String[6][6];
		System.out.print("�� �ε��� �Է� : ");
		int row = sc.nextInt();
		System.out.print("�� �ε��� �Է� : ");
		int col = sc.nextInt();
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(i==0) {
					switch(j) {
						case 0 : arr[i][j] = "";
						break;
						case 1 : arr[i][j] ="0";
						break;
						case 2 : arr[i][j] ="1";
						break;
						case 3 : arr[i][j] ="2";
						break;
						case 4 : arr[i][j] ="3";
						break;
						case 5 : arr[i][j] ="4";
						break;
					}
				}
				else if(j==0) {
					switch(i) {
						case 0 : arr[i][j] = "";
						break;
						case 1 : arr[i][j] = "0";
						break;
						case 2 : arr[i][j] = "1";
						break;
						case 3 : arr[i][j] = "2";
						break;
						case 4 : arr[i][j] = "3";
						break;
						case 5 : arr[i][j] = "4";
					}
				}
				else if(i==row && j==col) {
					arr[i][j] = "X";
				}
				else { 
					arr[i][j] = "";
				}
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void practice11() {
		String[][] arr = new String[6][6];
		int row;
		int col;
		while(true) {
		System.out.print("�� �ε��� �Է� : ");
		row = sc.nextInt(); 
		if(row == 99) {
			System.out.println("���α׷� ����");
			break;
		}
		System.out.print("�� �ε��� �Է� : ");
		col = sc.nextInt();
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(i==0) {
					switch(j) {
						case 0 : arr[i][j] = "";
						break;
						case 1 : arr[i][j] ="0";
						break;
						case 2 : arr[i][j] ="1";
						break;
						case 3 : arr[i][j] ="2";
						break;
						case 4 : arr[i][j] ="3";
						break;
						case 5 : arr[i][j] ="4";
						break;
					}
				}
				else if(j==0) {
					switch(i) {
						case 0 : arr[i][j] = "";
						break;
						case 1 : arr[i][j] = "0";
						break;
						case 2 : arr[i][j] = "1";
						break;
						case 3 : arr[i][j] = "2";
						break;
						case 4 : arr[i][j] = "3";
						break;
						case 5 : arr[i][j] = "4";
					}
				}
				else if(i==row && j==col) {
					arr[i][j] = "X";
				}
				else { 
					if(arr[i][j]=="X"){
						arr[i][j] ="X";
					}
					else {
						arr[i][j] = "";
					}
				}
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		}
	}
}
