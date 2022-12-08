package home;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class SignUpController {
    @FXML
    private Circle btnClose; // 창닫기

    @FXML
    private JFXButton Submit;
    @FXML
    private JFXButton BackBtn;

    @FXML
    private TextField SignupName;
    @FXML
    private TextField SignupNumber;
    @FXML
    private TextField SignupId;
    @FXML
    private TextField SignupPw;


    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        if (event.getSource().equals(Submit)) {
            if (SignupName.getText().isEmpty() || SignupNumber.getText().isEmpty() || SignupId.getText().isEmpty() || SignupPw.getText().isEmpty()) {
                new AlterController("값이 모두 채워지지 않았습니다.");
            } else {
                DataBase db = new DataBase();
                if (db.signup(SignupName.getText(), SignupNumber.getText(), SignupId.getText(), SignupPw.getText()) == 1){
                    new FxmlController().Show("../MyFxml/Login.fxml");
                }
            }
        }
        if (event.getSource().equals(BackBtn)){
            new FxmlController().Show("../MyFxml/Login.fxml");
        }
    }
    @FXML
    private void handleMouseEvent(MouseEvent event) {
        if (event.getSource() == btnClose) {
            System.exit(0);
        }
    }


}