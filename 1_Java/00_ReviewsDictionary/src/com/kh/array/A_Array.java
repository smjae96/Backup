package com.kh.array;

import java.util.Arrays;

public class A_Array {
	/*
	 * �迭 (1���� �迭)
	 * : "���� �ڷ���"�� "���� ���� ������"�� �����ϴ� ����
	 * 
	 * - ���� ���
	 * 
	 * 		�ڷ���[] ����������;		// ��ȣ�ϴ� ���!
	 * 		�ڷ��� ����������[];
	 * 
	 * - �Ҵ�(����) ���
	 * 
	 * 		���������� = new �ڷ���[�迭 ����];
	 * 
	 * - ���� ����/����
	 * 
	 * 		* ���� : ����������[�ε���] = ��;	// �ε���: ��ġ�� �ǹ�. 0���� ����!**
	 * 		* ���� : ����������[�ε���]
	 * 
	 *  - �迭 �ʱ�ȭ(���� ���ʷ� ����)
	 *  
	 *  	* �ڷ���[] ���������� = new ����������[�迭����];
	 *  	  ����������[0] = ��1;
	 *  	  ����������[1] = ��2;
	 *  
	 *  	* �ڷ���[] ���������� = new ����������[]{��1, ��2, ��3};
	 *  	
	 *  	* �ڷ���[] ���������� = {��1, ��2, ��3};
	 *  
	 *  - �迭 ����
	 *  
	 *  	* ���� ����: �迭�� �ּ� ���� �����Ͽ� ���� �����Ͱ� �� ������ ����
	 *  			
	 *  				[������ �迭] = [���� �迭��];
	 *  			ex) int[] org = new int[3];		// ������ �迭�� �ʱⰪ�� 0
	 *  				int[] copy = org;			// ���� ����
	 *  				copy[0] = 10;
	 *  				System.out.println(org[0]); // ��� : 10
	 *  	
	 *  	* ���� ����: ���ο� �迭 ��ü�� �����ؼ� ���� �迭�� �����͸� ����
	 *  			
	 *  				* �迭A: ���� �迭, �迭B: ������ �迭
	 *  				-�ݺ��� ���
	 *  				for(int i=0; i<�迭����; i++) {
	 *  					// i: 0, 1, 2, ..., �迭����-1
	 *  					�迭B[i] = �迭A[i];	// �迭A�� i��° ��ġ�� �����͸�
	 *  										// �迭B�� i��° ��ġ�� ����(����)
	 *  				}
	 *  			
	 *  				- clone() ���
	 *  					�迭B = �迭A.clone();
	 *  
	 *  				- Arrays.copyOf() ���
	 *  					�迭B = Arrays.copyOf(�迭A, ������ ������ ����); 
	 *  								// ������ ������ ���� �ڸ����� ���� �迭A�� ���̸�ŭ ���Ƿ� �迭A.length ����ϴ� ��찡 ����.
	 *  
	 *  				- System.arraycopy() ���
	 *  					System.arraycopy(�迭A, �迭A ������ ���� ��ġ(0), �迭B, �迭B ������ ���� ��ġ(0), ������ ������ ����);
	 *  
	 *   - �ݺ��� foreach��(���� for��)
	 *   	* �Ϲ����� for�� : for(�ʱ��; ���ǽ�; ������) {}
	 *   	* foreach��	  
	 *   					 for(�ڷ��� ������:�迭��) {
	 *							 // ������ : �迭�� ù��° ��ġ�� �����ͺ��� ������ ��ġ�� �����͸� ����� �� �ִ�.
	 *						 }			    
	 *
	 *						 ex) int[] arr = {10, 20, 30};
	 *							 for(int item : arr) {
	 *								System.out.print(item + " ");
	 *							 }
	 *							 // ���: 10 20 30	
	 *
	 *  
	 */
	public static void main(String[] args) {
		
		
		// �ڵ� ���� : ctrl + shift + f
		
		// foreach�� ����Ͽ� �迭�� ù��° �����ͺ��� ������ �����ͱ��� ���
		int[] arr = { 10, 20, 30 };
		for (int item : arr) {
			System.out.print(item + " ");
		}
		System.out.println();
		System.out.println("================================================");
		
		// �迭 ����
		int[] a = { 1, 3, 5, 7};
		int[] b = new int[a.length];
		
		System.out.println("a �迭�� �ּ�: " +a + ", b �迭�� �ּ�: " +b);
		// -���� ����
		b= a;
		System.out.println("���� ���� �� �ּ�");
		System.out.println("a �迭�� �ּ�: " +a + ", b �迭�� �ּ�: " +b);
		System.out.println("b �迭�� ������: " + Arrays.toString(b));
		
		// a �迭�� 3��° ��ġ�� ���� 10�� ���ϱ�
		a[2] = a[2] + 10;					// Q. ���� ���Կ����ڸ� ����ϸ�? a[2] += 10;
		System.out.println("a �迭�� ������: " + Arrays.toString(a));
		System.out.println("b �迭�� ������: " + Arrays.toString(b));
		
		// - ���� ����
		int[] c = new int[a.length];
		// [1] �ݺ���
		System.out.println("a �迭�� �ּ�: " +a + ", c �迭�� �ּ�: " +c);
		
		for(int i=0; i<c.length; i++) {
			c[i] = a[i];
		}
		System.out.println("�ݺ������� ���� ���� �� �ּ�");
		System.out.println("a �迭�� �ּ�: " +a + ", c �迭�� �ּ�: " +c);
		System.out.println("a �迭�� ������: " + Arrays.toString(a));
		System.out.println("c �迭�� ������: " + Arrays.toString(c));
		
		c[1] = c[1]-10;		//Q. ���� ���Կ����� ����ϸ�? c[1] -= 10;
		System.out.println("a[1] : " +a[1]);	// ��� ? 3	
		System.out.println("c[1] : " +c[1]);	// ��� ? 3 - 10 = -7
		
		// [2] clone() ���
		int[] d = new int[a.length];
		System.out.println("[���� ��] a �迭�� �ּ�: " +a + ", d �迭�� �ּ�: " +d);
		d = a.clone();
		System.out.println("[���� ��] a �迭�� �ּ�: " +a + ", d �迭�� �ּ�: " +d);
		a[0] = 9;
		
		System.out.println("a �迭�� ������: " +Arrays.toString(a));
		System.out.println("d �迭�� ������: " +Arrays.toString(d));
		
		// [3] Arrays.copyOf ���
		int[] e = new int[a.length];
		System.out.println("[���� ��] a �迭�� �ּ�: " +a + ", e �迭�� �ּ�: " +e);
		e = Arrays.copyOf(a, a.length);
		System.out.println("[���� ��] a �迭�� �ּ�: " +a + ", e �迭�� �ּ�: " +e);
		
		e[0] = e[0] * 2;			// Q.���� ���Կ����� ���? e[0] *= 2;
		System.out.println("a �迭�� ������: " +Arrays.toString(a));
		System.out.println("e �迭�� ������: " +Arrays.toString(e));
		
		// [4] System.arraycopy() ��� 			// ������ �Ŀ��� �ּҰ� �ٲ��� ����. ���� ��ü�� �������� �ʴ´�.
		int[] f = new int[a.length];
		System.out.println("[���� ��] a �迭�� �ּ�: " +a + ", f �迭�� �ּ�: " +f);
		System.arraycopy(a, 0, f, 0, a.length); // a �迭�� ù��° ��ġ���� a �迭 ���̸�ŭ
												// f �迭�� ù��° ��ġ���� ����
		System.out.println("[���� ��] a �迭�� �ּ�: " +a + ", f �迭�� �ּ�: " +f);
		
		System.out.println("a �迭�� ������: " +Arrays.toString(a));
		System.out.println("f �迭�� ������: " +Arrays.toString(f));
		
	}

}
