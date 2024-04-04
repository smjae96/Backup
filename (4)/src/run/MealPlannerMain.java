package run;

public class MealPlannerMain {
    public static void main(String[] args) {
        MealPlannerModel model = new MealPlannerModel();
        MealPlannerDAO dao = new MealPlannerDAO();
        MealPlannerService service = new MealPlannerService(model, dao);
        MealPlannerView view = new MealPlannerView();
        MealPlannerController controller = new MealPlannerController(model, service, view);

        // MVC 패턴을 이용하여 실행
        controller.runMealPlanner();
    }
}

