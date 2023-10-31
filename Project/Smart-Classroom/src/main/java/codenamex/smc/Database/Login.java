package codenamex.smc.Database;

import javafx.event.ActionEvent;

import codenamex.smc.sceneController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import codenamex.smc.sceneController;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {

    @FXML
    private Label passwordChangeTextfield;
    @FXML
    private Label afterLoginText;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private ImageView userEmpty;
    @FXML
    private ImageView passEmpty;
    @FXML
    private Button submitButton;
    public void loginAdmin(ActionEvent e)
    {
        String sql_command ="SELECT * FROM login_info WHERE username = ? AND password = ?;";
        Connection connect = DatabaseManager.connectDB();
        try
        {
//            assert connect != null;
            PreparedStatement prepare = connect.prepareStatement(sql_command);

            prepare.setString(1,username.getText());
            prepare.setString(2,password.getText());
//            prepare.setString(3,password.getText());

            ResultSet result = prepare.executeQuery();

            if(result.next()) {
//                sceneController.switchControlsAction("homepage/homepage-tasks-dark.fxml",e);
                sceneController.switchControlsAction("homepage/homepage-tasks.fxml", e);
//                  switchControlsAction("Dashboard.fxml",e);

            }
            else
                afterLoginText.setText("Login Credentials doesn't match. Try again😅");
        }
        catch (Exception exc){exc.printStackTrace();}
    }

    public void loginSubmitButton(ActionEvent e) throws IOException {
        userEmpty.setVisible(username.getText().isEmpty());
        passEmpty.setVisible(password.getText().isEmpty());
        if(username.getText().isEmpty() || password.getText().isEmpty())
        {
            afterLoginText.setStyle("-fx-text-fill: red;");
            afterLoginText.setText("Please enter your credentials");
        }
        else loginAdmin(e);
    }
    public void ForgotPasswordSubmit(ActionEvent e) throws IOException{
//        TextField passwordChangeTextfield = new TextField();
        passwordChangeTextfield.setText("Check your mail, after confirmation the password will be changed");
    }

    public void closeButton(ActionEvent e) {
        sceneController.closeButton(e);
    }

    public void switchToFP(MouseEvent e) throws IOException {
        sceneController.switchToFP(e);
    }

    public void switchToSignup(MouseEvent e) throws IOException {
        sceneController.switchToSignup(e);
    }
}
