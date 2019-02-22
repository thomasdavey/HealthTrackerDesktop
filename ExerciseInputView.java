package sample;

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

import static javafx.application.Application.launch;

public class ExerciseInputView extends Application {

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

        Label custom = new Label("Add Custom Exercise");

        Label exName = new Label("Exercise Name: ");
        TextField nameField = new TextField();

        Label type = new Label("Type of Exercise: ");
        ObservableList<String> exOptions = FXCollections.observableArrayList(
                "Strength",
                "Cardio"
        );

        final ComboBox exer = new ComboBox(exOptions);

        Label cals = new Label("Calories Burned: ");
        TextField calsField = new TextField();
        calsField.setPromptText("0");

        Label time = new Label("Duration: ");
        TextField timeField = new TextField();

        Button addExercise = new Button("Add Exercise");

        vbox.getChildren().addAll(custom, exName, nameField, type, exer,
                cals, calsField, time, timeField, addExercise);

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

        Label preset = new Label("Choose Exercise to Add");

        Label cardio = new Label("Cardio");
        ObservableList<String> cardioOptions = FXCollections.observableArrayList(
                "Treadmill",
                "Cross Trainer",
                "Cycling",
                "Step Machine"
        );

        final ComboBox cardios = new ComboBox(cardioOptions);

        Label strength = new Label("Strength");
        ObservableList<String> strengthOptions = FXCollections.observableArrayList(
                "Abs",
                "Legs",
                "Arms",
                "Shoulders"
        );

        final ComboBox strengths = new ComboBox(strengthOptions);

        Button addExercise = new Button("Add Exercise");

        vbox.getChildren().addAll(preset, cardio, cardios, strength, strengths,
                addExercise);

        return vbox;
    }

    @Override
    public void start(Stage stage) throws Exception {

        StackPane root = new StackPane();
        BorderPane borderPane = new BorderPane();

        stage.setTitle("Health Tracker - Exercise Input");

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
