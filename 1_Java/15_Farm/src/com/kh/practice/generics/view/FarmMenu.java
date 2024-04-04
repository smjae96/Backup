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
		System.out.println("========== KH 마트 ==========");
		while(true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 직원메뉴");
			System.out.println("2. 손님 메뉴");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");
			int num = sc.nextInt();
			if(num==1) {
				adminMenu();
			} else if(num==2) {
				customerMenu();
			} else if(num==9) {
				System.out.println("프로그램 종료");
				return;
			} else {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}	
	}
	
	public void adminMenu() {
		while(true) {
			System.out.println("******* 직원 메뉴 *******");
			System.out.println("1. 새 농산물 추가");
			System.out.println("2. 종류 삭제");
			System.out.println("3. 수량 수정");
			System.out.println("4. 농산물 목록");
			System.out.println("9. 메인으로 돌아가기");
			System.out.print("메뉴 번호 선택 : ");
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
				return;	// mainMenu()를 호출하면 이 위치에서 멈추고 mainMenu()를 실행한다. 
						// 이렇게 되면 maimMenu()에서 프로그램 종료를 선택할 경우 Run 클래스에 있는 mainMenu()로 가는 게 아니라 
						// 다시 adminMenu()로 돌아오게 된다. 
						// 따라서 그냥 adminMenu()를 빠져나가는 return을 쓴다.
			} else {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}	
	}
	
	public void customerMenu() {
		printFarm();
		while(true) {
			System.out.println("******* 고객 메뉴 *******");
			System.out.println("1. 농산물 사기");
			System.out.println("2. 농산물 빼기");
			System.out.println("3. 구입한 농산물 보기");
			System.out.println("9. 메인으로 돌아가기");
			System.out.print("메뉴 번호 선택 : ");
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
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void addNewKind() {
		System.out.println("1. 과일 / 2. 채소 / 3. 견과");
		System.out.print("추가할 종류 번호 : ");
		int num = sc.nextInt();
		String kind = null;
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("수량 : ");
		int amount = sc.nextInt();
		if(num == 1) {
			kind = "과일";
			if(fc.addNewKind(new Fruit(kind, name), amount)) {
				System.out.println("새 농산물이 추가되었습니다.");
			} else {
				System.out.println("새 농산물 추가에 실패하였습니다. 다시 입력해주세요.");
				addNewKind();
			}
			
		} else if(num == 2) {
			kind = "채소";
			if(fc.addNewKind(new Vegetable(kind, name), amount)) {
				System.out.println("새 농산물이 추가되었습니다.");
			} else {
				System.out.println("새 농산물 추가에 실패하였습니다. 다시 입력해주세요.");
				addNewKind();
			}
		} else if(num == 3) {
			kind = "견과";
			if(fc.addNewKind(new Nut(kind, name), amount)) {
				System.out.println("새 농산물이 추가되었습니다.");
			} else {
				System.out.println("새 농산물 추가에 실패하였습니다. 다시 입력해주세요.");
				addNewKind();
			}
		} else {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			addNewKind();
		}
		
	}
	
	public void removeKind() {
		System.out.println("1. 과일 / 2. 채소 / 3. 견과");
		System.out.print("삭제할 종류 번호 : ");
		int num = sc.nextInt();
		String kind = null;
		System.out.print("이름 : ");
		String name = sc.next();
		if(num == 1) {
			kind = "과일";
			if(fc.removeKind(new Fruit(kind, name))) {
				System.out.println("농산물 삭제에 성공하였습니다.");
			} else {
				System.out.println("농산물 삭제에 실패하였습니다. 다시 입력해주세요.");
				removeKind();
			}
			
		} else if(num == 2) {
			kind = "채소";
			if(fc.removeKind(new Vegetable(kind, name))){
				System.out.println("농산물 삭제에 성공하였습니다.");
			} else {
				System.out.println("농산물 삭제에 실패하였습니다. 다시 입력해주세요.");
				removeKind();
			}
		} else if(num == 3) {
			kind = "견과";
			if(fc.removeKind(new Nut(kind, name))){
				System.out.println("농산물 삭제에 성공하였습니다.");
			} else {
				System.out.println("농산물 삭제에 실패하였습니다. 다시 입력해주세요.");
				removeKind();
			}
		} else {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			removeKind();
		}
		
	}
	
	public void changeAmount() {
		System.out.println("1.과일 / 2. 채소 / 3. 견과");
		System.out.print("수정할 종류 번호 : ");
		int num = sc.nextInt();
		String kind = null;
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("수량 : ");
		int amount = sc.nextInt();
//		if(num==1) {
//			kind = "과일";
//			if(fc.changeAmount(new Fruit(kind, name), amount)) {
//				System.out.println("농산물 수량이 수정되었습니다.");
//			} else {
//				System.out.println("농산물 수량 수정에 실패하였습니다. 다시 입력해주세요.");
//				changeAmount();
//			}
//		} else if(num==2) {
//			kind = "채소";
//			if(fc.changeAmount(new Vegetable(kind, name), amount)) {
//				System.out.println("농산물 수량이 수정되었습니다.");
//			} else {
//				System.out.println("농산물 수량 수정에 실패하였습니다. 다시 입력해주세요.");
//				changeAmount();
//			}
//		} else if(num==3) {
//			kind = "견과";
//			if(fc.changeAmount(new Nut(kind, name), amount)) {
//				System.out.println("농산물 수량이 수정되었습니다.");
//			} else {
//				System.out.println("농산물 수량 수정에 실패하였습니다. 다시 입력해주세요.");
//				changeAmount();
//			}
//		}
		
		Farm f = null;
		if(num==1)  {
			kind = "과일";
			f = new Fruit(kind,name);
		} else if(num==2) {
			kind = "채소";
			f = new Vegetable(kind,name);
		} else if(num==3){
			kind = "견과";
			f = new Nut(kind,name);
		} else {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			changeAmount();
		}
		
		if(fc.changeAmount(f, amount)) {
			System.out.println("농산물 수량이 수정되었습니다.");
		} else {
			System.out.println("농산물 수량 수정에 실패하였습니다. 다시 입력해주세요.");
			changeAmount();
		}
	}
	
	public void printFarm() {
		System.out.println("현재 KH마트 농산물 수량");
		HashMap<Farm,Integer> hm = fc.printFarm();
		Set<Farm> set = hm.keySet();
		Iterator<Farm> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			Farm f = iterator.next();
			System.out.println(f + "("+hm.get(f)+"개)");		// f: key값- 농산물 종류, hm.get(f): value값 - 농산물 개수
															// f가 Fruit, Vegetable, Nut 클래스에서 toString()메소드가 재정의
															// 되어 있으므로 그 형식에 맞춰서 출력됨. 
		}
	}
	
	public void buyFarm() {
		System.out.println("1.과일 / 2. 채소 / 3. 견과");
		System.out.print("구매 종류 번호 : ");
		int num = sc.nextInt();
		System.out.print("구매할 것 : ");
		String name = sc.next();
		String kind = null;
		Farm f = null;
		if(num==1)  {
			kind = "과일";
			f = new Fruit(kind,name);
		} else if(num==2) {
			kind = "채소";
			f = new Vegetable(kind,name);
		} else if(num==3){
			kind = "견과";
			f = new Nut(kind,name);
		} else {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			buyFarm();
		}
		
		if(fc.buyFarm(f)) {
			System.out.println("구매에 성공하였습니다.");
			printFarm();
		} else {
			System.out.println("마트에 없는 물건이거나 수량이 없습니다. 다시 입력해주세요.");
			buyFarm();
		}
	}
	
	public void removeFarm() {
		System.out.println("1.과일 / 2. 채소 / 3. 견과");
		System.out.print("취소 종류 번호 : ");
		int num = sc.nextInt();
		System.out.print("구매 취소할 것 : ");
		String name = sc.next();
		String kind = null;
		Farm f = null;
		if(num==1)  {
			kind = "과일";
			f = new Fruit(kind,name);
		} else if(num==2) {
			kind = "채소";
			f = new Vegetable(kind,name);
		} else if(num==3){
			kind = "견과";
			f = new Nut(kind,name);
		} else {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			removeFarm();
		}
		
		if(fc.removeFarm(f)) {
			System.out.println("구매 취소에 성공하셨습니다.");
			printFarm();
		} else {
			System.out.println("구매 목록이 존재하지 않습니다. 다시 입력해주세요.");
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
