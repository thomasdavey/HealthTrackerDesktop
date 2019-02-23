package View;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FoodInputView extends Application {

    public HBox createToolBar(){

        HBox hbox = new HBox(150);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(0, 0, 0, 0));

        //creating each button and adding them all to the toolbar
        Button empty = new Button("spare button");
        Button dailyLog = new Button("Daily Log");
        Button home = new Button("Home");
        Button groups = new Button("Groups");
        Button account = new Button("Account");

        hbox.getChildren().addAll(empty, dailyLog, home, groups, account);

        hbox.setPrefHeight(80);
        hbox.setPrefWidth(1100);
        hbox.setStyle("-fx-background-color: rgba(0, 0, 225, 0.4);"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 1");

        return hbox;
    }

    public VBox createCustomLog(){

        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(50, 0, 20, 30));
        vbox.setPrefWidth(550);
        vbox.setAlignment(Pos.TOP_LEFT);
        vbox.setStyle("-fx-background-color: rgba(192, 192, 192, 0.4);"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 1;");

        Label custom = new Label("Add Custom Food");

        Label foodName = new Label("Food Name: ");
        TextField foodField = new TextField();

        Label cals = new Label("Calories: ");
        TextField calsField = new TextField();
        calsField.setPromptText("0");

        Label fat = new Label("Fat: ");
        TextField fatField = new TextField();
        fatField.setPromptText("0g");

        Label protein = new Label("Protein: ");
        TextField proteinField = new TextField();
        proteinField.setPromptText("0g");

        Label meal = new Label("Select Meal: ");

        ObservableList<String> mealOptions = FXCollections.observableArrayList(
                "Breakfast",
                "Lunch",
                "Dinner",
                "Snacks"
        );

        final ComboBox meals = new ComboBox(mealOptions);

        Button addFood = new Button("Add Food");


        vbox.getChildren().addAll(custom, foodName, foodField, cals, calsField, fat,
                fatField, protein, proteinField, meal, meals, addFood);

        return vbox;

    }

    public VBox createLog(){

        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(50, 0, 20, 30));
        vbox.setPrefWidth(550);
        vbox.setAlignment(Pos.TOP_LEFT);
        vbox.setStyle("-fx-background-color: rgba(192, 192, 192, 0.4);"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 1;");

        Label preset = new Label("Choose Food to Add");

        Label meat = new Label("Meat");
        ObservableList<String> meatOptions = FXCollections.observableArrayList(
                "Chicken",
                "Beef",
                "Duck",
                "Pork"
        );

        final ComboBox meats = new ComboBox(meatOptions);

        Label fruitveg = new Label("Fruits/Vegetables");
        ObservableList<String> vegOptions = FXCollections.observableArrayList(
                "Apple",
                "Spinach",
                "Banana",
                "Cucumber"
        );

        final ComboBox fruitvegs = new ComboBox(vegOptions);

        Label dairy = new Label("Dairy");
        ObservableList<String> dairyOptions = FXCollections.observableArrayList(
                "Egg",
                "Milk",
                "Cheese",
                "Yoghurt"
        );

        final ComboBox dairys = new ComboBox(dairyOptions);

        Label other = new Label("Other");

        ObservableList<String> otherOptions = FXCollections.observableArrayList(
                "Donut",
                "Crisps",
                "White chocolate",
                "Peanuts"
        );

        final ComboBox others = new ComboBox(otherOptions);

        Label select = new Label("Select Meal: ");

        ObservableList<String> mealOptions = FXCollections.observableArrayList(
                "Breakfast",
                "Lunch",
                "Dinner",
                "Snacks"
        );

        final ComboBox meals = new ComboBox(mealOptions);

        Button addFood = new Button("Add Food");

        vbox.getChildren().addAll(preset, meat, meats, fruitveg, fruitvegs, dairy, dairys,
                other, others, select, meals, addFood);

        return vbox;
    }

    @Override
    public void start(Stage stage) throws Exception {

        StackPane root = new StackPane();
        BorderPane borderPane = new BorderPane();

        stage.setTitle("Health Tracker - Food Input");

        borderPane.setBottom(createToolBar());
        borderPane.setLeft(createCustomLog());
        borderPane.setRight(createLog());

        Scene scene = new Scene(borderPane, 1100, 700);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args){

        launch(args);
    }


}

