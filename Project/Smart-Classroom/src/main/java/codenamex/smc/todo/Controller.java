package codenamex.smc.todo;

//import com.jfoenix.controls.PasswordField;
//import com.jfoenix.controls.Snackbar;
//import com.jfoenix.controls.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
//import com.jfoenix.controls.Snackbar;
//import com.jfoenix.controls.Snackbar.SnackbarEvent;
public class Controller implements Initializable {

    @FXML
    private Pane Proot;

    @FXML
    private TextField txtuser;

    @FXML
    private TextField txtemail;

    @FXML
    private PasswordField txtpass;

    @FXML
    private ImageView exit;

    double x,y=0;

    @FXML
    void signup(ActionEvent event) {
        if(txtuser.getText().isEmpty() && txtemail.getText().isEmpty() && txtpass.getText().isEmpty()){
            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();

                stage.close();

                Dash();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
           // showSnackBar("User Name or Password wrong");
        }

    }
    /*
    private void showSnackBar(String s) {

        Snackbar snackBar=new Snackbar(Proot);

        snackBar.setPrefWidth(260.0);
        Duration duration = new Duration(4000);

        SnackbarEvent snackbarEvent = new SnackbarEvent.Builder()
                .message(s)
                .duration(duration)
                .build();

        snackBar.enqueue(snackbarEvent);
    }
*/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        exit.setOnMouseClicked(e -> System.exit(0));
    }

    public void Dash()throws Exception{

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("View/Dashboard.fxml")));

        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        //move around here
        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });
        stage.setScene(new Scene(root));
        stage.show();
    }



}
