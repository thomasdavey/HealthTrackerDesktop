package Controllers;

import DBClasses.DBAdd;
import DBClasses.LoadUser;
import Model.Group;
import Model.Message;
import Model.User;
import application.Launch;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GroupsController implements Initializable {

    public HBox topBar;
    public ScrollPane scrollPane;
    public TextField message;
    public ScrollPane messageDisplay;

    private Group current;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Launch.makeStageDraggable(topBar);

        ArrayList<User> users = new ArrayList<>();
        users.add(Launch.getCurrentUser());

        current = new Group(users,"Test");

        ArrayList<Message> messages = DBAdd.getMessages(current.getGroupName());

        VBox v = new VBox();
        v.getChildren().clear();
        v.setFillWidth(true);
        for (int i = 0; i < 1; i++) {
            VBox temp = new VBox();
            Label a = new Label(current.getGroupName());
            a.getStyleClass().add("groupName");
            Label b;
            if (messages.size() > 0) {
                b = new Label(messages.get(messages.size() - 1).getMessage());
            } else {
                b = new Label("");
            }
            b.getStyleClass().add("groupInfo");
            temp.getStyleClass().add("groupBox");
            temp.getChildren().add(a);
            temp.getChildren().add(b);
            v.getChildren().add(temp);
        }
        scrollPane.setContent(v);

        VBox messageView = new VBox();
        messageView.setStyle("-fx-padding: 0px 0px 15px 0px");
        messageView.setMaxWidth(500);
        messageView.getChildren().clear();
        for (int i = 0; i < messages.size(); i++) {
            Message mess = messages.get(i);
            HBox wrap = new HBox();
            wrap.setPrefWidth(500);
            wrap.setMaxWidth(500);
            wrap.setMinWidth(500);
            wrap.getChildren().clear();
            VBox message = new VBox();
            message.getStyleClass().add("messageWrapper");
            Label a = new Label(mess.getName());
            a.getStyleClass().add("messageName");
            String messs = mess.getMessage();
            Label b = new Label(mess.getMessage());
            b.getStyleClass().add("message");
            a.setWrapText(true);
            b.setWrapText(true);
            message.getChildren().clear();
            if (i == 0) {
                message.getChildren().add(a);
            } else if (!messages.get(i-1).getUser().equals(messages.get(i).getUser())) {
                message.getChildren().add(a);
            } else {
                message.setStyle("-fx-padding: 3px 5px 0px 15px");
            }
            message.getChildren().add(b);
            wrap.getChildren().add(message);
            if (!mess.getUser().equals(Launch.getCurrentUser().getUserName())) {
                b.getStyleClass().clear();
                b.getStyleClass().add("messageOther");
                wrap.setAlignment(Pos.TOP_RIGHT);
                message.setAlignment(Pos.TOP_RIGHT);
            }
            messageView.getChildren().add(wrap);
        }
        messageDisplay.vvalueProperty().bind(messageView.heightProperty());

        messageDisplay.setContent(messageView);
    }

    public void minimise(MouseEvent mouseEvent) {
        Launch.primary.setIconified(true);
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

    public void onEnter(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            send();
        }
    }

    private void send() throws IOException {
        if (message.getText().equals("")) {
            return;
        }
        DBAdd.addMesage(Launch.getCurrentUser().getUserName(),current,message.getText());
        message.clear();
        message.setStyle("-fx-background-color: transparent");
        Parent root = FXMLLoader.load(getClass().getResource("/View/groups.fxml"));
        Launch.stage.getScene().setRoot(root);
    }

    public void sendClicked(MouseEvent mouseEvent) throws IOException {
        send();
    }
}
