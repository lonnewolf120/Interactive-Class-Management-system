package codenamex.smc;
import codenamex.smc.ViewStyles;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {

//    private double x=0.0, y=0.0;
    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("/codenamex/smc/login.fxml"))));

        stage.initStyle(StageStyle.TRANSPARENT);
        ViewStyles.MoveAbleWindow(stage,root);   //Moveable window option
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}