package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Launch extends Application {

    public static Stage stage = null;
    public static Stage primary = null;

    private static double xOffSet = 0;
    private static double yOffSet = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primary = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("/View/login.fxml"));
        newWindow(root, primary);
    }

    public static void makeStageDraggable(HBox topBar) {
        topBar.setOnMousePressed((event) -> {
            xOffSet = event.getSceneX();
            yOffSet = event.getSceneY();
        });
        topBar.setOnMouseDragged((event) -> {
            stage.setX(event.getScreenX() - xOffSet);
            stage.setY(event.getScreenY() - yOffSet);
        });
    }

    public static void newWindow(Parent r, Stage s) {
        stage = s;
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(r));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
