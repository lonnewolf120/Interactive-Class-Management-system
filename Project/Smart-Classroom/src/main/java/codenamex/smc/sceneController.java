package codenamex.smc;

//import io.github.palexdev.materialfx.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class sceneController {
    private Parent root;
    private Stage stage;
    private Scene scene;

    public void switchControls(MouseEvent e, String view) throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(view)));
        scene = new Scene(root);
        stage= (Stage) ((Node)e.getSource()).getScene().getWindow();
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    public void switchControlsAction(String view, ActionEvent e) throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(view)));
        scene = new Scene(root);
        stage= (Stage) ((Node)e.getSource()).getScene().getWindow();
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    public void switchToSignup(MouseEvent e) throws IOException {
        switchControls(e,"signup.fxml");
    }
    public void switchToSignupA(ActionEvent e) throws IOException {
       switchControlsAction("signup.", e);
    }
    public void switchToLoginA(ActionEvent e) throws IOException {
        switchControlsAction("login.fxml",e);
    }
    public void switchToLogin(MouseEvent e) throws IOException {
        switchControls(e,"login.fxml");
    }
    public void switchToFP(MouseEvent e) throws IOException {
        switchControls(e,"forgot-password.fxml");
    }
    public void closeButton(ActionEvent e){
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.close();
    }

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
                switchControlsAction("homepage/homepage-tasks-dark.fxml",e);
            else
                afterLoginText.setText("Login Credentials doesn't match. Try again😅");
        }
        catch (Exception exc){exc.printStackTrace();}
    }
    public void loginSubmitButton(ActionEvent e) throws IOException{
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
