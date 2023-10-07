package codenamex.smc;

import io.github.palexdev.materialfx.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.close();
    }

    public void loginSubmit(ActionEvent e) throws  IOException{

    }
    @FXML
    private Label passwordChangeTextfield;
    private Label afterLoginText;
    private TextField username;
    private MFXPasswordField password;
    public void loginSubmitButton(ActionEvent e) throws IOException{
        if(username.getText().isBlank() && password.getText().isBlank())
        {
            afterLoginText.setStyle("-fx-text-fill: red;");
            afterLoginText.setText("Please enter your credentials");
        }
    }
    public void ForgotPasswordSubmit(ActionEvent e) throws IOException{
//        TextField passwordChangeTextfield = new TextField();
        passwordChangeTextfield.setText("Check your mail, after confirmation the password will be changed");
    }
}
