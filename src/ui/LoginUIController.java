/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import database.Configuration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import bms.BMS;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author HD
 */
public class LoginUIController implements Initializable {
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    PopupNotification notify;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       notify = new PopupNotification();
    }    

    @FXML
    private void loginButtonActionEvent(ActionEvent event) {
        Configuration credentials = new Configuration();
        credentials.setUsername(username.getText());
        credentials.setPassword(password.getText());
        
        if(credentials.isValidUser())
        {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
                Scene scene = new Scene(root);
                BMS.STAGE.setScene(scene);
                BMS.STAGE.setMaximized(true);
            } catch (IOException ex) {
                Logger.getLogger(LoginUIController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            notify.alert("Invalid Credentials !!!","Try Again ");
            username.clear();
            password.clear();
            
        }
    }

    @FXML
    private void cancelButtonActionEvent(ActionEvent event) {
        username.clear();
        password.clear();
    }

    @FXML
    private void changeCredentailsEvent(ActionEvent event) {
        try {
            Parent node = FXMLLoader.load(getClass().getResource("changeCredential.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/icon.png")));
            stage.setScene(new Scene(node));
            stage.show();
        } catch (IOException ex) {
            notify.alert("Sorry", "Unable to open");
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
