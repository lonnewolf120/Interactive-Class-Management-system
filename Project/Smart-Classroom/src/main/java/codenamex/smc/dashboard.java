package codenamex.smc;

import codenamex.smc.Database.DatabaseManager;
import codenamex.smc.model.Task;
import codenamex.smc.model.TaskProperty;
import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.beans.property.*;
import codenamex.smc.design.ToggleSwitch;
import codenamex.smc.sceneController;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.sql.Date;

import javax.xml.datatype.DatatypeFactory;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.ResourceBundle;
import codenamex.smc.todo.add_item_controller;
import javafx.util.Duration;

public class dashboard implements Initializable {

    Stage stage;
    @FXML
    private Button AddTask;

    @FXML
    private Button EnterFullScreen;

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

//    @FXML
//    private ListView<?> taskList;

    @FXML
    private TextField taskTitile;
    //#Task Table
    @FXML
    private TableView<TaskProperty> taskTable;
    @FXML
    private TableColumn<TaskProperty, SimpleStringProperty> titleCol;
    @FXML
    private TableColumn<TaskProperty, SimpleStringProperty> TaskCol;
    @FXML
    private TableColumn<TaskProperty, SimpleStringProperty> DateCol;
    @FXML
    private TableColumn<TaskProperty, SimpleIntegerProperty> PriorityCol;
    @FXML
    private TableColumn<TaskProperty, SimpleBooleanProperty> CompletedCol;


    @FXML
    private ScrollPane todoBox;

    @FXML
    private AnchorPane topbar;

    @FXML
    private CheckBox urgentCheckbox;

    @FXML
    private BorderPane window;

    private Integer priority;

    public dashboard() {
    }

    public void ToggleSwitch()
    {
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
    public void prioritySetter()
    {
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleSwitch();
        prioritySetter();
        try {

//            titleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
//            TaskCol.setCellValueFactory(new PropertyValueFactory<>("Description"));
//            DateCol.setCellValueFactory(new PropertyValueFactory<>("Deadline"));
//            PriorityCol.setCellValueFactory(new PropertyValueFactory<>("Priority"));
//            CompletedCol.setCellValueFactory(new PropertyValueFactory<>("Completed"));
//        taskTable.getColumns().addAll(taskPriorityColumn, taskNameColumn, descriptionColumn, deadlineColumn);
            titleCol.setCellValueFactory(new PropertyValueFactory<>("headline"));
            TaskCol.setCellValueFactory(new PropertyValueFactory<>("description"));
            DateCol.setCellValueFactory(new PropertyValueFactory<>("deadline"));
            PriorityCol.setCellValueFactory(new PropertyValueFactory<>("priority"));
            CompletedCol.setCellValueFactory(new PropertyValueFactory<>("completed"));

            // Retrieve data from the database and populate an ObservableList
            ObservableList<TaskProperty> tasksList = fetchDataFromDatabase();
            for (TaskProperty task : tasksList) {
                System.out.println("Priority: " + task.getPriority());
                System.out.println("Headline: " + task.getHeadline());
                System.out.println("Description: " + task.getDescription());
                System.out.println("Deadline: " + task.getDeadline());
                System.out.println("Description: " + task.getCompleted());

                // Print other properties as needed
            }
            // Bind the data to the TableView
            taskTable.setItems(tasksList);
        }
        catch(Exception e)
        {
            System.out.println("Some Columns were null");
            e.printStackTrace();
        }
    }

    private ObservableList<TaskProperty> fetchDataFromDatabase() {
        ObservableList<TaskProperty> tasks = FXCollections.observableArrayList();
        try
        {
            String sql = "SELECT priority, headline, description, deadline, completed FROM userdata.tasks;";
            PreparedStatement preparedStatement = DatabaseManager.connectDB().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Integer priority = resultSet.getInt("priority");
                String headline = resultSet.getString("headline");
                String description = resultSet.getString("description");
                Date deadline = resultSet.getDate("deadline");
                Boolean completed = resultSet.getBoolean("completed");
                TaskProperty task = new TaskProperty(priority,headline,description,deadline,completed);
                tasks.add(task);
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return tasks;
    }


    public void AddTaskButton(ActionEvent e)
    {
        Boolean isComplete = markComplete.isPressed();
        Date newDate = Date.valueOf(datePicker.getValue());
        if(newDate==null) newDate=Date.valueOf(LocalDate.now());
        if(priority==null) priority=0;
        String title, desc;
        title=(taskTitile.getText().isEmpty())? "" : taskTitile.getText();
        desc=(descriptionText.getText().isEmpty())? "" : descriptionText.getText();
        Task task = new Task(priority,title, desc,newDate,isComplete);
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
