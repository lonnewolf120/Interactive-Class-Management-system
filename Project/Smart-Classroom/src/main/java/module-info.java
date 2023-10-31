module java.codenamex.smc {
    requires javafx.controls;
    requires javafx.fxml;
//    requires com.dlsc.formsfx;
    requires java.sql;
    requires mysql.connector.j;
//    requires MaterialFX;

    opens codenamex.smc to javafx.fxml;
    opens codenamex.smc.todo_deprecated to javafx.fxml;
    exports codenamex.smc;
    opens codenamex.smc.Database to javafx.fxml;
    exports codenamex.smc.Database;
//    exports java.codenamex.smc.todo_deprecated;
}