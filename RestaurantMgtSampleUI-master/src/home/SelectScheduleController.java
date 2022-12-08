package home;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;


public class SelectScheduleController implements Initializable {
    @FXML
    private Circle btnClose; // 창닫기
    @FXML
    private Label UserName;
    @FXML
    private Button SignOut;
    @FXML
    private Button Home;
    @FXML
    private Button GoPrint;
    @FXML
    private Button GoCustom;
    @FXML
    private Button clientroom;
    @FXML
    private ChoiceBox time1;
    @FXML
    public ChoiceBox time2;
    @FXML
    private ToggleGroup day;
    @FXML
    private ToggleGroup place;
    @FXML
    private ToggleGroup floor;
    public static ArrayList<String> SelectUserRoom = null;
    public static String SelectUserRoomTime = null;
    public static String SelectUserRoomDay = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UserName.setText(Session.getUserId());
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
        if (event.getSource() == GoCustom){
            new FxmlController().Show("../MyFxml/CheckBoxSchedule.fxml");
        }


        if (event.getSource() == clientroom) {
            try{
                Map<String,String> MyPlace = new HashMap<>();
                MyPlace.put("인문관" , "inmun");
                MyPlace.put("공학관" , "gonghak");
                MyPlace.put("본관" , "bon");

                String selectedTime1 = time1.getSelectionModel().getSelectedItem().toString().replace("교시" , "");
                String selectedTime2=  time2.getSelectionModel().getSelectedItem().toString().replace("교시" , "");;
                String sday = ((ToggleButton) day.getSelectedToggle()).getText();
                sday = sday + "요일";

                String splace = ((ToggleButton) place.getSelectedToggle()).getText();
                splace = MyPlace.get(splace);

                String sfloor = ((ToggleButton) floor.getSelectedToggle()).getText().replace("층","");
                SelectUserRoom = new SelectRoom().PrintRoom(sday ,sfloor ,splace , Integer.parseInt(selectedTime1) , Integer.parseInt(selectedTime2) , 0);
                SelectUserRoomTime = selectedTime1 + "~" + selectedTime2 + "교시";
                SelectUserRoomDay = sday;
                if (SelectUserRoom.size() == 0){
                    new AlterController("해당 시간에 공강인 강의실이 존재하지 않습니다!");
                }
                else{
                    new FxmlController().Show("../MyFxml/PrintSelectSchedule.fxml");
                }
            }
            catch (Exception ignored){
                new AlterController("값을 모두 선택해주세요.");
            }

        }


    }

    @FXML
    private void handleMouseEvent(MouseEvent event) {
        if (event.getSource() == btnClose) {
            System.exit(0);
        }
    }


}