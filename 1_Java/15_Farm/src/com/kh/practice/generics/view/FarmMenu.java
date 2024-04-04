package com.kh.practice.generics.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.kh.practice.generics.controller.FarmController;
import com.kh.practice.generics.model.vo.Farm;
import com.kh.practice.generics.model.vo.Fruit;
import com.kh.practice.generics.model.vo.Nut;
import com.kh.practice.generics.model.vo.Vegetable;

public class FarmMenu {
	private Scanner sc = new Scanner(System.in);
	private FarmController fc = new FarmController();
	
	public void mainMenu() {
		System.out.println("========== KH ��Ʈ ==========");
		while(true) {
			System.out.println("******* ���� �޴� *******");
			System.out.println("1. �����޴�");
			System.out.println("2. �մ� �޴�");
			System.out.println("9. ����");
			System.out.print("�޴� ��ȣ ���� : ");
			int num = sc.nextInt();
			if(num==1) {
				adminMenu();
			} else if(num==2) {
				customerMenu();
			} else if(num==9) {
				System.out.println("���α׷� ����");
				return;
			} else {
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
			}
		}	
	}
	
	public void adminMenu() {
		while(true) {
			System.out.println("******* ���� �޴� *******");
			System.out.println("1. �� ��깰 �߰�");
			System.out.println("2. ���� ����");
			System.out.println("3. ���� ����");
			System.out.println("4. ��깰 ���");
			System.out.println("9. �������� ���ư���");
			System.out.print("�޴� ��ȣ ���� : ");
			int num = sc.nextInt();
			if(num ==1) {
				addNewKind();
			} else if(num ==2) {
				removeKind();
			} else if(num==3) {
				changeAmount();
			} else if(num==4) {
				printFarm();
			} else if(num==9) {
				return;	// mainMenu()�� ȣ���ϸ� �� ��ġ���� ���߰� mainMenu()�� �����Ѵ�. 
						// �̷��� �Ǹ� maimMenu()���� ���α׷� ���Ḧ ������ ��� Run Ŭ������ �ִ� mainMenu()�� ���� �� �ƴ϶� 
						// �ٽ� adminMenu()�� ���ƿ��� �ȴ�. 
						// ���� �׳� adminMenu()�� ���������� return�� ����.
			} else {
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
			}
		}	
	}
	
