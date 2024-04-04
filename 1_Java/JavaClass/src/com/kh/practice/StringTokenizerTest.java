package com.kh.practice;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
		// key : name, phone, address, email
		//	- key�� �ش��ϴ� ���� value�� �ش��ϴ� ���� (:)�� ����
		//	- �� ������ (,)�� ����
		String data = "name: Hong, phone:010-1234-5678, address: gangnam, email: hong12@gmail.com";
//		
//		// StringTokenizer �� ����Ͽ� �Ʒ� ������ ���
//		// �̸��� Hong�̰�, ����ó�� 010-1234-5678�̰�, �ּҴ� gangnam�̰�, �̸����� hong12@gmail.com�Դϴ�.
//		//		%s					%s					%s					%s
//		String[] dataArr = new String[8];
//		int index =0;
//		
//		// (1) (,)�� �����Ͽ� ��ūȭ
//		StringTokenizer st = new StringTokenizer(data, ",");
//		
//		while (st.hasMoreTokens()) {
//			String keyValue = st.nextToken();		// , �������� ��ūȭ�Ͽ� ���ڿ��� ����
//			System.out.println(keyValue);
//			
//			
//			// (2) (:)���� �����Ͽ� ��ūȭ
//			StringTokenizer st2 = new StringTokenizer(keyValue, ":");
//			
//			while(st2.hasMoreTokens()) {
//				dataArr[index++] = st2.nextToken();
//			}
//		}
//		// �̸��� Hong�̰�, ����ó�� 010-1234-5678, �ּҴ� gangnam�̰�, �̸����� hong12@gmail.com�Դϴ�.
//		System.out.printf("�̸��� %s�̰�, ����ó�� %s�̰�, �ּҴ� %s�̰�, �̸����� %s�Դϴ�.",
//								dataArr[1], dataArr[3], dataArr[5], dataArr[7]);
		
		
		
		
		
		
		
		
		
	// �� Ǯ��(�ϼ� �ȵ�!)	
		
		String[] arr = new String[4];
		int i = 0;
		
		StringTokenizer st = new StringTokenizer(data, ",");
		
		while(st.hasMoreTokens()) {
			arr[i] = st.nextToken();
		//	System.out.println(arr[i]);
			i++;
		}
		int index = 0;
		String[] arrJ = new String[8];
		for(int j=0; j<arr.length; j++) {
			String dataJ = arr[j];
			StringTokenizer st2 = new StringTokenizer(dataJ, ":");
			while(st2.hasMoreTokens()) {
				
				arrJ[index++] = st2.nextToken();
			}
		}
		System.out.printf("�̸��� %s�̰�, ����ó�� %s�̰�, �ּҴ� %s�̰�, �̸����� %s�Դϴ�.",
				arrJ[1], arrJ[3], arrJ[5], arrJ[7]);
		
		
//		String data0 = arr[0];
//		st = new StringTokenizer(data0, ":");
//		while(st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
//		}
		
		
	}
	
	
	public void test() {
		// StringTokenizer : ���ڿ� ���� Ư�� �����ڷ� �����ִ� Ŭ����(��ūȭ)
		
		String msg = "�ȳ��ϼ���|���´����Դϴ�|�ݰ����ϴ�"; // Ư�� ������ : |
		
		String[] arr = new String[3];
		int i = 0;
		
		StringTokenizer st = new StringTokenizer(msg, "|");	// ��ΰ� java.util�̹Ƿ� import �ʿ�
		
		// ������.hasMoreTokens() : �����ڸ� ���� ��ūȭ �� �� �ִ� �� Ȯ���ϴ� �޼ҵ�
		//						  true/false : true(��ūȭ ����) false(��ūȭ �Ұ�)
		
		while(st.hasMoreTokens()) { // ��ūȭ�� �����ϴٸ� ��� �ݺ����� �����Ѵ�.
			
			// ������.nextToken(): ������ �������� ���� �и��ؼ� ��ȯ�ϴ� �޼ҵ�
			// 					 ���� ��ȯ�ϰ� ���� ������ ��ġ�� �̵�
			//System.out.println(st.nextToken());
			arr[i] = st.nextToken();
			System.out.println(arr[i]);
			i++;
			
		}
		
	}

}
