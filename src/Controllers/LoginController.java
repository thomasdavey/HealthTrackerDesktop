package Controllers;

import application.Launch;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    public HBox topBar;
    public Button button;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Launch.makeStageDraggable(topBar);
    }

    public void minimise(MouseEvent mouseEvent) {
        Launch.stage.setIconified(true);
    }

    public void close(MouseEvent mouseEvent) {
        System.exit(0);
    }

    public void register(MouseEvent mouseEvent) throws IOException {
        if (Launch.stage == Launch.primary) {
            Parent root = FXMLLoader.load(getClass().getResource("/View/register.fxml"));
            Launch.newWindow(root, new Stage());
        }
    }

    public void login(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/home.fxml"));
        Launch.stage.close();
        if (Launch.stage != Launch.primary) {
            Launch.stage = Launch.primary;
            Launch.stage.close();
        }
        Launch.newWindow(root, new Stage());
    }
}
