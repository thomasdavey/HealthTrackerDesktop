package Controllers;

import DBClasses.DBAdd;
import Model.Food;
import application.Launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;

public class AddCustomFoodController implements Initializable {

    public HBox topBar;
    public TextField name;
    public TextField calories;
    public TextField protein;
    public TextField carbs;
    public TextField fat;
    public CheckBox save;

    private double k = 0;
    private double p = 0;
    private double c = 0;
    private double f = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Launch.makePopupDraggable(topBar);

    }

    public void minimise(MouseEvent mouseEvent) {
        Launch.stage.setIconified(true);
    }

    public void close(MouseEvent mouseEvent) {
        Launch.stage.close();
        Launch.stage = Launch.primary;
    }

    public void addFood(MouseEvent mouseEvent) throws IOException {
        if (validate()) {
            if (save.isSelected()) {
                AddFoodController.addCount((int)k);
                String user = Launch.getCurrentUser().getUserName();
                Food newFood = new Food(name.getText(), (int) k, (int) p, (int) c, (int) f, "Custom", user);
                DBAdd.addCustomFood(newFood);
            } else {
                AddFoodController.addCount((int)k);
            }

            Parent root = FXMLLoader.load(getClass().getResource("/View/addFood.fxml"));
            Launch.stage.getScene().setRoot(root);
        }
    }

    private Boolean validate() {
        if (name.getText().equals("")) {
            name.setPromptText("Enter Food Name");
            name.setStyle("-fx-prompt-text-fill: red");
            return false;
        }

        String error = "-fx-prompt-text-fill: red; -fx-background-color: transparent; -fx-text-fill:  rgba(0,0,0,0.8)";

        if (calories.getText().equals("")) {
            calories.setPromptText("Enter Calories");
            calories.setStyle(error);
            return false;
        } else {
            try {
                k = Double.parseDouble(calories.getText());
            } catch (Exception e) {
                calories.setText("");
                calories.setPromptText("Enter Calories");
                calories.setStyle(error);
                return false;
            }
        }

        if (protein.getText().equals("")) {
            protein.setPromptText("Enter Protein");
            protein.setStyle(error);
            return false;
        } else {
            try {
                p = Double.parseDouble(protein.getText());
            } catch (Exception e) {
                protein.setText("");
                protein.setPromptText("Enter Protein");
                protein.setStyle(error);
                return false;
            }
        }

        if (carbs.getText().equals("")) {
            carbs.setPromptText("Enter Carbohydrates");
            carbs.setStyle(error);
            return false;
        } else {
            try {
                c = Double.parseDouble(carbs.getText());
            } catch (Exception e) {
                carbs.setText("");
                carbs.setPromptText("Enter Carbohydrates");
                carbs.setStyle(error);
                return false;
            }
        }

        if (fat.getText().equals("")) {
            fat.setPromptText("Enter Fat");
            fat.setStyle(error);
            return false;
        } else {
            try {
                f = Double.parseDouble(fat.getText());
            } catch (Exception e) {
                fat.setText("");
                fat.setPromptText("Enter Fat");
                fat.setStyle(error);
                return false;
            }
        }

        return true;
    }
}
