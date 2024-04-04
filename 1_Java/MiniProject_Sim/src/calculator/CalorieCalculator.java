package calculator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import food.Food;
import foodselector.FoodSelector;
import menu.MenuCreator;
import restaurant.Restaurant;
import run.Run;

public class CalorieCalculator {
	public static double calculateTotalCalories(ArrayList<Food> selectedFoods) {
		int totalCalories = 0;
		for(Food food : selectedFoods) {
			totalCalories += food.calculateCalories();
		}
		return totalCalories;
	}
	
	public static void printResult(String name, ArrayList<Food> selectedFoods, double totalCalories, double maxCalories) {
		System.out.println();
		System.out.println("<< "+name+"님이 선택한 음식 >> ");
		for(int i=0; i<selectedFoods.size(); i++) {
			if(i<2) {
			System.out.print(selectedFoods.get(i).getName() + " / ");
			} else {
				System.out.println(selectedFoods.get(i).getName());
			}
		}
		System.out.println();
		System.out.print("총 칼로리 : " +totalCalories + "kcal");
		
		if(totalCalories > maxCalories) {
			System.out.println("일일 권장섭취량 초과입니다. 다시 선택하십시오!");
			for(int i=0; i<selectedFoods.size(); i++) {
				selectedFoods.remove(i);
			}
			
		}
		
	}
	
	public static void saveMenuFile(String name, ArrayList<Food> selectedFoods, double totalCalories, double maxCalories) {
	    String fileName = name + " Selected_menu.txt";

	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
	        writer.write(name + "님이 선택한 음식:\n");
	        for (Food food : selectedFoods) {
	            writer.write("- " + food.getName() + "\n");
	        }

	        writer.write("총 칼로리: " + totalCalories + " kcal\n");

	        if (totalCalories > maxCalories) {
	            System.out.println("일일 권장섭취량 초과입니다. 다시 선택하십시오!");
	        } else {
	        	System.out.println();
	            System.out.println("결과가 파일에 저장되었습니다: " + fileName);
	        }
	    } catch (IOException e) {
	       e.printStackTrace();
	    }
	}
}
