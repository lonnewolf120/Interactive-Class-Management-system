module codenamex.smc {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.dlsc.formsfx;
//    requires MaterialFX;

    opens codenamex.smc to javafx.fxml;
    exports codenamex.smc;

}