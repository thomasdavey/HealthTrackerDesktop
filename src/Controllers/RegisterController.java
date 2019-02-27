package Controllers;

import application.Launch;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    public HBox topBar;
    public ComboBox<String> activityLevels;
    public ComboBox<String> sex;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Launch.makeStageDraggable(topBar);
        setActivityLevels();
        setSex();
    }

    public void minimise(MouseEvent mouseEvent) {
        Launch.stage.setIconified(true);
    }

    public void close(MouseEvent mouseEvent) {
        System.exit(0);
    }

    private void setActivityLevels() {
        activityLevels.getItems().add("Less than 2 hours per week");
        activityLevels.getItems().add("2-5 hours per week");
        activityLevels.getItems().add("5-10 hours per week");
        activityLevels.getItems().add("More than 10 hours per week");
    }

    private void setSex() {
        sex.getItems().add("Male");
        sex.getItems().add("Female");
    }
}
