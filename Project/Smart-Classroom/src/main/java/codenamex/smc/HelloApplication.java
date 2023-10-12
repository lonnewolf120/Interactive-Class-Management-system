package codenamex.smc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {

    private double x=0.0, y=0.0;
    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        Scene scene = new Scene(root);

/*    Moveable window option
        x=stage.getX();
        y=stage.getY();
        root.setOnMousePressed((MouseEvent e)->{
            x= stage.getX();
            y= stage.getY();
        });
        root.setOnMouseDragged((MouseEvent e)->{
            stage.setX(e.getSceneX()-x);
            stage.setY(e.getSceneY()-y);
            stage.setOpacity(.8);
        });
        root.setOnMouseReleased((MouseEvent e)->{
            stage.setOpacity(1);
        });
 */
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}