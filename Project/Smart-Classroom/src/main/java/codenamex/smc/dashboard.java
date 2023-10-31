package codenamex.smc;

import javafx.beans.property.SimpleBooleanProperty;
import codenamex.smc.design.ToggleSwitch;
import codenamex.smc.sceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class dashboard implements Initializable {

    Stage stage;
    @FXML
    private Button completeButton;

    @FXML
    private Button completeButton1;

    @FXML
    private StackPane contentArea;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField descriptionText;

    @FXML
    private CheckBox noDueDateCheckbox;

    @FXML
    private ListView<?> taskList;

    @FXML
    private ListView<?> taskListDone;

    @FXML
    private Pane themeSwitchPane;

    @FXML
    private CheckBox urgentCheckbox;
    @FXML
    private Pane topbar;
    @FXML
    private BorderPane window;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleSwitch themeButton = new ToggleSwitch();
        themeButton.setLayoutX(6);
        themeButton.setLayoutY(3);
        topbar.getChildren().add(themeButton);

        SimpleBooleanProperty isOn = themeButton.switchOnProperty();
        isOn.addListener((observable, oldValue, newValue)->{
            if(newValue)
            {
                themeButton.getScene().getRoot().getStylesheets().remove(getClass().getResource("css-files/whitetheme.css").toString());
                themeButton.getScene().getRoot().getStylesheets().add(getClass().getResource("css-files/darktheme.css").toString());
            }
            else
                themeButton.getScene().getRoot().getStylesheets().remove(getClass().getResource("css-files/darktheme.css").toString());
            themeButton.getScene().getRoot().getStylesheets().add(getClass().getResource("css-files/whitetheme.css").toString());

        });
    }
    @FXML
    void closeButton(ActionEvent e) {
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.close();
    }


}
