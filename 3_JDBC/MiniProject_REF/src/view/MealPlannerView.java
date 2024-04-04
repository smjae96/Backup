package view;

import java.util.ArrayList;

public class MealPlannerView {
    public void displayMenu(RestaurantMenu restaurantMenu) {
        ArrayList<Food> menu = restaurantMenu.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i).getName() +
                    " (칼로리: " + menu.get(i).calculateCalories() + " kcal)");
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
