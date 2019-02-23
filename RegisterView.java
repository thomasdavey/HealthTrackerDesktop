package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class RegisterView extends Application {

    private Integer[] heights(){
        Integer[] result = new Integer[150];

        int x = 100;
        for (int i = 0; i < 150; i++){
            result[i] = x;
            x++;
        }

        return result;
    }

    private Integer[] weights(){
        Integer[] result = new Integer[270];

        int x = 30;
        for (int i = 0; i < 270; i++){
            result[i] = x;
            x++;
        }

        return result;
    }

    private Integer[] goalWeight(){
        Integer[] result = new Integer[100];

        int x = -1;
        for (int i = 0; i < 100; i++){
            result[i] = x;
            x--;
        }

        return result;
    }

    public GridPane createRegister(){
        GridPane grid = new GridPane();
        grid.setPrefSize(900, 500);
        grid.setStyle("-fx-hgap: 100;" + "-fx-vgap: 30;");

        Label title = new Label("Register");
        grid.add(title, 0, 0);

        Label name = new Label("Name: ");
        TextField nameField = new TextField();
        grid.add(name, 0, 2);
        grid.add(nameField, 1, 2);

        Label user = new Label("Username: ");
        TextField username = new TextField();
        grid.add(user, 0,3);
        grid.add(username, 1, 3);

        Label pass = new Label("Password: ");
        PasswordField password = new PasswordField();
        grid.add(pass, 0, 4);
        grid.add(password, 1, 4);

        Label email = new Label("Email address: ");
        TextField emailField = new TextField();
        grid.add(email, 0, 5);
        grid.add(emailField, 1, 5);

        Label h = new Label("Height: ");
        final ComboBox height = new ComboBox();
        height.getItems().addAll(heights());
        Label cm = new Label("cm");
        grid.add(h, 0, 6);
        grid.add(height, 1, 6);
        grid.add(cm, 2, 6);

        Label w = new Label("Weight: ");
        final ComboBox weight = new ComboBox();
        weight.getItems().addAll(weights());
        Label kg = new Label("kg");
        grid.add(w, 0, 7);
        grid.add(weight, 1, 7);
        grid.add(kg, 2, 7);

        Label act = new Label("Activity Level: ");
        ObservableList<String> activity = FXCollections.observableArrayList(
                "Less than 2 hours per week",
                "2-5 hours per week",
                "5-10 hours per week",
                "More than 10 hours per week"
        );
        final ComboBox actLevel = new ComboBox(activity);
        grid.add(act, 0,8);
        grid.add(actLevel, 1, 8);

        Label goal = new Label("Initial Goal: ");
        final ComboBox goalWeight = new ComboBox();
        goalWeight.getItems().addAll(goalWeight());
        Label kg2 = new Label("kg");
        Label by = new Label("by");
        DatePicker goalDate = new DatePicker();
        grid.add(goal, 3, 4);
        grid.add(goalWeight, 3, 5);
        grid.add(kg2, 4, 5 );
        grid.add(by, 3, 6);
        grid.add(goalDate, 3, 7);

        Button register = new Button("Register");
        grid.add(register, 3, 8);

        return grid;
    }

    @Override
    public void start(Stage stage) throws Exception {

        StackPane root = new StackPane();
        BorderPane borderPane = new BorderPane();

        stage.setTitle("Health Tracker - Login");

        borderPane.setCenter(createRegister());

        Scene scene = new Scene(borderPane, 1100, 700);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args){

        launch(args);
    }

}
