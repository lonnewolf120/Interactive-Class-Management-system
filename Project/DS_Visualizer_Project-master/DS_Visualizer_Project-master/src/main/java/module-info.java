module com.example.datastructurevisualizer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.DataStructureVisualizer to javafx.fxml;
    exports com.example.DataStructureVisualizer;
}