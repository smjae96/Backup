package com.kh.practice.chap01_poly.view;

import java.util.Scanner;

import com.kh.practice.chap01_poly.controller.LibraryController;
import com.kh.practice.chap01_poly.model.vo.Book;
import com.kh.practice.chap01_poly.model.vo.Member;

public class LibraryMenu {
	private LibraryController lc = new LibraryController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		System.out.print("�̸� : ");
		String name = sc.next();
		
		System.out.print("���� : ");
		int age = sc.nextInt();
		
		System.out.print("���� : ");
		char gender = sc.next().charAt(0);
		
		Member m = new Member(name, age, gender);
		// LibrarayController �� insertMember() �޼ҵ��
		// ������ Member ��ü�� ����
		lc.insertMember(m); 
		
		// ----------------------------------------------
		// ���ѹݺ�
		//  - while(true) {}
		//	- do {   } while(true);
		//  - for(; ;) {}
		
		while(true) {
			
			System.out.println("===== �޴� =====");
			System.out.println("1. ����������");
			System.out.println("2. ���� ��ü ��ȸ");	
			System.out.println("3. ���� �˻�");	// ��� ����...
			System.out.println("4. ���� �뿩�ϱ�");
			System.out.println("9. ���α׷� �����ϱ�");
			
			System.out.print("�޴� ��ȣ : ");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				System.out.println(lc.myInfo().toString());	
				break;
			case 2:
				selectAll();
				break;
			case 3:
				searchBook();
				break;
			case 4:
				rentBook();
				break;
			case 9:
				return;
			}
		}

	}
	
	public void selectAll() {
		// LibraryController Ŭ������ selectAll �޼ҵ� ȣ�� ��
		// Book ��ü�迭�� ���޹޾� bList�� ����
		Book[] bList = lc.selectAll();
		
		// �ش� ��ü�迭�� ó�� ��ġ����(0) �迭�� ���̸�ŭ �ݺ����� ����
		for(int i=0; i<bList.length; i++) {
			// ���� ��� ������ ���
			// ex) 0������ : �������� ���� / ������ / tvN / true
			System.out.printf("%d������ : %s \n", i, bList[i].toString());
		}
	}
	
	public void searchBook() {
		System.out.print("�˻��� ���� Ű����: ");
		String keyword = sc.next();
		Book[] b1 = lc.searchBook(keyword);
		for(int i=0; i<b1.length; i++) {
			if(b1[i] != null) {
				System.out.println(b1[i].toString());
			} // ���� if���� ���ָ� nullpointerException ���� ��� ����.
		}
	}
	
	public void rentBook() {
		selectAll();		// selectAll �޼ҵ� ȣ��
		
		System.out.print("�뿩�� ���� ��ȣ ���� : ");
		int index = sc.nextInt();
		
		// LibrarayController Ŭ������ rentBook �޼ҵ�� �ε��� ������ ����(ȣ��)
		int result = lc.rentBook(index); // �� ��� ���� result�� �ް�
		
		switch(result) {
		case 0:
			System.out.println("���������� �뿩�Ǿ����ϴ�.");
			break;
		case 1:
			System.out.println("���� �������� �뿩 �Ұ����Դϴ�.");
			break;
		case 2:
			System.out.println("���������� �뿩�Ǿ����ϴ�. "
					+ "�丮�п� ������ �߱޵Ǿ����� �������������� Ȯ���ϼ���.");
			break;
		}
		
	}
	
	
}
