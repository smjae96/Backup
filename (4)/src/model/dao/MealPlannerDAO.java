package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MealPlannerDAO {
    private Connection connection;

    public MealPlannerDAO() {
        this.connection = JDBCTemplate.getConnection();
    }

    public ArrayList<Food> getRestaurantMenu(String restaurantName) {
        ArrayList<Food> menu = new ArrayList<>();
        String query = "SELECT * FROM menu WHERE restaurant_name = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, restaurantName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String foodName = resultSet.getString("food_name");
                    int carbohydrate = resultSet.getInt("carbohydrate");
                    int protein = resultSet.getInt("protein");
                    int fat = resultSet.getInt("fat");

                    menu.add(new Food(foodName, carbohydrate, protein, fat));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }

    public void saveResultToDatabase(String name, ArrayList<Food> selectedFoods, int totalCalories, int maxCalories) {
        String insertUserQuery = "INSERT INTO users (name, gender) VALUES (?, ?)";
        String insertFoodQuery = "INSERT INTO selected_foods (user_name, food_name) VALUES (?, ?)";
        String insertCaloriesQuery = "INSERT INTO total_calories (user_name, total_calories) VALUES (?, ?)";

        try {
            connection.setAutoCommit(false);

            // 사용자 정보 저장
            try (PreparedStatement userStatement = connection.prepareStatement(insertUserQuery)) {
                userStatement.setString(1, name);
                userStatement.setString(2, (maxCalories == 2500) ? "M" : "F");
                userStatement.executeUpdate();
            }

            // 선택한 음식 저장
            try (PreparedStatement foodStatement = connection.prepareStatement(insertFoodQuery)) {
                for (Food food : selectedFoods) {
                    foodStatement.setString(1, name);
                    foodStatement.setString(2, food.getName());
                    foodStatement.executeUpdate();
                }
            }

            // 총 칼로리 저장
            try (PreparedStatement caloriesStatement = connection.prepareStatement(insertCaloriesQuery)) {
                caloriesStatement.setString(1, name);
                caloriesStatement.setInt(2, totalCalories);
                caloriesStatement.executeUpdate();
            }

            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
