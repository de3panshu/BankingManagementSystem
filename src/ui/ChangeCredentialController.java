/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import database.Configuration;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author HD
 */
public class ChangeCredentialController implements Initializable {
    @FXML
    private JFXTextField oldUsername;
    @FXML
    private JFXPasswordField oldPassword;
    @FXML
    private JFXTextField newUsername;
    @FXML
    private JFXPasswordField newPassword;
    @FXML
    private JFXPasswordField newPasswordConfirm;
    PopupNotification notify;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       notify = new PopupNotification();
    }    

    @FXML
    private void saveButtonActionEvent(ActionEvent event) {
        Configuration credentials = new Configuration();
        credentials.setUsername(oldUsername.getText());
        credentials.setPassword(oldPassword.getText());
        
        if(credentials.isValidUser())
        {
//            try {
//                Parent root = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
//                Scene scene = new Scene(root);
//                BMS.STAGE.setScene(scene);
//                BMS.STAGE.setMaximized(true);
//            } catch (IOException ex) {
//                Logger.getLogger(LoginUIController.class.getName()).log(Level.SEVERE, null, ex);
//            }
            if(newPassword.getText().equals(newPasswordConfirm.getText()) && !newPassword.getText().isEmpty())
            {
                if(!newUsername.getText().isEmpty())
                {
                    credentials.setUsername(newUsername.getText());
                    credentials.setPassword(newPassword.getText());
                    credentials.configure();
                    notify.confirm("Saving SuccessFull", "");
                }
                else
                {
                    notify.alert("Enter Username", "");
                }
            }
            else
            {
                notify.warning("Password Mismatched or Empty", "");
            }
        }
        else
        {
            notify.alert("Invalid Credentials !!!","Try Again ");
            oldUsername.clear();
            oldPassword.clear();
            
        }
    }

    @FXML
    private void cancelButtonActionEvent(ActionEvent event) {
       newUsername.clear();
       newPassword.clear();
       newPasswordConfirm.clear();
       
    }
    
}
