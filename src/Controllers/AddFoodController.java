package Controllers;

import DBClasses.DBAdd;
import application.Launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;

public class AddFoodController implements Initializable {

    public HBox topBar;
    public ComboBox category;
    public ComboBox selection;
    public Label label;
    public Label total;

    public static int calorieCount = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Launch.makePopupDraggable(topBar);

        label.setText("Add " + DailyLogController.getMeal());
        total.setText("Total Calories: " + calorieCount);
        selection.setDisable(true);

        category.getItems().add("Meat");
        category.getItems().add("Fruit");
        category.getItems().add("Vegetable");
        category.getItems().add("Dairy");
        category.getItems().add("Grain");
        category.getItems().add("Sweet");
        category.getItems().add("Drink");
        category.getItems().add("Custom");
    }

    public void minimise(MouseEvent mouseEvent) {
        Launch.stage.setIconified(true);
    }

    public void close(MouseEvent mouseEvent) {
        Launch.stage.close();
        Launch.stage = Launch.primary;
    }

    public void setSelection(ActionEvent mouseEvent) {
        selection.setDisable(false);
        selection.getItems().clear();
        System.out.println(category.getSelectionModel().getSelectedItem().toString());
        ArrayList<String> foods = DBAdd.getFoods
                (category.getSelectionModel().getSelectedItem().toString(),Launch.getCurrentUser().getUserName());
        for (int i = 0; i < foods.size(); i++) {
            System.out.println(foods.get(i));
            selection.getItems().add(foods.get(i));
        }
    }

    public void addFood(MouseEvent mouseEvent) {
        if (!selection.getSelectionModel().isEmpty()) {
            calorieCount += DBAdd.getFoodCalories(selection.getSelectionModel().getSelectedItem().toString());
            total.setText("Total Calories: " + calorieCount);
        }
    }

    public void addCustom(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/addCustomFood.fxml"));
        Launch.stage.getScene().setRoot(root);
    }

    public void reset(MouseEvent mouseEvent) {
        calorieCount = 0;
        total.setText("Total Calories: " + calorieCount);
    }

    public void submit(MouseEvent mouseEvent) throws IOException {
        Date today = new Date(Calendar.getInstance().getTime().getTime());
        DBAdd.addCalories(Launch.getCurrentUser().getUserName(),
                today, calorieCount, DailyLogController.getMeal());
        Launch.stage.close();
        Launch.stage = Launch.primary;
        calorieCount = 0;
        Parent root = FXMLLoader.load(getClass().getResource("/View/dailyLog.fxml"));
        Launch.stage.getScene().setRoot(root);
    }

    public static void addCount(int i) {
        calorieCount += i;
    }
}
