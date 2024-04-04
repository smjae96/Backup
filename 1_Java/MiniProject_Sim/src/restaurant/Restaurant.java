package restaurant;

import java.util.ArrayList;
import java.util.Scanner;

import food.Food;

public class Restaurant {
	private ArrayList<Food> menu;
	
	public Restaurant(ArrayList<Food> menu) {
		this.menu = menu;
	}
	
	public Food selectMenu(int choice) {
	//	Scanner sc = new Scanner(System.in);
		while(true) {
//			System.out.print("�޴� ��ȣ�� �����ϼ��� : ");
//			choice = sc.nextInt();
			if(choice>=1 && choice<= menu.size()) {
				System.out.println("�޴��� �߰��Ͽ����ϴ�.");
				return menu.get(choice-1);
			} else {
				System.out.println("��ȿ���� ���� �޴� ��ȣ�Դϴ�. �ٽ� �����ϼ���.");
			}
		}
	}
}
