package home;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;


public class LoginBackup {
    @FXML
    private Circle btnClose; // 창닫기

    @FXML
    private JFXButton LogInBtn;
    @FXML
    private JFXButton SignUp;

    @FXML
    private TextField login_name;
    @FXML
    private TextField login_number;
    @FXML
    private TextField login_id;
    @FXML
    private TextField login_pw;

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        if (event.getSource() == LogInBtn) {
            if (login_name.getText().isEmpty() || login_number.getText().isEmpty() || login_id.getText().isEmpty() || login_pw.getText().isEmpty()) {
                new AlterController("값이 모두 채워지지 않았습니다.");
            }
            else{
                DataBase Db = new DataBase();
                if (Db.login(login_name.getText() , login_number.getText() ,login_id.getText() , login_pw.getText()) == 1){
                    Session.setUsername(login_name.getText());
                    Session.setUserId(login_id.getText());
                    new FxmlController().Show("../MyFxml/Home.fxml");
                }
                else{
                    new AlterController("해당하는 정보를 가진 아이디가 존재하지 않습니다.");

                }
            }
        }
        if(event.getSource() == SignUp) {
            new FxmlController().Show("../MyFxml/SignUp.fxml");
        }
    }
    @FXML
    private void handleMouseEvent(MouseEvent event) {
        if (event.getSource() == btnClose) {
            System.exit(0);
        }
    }


}