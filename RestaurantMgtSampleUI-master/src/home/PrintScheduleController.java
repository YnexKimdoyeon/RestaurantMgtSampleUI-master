package home;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;


public class PrintScheduleController implements Initializable {
    @FXML
    private Circle btnClose; // 창닫기
    @FXML
    private Label UserName;
    @FXML
    private Label StudentName;
    @FXML
    private Label ResultRoom;
    @FXML
    private Button SignOut;
    @FXML
    private Button Home;
    @FXML
    private Button GoPrint;
    @FXML
    private Button GoCustom;
    @FXML
    private Button SelectBetween;

    @FXML
    private VBox pnItems = null;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UserName.setText(Session.getUserId());
        StudentName.setText(Session.getUsername());
        ArrayList<String> ListRoom = null;
        Node[] nodes = new Node[1000];
        try {
            ListRoom = new DataBase().UserSchedulePrint();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        int a = 0;
        for (int i = 0; i < ListRoom.size(); i++) {
            String[] RoomSplit = ListRoom.get(i).split(",");
            for (int k =1; k < RoomSplit.length-1; k++)
            {
                final int c = a;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../MyFxml/Item.fxml"));
                try {
                    ItemsController itemController = new ItemsController(RoomSplit[0] , RoomSplit[1] , RoomSplit[k+1]);
                    loader.setController(itemController);

                    nodes[a] = loader.load();
                    nodes[a].setOnMouseEntered(event -> {
                        nodes[c].setStyle("-fx-background-color : #EBE8F9");
                    });
                    pnItems.getChildren().add(nodes[a]);
                    a +=1;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        ResultRoom.setText(String.valueOf(a));
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        if (event.getSource() == SignOut){
            new FxmlController().Show("../MyFxml/Login.fxml");
        }
        if (event.getSource() == Home){
            new FxmlController().Show("../MyFxml/Home.fxml");
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