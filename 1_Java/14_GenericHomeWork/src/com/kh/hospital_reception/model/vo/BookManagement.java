package com.kh.hospital_reception.model.vo;

import java.util.Scanner;

public class BookManagement {
	StringArray2<String> strA = new StringArray2<>();
	Scanner sc = new Scanner(System.in);
	// �뿩�ϴ� �޼ҵ�
	public void renting() {
		String str = null;
		System.out.print("������ �������� �Է��ϼ��� : ");
		str = sc.next();
		strA.add(str);
//			if(st[i] == null) {
//				st[i] = book;
//			}
	}
		
	
	// �ݳ��ϴ� �޼ҵ�
	public void returning() {
		System.out.print("�ݳ��� �������� �Է��ϼ��� : ");
		String name = sc.next();
		strA.remove(name);
	}	
	
	// �뿩��� ��ȸ�ϴ� �޼ҵ�
	public void check() {
		String[] st = new String[10];
		System.out.println("===  �뿩��� ===");
		strA.print();
//		for(int i=0; i<st.length; i++) {
//			System.out.println(strA.print());
//		}
//		for(int i=0; i<strA.arr.length; i++) {
//			if(strA.arr[i] == book) {
//				
//			}
//		}
		
	}
	
	public void get() {
				System.out.println();
				System.out.println("=== �ݳ� �ؾ� �� ���� ===");
				System.out.print("å ��ȣ�� �Է��ϼ���. ��ȣ�� �������� �ݳ� ������ �ӹ��� å�Դϴ�.(1~10) : ");
				int num = sc.nextInt();
				if(strA.get(num-1)!= null) {
					System.out.println(num +"��°�� �ݳ��ϼž� �� å�� '"+strA.get(num-1)+"' �Դϴ�.");
				} else {
					System.out.println("�뿩�� ���� ���� �ʰ��� ��ȣ�Դϴ�. �ٽ� �Է��ϼ���.");
					get();
				}
				
			
			
		
		
	}
}
