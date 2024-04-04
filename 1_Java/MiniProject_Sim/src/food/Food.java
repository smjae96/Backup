package food;

import nutrition.Nutrition;

public class Food implements Nutrition {

	protected String name;	// 음식 이름
	protected double carb;	// 음식의 탄수화물량
	protected double protein;	// 음식의 단백질량
	protected double fat; 	// 음식의 지질량
	
	public Food(String name, double carb, double protein, double fat) {
		this.name = name;
		this.carb = carb;
		this.protein = protein;
		this.fat = fat;
	}
	
	public double calculateCalories() {
		return carb*GRAMCARB + protein*GRAMPROTEIN + fat*GRAMFAT;
	}
	
	public String getName() {
		return name;
	}
}
