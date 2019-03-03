package Controllers;

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

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
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

        String[] dates = new String[7];
        dates[0] = "Today";
        for (int i = 1; i < 7; i++) {
            cal.add(Calendar.DATE, -1);
            date = cal.getTime();
            dates[i] = dateFormat.format(date);
        }

        series = new XYChart.Series<>();

        chart.getData().clear();
        int count = 6;

        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            series.getData().add(new XYChart.Data<>(dates[count--], random.nextInt(600) + 2500));
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
