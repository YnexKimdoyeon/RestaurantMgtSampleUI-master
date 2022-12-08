package home;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

public class MainViewController implements Initializable {
    @FXML
    private Circle btnClose; // 창닫기
    @FXML
    private Label UserName;
    @FXML
    private Label weather;

    @FXML
    private WebView MyView ;
    private WebEngine webengine ;
    @FXML
    private Button btnBack;
    @FXML
    private Button SignOut;
    @FXML
    private Button GoPrint;
    @FXML
    private Button GoCustom;
    @FXML
    private Button SelectBetween;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.webengine = this.MyView.getEngine();
        this.webengine.load("https://lms.sunmoon.ac.kr/ilos/main/main_form.acl");;
        UserName.setText(Session.getUserId());
        weather.setText(Session.getWeather());
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        if (event.getSource() == btnBack) {
            WebHistory history = this.webengine.getHistory();
            int idx = history.currentIndexProperty().get();
            if (idx > 0) {
                history.go(-1);
            }
        }
        if (event.getSource() == SignOut){
            new FxmlController().Show("../MyFxml/Login.fxml");
        }
        if (event.getSource() == GoPrint){
            new FxmlController().Show("../MyFxml/PrintSchedule.fxml");
        }
        if (event.getSource() == GoCustom){
            new FxmlController().Show("../MyFxml/CheckBoxSchedule.fxml");
        }
        if (event.getSource() == SelectBetween){
            new FxmlController().Show("../MyFxml/SelectSchedule.fxml");
        }
    }

    @FXML
    private void handleMouseEvent(MouseEvent event) {
        if (event.getSource() == btnClose) {
            System.exit(0);
        }
    }


}