package Controllers;

import DBClasses.LoadUser;
import application.Launch;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import org.h2.jdbc.JdbcSQLException;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;

public class GoalsController implements Initializable {

    public HBox topBar;
    public LineChart<String, Number> chart;
    public Line line;
    public NumberAxis numberAxis;
    private XYChart.Series<String, Number> series;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Launch.makeStageDraggable(topBar);
        createChart();
    }

    private void createChart() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE dd");
        Calendar cal = Calendar.getInstance();
        Date date;

        String[] dateStrings = new String[7];
        java.sql.Date[] dates = new java.sql.Date[7];
        for (int i = 0; i < 7; i++) {
            cal.add(Calendar.DATE, -1);
            date = cal.getTime();
            dates[i] = new java.sql.Date(date.getYear(),date.getMonth(),date.getDate());
            dateStrings[i] = dateFormat.format(date);
        }

        series = new XYChart.Series<>();
        chart.getData().clear();
        int count = 6;

        for (int i = 0; i < 7; i++) {
            try {
                int calories = LoadUser.getCaloriesByDate(Launch.getCurrentUser().getUserName(), dates[count]);
                series.getData().add(new XYChart.Data<>(dateStrings[count], calories));
                count--;
            } catch (SQLException e) {
                series.getData().add(new XYChart.Data<>(dateStrings[count], 0));
                count--;
            }
        }

        chart.getData().add(series);
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
