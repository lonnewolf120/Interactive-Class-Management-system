package codenamex.smc.Database;

import javafx.event.ActionEvent;

import codenamex.smc.sceneController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static codenamex.smc.Database.DatabaseManager.connectDB;

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
    private static int userId;
    public void loginAdmin(ActionEvent e) {
        userId = -1; // Initialize with an invalid value if the login is unsuccessful

        String sql_command = "SELECT user_id FROM login_info WHERE username = ? AND password = ?;";
        Connection connect = connectDB();

        try {
            PreparedStatement prepare = connect.prepareStatement(sql_command);
            prepare.setString(1, username.getText());
            prepare.setString(2, password.getText());

            ResultSet result = prepare.executeQuery();

            if (result.next()) {
                userId = result.getInt("user_id"); // Get the user_id if the login is successful
                sceneController.switchControlsAction("homepage/homepage-tasks.fxml", e);
            } else {
                afterLoginText.setText("Login Credentials don't match. Try again😅");
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }
    public static int getUserId(){return userId;}

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
