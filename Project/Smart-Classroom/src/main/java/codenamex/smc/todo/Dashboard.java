package codenamex.smc.todo;

import codenamex.smc.HelloApplication;
import codenamex.smc.todo.Data.OtherData;
import codenamex.smc.todo.Data.TodoData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dashboard implements Initializable {

    @FXML
    private ImageView Exit;

    @FXML
    private ImageView Minimize;

    @FXML
    private ImageView Maximize;

    @FXML
    private BorderPane window;

    @FXML
    private StackPane contentArea;

    Stage stage = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Exit.setOnMouseClicked(e -> {

            try{

                TodoData.getInstance().storeTodoItems();
                OtherData.getInstance().storeOtherItems();


            }catch (IOException exception){
                System.out.println(exception.getMessage());
            }
            System.exit(0);

        });
        Minimize.setOnMouseClicked(e -> {
            stage = (Stage) window.getScene().getWindow();
            stage.setIconified(true);
        });
        Maximize.setOnMouseClicked(e -> {
            stage = (Stage) window.getScene().getWindow();
            if(stage.isMaximized())
                stage.setMaximized(false);
            else
                stage.setMaximized(true);
        });



        try {
            FXMLLoader fxml = new FXMLLoader(HelloApplication.class.getResource("Today.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().add(fxml.load());

        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Inbox(ActionEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(HelloApplication.class.getResource("Today.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().add(fxml.load());

    }

    @FXML
    private void Today(ActionEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(HelloApplication.class.getResource("Today.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().add(fxml.load());
        try{

            TodoData.getInstance().storeTodoItems();
            OtherData.getInstance().storeOtherItems();

        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    @FXML
    private void Upcomming(ActionEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(HelloApplication.class.getResource("Upcomming.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().add(fxml.load());
        try{
            TodoData.getInstance().storeTodoItems();
            OtherData.getInstance().storeOtherItems();
        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    @FXML
    private void Important(ActionEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(HelloApplication.class.getResource("Important.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().add(fxml.load());
        try{
            TodoData.getInstance().storeTodoItems();
            OtherData.getInstance().storeOtherItems();
        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    @FXML
    private void Someday(ActionEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(HelloApplication.class.getResource("Someday.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().add(fxml.load());
        try{
            TodoData.getInstance().storeTodoItems();
            OtherData.getInstance().storeOtherItems();
        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }

    }

    @FXML
    private void Trash(ActionEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(HelloApplication.class.getResource("Trash.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().add(fxml.load());
        try{

            TodoData.getInstance().storeTodoItems();
            OtherData.getInstance().storeOtherItems();

        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    @FXML
    void Addnew(ActionEvent event) throws Exception {
        Addnewpage();
    }
    double x,y = 0;
    public void Addnewpage()throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Addnew.fxml")));
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
