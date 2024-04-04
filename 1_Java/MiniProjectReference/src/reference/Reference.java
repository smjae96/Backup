package reference;

public class Reference {
	// 패키지 구조: nutrition
	package nutrition;

	public interface Nutrition {
	    int CARBOHYDRATE_CAL = 4;
	    int PROTEIN_CAL = 4;
	    int FAT_CAL = 9;
	}

	// 패키지 구조: food
	package food;

	import nutrition.Nutrition;

	public class Food implements Nutrition {
	    protected String name;
	    protected int carbohydrate;
	    protected int protein;
	    protected int fat;

	    public Food(String name, int carbohydrate, int protein, int fat) {
	        this.name = name;
	        this.carbohydrate = carbohydrate;
	        this.protein = protein;
	        this.fat = fat;
	    }

	    public int calculateCalories() {
	        return carbohydrate * CARBOHYDRATE_CAL + protein * PROTEIN_CAL + fat * FAT_CAL;
	    }

	    public String getName() {
	        return name;
	    }
	}
	
	// 패키지 구조: food
	package food;

	public class Burgerking extends Food {
	    public Burgerking(String name, int carbohydrate, int protein, int fat) {
	        super(name, carbohydrate, protein, fat);
	    }
	}

	// 패키지 구조: food
	package food;

	public class Hansot extends Food {
	    public Hansot(String name, int carbohydrate, int protein, int fat) {
	        super(name, carbohydrate, protein, fat);
	    }
	}

	// 패키지 구조: food
	package food;

	public class HomeCook extends Food {
	    public HomeCook(String name, int carbohydrate, int protein, int fat) {
	        super(name, carbohydrate, protein, fat);
	    }
	}


	// 패키지 구조: restaurant
	package restaurant;

	import food.Food;

	import java.util.ArrayList;

	public class Restaurant {
	    private ArrayList<Food> menu;

	    public Restaurant(ArrayList<Food> menu) {
	        this.menu = menu;
	    }

	    public Food getMenu(int choice) {
	        if (choice >= 1 && choice <= menu.size()) {
	            return menu.get(choice - 1);
	        } else {
	            System.out.println("Invalid menu choice. Defaulting to Menu1.");
	            return menu.get(0);
	        }
	    }
	}

	// 패키지 구조: userinput
	package userinput;

	import java.util.Scanner;

	public class UserInput {
	    private static Scanner scanner = new Scanner(System.in);

	    public static String getUsername() {
	        System.out.print("Enter your name: ");
	        return scanner.nextLine();
	    }

	    public static char getGender() {
	        System.out.print("Enter your gender (M/F): ");
	        return scanner.next().charAt(0);
	    }
	}

	// 패키지 구조: menucreator
	package menucreator;

	import food.Burgerking;
	import food.Hansot;
	import food.HomeCook;

	import java.util.ArrayList;

	public class MenuCreator {
	    public static ArrayList<Food> createBurgerkingMenu() {
	        ArrayList<Food> menu = new ArrayList<>();
	        menu.add(new Burgerking("Whopper", 50, 25, 35));
	        menu.add(new Burgerking("Cheeseburger", 30, 15, 20));
	        menu.add(new Burgerking("Chicken Royale", 40, 20, 25));
	        menu.add(new Burgerking("Fish Sandwich", 35, 18, 30));
	        menu.add(new Burgerking("Veggie Burger", 25, 12, 15));
	        return menu;
	    }

	    public static ArrayList<Food> createHansotMenu() {
	        ArrayList<Food> menu = new ArrayList<>();
	        menu.add(new Hansot("Bibimbap", 60, 20, 25));
	        menu.add(new Hansot("Kimchi Fried Rice", 40, 15, 20));
	        menu.add(new Hansot("Spicy Chicken Bowl", 50, 25, 30));
	        menu.add(new Hansot("Japchae", 30, 10, 15));
	        menu.add(new Hansot("Dolsot Bibimbap", 70, 22, 28));
	        return menu;
	    }

