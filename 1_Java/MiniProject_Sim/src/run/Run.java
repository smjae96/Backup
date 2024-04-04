package run;

import java.util.ArrayList;

import calculator.CalorieCalculator;
import food.Food;
import foodselector.FoodSelector;
import input.UserInput;
import menu.MenuCreator;
import restaurant.Restaurant;

public class Run {
	public static void main(String[] args) {
		
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
			
			double totalCalories = CalorieCalculator.calculateTotalCalories(selectedFoods);
			
			double maxCalories = (gender == 'M') ? 2500 : 2000;
			
			CalorieCalculator.printResult(name, selectedFoods, totalCalories, maxCalories);
			
			if(totalCalories> maxCalories) {
				continue;
			}
			else {
				CalorieCalculator.saveMenuFile(name, selectedFoods, totalCalories, maxCalories);
				return;
			}
		}
		
				
	}
}
