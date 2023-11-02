package codenamex.smc;

import codenamex.smc.model.Task;
import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.beans.property.SimpleBooleanProperty;
import codenamex.smc.design.ToggleSwitch;
import codenamex.smc.sceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.sql.Date;

import javax.xml.datatype.DatatypeFactory;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;
import codenamex.smc.todo.add_item_controller;
import javafx.util.Duration;

public class dashboard implements Initializable {

    Stage stage;
    @FXML
    private Button AddTask;

    @FXML
    private Button EnterTaskView;

    @FXML
    private Button clear;

    @FXML
    private StackPane contentArea;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField descriptionText;

    @FXML
    private Button markComplete;

    @FXML
    private CheckBox noDueDateCheckbox;

    @FXML
    private MenuButton prioritySetterBox;

    @FXML
    private ListView<?> taskList;

    @FXML
    private ListView<?> taskListDone;

    @FXML
    private TextField taskTitile;

    @FXML
    private AnchorPane topbar;

    @FXML
    private CheckBox urgentCheckbox;

    @FXML
    private BorderPane window;
    private Integer priority;

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
        prioritySetterBox.getItems().removeAll();
        MenuItem menuItem = new MenuItem("Urgent");
        MenuItem menuItem1 = new MenuItem("High");
        MenuItem menuItem2 = new MenuItem("Mid");
        MenuItem menuItem3 = new MenuItem("Low");
        MenuItem menuItem4 = new MenuItem("None");
//        Collection<MenuItem> mnc = new Colle
        prioritySetterBox.getItems().addAll(menuItem,menuItem1,menuItem2,menuItem3,menuItem4);
        menuItem.setOnAction(event ->{
            priority=4;
            prioritySetterBox.setAccessibleText(menuItem.getText());
        });
        menuItem1.setOnAction(event ->{
            priority=3;
            prioritySetterBox.setAccessibleText(menuItem1.getText());
        });
        menuItem2.setOnAction(event ->{
            priority=2;
            prioritySetterBox.setAccessibleText(menuItem2.getText());
        });
        menuItem3.setOnAction(event ->{
            priority=1;
            prioritySetterBox.setAccessibleText(menuItem3.getText());
        });
        menuItem4.setOnAction(event ->{
            priority=0;
            prioritySetterBox.setAccessibleText(menuItem4.getText());
        });

    }
    public void AddTaskButton(ActionEvent e)
    {
        Boolean isComplete = markComplete.isPressed();
        Task task = new Task(priority,taskTitile.getText(), descriptionText.getText(), Date.valueOf(datePicker.getValue()),isComplete);
        add_item_controller.insert(task);

        //#Animation
        ScaleTransition pulse = new ScaleTransition(Duration.seconds(1), AddTask);
        pulse.setToX(1.1);
        pulse.setToY(1.1);
        pulse.setAutoReverse(true);
        pulse.setCycleCount(Animation.INDEFINITE);
        AddTask.setOnMouseEntered(event -> pulse.play());
        AddTask.setOnAction(event -> pulse.play());
        AddTask.setOnMouseExited(event -> pulse.stop());
        //.
    }
    @FXML
    void closeButton(ActionEvent e) {
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.close();
    }


}
