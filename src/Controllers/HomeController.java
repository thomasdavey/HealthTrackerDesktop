package Controllers;

import DBClasses.DBAdd;
import DBClasses.LoadUser;
import Model.Calculator;
import Model.User;
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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    public HBox topBar;
    public Label currentDate;
    public Label welcome;
    public ProgressIndicator dayProgress;
    public Label daysLeft;
    public ProgressIndicator calorieProgress;
    public Label caloriesLeft;
    public ProgressIndicator goalProgress;
    public Label goalLeft;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Launch.makeStageDraggable(topBar);

        SimpleDateFormat date = new SimpleDateFormat("EEEEE, dd MMMMM yyyy");
        currentDate.setText(date.format(new Date()));

        welcome.setText("Welcome, " + Launch.getCurrentUser().getFirstName());



        int todayCalories = 0;
        int allowedCalories;

        User current = Launch.getCurrentUser();

        double metaRate = Calculator.metabolicRate(current.getWeight(),
                current.getHeight(), current.getAge());
        int extremity = Calculator.getWeightLossExtremity(current.getGoals().get(0));

        allowedCalories = Calculator.targetCalories(metaRate, current.getActivityLevel(), extremity);

        java.sql.Date today = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        try {
            todayCalories = LoadUser.getCaloriesByDate(Launch.getCurrentUser().getUserName(), today);
        } catch (SQLException e) {
            DBAdd.addCalories(Launch.getCurrentUser().getUserName(), today, todayCalories);
        }
        caloriesLeft.setText(String.valueOf(allowedCalories-todayCalories));
        double progress = 1;
        if (todayCalories > allowedCalories) {
            progress = (allowedCalories-todayCalories) / allowedCalories;
        }
        calorieProgress.setProgress(progress);



        int remaining = Launch.getCurrentUser().getGoals().get(0).getDaysRemaining();
        double percentage = 1;
        if (remaining != 0) {
            percentage -= remaining / Launch.getCurrentUser().getGoals().get(0).getStartDays();
        }
        dayProgress.setProgress(percentage);
        daysLeft.setText(String.valueOf(Launch.getCurrentUser().getGoals().get(0).getDaysRemaining()));

        double percentLost = 0;
        if (current.getGoals().get(0).getPercentLost() > 0) {
            percentLost = current.getGoals().get(0).getPercentLost();
        }
        goalProgress.setProgress(percentLost/100);
        goalLeft.setText((int)percentLost + "%");

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
