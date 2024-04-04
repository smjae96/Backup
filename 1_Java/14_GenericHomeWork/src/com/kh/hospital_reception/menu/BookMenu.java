package com.kh.hospital_reception.menu;

import java.util.Scanner;

import com.kh.hospital_reception.model.vo.BookManagement;

public class BookMenu {
	private Scanner sc= new Scanner(System.in);
	private BookManagement bm = new BookManagement();
	
	public void mainMenu() {
		while(true) {
			System.out.println("=== ���� �޴� ===");
			System.out.println("1. ���� ����");
			System.out.println("2. ���� �ݳ�");
			System.out.println("3. �뿩��� ��ȸ");
			System.out.println("4. �ݳ� ������ �ӹ��� ���� ���� ��ȸ");
			System.out.println("9. ���α׷� ����");
			System.out.print("�޴� ��ȣ�� �Է��ϼ��� : ");
			int num = sc.nextInt();
			if(num==1) {
				rentMenu();
			}
			else if(num==2) {
				returnMenu();
			}
			else if(num==3) {
				checkList();
			}
			else if(num==4) {
				goGet();
			}
			else if(num==9) {
				System.out.println("���α׷� ����");
				break;
			}
			else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
			}
		}	
	}
	
	public void rentMenu() {
		bm.renting();
	}
	
	public void returnMenu() {
		bm.returning();
	}
//	
	public void checkList() {
		bm.check();
		System.out.println();
	}
	public void goGet() {
		bm.get();
	}
}
