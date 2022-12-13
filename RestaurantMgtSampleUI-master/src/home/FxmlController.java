package home;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static home.Main.mainStage;

public class FxmlController {
    private double x, y;
    public void Show(String Data) throws Exception {
        Stage primaryStage = mainStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Data));
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root));

        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {

            mainStage.setX(event.getScreenX() - x);
            mainStage.setY(event.getScreenY() - y);

        });
        }
    }
