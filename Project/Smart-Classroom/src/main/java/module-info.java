module codenamex.smc {
    requires javafx.controls;
    requires javafx.fxml;
//    requires com.dlsc.formsfx;
    requires java.sql;
    requires mysql.connector.j;
//    requires MaterialFX;

    opens codenamex.smc to javafx.fxml;
    opens codenamex.smc.todo to javafx.fxml;
    exports codenamex.smc;
    exports codenamex.smc.todo;
}