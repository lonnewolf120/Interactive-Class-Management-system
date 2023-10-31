/*package codenamex.smc;

import codenamex.smc.sceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import codenamex.smc.Database.DatabaseManager;
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

            ResultSet result = prepare.executeQuery();

            if(result.next())
                sceneController.switchControlsAction("homepage/homepage-tasks-dark.fxml",e);
//                  switchControlsAction("Dashboard.fxml",e);
            else
                afterLoginText.setText("Login Credentials doesn't match. Try again😅");
        }
        catch (Exception exc){exc.printStackTrace();}
    }

    public void loginSubmitButton(ActionEvent e) throws IOException {
        userEmpty.setVisible(username.getText().isBlank());
        passEmpty.setVisible(password.getText().isBlank());
        if(username.getText().isBlank() || password.getText().isBlank())
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
}
*/