	    public static ArrayList<Food> createHomeCookMenu() {
	        ArrayList<Food> menu = new ArrayList<>();
	        menu.add(new HomeCook("Grilled Chicken Salad", 15, 30, 10));
	        menu.add(new HomeCook("Vegetable Stir-Fry", 25, 10, 15));
	        menu.add(new HomeCook("Salmon with Quinoa", 20, 25, 18));
	        menu.add(new HomeCook("Pasta Primavera", 45, 15, 20));
	        menu.add(new HomeCook("Tofu and Vegetable Curry", 30, 12, 25));
	        return menu;
	    }
	}

	// 패키지 구조: foodselector
	package foodselector;

	import food.Food;
	import restaurant.Restaurant;

	import java.util.ArrayList;
	import java.util.Scanner;

	public class FoodSelector {
	    private static Scanner scanner = new Scanner(System.in);

	    public static ArrayList<Food> selectFoods(Restaurant burgerking, Restaurant hansot, Restaurant homeCook) {
	        ArrayList<Food> selectedFoods = new ArrayList<>();

	        for (int i = 0; i < 3; i++) {
	            System.out.println("Select a menu from each restaurant (1-5):");
	            System.out.println("1. Burgerking  2. Hansot  3. HomeCook");

	            int restaurantChoice = scanner.nextInt();
	            int menuChoice = scanner.nextInt();

	            Food selectedMenu = null;

	            switch (restaurantChoice) {
	                case 1:
	                    selectedMenu = burgerking.getMenu(menuChoice);
	                    break;
	                case 2:
	                    selectedMenu = hansot.getMenu(menuChoice);
	                    break;
	                case 3:
	                    selectedMenu = homeCook.getMenu(menuChoice);
	                    break;
	                default:
	                    System.out.println("Invalid restaurant choice.");
	                    i--;
	                    continue;
	            }

	            selectedFoods.add(selectedMenu);
	        }
	        return selectedFoods;
	    }
	}

	// 패키지 구조: calculator
	package calculator;

	import food.Food;

	import java.util.ArrayList;

	public class CalorieCalculator {
	    public static double calculateTotalCalories(ArrayList<Food> selectedFoods) {
	        double totalCalories = 0;
	        for (Food food : selectedFoods) {
	            totalCalories += food.calculateCalories();
	        }
	        return totalCalories;
	    }

	    public static void printResult(String name, ArrayList<Food> selectedFoods, int totalCalories, int maxCalories) {
	        System.out.println(name + "님이 선택한 음식:");
	        for (Food food : selectedFoods) {
	            System.out.println("- " + food.getName());
	        }

	        System.out.println("총 칼로리: " + totalCalories + " kcal");

	        if (totalCalories > maxCalories) {
	            System.out.println("일일 권장섭취량 초과입니다. 다시 선택하십시오!");
	        }
	    }
	}

	// 패키지 구조: main
	package main;

	import calculator.CalorieCalculator;
	import foodselector.FoodSelector;
	import menucreator.MenuCreator;
	import restaurant.Restaurant;
	import userinput.UserInput;

	import food.Burgerking;
	import food.Hansot;
	import food.HomeCook;

	import java.util.ArrayList;

	public class Main {
	    public static void main(String[] args) {
	        // 사용자 정보 입력
	        String name = UserInput.getUsername();
	        char gender = UserInput.getGender();

	        // 각 식당의 메뉴 ArrayList 생성
	        ArrayList<food.Food> burgerkingMenu = MenuCreator.createBurgerkingMenu();
	        ArrayList<food.Food> hansotMenu = MenuCreator.createHansotMenu();
	        ArrayList<food.Food> homeCookMenu = MenuCreator.createHomeCookMenu();

	        // 각 식당 객체 생성
	        restaurant.Restaurant burgerking = new restaurant.Restaurant(burgerkingMenu);
	        restaurant.Restaurant hansot = new restaurant.Restaurant(hansotMenu);
	        restaurant.Restaurant homeCook = new restaurant.Restaurant(homeCookMenu);

	        // 음식 선택
	        ArrayList<food.Food> selectedFoods = foodselector.FoodSelector.selectFoods(burgerking, hansot, homeCook);

	        // 총 칼로리 계산
	        int totalCalories = calculator.CalorieCalculator.calculateTotalCalories(selectedFoods);

	        // 일일 권장섭취량 확인 및 결과 출력
	        int maxCalories = (gender == 'M') ? 2500 : 2000;
	        calculator.CalorieCalculator.printResult(name, selectedFoods, totalCalories, maxCalories);
	    }
	}

}

}
