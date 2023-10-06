package codenamex.smc;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class sceneController {
    private Parent root;
    private Stage stage;
    private Scene scene;

    public void switchToSignup(MouseEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("signup.fxml")));
        scene = new Scene(root);
        stage= (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(scene);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    public void switchToSignupA(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("signup.fxml")));
        scene = new Scene(root);
        stage= (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(scene);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    public void switchToLoginA(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        scene = new Scene(root);
        stage= (Stage) ((Node)e.getSource()).getScene().getWindow();
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }public void switchToLogin(MouseEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        scene = new Scene(root);
        stage= (Stage) ((Node)e.getSource()).getScene().getWindow();
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public void switchToFP(MouseEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("forgot-password.fxml")));
        scene = new Scene(root);
        stage= (Stage) ((Node)e.getSource()).getScene().getWindow();
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public void closeButton(ActionEvent e) throws IOException {
        stage= (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.close();
    }
}
