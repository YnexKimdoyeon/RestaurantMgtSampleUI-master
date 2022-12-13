package home;

import javafx.scene.control.Alert;

public class AlterController {
    public AlterController(String value){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("안내창");
        alert.setHeaderText(value);
        alert.showAndWait().ifPresent(rs -> {
        });

    }
}
