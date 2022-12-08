package home;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CheckBoxController implements Initializable {
    @FXML
    private Circle btnClose;
    @FXML
    private Button clientroom;
    @FXML
    private Button SignOut;
    @FXML
    private Button GoPrint;
    @FXML
    private Button GoCustom;
    @FXML
    private Button Home;
    @FXML
    private Button SelectBetween;

    @FXML
    private Label UserName;


    // 월요일 //
    @FXML
    private CheckBox monday1;
    @FXML
    private CheckBox monday2;
    @FXML
    private CheckBox monday3;
    @FXML
    private CheckBox monday4;
    @FXML
    private CheckBox monday5;
    @FXML
    private CheckBox monday6;
    @FXML
    private CheckBox monday7;
    @FXML
    private CheckBox monday8;
    // 월요일 //

    // 화요일 //
    @FXML
    private CheckBox tuesday1;
    @FXML
    private CheckBox tuesday2;
    @FXML
    private CheckBox tuesday3;
    @FXML
    private CheckBox tuesday4;
    @FXML
    private CheckBox tuesday5;
    @FXML
    private CheckBox tuesday6;
    @FXML
    private CheckBox tuesday7;
    @FXML
    private CheckBox tuesday8;
    // 화요일 //

    // 수요일 //
    @FXML
    private CheckBox wednesday1;
    @FXML
    private CheckBox wednesday2;
    @FXML
    private CheckBox wednesday3;
    @FXML
    private CheckBox wednesday4;
    @FXML
    private CheckBox wednesday5;
    @FXML
    private CheckBox wednesday6;
    @FXML
    private CheckBox wednesday7;
    @FXML
    private CheckBox wednesday8;
    // 수요일 //

    // 목요일 //
    @FXML
    private CheckBox thursday1;
    @FXML
    private CheckBox thursday2;
    @FXML
    private CheckBox thursday3;
    @FXML
    private CheckBox thursday4;
    @FXML
    private CheckBox thursday5;
    @FXML
    private CheckBox thursday6;
    @FXML
    private CheckBox thursday7;
    @FXML
    private CheckBox thursday8;
    // 목요일 //

    // 금요일 //
    @FXML
    private CheckBox friday1;
    @FXML
    private CheckBox friday2;
    @FXML
    private CheckBox friday3;
    @FXML
    private CheckBox friday4;
    @FXML
    private CheckBox friday5;
    @FXML
    private CheckBox friday6;
    @FXML
    private CheckBox friday7;
    @FXML
    private CheckBox friday8;
    // 금요일 //
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UserName.setText(Session.getUserId());
        ArrayList<String> UserSelectSession = new DataBase().UserSchedulePrintList();
        if (UserSelectSession.contains("월요일 1 1")) {
            monday1.setSelected(true);
        }if (UserSelectSession.contains("월요일 2 2")) {
            monday2.setSelected(true);
        }if (UserSelectSession.contains("월요일 3 3")) {
            monday3.setSelected(true);
        }if (UserSelectSession.contains("월요일 4 4")) {
            monday4.setSelected(true);
        }if (UserSelectSession.contains("월요일 5 5")) {
            monday5.setSelected(true);
        }if (UserSelectSession.contains("월요일 6 6")) {
            monday6.setSelected(true);
        }if (UserSelectSession.contains("월요일 7 7")) {
            monday7.setSelected(true);
        }if (UserSelectSession.contains("월요일 8 8")) {
            monday8.setSelected(true);

        }if (UserSelectSession.contains("화요일 1 1")) {
            tuesday1.setSelected(true);
        }if (UserSelectSession.contains("화요일 2 2")) {
            tuesday2.setSelected(true);
        }if (UserSelectSession.contains("화요일 3 3")) {
            tuesday3.setSelected(true);
        }if (UserSelectSession.contains("화요일 4 4")) {
            tuesday4.setSelected(true);
        }if (UserSelectSession.contains("화요일 5 5")) {
            tuesday5.setSelected(true);
        }if (UserSelectSession.contains("화요일 6 6")) {
            tuesday6.setSelected(true);
        }if (UserSelectSession.contains("화요일 7 7")) {
            tuesday7.setSelected(true);
        }if (UserSelectSession.contains("화요일 8 8")) {
            tuesday8.setSelected(true);

        }if (UserSelectSession.contains("수요일 1 1")) {
            wednesday1.setSelected(true);
        }if (UserSelectSession.contains("수요일 2 2")) {
            wednesday2.setSelected(true);
        }if (UserSelectSession.contains("수요일 3 3")) {
            wednesday3.setSelected(true);
        }if (UserSelectSession.contains("수요일 4 4")) {
            wednesday4.setSelected(true);
        }if (UserSelectSession.contains("수요일 5 5")) {
            wednesday5.setSelected(true);
        }if (UserSelectSession.contains("수요일 6 6")) {
            wednesday6.setSelected(true);
        }if (UserSelectSession.contains("수요일 7 7")) {
            wednesday7.setSelected(true);
        }if (UserSelectSession.contains("수요일 8 8")) {
            wednesday8.setSelected(true);

        }if (UserSelectSession.contains("목요일 1 1")) {
            thursday1.setSelected(true);
        }if (UserSelectSession.contains("목요일 2 2")) {
            thursday2.setSelected(true);
        }if (UserSelectSession.contains("목요일 3 3")) {
            thursday3.setSelected(true);
        }if (UserSelectSession.contains("목요일 4 4")) {
            thursday4.setSelected(true);
        }if (UserSelectSession.contains("목요일 5 5")) {
            thursday5.setSelected(true);
        }if (UserSelectSession.contains("목요일 6 6")) {
            thursday6.setSelected(true);
        }if (UserSelectSession.contains("목요일 7 7")) {
            thursday7.setSelected(true);
        }if (UserSelectSession.contains("목요일 8 8")) {
            thursday8.setSelected(true);

        }if (UserSelectSession.contains("금요일 1 1")) {
            friday1.setSelected(true);
        }if (UserSelectSession.contains("금요일 2 2")) {
            friday2.setSelected(true);
        }if (UserSelectSession.contains("금요일 3 3")) {
            friday3.setSelected(true);
        }if (UserSelectSession.contains("금요일 4 4")) {
            friday4.setSelected(true);
        }if (UserSelectSession.contains("금요일 5 5")) {
            friday5.setSelected(true);
        }if (UserSelectSession.contains("금요일 6 6")) {
            friday6.setSelected(true);
        }if (UserSelectSession.contains("금요일 7 7")) {
            friday7.setSelected(true);
        }if (UserSelectSession.contains("금요일 8 8")) {
            friday8.setSelected(true);
        }

    }

    @FXML
    private void handleMouseEvent(MouseEvent event) {
        if (event.getSource() == btnClose) {
            System.exit(0);
        }
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        if (event.getSource() == SignOut){
            new FxmlController().Show("../MyFxml/Login.fxml");
        }
        if (event.getSource() == Home){
            new FxmlController().Show("../MyFxml/Home.fxml");
        }
        if (event.getSource() == GoPrint){
            new FxmlController().Show("../MyFxml/PrintSchedule.fxml");
        }
        if (event.getSource() == SelectBetween){
            new FxmlController().Show("../MyFxml/SelectSchedule.fxml");
        }
        if (event.getSource().equals(clientroom)) {
            ArrayList<String> GapSelectSchedule = new ArrayList<>();
            if (monday1.isSelected()){
                GapSelectSchedule.add("월요일 1 1");
            }
            if (monday2.isSelected()){
                GapSelectSchedule.add("월요일 2 2");
            }
            if (monday3.isSelected()){
                GapSelectSchedule.add("월요일 3 3");
            }
            if (monday4.isSelected()){
                GapSelectSchedule.add("월요일 4 4");
            }
            if (monday5.isSelected()){
                GapSelectSchedule.add("월요일 5 5");
            }
            if (monday6.isSelected()){
                GapSelectSchedule.add("월요일 6 6");
            }
            if (monday7.isSelected()){
                GapSelectSchedule.add("월요일 7 7");
            }
            if (monday8.isSelected()){
                GapSelectSchedule.add("월요일 8 8");
            }

            if (tuesday1.isSelected()){
                GapSelectSchedule.add("화요일 1 1");
            }
            if (tuesday2.isSelected()){
                GapSelectSchedule.add("화요일 2 2");
            }
            if (tuesday3.isSelected()){
                GapSelectSchedule.add("화요일 3 3");
            }
            if (tuesday4.isSelected()){
                GapSelectSchedule.add("화요일 4 4");
            }
            if (tuesday5.isSelected()){
                GapSelectSchedule.add("화요일 5 5");
            }
            if (tuesday6.isSelected()){
                GapSelectSchedule.add("화요일 6 6");
            }
            if (tuesday7.isSelected()){
                GapSelectSchedule.add("화요일 7 7");
            }
            if (tuesday8.isSelected()){
                GapSelectSchedule.add("화요일 8 8");
            }

            if (wednesday1.isSelected()){
                GapSelectSchedule.add("수요일 1 1");
            }
            if (wednesday2.isSelected()){
                GapSelectSchedule.add("수요일 2 2");
            }
            if (wednesday3.isSelected()){
                GapSelectSchedule.add("수요일 3 3");
            }
            if (wednesday4.isSelected()){
                GapSelectSchedule.add("수요일 4 4");
            }
            if (wednesday5.isSelected()){
                GapSelectSchedule.add("수요일 5 5");
            }
            if (wednesday6.isSelected()){
                GapSelectSchedule.add("수요일 6 6");
            }
            if (wednesday7.isSelected()){
                GapSelectSchedule.add("수요일 7 7");
            }
            if (wednesday8.isSelected()){
                GapSelectSchedule.add("수요일 8 8");
            }

            if (thursday1.isSelected()){
                GapSelectSchedule.add("목요일 1 1");
            }
            if (thursday2.isSelected()){
                GapSelectSchedule.add("목요일 2 2");
            }
            if (thursday3.isSelected()){
                GapSelectSchedule.add("목요일 3 3");
            }
            if (thursday4.isSelected()){
                GapSelectSchedule.add("목요일 4 4");
            }
            if (thursday5.isSelected()){
                GapSelectSchedule.add("목요일 5 5");
            }
            if (thursday6.isSelected()){
                GapSelectSchedule.add("목요일 6 6");
            }
            if (thursday7.isSelected()){
                GapSelectSchedule.add("목요일 7 7");
            }
            if (thursday8.isSelected()){
                GapSelectSchedule.add("목요일 8 8");
            }

            if (friday1.isSelected()){
                GapSelectSchedule.add("금요일 1 1");
            }
            if (friday2.isSelected()){
                GapSelectSchedule.add("금요일 2 2");
            }
            if (friday3.isSelected()){
                GapSelectSchedule.add("금요일 3 3");
            }
            if (friday4.isSelected()){
                GapSelectSchedule.add("금요일 4 4");
            }
            if (friday5.isSelected()){
                GapSelectSchedule.add("금요일 5 5");
            }
            if (friday6.isSelected()){
                GapSelectSchedule.add("금요일 6 6");
            }
            if (friday7.isSelected()){
                GapSelectSchedule.add("금요일 7 7");
            }
            if (friday8.isSelected()){
                GapSelectSchedule.add("금요일 8 8");
            }
            String[] array = GapSelectSchedule.toArray(new String[GapSelectSchedule.size()]);
            new DataBase().UserScheduleAdd(array);
        }
    }


    public void clickCheckBox(ActionEvent actionEvent) {

    }


}
