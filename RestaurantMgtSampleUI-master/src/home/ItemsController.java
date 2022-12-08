package home;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ItemsController implements Initializable {


    @FXML
    public Label RoomNumberValue;
    @FXML
    public Label StartTimeValue;
    @FXML
    public Label DayValue;

    private final String Day;
    private final String StartTime;

    private final String RoomNumber;

    public ItemsController(String Day , String StartTime , String RoomNumber) {
        // TODO: 오브젝트를 받습니다.
        this.Day = Day;
        this.StartTime = StartTime;
        this.RoomNumber = RoomNumber;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DayValue.setText(Day);
        StartTimeValue.setText(StartTime);
        RoomNumberValue.setText(RoomNumber);
    }
}