package menu;

import java.util.ArrayList;

import food.*;

public class MenuCreator {

	public static ArrayList<Food> BurgerkingMenu() {
		ArrayList<Food> menu = new ArrayList<>();
		menu.add(new Burgerking("콰트로 치즈와퍼", 71.1, 57.7, 28.2));
		menu.add(new Burgerking("통새우 와퍼", 50.0, 33.3, 45.3));
		menu.add(new Burgerking("롱치킨 버거", 55.7, 58.5, 12.7));
		menu.add(new Burgerking("바삭킹 4조각", 8.2, 73.4, 24.2));
		menu.add(new Burgerking("스태커4 와퍼",51.2,106.7,121.4));
		menu.add(new Burgerking("굶기",0,0,0));
		return menu;
	}
	public static ArrayList<Food> HansotMenu() {
		ArrayList<Food> menu = new ArrayList<>();
		menu.add(new Hansot("치킨마요덮밥", 79.6, 25.3, 29.6));
		menu.add(new Hansot("돈까스 도련님", 69.0, 50.0, 30.0));
		menu.add(new Hansot("돈까스 카레", 95.3, 14.8, 10.7));
		menu.add(new Hansot("소불고기 도시락", 17.5, 118.3, 39.0));
		menu.add(new Hansot("참치야채고추장",66.1,24.4,11.3));
		menu.add(new Hansot("굶기",0,0,0));
		return menu;
	}
	public static ArrayList<Food> HomeCookMenu() {
		ArrayList<Food> menu = new ArrayList<>();
		menu.add(new HomeCook("된장찌개 + 밥 한 공기", 84.1, 20.6, 6.5));
		menu.add(new HomeCook("리코타 샐러드", 21.3, 4.9, 15.1));
		menu.add(new HomeCook("고등어 구이 + 밥 한 공기", 70.0, 40.8, 26.0));
		menu.add(new HomeCook("신라면 + 밥 한 공기", 146.3, 15.6, 16.9));
		menu.add(new HomeCook("블랙페퍼 닭가슴살",1.0,24.0,1.6));
		menu.add(new HomeCook("굶기",0,0,0));
		return menu;
	}
	
}
