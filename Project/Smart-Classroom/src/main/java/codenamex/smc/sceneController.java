package codenamex.smc;

//import codenamex.smc.Login;
//import codenamex.smc.RegisterUser;
//import io.github.palexdev.materialfx.controls.*;
import codenamex.smc.Database.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class sceneController {
    private static Parent root;
    private static Stage stage;
    private static Scene scene;
    static double x=0.0;
    static double y=0.0;//for Stage's getX, getY
    public static void MoveAbleWindow()
    {
        x=(stage.getX());
        y=(stage.getY());
        root.setOnMousePressed(event -> {
            x=(event.getSceneX());
            y=(event.getSceneY());
        });
        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
            stage.setOpacity(.7);
        });
        root.setOnMouseReleased((MouseEvent e)->{
            stage.setOpacity(1);
        });
    }
    public static void switchControls(MouseEvent e, String view) throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(sceneController.class.getResource(view)));
        stage= (Stage) ((Node)e.getSource()).getScene().getWindow();
        MoveAbleWindow();   //Moveable window option
        scene = new Scene(root);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    public static void switchControlsAction(String view, ActionEvent e) throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(sceneController.class.getResource(view)));
        stage= (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        MoveAbleWindow();   //Moveable window option
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    public static void switchToSignup(MouseEvent e) throws IOException {
        switchControls(e,"signup.fxml");
    }
    public static void switchToSignupA(ActionEvent e) throws IOException {
       switchControlsAction("signup.", e);
    }
    public static void switchToLoginA(ActionEvent e) throws IOException {
        switchControlsAction("login.fxml",e);
    }
    public static void switchToLogin(MouseEvent e) throws IOException {
        switchControls(e,"login.fxml");
    }
    public static void switchToFP(MouseEvent e) throws IOException {
        switchControls(e,"forgot-password.fxml");
    }
    public static void closeButton(ActionEvent e){
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.close();
    }


    ///TODO--------LOGIN SEGMENT (make separate java file)--------



    ////TODO-----REGISTER USER (make separate Java file)/--------


    @FXML
    private PasswordField confirm_pass;

    @FXML
    private DatePicker date_of_birth;
    @FXML
    private MenuButton institute;

    @FXML
    private PasswordField new_pass;

    @FXML
    private TextField register_email;

    @FXML
    private Button register_submit;
    @FXML
    private Label doesnt_match_text;
    @FXML
    private Label userblank;
    @FXML
    private Label passblank1;
    @FXML
    private Label passblank2;
    @FXML
    private Label passblank;
    @FXML
    private TextField register_username;

    public void registerAdmin(ActionEvent e) {
//        String sql_command ="SELECT count(1) FROM login_info WHERE username = ? AND password = ?;";
        Connection connect = DatabaseManager.connectDB();
        String username = register_username.getText(), email = register_email.getText(), pass = new_pass.getText();
        String insertFields = "INSERT INTO `userdata`.`login_info` (`username`, `password`,`email`) VALUES ('";
        String insertValues = username + "','" + pass + "','" + email + "');";
        String insertToRegister = insertFields + insertValues;    //#SQL command
        try {
            Statement statement = connect.createStatement();
            statement.executeUpdate(insertToRegister);

            //!Alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registration Completed");
            alert.setHeaderText("Registered Mr." + username + "'s account");
            alert.setContentText("Congratulations, your ID has been registered.\nNow login with the credentials");
            alert.showAndWait();
            //!Alert
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void register_submit_button(ActionEvent e) throws IOException {
//        doesnt_match_text.setVisible(new_pass.getText().equals(confirm_pass.getText()));
//        register_username.setVisible(register_username.getText().isEmpty());
//        new_pass.setVisible(new_pass.getText().isEmpty());
        userblank.setVisible(register_username.getText().isEmpty());
        passblank1.setVisible(register_email.getText().isEmpty());
        passblank.setVisible(new_pass.getText().isEmpty());
        passblank2.setVisible(confirm_pass.getText().isEmpty());
        if (register_username.getText().isEmpty() || new_pass.getText().isEmpty() || confirm_pass.getText().isEmpty() || register_email.getText().isEmpty()) {
//            afterLoginText.setStyle("-fx-text-fill: red;");
//            afterLoginText.setText("Please enter your credentials");
        } else {
            if (new_pass.getText().equals(confirm_pass.getText())) {
                doesnt_match_text.getStyleClass().add("green");
                doesnt_match_text.setText("Matched!");
                registerAdmin(e);
//                sceneController.switchToLoginA(e);
                switchToLoginA(e);
            } else {

                doesnt_match_text.getStyleClass().add("red");
                doesnt_match_text.setText("doesn't match!");
            }

        }

    }



    }




