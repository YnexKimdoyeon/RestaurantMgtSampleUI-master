package home;

import java.io.IOException;
import java.net.URL;

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

import static home.SelectScheduleController.*;


public class PrintSelectScheduleController implements Initializable {
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
        StudentName.setText(Session.getUsername());
        ResultRoom.setText(String.valueOf(SelectUserRoom.size()));
        Node[] nodes = new Node[SelectUserRoom.size()];
        for (int k =0; k < nodes.length; k++)
        {
            final int c = k;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../MyFxml/Item.fxml"));
            try {
                ItemsController itemController = new ItemsController(SelectUserRoomDay , SelectUserRoomTime ,SelectUserRoom.get(k));
                loader.setController(itemController);

                nodes[k] = loader.load();
                nodes[k].setOnMouseEntered(event -> {
                    nodes[c].setStyle("-fx-background-color : #EBE8F9");
                });
                pnItems.getChildren().add(nodes[k]);
            } catch (IOException e) {
                e.printStackTrace();
            }
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