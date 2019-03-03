package Controllers;

import application.Launch;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    public HBox topBar;
    public Label currentDate;
    public Label welcome;
    public ProgressIndicator dayProgress;
    public Label daysLeft;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Launch.makeStageDraggable(topBar);

        SimpleDateFormat date = new SimpleDateFormat("EEEEE, dd MMMMM yyyy");
        currentDate.setText(date.format(new Date()));

        welcome.setText("Welcome, " + Launch.getCurrentUser().getFirstName());

        /*int remaining = Launch.getCurrentUser().getGoals().get(0).getDaysRemaining();
        double percentage = 1;
        if (remaining != 0) {
            percentage -= remaining / Launch.getCurrentUser().getGoals().get(0).getStartDays();
        }

        dayProgress.setProgress(percentage);
        daysLeft.setText(String.valueOf(Launch.getCurrentUser().getGoals().get(0).getDaysRemaining()));*/
    }

    public void minimise(MouseEvent mouseEvent) {
        Launch.stage.setIconified(true);
    }

    public void close(MouseEvent mouseEvent) {
        System.exit(0);
    }

    public void toDailyLog(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/dailyLog.fxml"));
        Launch.stage.getScene().setRoot(root);
    }

    public void toGoals(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/goals.fxml"));
        Launch.stage.getScene().setRoot(root);
    }

    public void toHome(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/home.fxml"));
        Launch.stage.getScene().setRoot(root);
    }

    public void toGroups(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/groups.fxml"));
        Launch.stage.getScene().setRoot(root);
    }

    public void toSettings(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/settings.fxml"));
        Launch.stage.getScene().setRoot(root);
    }
}
