package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LoginView extends Application {

    public VBox createLogin(){
        VBox vbox = new VBox(70);
        vbox.setPadding(new Insets(50, 50, 50, 50));
        vbox.setPrefWidth(800);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: rgba(192, 192, 192, 0.4);");

        Label name = new Label("Health Tracker Name");

        Label user = new Label("Username: ");
        TextField username = new TextField();

        Label pass = new Label("Password");
        PasswordField password = new PasswordField();

        Button login = new Button("Log in");

        Button register = new Button("Not registered? Sign up here");

        vbox.getChildren().addAll(name, user, username, pass, password, login, register);

        return vbox;
    }

    @Override
    public void start(Stage stage) throws Exception {

        StackPane root = new StackPane();
        BorderPane borderPane = new BorderPane();

        stage.setTitle("Health Tracker - Login");

        borderPane.setCenter(createLogin());

        Scene scene = new Scene(borderPane, 1100, 700);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args){

        launch(args);
    }

}
