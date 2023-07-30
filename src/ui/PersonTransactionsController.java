/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import bms.BMS;
import database.Transaction;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author HD
 */
public class PersonTransactionsController implements Initializable {
    @FXML
    private TableColumn<Transaction, String> sender;
    @FXML
    private TableColumn<Transaction, String> reciever;
    @FXML
    private TableColumn<Transaction, String> transactionDate;
    @FXML
    private TableColumn<Transaction, String> amount;
    @FXML
    private TableView<Transaction> mainTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sender.setCellValueFactory(new PropertyValueFactory<>("fromAccount"));
        reciever.setCellValueFactory(new PropertyValueFactory<>("toAccount"));
        transactionDate.setCellValueFactory(new PropertyValueFactory<>("transactionDate"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        mainTable.setItems(BMS.transactionList);
//        BMS.transactionList.stream().forEach((transaction)->{
//            System.out.println(transaction.toString());
//        });
    }    
    
}
