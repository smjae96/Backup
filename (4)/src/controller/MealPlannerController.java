package controller;

public class MealPlannerController {
    private MealPlannerModel model;
    private MealPlannerService service;
    private MealPlannerView view;

    public MealPlannerController(MealPlannerModel model, MealPlannerService service, MealPlannerView view) {
        this.model = model;
        this.service = service;
        this.view = view;
    }

    public void runMealPlanner() {
        service.runMealPlanner();
    }
}