	public void customerMenu() {
		printFarm();
		while(true) {
			System.out.println("******* �� �޴� *******");
			System.out.println("1. ��깰 ���");
			System.out.println("2. ��깰 ����");
			System.out.println("3. ������ ��깰 ����");
			System.out.println("9. �������� ���ư���");
			System.out.print("�޴� ��ȣ ���� : ");
			int num = sc.nextInt();
			if(num==1) {
				buyFarm();
			} else if(num==2) {
				removeFarm();
			} else if(num==3) {
				printBuyFarm();
			} else if(num==9) {
				return;
			} else {
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	public void addNewKind() {
		System.out.println("1. ���� / 2. ä�� / 3. �߰�");
		System.out.print("�߰��� ���� ��ȣ : ");
		int num = sc.nextInt();
		String kind = null;
		System.out.print("�̸� : ");
		String name = sc.next();
		System.out.print("���� : ");
		int amount = sc.nextInt();
		if(num == 1) {
			kind = "����";
			if(fc.addNewKind(new Fruit(kind, name), amount)) {
				System.out.println("�� ��깰�� �߰��Ǿ����ϴ�.");
			} else {
				System.out.println("�� ��깰 �߰��� �����Ͽ����ϴ�. �ٽ� �Է����ּ���.");
				addNewKind();
			}
			
		} else if(num == 2) {
			kind = "ä��";
			if(fc.addNewKind(new Vegetable(kind, name), amount)) {
				System.out.println("�� ��깰�� �߰��Ǿ����ϴ�.");
			} else {
				System.out.println("�� ��깰 �߰��� �����Ͽ����ϴ�. �ٽ� �Է����ּ���.");
				addNewKind();
			}
		} else if(num == 3) {
			kind = "�߰�";
			if(fc.addNewKind(new Nut(kind, name), amount)) {
				System.out.println("�� ��깰�� �߰��Ǿ����ϴ�.");
			} else {
				System.out.println("�� ��깰 �߰��� �����Ͽ����ϴ�. �ٽ� �Է����ּ���.");
				addNewKind();
			}
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			addNewKind();
		}
		
	}
	
	public void removeKind() {
		System.out.println("1. ���� / 2. ä�� / 3. �߰�");
		System.out.print("������ ���� ��ȣ : ");
		int num = sc.nextInt();
		String kind = null;
		System.out.print("�̸� : ");
		String name = sc.next();
		if(num == 1) {
			kind = "����";
			if(fc.removeKind(new Fruit(kind, name))) {
				System.out.println("��깰 ������ �����Ͽ����ϴ�.");
			} else {
				System.out.println("��깰 ������ �����Ͽ����ϴ�. �ٽ� �Է����ּ���.");
				removeKind();
			}
			
		} else if(num == 2) {
			kind = "ä��";
			if(fc.removeKind(new Vegetable(kind, name))){
				System.out.println("��깰 ������ �����Ͽ����ϴ�.");
			} else {
				System.out.println("��깰 ������ �����Ͽ����ϴ�. �ٽ� �Է����ּ���.");
				removeKind();
			}
		} else if(num == 3) {
			kind = "�߰�";
			if(fc.removeKind(new Nut(kind, name))){
				System.out.println("��깰 ������ �����Ͽ����ϴ�.");
			} else {
				System.out.println("��깰 ������ �����Ͽ����ϴ�. �ٽ� �Է����ּ���.");
				removeKind();
			}
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			removeKind();
		}
		
	}
	
	public void changeAmount() {
		System.out.println("1.���� / 2. ä�� / 3. �߰�");
		System.out.print("������ ���� ��ȣ : ");
		int num = sc.nextInt();
		String kind = null;
		System.out.print("�̸� : ");
		String name = sc.next();
		System.out.print("���� : ");
		int amount = sc.nextInt();
//		if(num==1) {
//			kind = "����";
//			if(fc.changeAmount(new Fruit(kind, name), amount)) {
//				System.out.println("��깰 ������ �����Ǿ����ϴ�.");
//			} else {
//				System.out.println("��깰 ���� ������ �����Ͽ����ϴ�. �ٽ� �Է����ּ���.");
//				changeAmount();
//			}
//		} else if(num==2) {
//			kind = "ä��";
//			if(fc.changeAmount(new Vegetable(kind, name), amount)) {
//				System.out.println("��깰 ������ �����Ǿ����ϴ�.");
//			} else {
//				System.out.println("��깰 ���� ������ �����Ͽ����ϴ�. �ٽ� �Է����ּ���.");
//				changeAmount();
//			}
//		} else if(num==3) {
//			kind = "�߰�";
//			if(fc.changeAmount(new Nut(kind, name), amount)) {
//				System.out.println("��깰 ������ �����Ǿ����ϴ�.");
//			} else {
//				System.out.println("��깰 ���� ������ �����Ͽ����ϴ�. �ٽ� �Է����ּ���.");
//				changeAmount();
//			}
//		}
		
		Farm f = null;
		if(num==1)  {
			kind = "����";
			f = new Fruit(kind,name);
		} else if(num==2) {
			kind = "ä��";
			f = new Vegetable(kind,name);
		} else if(num==3){
			kind = "�߰�";
			f = new Nut(kind,name);
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			changeAmount();
		}
		
		if(fc.changeAmount(f, amount)) {
			System.out.println("��깰 ������ �����Ǿ����ϴ�.");
		} else {
			System.out.println("��깰 ���� ������ �����Ͽ����ϴ�. �ٽ� �Է����ּ���.");
			changeAmount();
		}
	}
	
	public void printFarm() {
		System.out.println("���� KH��Ʈ ��깰 ����");
		HashMap<Farm,Integer> hm = fc.printFarm();
		Set<Farm> set = hm.keySet();
		Iterator<Farm> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			Farm f = iterator.next();
			System.out.println(f + "("+hm.get(f)+"��)");		// f: key��- ��깰 ����, hm.get(f): value�� - ��깰 ����
															// f�� Fruit, Vegetable, Nut Ŭ�������� toString()�޼ҵ尡 ������
															// �Ǿ� �����Ƿ� �� ���Ŀ� ���缭 ��µ�. 
		}
	}
	
	public void buyFarm() {
		System.out.println("1.���� / 2. ä�� / 3. �߰�");
		System.out.print("���� ���� ��ȣ : ");
		int num = sc.nextInt();
		System.out.print("������ �� : ");
		String name = sc.next();
		String kind = null;
		Farm f = null;
		if(num==1)  {
			kind = "����";
			f = new Fruit(kind,name);
		} else if(num==2) {
			kind = "ä��";
			f = new Vegetable(kind,name);
		} else if(num==3){
			kind = "�߰�";
			f = new Nut(kind,name);
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			buyFarm();
		}
		
		if(fc.buyFarm(f)) {
			System.out.println("���ſ� �����Ͽ����ϴ�.");
			printFarm();
		} else {
			System.out.println("��Ʈ�� ���� �����̰ų� ������ �����ϴ�. �ٽ� �Է����ּ���.");
			buyFarm();
		}
	}
	
	public void removeFarm() {
		System.out.println("1.���� / 2. ä�� / 3. �߰�");
		System.out.print("��� ���� ��ȣ : ");
		int num = sc.nextInt();
		System.out.print("���� ����� �� : ");
		String name = sc.next();
		String kind = null;
		Farm f = null;
		if(num==1)  {
			kind = "����";
			f = new Fruit(kind,name);
		} else if(num==2) {
			kind = "ä��";
			f = new Vegetable(kind,name);
		} else if(num==3){
			kind = "�߰�";
			f = new Nut(kind,name);
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			removeFarm();
		}
		
		if(fc.removeFarm(f)) {
			System.out.println("���� ��ҿ� �����ϼ̽��ϴ�.");
			printFarm();
		} else {
			System.out.println("���� ����� �������� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
			removeFarm();
		}
	}
	
	public void printBuyFarm() {
		ArrayList<Farm> al = fc.printBuyFarm();
		Iterator<Farm> iterator = al.iterator();
		while(iterator.hasNext()) {
			Farm f = iterator.next();
			System.out.println(f);
		}
		printFarm();
		
	}
}
