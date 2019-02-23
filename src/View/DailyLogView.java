package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.application.*;
import javafx.scene.text.Font;
import javafx.stage.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DailyLogView extends Application{

    LocalDate todaysDate;
    int totalFood;
    int totalExercise;
    int netCals;
    int calBudget;

    //method for creating a static toolbar to navigate to other views
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

    //method for creating the sidebar showing daily stats
    public VBox createSideBar(){

        //get the date to display on the stats
        todaysDate = java.time.LocalDate.now();
        DateTimeFormatter str = DateTimeFormatter.ofPattern("E, dd MMMM yyyy");
        String dateString = todaysDate.format(str);

        VBox vbox = new VBox(40);
        vbox.setPadding(new Insets(30, 30, 10, 30));
        vbox.setPrefHeight(300);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: rgba(0, 0, 128, 0.6);"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 1");

        Font font = new Font("Verdana", 18);

        Label date = new Label(dateString);
        date.setFont(new Font("Verdana", 20));

        Label food = new Label("Total Food: ");
        food.setFont(font);
        Label foodv = new Label(totalFood + " cals");
        foodv.setFont(font);

        Label exercise = new Label("Total Exercise: ");
        exercise.setFont(font);
        Label exercisev = new Label(totalExercise + " cals");
        exercisev.setFont(font);

        Label net = new Label("Net calories: ");
        net.setFont(font);
        Label netv = new Label(netCals + " cals");
        netv.setFont(font);

        Label budget = new Label("Under budget: ");
        budget.setFont(font);
        Label budgetv = new Label(calBudget + " cals");
        budgetv.setFont(font);

        vbox.getChildren().addAll(date, food, foodv, exercise, exercisev,
                net, netv, budget, budgetv);

        return vbox;
    }

    //method for creating the left side of the main logging section
    public VBox createLeftLog(){

        VBox vbox = new VBox(100);
        vbox.setPadding(new Insets(50, 0, 20, 30));
        vbox.setPrefWidth(400);
        vbox.setAlignment(Pos.TOP_LEFT);
        vbox.setStyle("-fx-background-color: rgba(192, 192, 192, 0.4);"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 1;");

        Font font = new Font("Verdana", 15);

        Label breakfast = new Label("Breakfast");
        breakfast.setFont(font);

        Label lunch = new Label("Lunch");
        lunch.setFont(font);

        vbox.getChildren().addAll(breakfast, lunch);

        Button addFood = new Button("Add Food");
        vbox.getChildren().add(addFood);

        return vbox;
    }

    ////method for creating the right side of the main logging section
    public VBox createRightLog(){

        VBox vbox = new VBox(100);
        vbox.setPadding(new Insets(50, 0, 20, 30));
        vbox.setPrefWidth(400);
        vbox.setAlignment(Pos.TOP_LEFT);
        vbox.setStyle("-fx-background-color: rgba(192, 192, 192, 0.4);"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 1;");

        Label dinner = new Label("Dinner");
        dinner.setFont(new Font("Verdana", 15));

        Label snacks = new Label("Snacks");
        snacks.setFont(new Font("Verdana", 15));

        Label exercise = new Label("Exercise");
        exercise.setFont(new Font("Verdana", 15));

        vbox.getChildren().addAll(dinner, snacks, exercise);

        Button addExercise = new Button("Add Exercise");
        vbox.getChildren().add(addExercise);
        addExercise.setAlignment(Pos.BOTTOM_CENTER);

        return vbox;
    }

    //overriding start method to set up the scene
    @Override
    public void start(Stage stage) throws Exception {

        StackPane root = new StackPane();
        BorderPane borderPane = new BorderPane();

        stage.setTitle("Health Tracker - Daily Diet and Exercise Log");

        borderPane.setBottom(createToolBar());
        borderPane.setRight(createSideBar());
        borderPane.setLeft(createLeftLog());
        borderPane.setCenter(createRightLog());

        Scene scene = new Scene(borderPane, 1100, 700);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args){

        launch(args);
    }


}

