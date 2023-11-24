/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jfxgoogledrive.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import com.google.api.services.drive.model.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import jfxgoogledrive.drive.DriveController;
import utilities.GD_Constants;

/**
 *
 * @author Tony Manjarres
 */
public class FileItemController implements Initializable {

    @FXML
    private Label lblName;

    @FXML
    private ImageView imThumbnail;
    
    private File file;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO
    }

    public void setFile(File f) {
        this.file = f;
        lblName.setText(this.file.getTitle());
        String type = this.file.getMimeType();
        System.out.println(type);
        switch (type) {
            case GD_Constants.DOCX_TYPE:
                imThumbnail.setImage(new Image(getClass().getResourceAsStream(GD_Constants.WORD_ICON)));
                break;
            case GD_Constants.DOC_TYPE:
                imThumbnail.setImage(new Image(getClass().getResourceAsStream(GD_Constants.WORD_ICON)));
                break;
            case GD_Constants.XLSX_TYPE:
                imThumbnail.setImage(new Image(getClass().getResourceAsStream(GD_Constants.EXCEL_ICON)));
                break;
            case GD_Constants.PDF_TYPE:
                imThumbnail.setImage(new Image(getClass().getResourceAsStream(GD_Constants.PDF_ICON)));
                break;
            case GD_Constants.PPT_TYPE:
                imThumbnail.setImage(new Image(getClass().getResourceAsStream(GD_Constants.PPT_ICON)));
                break;
            case GD_Constants.JAR_TYPE:
                imThumbnail.setImage(new Image(getClass().getResourceAsStream(GD_Constants.JAVA_ICON)));
                break;
        }
    }
    
    @FXML
    private void downloadFile(MouseEvent event) {
        System.out.println(lblName.getText());
        try {
            DriveController.downloadFile(this.file.getId(), this.file.getMimeType());
        } catch (IOException | GeneralSecurityException ex) {
            Logger.getLogger(FileItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
