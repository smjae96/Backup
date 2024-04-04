package com.kh.array;

import java.util.Arrays;

/*
 * �迭 (2���� �迭)
 * : �ڷ����� ���� 1���� �迭�� ����
 * 	 �迭 �ȿ� �迭�� ����
 * 	 �ε��� ( 2 )�� �ʿ�. **(�ε��� ���۹�ȣ: 0)**
 * 
 * - ���� ���
 * 
 * 			�ڷ���[][] ����������;
 * 
 * - �Ҵ�(����)
 * 
 * 			���������� = new �ڷ���[��ũ��(2�����迭����)][��ũ��(1�����迭����)];
 * 
 * 			* ���������� �迭 �Ҵ�: �� ũ�⸦ �������� �ʰ�, �� �ٸ� ������ 1���� �迭�� ����
 * 				���������� = new �ڷ���[��ũ��(2�����迭����)][];
 * 
 * - ���� ����
 * 			
 * 			����������[�� �ε���] = {��1, ��2, ��3}; // �� �ε��� ��ġ�� �ִ� 1���� �迭�� ����
 * 			����������[�� �ε���][�� �ε���] = ��;
 * 
 * - ���� ����
 * 			
 * 			����������[�� �ε���];				// �� �ε��� ��ġ�� �迭�� ����(����)
 * 											// �迭 ����: ����������[�� �ε���].length
 * 											// �迭 ������ Ȯ��: Arrays.toString(����������[�� �ε���]);
 * 			
 * 			����������[�� �ε���][�� �ε���];		// �� �ε���, �� �ε��� ��ġ�� ������ ����
 * 
 * - �迭 �ʱ�ȭ
 * 		
 * 			�ڷ���[][] ���������� = { 1���� �迭1, 1���� �迭2, 1���� �迭3, ...};
 * 							 = { {��1, ��2, ��3}, {��4, ��5, ��6}, ...};
 * 
 * 			����������[0] = {��1, ��2, ��3};
 * 			����������[1] = {��4, ��5, ��6};		// ��5 ����: ����������[1][1]
 * 			����������[n-1] = {��a, ��b, ��c};
 * 
 * 	
 * 
 */
public class B_Dimension {

	public static void main(String[] args) {
		
		// ���ڿ� 2���� �迭 ���� �� �Ҵ�
		// [�ʱⰪ]
		/*{
			{"������", "���ʱ�", "������"},
			{"�ڹο�", "�ּ���", "������"},
			{"����ö", "�赿��", "������"}
		  }
		 */
		String[][] arr = {
				{"������", "���ʱ�", "������"},
				{"�ڹο�", "�ּ���", "������"},
				{"����ö", "�赿��", "������"}
  			};
		// ��� : �ݺ��� �� �� �ʿ�? �ε��� ������ŭ.. 2��
		/*
		 * foreach ��
		 * 				for(�ڷ��� ������:�迭��) { // ���������� ������ ���� ����! }
		 * 				 �� �� �������� �� ����� ���ϸ� �ȴ�.	
		 */
			int index =0; // ���� for�� ����� ��� ���� ǥ�����ֱ� ���� index ���� ���� �� �ʱ�ȭ
			for( String[] names : arr) {
				System.out.print((++index) + "�� : ");
				for(String name : names) {
					System.out.print(name + " ");
				}
				System.out.println();
			}
			
//			for(int i=0; i<arr.length; i++) {
//				System.out.print(i+1 + "��: ");
//				for(int j=0; j<arr[i].length; j++) {
//					System.out.print(arr[i][j] + " ");
//				}
//				System.out.println();
//			}
		/*
		 * 1�� : ������ ���ʱ� ������
		 * 2�� : �ڹο� �ּ��� ������
		 * 3�� : ����ö �赿�� ������
		 */
		
		// �� ������ �������� ���� �� �ٽ� ���
		for(int i=0; i<arr.length; i++) {
			Arrays.sort(arr[i]);
		}
		System.out.println("-----------------------------");
		for(int i=0; i<arr.length; i++) {
			System.out.print(i+1 + "�� : ");
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		
/*		index =0;
		for( String[] names : arr) {
			System.out.print((++index) + "�� : ");
			for(String name : names) {
				System.out.print(name + " ");
			}
			System.out.println();
		}
*/		
			

	
		
		
		
	}

}