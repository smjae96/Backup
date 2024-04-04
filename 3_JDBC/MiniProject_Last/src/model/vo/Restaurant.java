package model.vo;

import java.util.ArrayList;
import java.util.Scanner;

import model.vo.food.*;

public class Restaurant {
	private ArrayList<Food> menu;
	
	public Restaurant(ArrayList<Food> menu) {
		this.menu = menu;
	}
	
	public Food selectMenu(int choice) {
	//	Scanner sc = new Scanner(System.in);
		while(true) {
//			System.out.print("메뉴 번호를 선택하세요 : ");
//			choice = sc.nextInt();
			if(choice>=1 && choice<= menu.size()) {
				System.out.println("메뉴를 추가하였습니다.");
				return menu.get(choice-1);
			} else {
				System.out.println("유효하지 않은 메뉴 번호입니다. 다시 선택하세요.");
			}
		}
	}
}
