package foodselector;

import java.util.ArrayList;
import java.util.Scanner;

import food.Food;
import restaurant.Restaurant;

public class FoodSelector {
	private static Scanner sc = new Scanner(System.in);
	
	
	public static ArrayList<Food> selectFoods(Restaurant burgerking, Restaurant hansot, Restaurant homeCook) {
		ArrayList<Food> selectedFoods = new ArrayList<>();
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
		Food selectedBurgerking = burgerking.selectMenu(choice);
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
		Food selectedHansot = hansot.selectMenu(choice);
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
		Food selectedHomeCook = homeCook.selectMenu(choice);
		selectedFoods.add(selectedHomeCook);
		
		return selectedFoods;
		
	}
}
