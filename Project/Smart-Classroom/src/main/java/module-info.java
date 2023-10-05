module codenamex.smc {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens codenamex.smc to javafx.fxml;
    exports codenamex.smc;

}