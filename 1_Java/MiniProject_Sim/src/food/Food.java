package food;

import nutrition.Nutrition;

public class Food implements Nutrition {

	protected String name;	// ���� �̸�
	protected double carb;	// ������ ź��ȭ����
	protected double protein;	// ������ �ܹ�����
	protected double fat; 	// ������ ������
	
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
