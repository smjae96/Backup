package com.kh.practice.chap02;

public class ControlPractice2 {
	public static void main(String[] args) {
		//gugudan();
		//breaker();
		continue1();
	}
	
	public static void gugudan() {
		// �ٱ��� for�� : X��
		// ���� for��  : �������� ��
		// for(�ʱ��;���ǽ�;������) {}
//		for(int i=2; i<10; i++) {
//			// i : 2, 3, 4, ..., 9 - 2�ܺ��� 9��
//			for(int j=1; j<10; j++) {
//				// j : 1, 2, 3, ..., 9 - �������� ��
//				System.out.printf("%d x %d = %d\n" , i, j, (i*j));
//			}
//			System.out.println();
//		}
		
		//���η� ������ ����ϱ�
		for(int i=1; i<10; i++) { // �ٱ��� for��: �������� ��
			for(int j=2; j<10; j++) { // ���� for��: x��
				System.out.printf("%d x %d = %d \t",j,i,j*i);
				//System.out.printf("%d x %d = %2d", j,i,j*i); // %2d�ϸ� ��¦ ���� �����.
				//System.out.print(j+" x "+ i + " = " + j*i);
				//System.out.print("\t");
			}
			System.out.println();
		}
	}
	public static void breaker() {
		for(int i=1; ; i++) {
			System.out.println(i + "���");
			if(i>=10) {
				break;
			}
		}
	}
	public static void continue1() {
		for(int i=1; i<=10; i++) {
			if(i%2==0) {
				continue;
			}
			System.out.println(i + "���");
		}
	}
}
