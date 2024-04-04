package model.view;

import java.util.ArrayList;
import java.util.Scanner;

import model.vo.food.*;
import model.vo.Restaurant;

public class FoodMenu {

	private static Scanner sc = new Scanner(System.in);
	
	
	public static void mainMenu() {
		System.out.println("\n ===== 회원님 환영합니다! ===== \n");
		while(true) {
			System.out.println("1. 오늘의 메뉴 선택하기");
			System.out.println("2. 내가 선택한 음식 리스트 확인하기");
			System.out.println("3. 회원 탈퇴");
			System.out.println("0. 로그아웃");
			System.out.println("메뉴를 선택하세요(1~3) : ");
			int choice = sc.nextInt();
			sc.nextLine();
			if(choice == 1) {
				FoodMenu.selectFoods();
				
				
			} else if(choice == 2) {
				FoodMenu.showFoodList();
			} else if(choice == 3) {
				new MemberMenu().deleteMember();
			} else if(choice == 0) {
				return;
			} else {
				System.out.println("메뉴 번호를 잘못 선택하셨습니다. 다시 선택해 주세요.");
				continue;
			}
		}
		
	}
	
	
	public static ArrayList<Food> selectFoods() {
		ArrayList<Food> selectedFoods = new ArrayList<>();
		Restaurant rt = new Restaurant(selectedFoods);
		System.out.println();
		System.out.println("===== 버거킹 메뉴 =====");
		System.out.println("1. 콰트로 치즈 와퍼");
		System.out.println("2. 통새우 와퍼");
		System.out.println("3. 롱치킨 버거");
		System.out.println("4. 바삭킹 4조각");
		System.out.println("5. 스태커 4와퍼");
		System.out.println("6. 굶기");
		System.out.print("메뉴를 선택하세요(1~6) : ");
		int choice = sc.nextInt();
		Food selectedBurgerking = rt.selectMenu(choice);
		selectedFoods.add(selectedBurgerking);
		
		System.out.println();
		
		System.out.println("===== 한솥 메뉴 =====");
		System.out.println("1. 치킨마요덮밥");
		System.out.println("2. 돈까스 도련님");
		System.out.println("3. 돈까스 카레");
		System.out.println("4. 소불고기 도시락");
		System.out.println("5. 참치야채고추장");
		System.out.println("6. 굶기");
		System.out.print("메뉴를 선택하세요(1~6) : ");
		choice = sc.nextInt();
		Food selectedHansot = rt.selectMenu(choice);
		selectedFoods.add(selectedHansot);
		
		System.out.println();
		
		System.out.println("===== 집밥 메뉴 =====");
		System.out.println("1. 된장찌개 + 밥 한 공기");
		System.out.println("2. 리코타 샐러드");
		System.out.println("3. 고등어 구이 + 밥 한 공기");
		System.out.println("4. 신라면 + 밥 한 공기");
		System.out.println("5. 블랙페퍼 닭가슴살");
		System.out.println("6. 굶기");
		System.out.print("메뉴를 선택하세요(1~6) : ");
		choice = sc.nextInt();
		Food selectedHomeCook = rt.selectMenu(choice);
		selectedFoods.add(selectedHomeCook);
		
		return selectedFoods;
		
	}
	
	public static void showFoodList() {
		
	}
}
