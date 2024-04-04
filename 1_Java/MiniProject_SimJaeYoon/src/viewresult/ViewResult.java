package viewresult;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import food.Food;

public class ViewResult {
	public static double calculateTotalCalories(ArrayList<Food> selectedFoods) {
		int totalCalories = 0;
		for(Food food : selectedFoods) {
			totalCalories += food.calculateCalories();
		}
		return totalCalories;
	}
	
	public static int printResult(String name, ArrayList<Food> selectedFoods, double totalCalories, double maxCalories) {
		System.out.println();
		System.out.println("<< "+name+"님이 선택한 음식 >> ");
		int totalPrice = 0;
		for(int i=0; i<selectedFoods.size(); i++) {
			totalPrice += selectedFoods.get(i).getPrice();
			if(i<2) {
			System.out.print(selectedFoods.get(i).getName() + " / ");
			} else {
				System.out.println(selectedFoods.get(i).getName());
				
			}
		}
		System.out.println();
		System.out.println("총 가격 : " +totalPrice + "원");
		System.out.print("총 칼로리 : " +totalCalories + "kcal");
		System.out.println();
		
		Date today = new Date();  
		System.out.printf("===== %tF %tT =====",today, today);
		if(totalCalories > maxCalories) {
			System.out.println("일일 권장섭취량 초과입니다. 다시 선택하십시오!");
			for(int i=0; i<selectedFoods.size(); i++) {
				selectedFoods.remove(i);
			}
			
		}
		return totalPrice;
		
	}
	
	public static void saveMenuFile(String name, ArrayList<Food> selectedFoods, double totalCalories, double maxCalories) {
	    String fileName = name + "님의 음식리스트.txt";
	    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date time = new Date();
	    String today = simpleDate.format(time);
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
	        writer.write(name + "님이 선택한 음식\n");
	        for(int i=0; i<selectedFoods.size(); i++) {
	            if(i<2) {
	        	writer.write("- " + selectedFoods.get(i).getName() + ": "+selectedFoods.get(i).getPrice()+ "원\n");
	            } else {
	            	writer.write("- " + selectedFoods.get(i).getName() + "\n");
	            }
	        }

	        writer.write("총 칼로리: " + totalCalories + " kcal\n");
	        writer.write("총 가격 : " + ViewResult.printResult(name, selectedFoods, totalCalories, maxCalories) + "원\n");
	        writer.write("=====" +today + "=====");

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
