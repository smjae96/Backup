package com.kh.loop;

/*
 * �ݺ��� while
 * 
 * - ǥ����
 * 
 * 			[�ʱ��]
 * 			while(���ǽ�) {
 * 				// �ݺ������� ������ �ڵ�
 * 				[������] 
 * 			}	
 * 
 * - ���� �帧
 * 			���ǽ� -> ���ǽ��� ��(true)�� ��� -> �ݺ������� ������ �ڵ� 
 * 		->	���ǽ� -> ���ǽ��� ��(true)�� ��� -> �ݺ������� ������ �ڵ�
 * 		-> 	���ǽ� -> ���ǽ��� ����(false)�� ��� -> �ݺ��� ���� 
 * 
 * - do~while��
 * 
 * 	* ǥ����
 *				[�ʱ��]
 * 				do {
 * 					// �ݺ������� ������ �ڵ�
 * 					[������]
 * 				} while(���ǽ�);
 * 
 * 	* ���� �帧 : 									�ݺ������� ������ �ڵ� ���� 
 * 			->	���ǽ� -> ���ǽ��� ��(true)�� ��� -> �ݺ������� ������ �ڵ� ����
 * 			-> 	���ǽ� -> ���ǽ��� ��(true)�� ��� -> �ݺ������� ������ �ڵ� ����
 * 			-> 	���ǽ� -> ���ǽ��� ����(false)�� ��� -> �ݺ��� ����
 *
 */
public class B_While {

	public static void main(String[] args) {
		
		int num = 1;
		while (num == 0) {
			System.out.println(num);
		}
		// ��� : ��µǴ� ���� ����.
		
		do {
			System.out.println(num);
		}while(num ==0);
		// ��� : 1
		
		int sel = 9;
		do {
			System.out.println("1) ¦�� �Է�");
			System.out.println("2) Ȧ�� �Է�");
			System.out.println("9) ����");
			
			// Scanner.. �Է¹���
			
			if(sel != 1 && sel != 2 && sel !=9) {
				System.out.println("�Է��� �޴��� �����ϴ�. �ٽ� �Է��Ͻÿ�.");
				//break;		// �ݺ��� ����
				continue;		// �Ʒ� �ڵ带 �������� �ʰ�, ó������ �ٽ� �ݺ�
			}
			
			// .... 1�Է� �� ¦���̴�. 2�Է� �� Ȧ���̴�....
		} while(sel != 9);
	
		
		do {
			if(sel == 9) {
				break;		//sel�� ���� 9�� ��� �ݺ��� ����
			}
		}while(true);
		
		String num1 = "10";
		String num2 = "10";
		System.out.println(num1.hashCode());
		System.out.println(num2.hashCode());
		
		num1 = "100";
		System.out.println(num1.hashCode());
		
		num1 = "10";
		System.out.println(num1.hashCode());
		
		int[] arr = new int[3];
		int[] arr2 = new int[3];
		
		System.out.println(arr);
		System.out.println(arr2);
		System.out.println(arr.hashCode());
		System.out.println(arr2.hashCode());
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
	}

}
