package model.service;

import java.util.ArrayList;

public class MealPlannerService {
    private MealPlannerModel model;
    private MealPlannerDAO dao;

    public MealPlannerService(MealPlannerModel model, MealPlannerDAO dao) {
        this.model = model;
        this.dao = dao;
    }

    public void runMealPlanner() {
        // 사용자 정보 입력
        String name = UserInput.getUsername();
        char gender = UserInput.getGender();

        // 각 식당의 메뉴 가져오기
        ArrayList<Food> burgerkingMenu = dao.getRestaurantMenu("Burgerking");
        ArrayList<Food> hansotMenu = dao.getRestaurantMenu("Hansot");
        ArrayList<Food> homeCookMenu = dao.getRestaurantMenu("HomeCook");

        // 각 식당 객체 생성
        RestaurantManager manager = new RestaurantManager(burgerkingMenu, hansotMenu, homeCookMenu);

        // 음식 선택
        ArrayList<Food> selectedFoods = manager.selectFoods();

        // 총 칼로리 계산
        int totalCalories = CalorieCalculator.calculateTotalCalories(selectedFoods);

        // 일일 권장섭취량 확인 및 결과 출력
        int maxCalories = (gender == 'M') ? 2500 : 2000;
        CalorieCalculator.printResult(name, selectedFoods, totalCalories, maxCalories);

        // 결과를 모델에 저장
        model.addSelectedFoods(selectedFoods);

        // 결과를 데이터베이스에 저장
        dao.saveResultToDatabase(name, selectedFoods, totalCalories, maxCalories);
    }
}

