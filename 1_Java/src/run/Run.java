package run;

import java.util.ArrayList;
import java.util.Scanner;

import food.Food;
import foodselector.FoodSelector;
import input.UserInput;
import menu.MenuCreator;
import restaurant.Restaurant;
import viewresult.ViewResult;

public class Run {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = UserInput.getUserName();
		char gender = UserInput.getGender();
		
		while(true) {
			ArrayList<Food> burgerkingMenu = MenuCreator.BurgerkingMenu();
			ArrayList<Food> hansotMenu = MenuCreator.HansotMenu();
			ArrayList<Food> homeCookMenu = MenuCreator.HomeCookMenu();
			
			Restaurant burgerking = new Restaurant(burgerkingMenu);
			Restaurant hansot = new Restaurant(hansotMenu);
			Restaurant homeCook = new Restaurant(homeCookMenu);
			
			
			ArrayList<Food> selectedFoods = FoodSelector.selectFoods(burgerking, hansot, homeCook);
			
			double totalCalories = ViewResult.calculateTotalCalories(selectedFoods);
			
			double maxCalories = (gender == 'M') ? 2500 : 2000;
			
			ViewResult.printResult(name, selectedFoods, totalCalories, maxCalories);
			
			if(totalCalories> maxCalories) {
				continue;
			}
			else {
				System.out.println();
				System.out.println();
				System.out.println("주문을 취소하시겠습니까?");
				System.out.println("취소 시 최초 주문화면으로 돌아갑니다.");
				System.out.println("*****취소를 원하시면 Y를 눌러주세요. 다른 키를 누를 시 주문이 확정됩니다!*****");
				System.out.print("입력 : ");
				String order = sc.nextLine().toUpperCase();
				
				if(order.equals("Y")) {
					selectedFoods.clear();
					continue;
				} else {
					System.out.println();
					System.out.println("주문이 확정되었습니다!!");
					ViewResult.saveMenuFile(name, selectedFoods, totalCalories, maxCalories);
					return;
				}
			}
		}
		
				
	}
}
