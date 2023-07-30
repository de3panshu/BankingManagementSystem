/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import database.BMSDataBase;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import bms.BMS;
import com.jfoenix.controls.JFXButton;
import database.Account;
import database.Customer;
import database.Transaction;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * FXML Controller class
 *
 * @author HD
 */
public class DashBoardController implements Initializable {
    @FXML
    private TableView<Account> accountTable;
    @FXML
    private TableColumn<Account, String> accountNumberCol;
    @FXML
    private TableColumn<Account, String> cifNumberCol;
    @FXML
    private TableColumn<Account, String> accountTypeCol;
    @FXML
    private TableColumn<Account, String> accountCurrentBalanceCol;
    @FXML
    private TextField updateAccountAccountNumber;
    @FXML
    private ImageView updateAccountPersonImage;
    @FXML
    private ImageView updateAccountSignatureImage;
    @FXML
    private JFXTextField updateAccountCustomerName;
    @FXML
    private JFXDatePicker updateAccountDob;
    @FXML
    private JFXTextField updateAccountContact;
    @FXML
    private JFXTextField updateAccountAdrress;
    @FXML
    private JFXComboBox<String> updateAccountAccountType;
    @FXML
    private JFXComboBox<String> updateAccountGender;
    @FXML
    private JFXTextField updateAccountEmail;
    @FXML
    private JFXTextField updateAccountPanNumber;
    @FXML
    private JFXTextField updateAccountAdhaarNumber;
    @FXML
    private JFXTextField newAccountCustomerName;
    @FXML
    private JFXTextField newAccountAccountNumber;
    @FXML
    private JFXComboBox<String> newAccountAccountType;
    @FXML
    private JFXRadioButton newAccountMale;
    @FXML
    private ToggleGroup genderButtons;
    @FXML
    private JFXRadioButton newAccountFemale;
    @FXML
    private JFXRadioButton newAccountOther;
    @FXML
    private JFXDatePicker newAccountDob;
    @FXML
    private JFXTextField newAccountContact;
    @FXML
    private JFXTextField newAccountAddress;
    @FXML
    private JFXTextField newAccountEmail;
    @FXML
    private JFXTextField newAccountAdhaarNumber;
    @FXML
    private JFXTextField newAccountPanNumber;
    @FXML
    private JFXTextField newAccountCifNumber;
    @FXML
    private JFXTextField newAccountInitialDeposit;
    @FXML
    private ImageView newAccountPersonImage;
    @FXML
    private Label newAccountPersonImageFileName;
    @FXML
    private ImageView newAccountSignatureImage;
    @FXML
    private Label newAccountSignatureImageFileName;
    @FXML
    private TableView<Transaction> transactionTable;
    @FXML
    private TableColumn<Transaction, String> transactionTableFrom;
    @FXML
    private TableColumn<Transaction, String>transactionTableTo;
    @FXML
    private TableColumn<Transaction, String>transactionTableDate;
    @FXML
    private TableColumn<Transaction, String>transactionTableAmount;
    @FXML
    private TextField depositAccountNumber;
    @FXML
    private ImageView depositPersonImage;
    @FXML
    private Label depositCustomerName;
    @FXML
    private Label depositContactNumber;
    @FXML
    private Label depositCurrentBalance;
    @FXML
    private JFXTextField depositAmount;
    @FXML
    private TextField withdrawAccountNumber;
    @FXML
    private ImageView withdrawPersonImage;
    @FXML
    private Label withdrawCustomerName;
    @FXML
    private Label withdrawContactNumber;
    @FXML
    private Label withdrawCurrentBalance;
    @FXML
    private JFXTextField withdrawAmount;
    @FXML
    private TextField transferSenderAccountNumber;
    @FXML
    private ImageView transferSenderPersonImage;
    @FXML
    private Label transferSenderCustomerName;
    @FXML
    private Label transferSenderContactNumber;
    @FXML
    private Label transferSenderCurrentBalance;
    @FXML
    private TextField transferReceiverAccountNumber;
    @FXML
    private ImageView transferReceiverPersonImage;
    @FXML
    private Label transferReceiverCustomerName;
    @FXML
    private Label transferReceiverContactNumber;
    @FXML
    private Label transferReceiverCurrentBalance;
    @FXML
    private JFXTextField transferAmount;
    @FXML
    private TableView<Customer> customerTable;
    @FXML
    private TableColumn<Customer,String> customerTableName;
    @FXML
    private TableColumn<Customer,String>customerTableGender;
    @FXML
    private TableColumn<Customer,String>customerTableDob;
    @FXML
    private TableColumn<Customer,String>customerTableAddress;
    @FXML
    private TableColumn<Customer,String>customerTableContact;
    @FXML
    private TableColumn<Customer,String>customerTableEmail;
    @FXML
    private TableColumn<Customer,String>customerTableAdhaarNumber;
    @FXML
    private TableColumn<Customer,String>customerTablePanNumber;
    @FXML
    private TextField customerProfileContactNumber;
    @FXML
    private ImageView customerProfilePersonImage;
    @FXML
    private ImageView customerProfileSignatureImage;
    @FXML
    private Label customerProfileName;
    @FXML
    private Label customerProfileDob;
    @FXML
    private Label customerProfileContact;
    @FXML
    private Label customerProfileAddress;
    @FXML
    private Label customerProfileAccoutType;
    @FXML
    private Label customerProfileGender;
    @FXML
    private Label customerProfileEmail;
    @FXML
    private Label customerProfilePanNumber;
    @FXML
    private Label customerProfileAdhaarNumber;
    @FXML
    private Label customerProfileAccountNumber;
    @FXML
    private Label customerProfileCurrentBalance;
    
    private Connection database;
    private PopupNotification notify;
    private ObservableList<Account> accountList;
    private ObservableList<Transaction> transactionList;
    ObservableList<Customer> customerList;
    String copiedAccountNumber;
    private final String RESOURCE_DIRECTORY = "C:\\BMS_resource";
    @FXML
    private JFXButton imageButton;
    @FXML
    private JFXButton signatureImage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      notify = new PopupNotification();
      BMSDataBase mysql = new BMSDataBase();
      database = BMSDataBase.connection;
      mysql.createAccountTable();
      mysql.createCustomerTable();
      mysql.createTansactionTable();
      new File(RESOURCE_DIRECTORY).mkdirs();
      ObservableList <String> accountTypeList = FXCollections.observableArrayList("Saving Account","Current Account");
      updateAccountAccountType.getItems().addAll(accountTypeList);
      newAccountAccountType.getItems().addAll(accountTypeList);
      updateAccountGender.getItems().addAll(FXCollections.observableArrayList("Male","Female","Other"));
      // setting up toggleData
      newAccountMale.setUserData("Male");
      newAccountFemale.setUserData("Female");
      newAccountOther.setUserData("Other");
      imageButton.setDisable(true);
      signatureImage.setDisable(true);
      ////textfields restrictions code goes here
      newAccountAccountNumber.textProperty().addListener((ObservableValue<?extends String> observable, String oldValue, String newValue) -> {
          if(!newValue.matches("\\d*"))
          {
              newAccountAccountNumber.setText(newValue.replaceAll("[^\\d]",""));
          }
          if(newAccountAccountNumber.getText().length() >11)
          {
              newAccountAccountNumber.setText(newAccountAccountNumber.getText().substring(0, 11));
              
          }
          
          if(newAccountAccountNumber.getText().length() >= 11)
              {
                  imageButton.setDisable(false);
                  signatureImage.setDisable(false);
              }
          else
              {
                  imageButton.setDisable(true);
                signatureImage.setDisable(true);
              }
      });
      updateAccountAccountNumber.textProperty().addListener((ObservableValue<?extends String> observable, String oldValue, String newValue) -> {
          if(!newValue.matches("\\d*"))
          {
              updateAccountAccountNumber.setText(newValue.replaceAll("[^\\d]",""));
          }
          if(updateAccountAccountNumber.getText().length() >11)
          {
              updateAccountAccountNumber.setText(updateAccountAccountNumber.getText().substring(0, 11));
          }
      });
      depositAccountNumber.textProperty().addListener((ObservableValue<?extends String> observable, String oldValue, String newValue) -> {
          if(!newValue.matches("\\d*"))
          {
              depositAccountNumber.setText(newValue.replaceAll("[^\\d]",""));
          }
          if(depositAccountNumber.getText().length() >11)
          {
              depositAccountNumber.setText(depositAccountNumber.getText().substring(0, 11));
          }
      });
      withdrawAccountNumber.textProperty().addListener((ObservableValue<?extends String> observable, String oldValue, String newValue) -> {
          if(!newValue.matches("\\d*"))
          {
              withdrawAccountNumber.setText(newValue.replaceAll("[^\\d]",""));
          }
          if(withdrawAccountNumber.getText().length() >11)
          {
              withdrawAccountNumber.setText(withdrawAccountNumber.getText().substring(0, 11));
          }
      });
      transferSenderAccountNumber.textProperty().addListener((ObservableValue<?extends String> observable, String oldValue, String newValue) -> {
          if(!newValue.matches("\\d*"))
          {
              transferSenderAccountNumber.setText(newValue.replaceAll("[^\\d]",""));
          }
          if(transferSenderAccountNumber.getText().length() >11)
          {
              transferSenderAccountNumber.setText(transferSenderAccountNumber.getText().substring(0, 11));
          }
      });
      transferReceiverAccountNumber.textProperty().addListener((ObservableValue<?extends String> observable, String oldValue, String newValue) -> {
          if(!newValue.matches("\\d*"))
          {
              transferReceiverAccountNumber.setText(newValue.replaceAll("[^\\d]",""));
          }
          if(transferReceiverAccountNumber.getText().length() >11)
          {
              transferReceiverAccountNumber.setText(transferReceiverAccountNumber.getText().substring(0, 11));
          }
      });
      newAccountCifNumber.textProperty().addListener((ObservableValue<?extends String> observable, String oldValue, String newValue) -> {
          if(!newValue.matches("\\d*"))
          {
              newAccountCifNumber.setText(newValue.replaceAll("[^\\d]",""));
          }
          if(newAccountCifNumber.getText().length() >11)
          {
              newAccountCifNumber.setText(newAccountCifNumber.getText().substring(0, 11));
          }
      });
      newAccountContact.textProperty().addListener((ObservableValue<?extends String> observable, String oldValue, String newValue) -> {
          if(!newValue.matches("\\d*"))
          {
              newAccountContact.setText(newValue.replaceAll("[^\\d]",""));
          }
          if(newAccountContact.getText().length() >10)
          {
              newAccountContact.setText(newAccountContact.getText().substring(0, 10));
          }
      });
      customerProfileContactNumber.textProperty().addListener((ObservableValue<?extends String> observable, String oldValue, String newValue) -> {
          if(!newValue.matches("\\d*"))
          {
              customerProfileContactNumber.setText(newValue.replaceAll("[^\\d]",""));
          }
          if(customerProfileContactNumber.getText().length() >10)
          {
              customerProfileContactNumber.setText(customerProfileContactNumber.getText().substring(0, 10));
          }
      });
      newAccountAdhaarNumber.textProperty().addListener((ObservableValue<?extends String> observable, String oldValue, String newValue) -> {
          if(!newValue.matches("\\d*"))
          {
              newAccountAdhaarNumber.setText(newValue.replaceAll("[^\\d]",""));
          }
          if(newAccountAdhaarNumber.getText().length() >12)
          {
              newAccountAdhaarNumber.setText(newAccountAdhaarNumber.getText().substring(0, 12));
          }
      });
      newAccountPanNumber.textProperty().addListener((ObservableValue<?extends String> observable, String oldValue, String newValue) -> {
          if(newAccountPanNumber.getText().length() >10)
          {
              newAccountPanNumber.setText(newAccountPanNumber.getText().substring(0, 10));
          }
      });
      newAccountInitialDeposit.textProperty().addListener((ObservableValue<?extends String> observable, String oldValue, String newValue) -> {
          if(!newValue.matches("\\d*"))
          {
              newAccountInitialDeposit.setText(newValue.replaceAll("[^\\d]",""));
          }
      });
      depositAmount.textProperty().addListener((ObservableValue<?extends String> observable, String oldValue, String newValue) -> {
          if(!newValue.matches("\\d*"))
          {
              depositAmount.setText(newValue.replaceAll("[^\\d]",""));
          }
      });
      withdrawAmount.textProperty().addListener((ObservableValue<?extends String> observable, String oldValue, String newValue) -> {
          if(!newValue.matches("\\d*"))
          {
              withdrawAmount.setText(newValue.replaceAll("[^\\d]",""));
          }
      });
      transferAmount.textProperty().addListener((ObservableValue<?extends String> observable, String oldValue, String newValue) -> {
          if(!newValue.matches("\\d*"))
          {
              transferAmount.setText(newValue.replaceAll("[^\\d]",""));
          }
      });
      
      //List for table data
      accountList = FXCollections.observableArrayList();
      customerList = FXCollections.observableArrayList();
      transactionList = FXCollections.observableArrayList();
       
      //loading database
        try {
           
            ResultSet rows = database.createStatement().executeQuery("Select * from account;");
            String accNumber;
            String cifNumber;
            String accType;
            String balance;
            while(rows.next())
            {
                accNumber = rows.getString(1);
                cifNumber = rows.getString(2);
                accType = rows.getString(3);
                balance = rows.getString(4);
                accountList.add(new Account(accNumber,cifNumber,accType,balance));
            }
            rows = database.createStatement().executeQuery("Select * from customer;");
            String number;
            String name;
            String gender;
            String dob;
            String address;
            String contact;
            String email;
            String adhaar;
            String pan;
            while(rows.next())
            {
                number = rows.getString(1);
                name = rows.getString(2);
                gender = rows.getString(3);
                dob = rows.getString(4);
                address = rows.getString(5);
                contact = rows.getString(6);
                email = rows.getString(7);
                adhaar = rows.getString(8);
                pan = rows.getString(9);
                customerList.add(new Customer(number,name,gender,dob,address,contact,email,adhaar,pan));
            }
            rows = database.createStatement().executeQuery("Select * from transaction;");
            String fromAccount;
            String toAccount;
            String transactionDate;
            String amount;
            while(rows.next())
            {
                fromAccount = rows.getString(1);
                toAccount = rows.getString(2);
                transactionDate = rows.getString(3);
                amount = rows.getString(4);
                transactionList.add(new Transaction(fromAccount,toAccount,transactionDate,amount));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
      //binding with List with table
        accountNumberCol.setCellValueFactory(new PropertyValueFactory<>("accountNumber"));
        cifNumberCol.setCellValueFactory(new PropertyValueFactory<>("cifNumber"));
        accountTypeCol.setCellValueFactory(new PropertyValueFactory<>("accountType"));
        accountCurrentBalanceCol.setCellValueFactory(new PropertyValueFactory<>("currentBalance"));
        accountTable.setItems(accountList);
        
        customerTableName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        customerTableGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        customerTableDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        customerTableContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        customerTableAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        customerTableAdhaarNumber.setCellValueFactory(new PropertyValueFactory<>("adhaar"));
        customerTablePanNumber.setCellValueFactory(new PropertyValueFactory<>("pan"));
        customerTableEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        customerTable.setItems(customerList);
        
        transactionTableFrom.setCellValueFactory(new PropertyValueFactory<>("fromAccount"));
        transactionTableTo.setCellValueFactory(new PropertyValueFactory<>("toAccount"));
        transactionTableDate.setCellValueFactory(new PropertyValueFactory<>("transactionDate"));
        transactionTableAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        transactionTable.setItems(transactionList);
        
        accountList.stream().filter((account)->(account.getAccountNumber().equalsIgnoreCase("BANK"))).forEach((account)->{
            bankAccount = account;
        });
    }    

    @FXML
    private void updateAccountSerchButtonActionEvent(ActionEvent event) {
        String accountNumber = updateAccountAccountNumber.getText();
        if(!accountNumber.isEmpty()&& accountNumber != null)
        {
            accountList.stream().filter((account) -> (account.getAccountNumber().equals(accountNumber))).forEach((account) -> {
                updateAccountAccountType.getSelectionModel().select(account.getAccountType());
                
            });
           customerList.stream().filter((customer)->(customer.getNumber().equals(accountNumber))).forEach((customer)->{
                String date = customer.getDob(); //1999/04/12
                int year = Integer.parseInt(date.substring(0,4));
                int month = Integer.parseInt(date.substring(5,7));
                int day = Integer.parseInt(date.substring(8,10));
                
                updateAccountCustomerName.setText(customer.getCustomerName());
                updateAccountGender.getSelectionModel().select(customer.getGender());
                updateAccountDob.setValue(LocalDate.of(year, month, day));
                updateAccountContact.setText(customer.getContact());
                updateAccountAdhaarNumber.setText(customer.getAdhaar());
                updateAccountAdrress.setText(customer.getAddress());
                updateAccountPanNumber.setText(customer.getPan());
                updateAccountEmail.setText(customer.getEmail());
                
            });
            try {
                updateAccountSignatureImage.setImage(new Image(new FileInputStream(RESOURCE_DIRECTORY+"\\s_"+accountNumber)));
                updateAccountPersonImage.setImage(new Image(new FileInputStream(RESOURCE_DIRECTORY+"\\p_"+accountNumber)));
            } catch (FileNotFoundException ex) {
                notify.alert("Images Not Found", "Restart the software");
                Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    @FXML
    private void updateAccountUpdateActionEvent(ActionEvent event) {
        try {
            String customerName = updateAccountCustomerName.getText();
            String gender = updateAccountGender.getSelectionModel().getSelectedItem();
            String dob = updateAccountDob.getValue().toString().replaceAll("-", "/");
            String contact = updateAccountContact.getText();
            String email = updateAccountEmail.getText();
            String address = updateAccountAdrress.getText();
            
            String query = "Update customer set Name = '"+customerName+"', gender = '"+gender+"',dob= '"+dob+"', contact='"+contact+"',email = '"+email+"',address = '"+address+"' where number = '"+updateAccountAccountNumber.getText()+"';";
            if(database.createStatement().executeUpdate(query)>0)
            {
               
                notify.confirm("Updated", "Details saved successfully");
                
                customerList.stream().filter((customer)->(customer.getNumber().equals(updateAccountAccountNumber.getText()))).forEach((Customer customer) -> {
                    Customer updatedCustomer = new Customer(customer.getNumber(),customerName,gender,dob,address,contact,email,customer.getAdhaar(),customer.getPan());
                    customerList.set(customerList.indexOf(customer),updatedCustomer);
                });
            }
        } catch (SQLException ex) {
            notify.alert("Failed !!!", "Something Went Wrong");
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void newAccountCreateButtonActionEvent(ActionEvent event) {
        try
        {
            String customerName = newAccountCustomerName.getText();
            String accountNumber = newAccountAccountNumber.getText();
            String accountType = newAccountAccountType.getSelectionModel().getSelectedItem();
            String gender = (String) genderButtons.getSelectedToggle().getUserData();
            String dob =newAccountDob.getValue().toString().replaceAll("-", "/");
            String contact = newAccountContact.getText();
            String address = newAccountAddress.getText();
            String email = newAccountEmail.getText();
            String adhaar = newAccountAdhaarNumber.getText();
            String pan = newAccountPanNumber.getText();
            String cif = newAccountCifNumber.getText();
            final String initialBalance = newAccountInitialDeposit.getText();
            
            
            
           //Validating fields
            if(!(customerName.isEmpty()&& accountNumber.isEmpty()&& accountType.isEmpty()&&gender.isEmpty()&&dob.isEmpty()&& contact.isEmpty()&& address.isEmpty()&& email.isEmpty()&& adhaar.isEmpty()&& pan.isEmpty()&& initialBalance.isEmpty()))
            {
                //means no fields are empty
                boolean worthToAdd = true;
                
                //validating Mobile Number
                Matcher match = (Pattern.compile("(0/91)?[7-9][0-9]{9}")).matcher(contact);
                if(!(match.find() && match.group().equals(contact)))//if not a valid contact
                {
                    worthToAdd = false;
                    notify.alert("Invalid Contact Number", contact);
                }
                
                //validating Adhaar Number
                match = (Pattern.compile("^[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}$")).matcher(adhaar);
                if(!(match.find() && match.group().equals(adhaar)))//if not a valid Adhaar
                {
                    worthToAdd = false;
                    notify.alert("Invalid Adhaar Number", adhaar);
                }
                //validating PAN Number
                match = (Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}")).matcher(pan);
                if(!(match.find() && match.group().equals(pan)))//if not a valid PAN
                {
                    worthToAdd = false;
                    notify.alert("Invalid PAN Number", pan);
                }
                //validating Amount
                match = (Pattern.compile("[+-]?[0-9]+")).matcher(initialBalance);
                if(!(match.find() && match.group().equals(initialBalance)))//if not a valid Amount
                {
                    worthToAdd = false;
                    notify.alert("Invalid Amount", initialBalance);
                }
                //validating Account Number
                match = (Pattern.compile("[1-9]{1}[0-9]{10}")).matcher(accountNumber);
                if(!(match.find() && match.group().equals(accountNumber)))//if not a account number
                {
                    worthToAdd = false;
                    notify.alert("Invalid Account Number", accountNumber);
                }
                
                //validating CIF Number
                match = (Pattern.compile("[1-9]{1}[0-9]{10}")).matcher(cif);
                if(!(match.find() && match.group().equals(cif)))//if not a cif number
                {
                    worthToAdd = false;
                    notify.alert("Invalid CIF Number", cif);
                }
                //validating E-mail
                match = (Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")).matcher(email);
                if(!(match.find() && match.group().equals(email)))//if not a E-mail
                {
                    worthToAdd = false;
                    notify.alert("Invalid E-mail ID", email);
                }
                //triming customer name to 30 length
                if(customerName.length()>30)
                    customerName = customerName.substring(0,30);
                
                //checking for account number existance on database.
                ResultSet result = (database.createStatement()).executeQuery("Select * from Account where number = '"+accountNumber+"';");
                if(result.next())
                {
                    worthToAdd = false;
                    notify.alert("Account Already Exist", accountNumber);
                }
                //checking for adhaar existance on database.
                result = (database.createStatement()).executeQuery("Select * from Customer where adhaar= '"+adhaar+"';");
                if(result.next())
                {
                    worthToAdd = false;
                    notify.alert("Customer Already Exist", result.getString("name"));
                }
                if(newAccountPersonImageFileName.getText().isEmpty() || newAccountPersonImageFileName.getText() == null)
                {
                    notify.alert("No image found", "Choose image");
                    worthToAdd = false;
                }
                if(newAccountSignatureImageFileName.getText().isEmpty() || newAccountSignatureImageFileName.getText() == null)
                {
                    notify.alert("No image found", "Choose signature");
                    worthToAdd = false;
                }
                
                //If everything is ok then add to datbase
                if(worthToAdd)
                {
                    String query1 = "insert into account values('"+accountNumber+"','"+cif+"','"+accountType+"','"+initialBalance+"');";
                    String query2 = "insert into Customer values('"+accountNumber+"','"+customerName+"','"+gender+"','"+dob+"','"+address+"','"+contact+"','"+email+"','"+adhaar+"','"+pan+"');";
                    ResultSet rows = database.createStatement().executeQuery("select * from account where number = 'BANK';");
                    rows.next();
                    int currentBalance = Integer.parseInt(initialBalance) + rows.getInt(4);
                    String query3 = "update account set balance = '"+currentBalance+"' where number='BANK';";
                    String query4 = "insert into transaction values('"+accountNumber+"','BANK','"+LocalDate.now().toString()+"','"+initialBalance+"');";
                    System.out.println(query3);
                    System.out.println(query4);
//                    System.out.println(query1);
//                    System.out.println(query2);
                    
                    //adding details to database and Account observable List
                    if((database.createStatement()).executeUpdate(query1)>0 && (database.createStatement()).executeUpdate(query2)>0 && (database.createStatement()).executeUpdate(query3)>0 && (database.createStatement()).executeUpdate(query4)>0)
                    {
                        notify.confirm("Successful", "Profile Created");
                        accountList.stream().filter((account)->account.getAccountNumber().equalsIgnoreCase("BANK")).forEach((account)->{
                            accountList.set(accountList.indexOf(account), new Account(account.getAccountNumber(),account.getCifNumber(),account.getAccountType(),(Integer.parseInt(initialBalance)+Integer.parseInt(account.getCurrentBalance()))+""));
                        });
                        accountList.add(new Account(accountNumber,cif,accountType,initialBalance));
                        customerList.add(new Customer(accountNumber,customerName,gender,dob.replaceAll("-", "/"),address,contact,email,adhaar,pan));
                        transactionList.add(new Transaction(accountNumber,"BANK",LocalDate.now().toString().replaceAll("-", "/"),initialBalance));
                        // adding images to file System.
                        
                        Path targetDir = Paths.get(RESOURCE_DIRECTORY);
                        Path target = targetDir.resolve("p_"+accountNumber);
                        Files.copy(imageSource, target);
                        
                        target = targetDir.resolve("s_"+accountNumber);
                        Files.copy(signatureSource, target);
                        
                        // clearing inserted details.
                        newAccountCustomerName.clear();
                        newAccountAccountNumber.clear();
                        newAccountAccountType.getSelectionModel().clearSelection();
                        genderButtons.getSelectedToggle().setSelected(false);
                        newAccountDob.setValue(LocalDate.now());
                        newAccountContact.clear();
                        newAccountAddress.clear();
                        newAccountEmail.clear();
                        newAccountAdhaarNumber.clear();
                        newAccountPanNumber.clear();
                        newAccountCifNumber.clear();
                        newAccountInitialDeposit.clear();
                        newAccountPersonImage.imageProperty().set(null);
                        newAccountSignatureImage.imageProperty().set(null);
                        newAccountSignatureImageFileName.setText("");
                        newAccountPersonImageFileName.setText("");
                        
                    }
                    else
                    {
                        notify.alert("Failed !!!", "Something Went Wrong");
                    }
                    
                }
            }
            else
            {
                notify.warning("Missing Fields", "Some Fields are missing");
            }
            
        }
            
        catch(NullPointerException e)
        {
            notify.warning("Missing Fields", "Some Fields are missing");
           e.printStackTrace();
        } catch (SQLException ex) {
            notify.warning("Connnection Lost", "Restart the software.");
            ex.printStackTrace();
        } catch (IOException ex) {
            notify.alert("Invalid location","Missing File or Folder");
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    Path imageSource;
    Path signatureSource;
    
    @FXML
    private void newAccountPersonImageBrowseButtonActionEvent(ActionEvent event) throws IOException {
        
           
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(BMS.STAGE);
            if (file != null) {
                try 
                {
                    newAccountPersonImage.setImage(new Image(new FileInputStream(file.getAbsolutePath())));
                    newAccountPersonImageFileName.setText(file.getName());
//                    System.out.println("Absolute Path"+file.getAbsolutePath());
                    imageSource = Paths.get(file.getAbsolutePath()); //original file
//                    Path targetDir = Paths.get(RESOURCE_DIRECTORY); 
//                    Files.createDirectories(targetDir);
//                    target = targetDir.resolve("p_"+newAccountAccountNumber.getText());// create new path ending with `name` content
////                    System.out.println("copying into " + target);
//                    System.out.println("copy to"+Files.copy(source, target));
//                    Files.copy(source, target);
                 
                }
                catch (FileNotFoundException ex) 
                {
                    Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
   
    @FXML
    private void newAccountSignatureImageBrowseButtonActionEvent(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(BMS.STAGE);
        if (file != null) 
        {
            try 
            {
                newAccountSignatureImage.setImage(new Image(new FileInputStream(file.getAbsolutePath())));
                newAccountSignatureImageFileName.setText(file.getName());
                signatureSource = Paths.get(file.getAbsolutePath()); //original file
            }
            catch (FileNotFoundException ex) 
            {
                Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void depositAccountNumberActionEvent(ActionEvent event) {
        if(depositAccountNumber.getText().length() == 11)
        {
            String accountNumber = depositAccountNumber.getText();
            customerList.stream().filter((customer)->(customer.getNumber().equals(accountNumber))).forEach((customer)->{
                depositCustomerName.setText(customer.getCustomerName());
                depositContactNumber.setText(customer.getContact());
            });
            accountList.stream().filter((account)->(account.getAccountNumber().equals(accountNumber))).forEach((Account account)->{
                depositCurrentBalance.setText(account.getCurrentBalance());
            });
            try {
                depositPersonImage.setImage(new Image(new FileInputStream(RESOURCE_DIRECTORY+"\\p_"+accountNumber)));
                
            } catch (FileNotFoundException ex) {
                notify.alert("Images Not Found", "Restart the software");
                Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            notify.alert("Invalid Account Number", depositAccountNumber.getText());
        }
    }

    private Account bankAccount;
    @FXML
    private void depositButtonActionEvent(ActionEvent event) {
        if(depositAmount.getText().isEmpty())
        {
            notify.warning("Missing Field", "Enter the amount");
        }
        else if(depositAccountNumber.getText().isEmpty()||depositAccountNumber.getText().length()!=11)
        {
            notify.warning("Invalid Account Number", depositAccountNumber.getText());
        }
        else
        {
            final int amount = Integer.parseInt(depositAmount.getText());
            final int bankAmount = Integer.parseInt(bankAccount.getCurrentBalance())+ amount;
            
            accountList.stream().filter((account)->(account.getAccountNumber().equals(depositAccountNumber.getText()))).forEach((Account account)->{
                int newAmount = amount+Integer.parseInt(account.getCurrentBalance());
                
                String query1 = "update account set balance = '"+newAmount+"' where number = '"+depositAccountNumber.getText()+"';";
                String query3 = "update account set balance = '"+bankAmount+"' where number = 'BANK';";
                String query2 = "insert into transaction values('"+account.getAccountNumber()+"','BANK','"+LocalDate.now().toString()+"','"+amount+"');";
                try 
                {
                    if(database.createStatement().executeUpdate(query1)>0 && database.createStatement().executeUpdate(query2) > 0 && database.createStatement().executeUpdate(query3) > 0) 
                    {
                        notify.confirm("Deposit SuccessFul", amount+" Rs");
                        Account updatedAccount = new Account(account.getAccountNumber(),account.getCifNumber(),account.getAccountType(),newAmount+"");
                        accountList.set(accountList.indexOf(account),updatedAccount);
                        transactionList.add(new Transaction(account.getAccountNumber(),"BANK",LocalDate.now().toString().replaceAll("-", "/"),amount+""));
                        bankAccount.updateBalance(bankAmount+"");
                        depositAmount.clear();
                        depositCustomerName.setText("");
                        depositContactNumber.setText("");
                        depositCurrentBalance.setText("");
                        depositAccountNumber.clear();
                        depositPersonImage.imageProperty().set(null);
                        
                    }
                } 
                catch (SQLException ex) {
                    Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
                }   
            });
        }
    }

    @FXML
    private void withdrawSearchActionEvent(ActionEvent event) {
        
        if(withdrawAccountNumber.getText().length() == 11)
        {
            String accountNumber = withdrawAccountNumber.getText();
            customerList.stream().filter((customer)->(customer.getNumber().equals(accountNumber))).forEach((customer)->{
                withdrawCustomerName.setText(customer.getCustomerName());
                withdrawContactNumber.setText(customer.getContact());
            });
            accountList.stream().filter((account)->(account.getAccountNumber().equals(accountNumber))).forEach((Account account)->{
                withdrawCurrentBalance.setText(account.getCurrentBalance());
            }); 
            try {
                withdrawPersonImage.setImage(new Image(new FileInputStream(RESOURCE_DIRECTORY+"\\p_"+accountNumber)));
                
            } catch (FileNotFoundException ex) {
                notify.alert("Images Not Found", "Restart the software");
                Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            notify.alert("Invalid Account Number", withdrawAccountNumber.getText());
        }
    }

    @FXML
    private void withdrawButtonActionEvent(ActionEvent event) {
        if(withdrawAmount.getText().isEmpty())
        {
            notify.warning("Missing Field", "Enter the amount");
        }
        else if(withdrawAccountNumber.getText().isEmpty() || withdrawAccountNumber.getText().length()!=11)
        {
            notify.warning("Invalid Account Number", withdrawAccountNumber.getText());
        }
        else
        {
            final int amount = Integer.parseInt(withdrawAmount.getText());
            final int bankAmount = Integer.parseInt(bankAccount.getCurrentBalance())-Integer.parseInt(withdrawAmount.getText());
            
            accountList.stream().filter((account)->(account.getAccountNumber().equals(withdrawAccountNumber.getText()))).forEach((Account account)->{
                int newAmount = Integer.parseInt(account.getCurrentBalance()) - amount;
                String query1 = "update account set balance = '"+newAmount+"' where number = '"+withdrawAccountNumber.getText()+"';";
                String query3 = "update account set balance = '"+bankAmount+"' where number = 'BANK';";
                
                String query2 = "insert into transaction values('BANK','"+account.getAccountNumber()+"','"+LocalDate.now().toString()+"','"+amount+"');";
                try 
                {
                    if(newAmount >= 0)
                    {
                        if(database.createStatement().executeUpdate(query1)>0 && database.createStatement().executeUpdate(query2) > 0) 
                        {
                            notify.confirm("Withdraw SuccessFul", amount+" Rs");
                            Account updatedAccount = new Account(account.getAccountNumber(),account.getCifNumber(),account.getAccountType(),newAmount+"");
                            accountList.set(accountList.indexOf(account),updatedAccount);
                            transactionList.add(new Transaction("BANK",account.getAccountNumber(),LocalDate.now().toString(),amount+""));
                            bankAccount.updateBalance(bankAmount+"");
                            withdrawAmount.clear();
                            withdrawCustomerName.setText("");
                            withdrawContactNumber.setText("");
                            withdrawCurrentBalance.setText("");
                            withdrawAccountNumber.clear();
                            withdrawPersonImage.imageProperty().set(null);
                        }
                    }
                    else
                    {
                        notify.warning("Failed", "Not Sufficient Balance");
                    }
                } 
                catch (SQLException ex) {
                    Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
                }   
            });
        }
    }

    @FXML
    private void transferSenderSearchButtonActionEvent(ActionEvent event) {
        if(transferSenderAccountNumber.getText().length() == 11)
        {
            String accountNumber = transferSenderAccountNumber.getText();
            customerList.stream().filter((customer)->(customer.getNumber().equals(accountNumber))).forEach((customer)->{
                transferSenderCustomerName.setText(customer.getCustomerName());
                transferSenderContactNumber.setText(customer.getContact());
            });
            accountList.stream().filter((account)->(account.getAccountNumber().equals(accountNumber))).forEach((Account account)->{
                transferSenderCurrentBalance.setText(account.getCurrentBalance());
            });
            try {
                transferSenderPersonImage.setImage(new Image(new FileInputStream(RESOURCE_DIRECTORY+"\\p_"+accountNumber)));
                
            } catch (FileNotFoundException ex) {
                notify.alert("Images Not Found", "Restart the software");
                Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            notify.alert("Invalid Account Number", transferSenderAccountNumber.getText());
        }
    }

    @FXML
    private void transferReceiverSearchActionEvent(ActionEvent event) {
        if(transferReceiverAccountNumber.getText().length() == 11)
        {
            String accountNumber = transferReceiverAccountNumber.getText();
            customerList.stream().filter((customer)->(customer.getNumber().equals(accountNumber))).forEach((customer)->{
                transferReceiverCustomerName.setText(customer.getCustomerName());
                transferReceiverContactNumber.setText(customer.getContact());
            });
            accountList.stream().filter((account)->(account.getAccountNumber().equals(accountNumber))).forEach((Account account)->{
                transferReceiverCurrentBalance.setText(account.getCurrentBalance());
            });
            try {
                transferReceiverPersonImage.setImage(new Image(new FileInputStream(RESOURCE_DIRECTORY+"\\p_"+accountNumber)));
                
            } catch (FileNotFoundException ex) {
                notify.alert("Images Not Found", "Restart the software");
                Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            notify.alert("Invalid Account Number", transferSenderAccountNumber.getText());
        }
    }

    @FXML
    private void transferButtonActionEvent(ActionEvent event) {
        if(transferAmount.getText().isEmpty())
        {
            notify.warning("Missing Field", "Enter the amount");
        }
        else if(transferSenderAccountNumber.getText().isEmpty() || transferSenderAccountNumber.getText().length()!=11)
        {
            notify.warning("Invalid Account Number", transferSenderAccountNumber.getText());
        }
        else if(transferReceiverAccountNumber.getText().isEmpty() || transferReceiverAccountNumber.getText().length()!=11)
        {
            notify.warning("Invalid Account Number", transferReceiverAccountNumber.getText());
        }
        else
        {
            final int amount = Integer.parseInt(transferAmount.getText());
            //final int bankAmount = Integer.parseInt(bankAccount.getCurrentBalance())-Integer.parseInt(withdrawAmount.getText());
            Account senderAccount = null;
            Account receiverAccount = null;
            for(Account record: accountList)
            {
                if(record.getAccountNumber().equals(transferSenderAccountNumber.getText()))
                {
                    senderAccount = record;
                }
                else if(record.getAccountNumber().equals(transferReceiverAccountNumber.getText()))
                {
                    receiverAccount = record;
                }
            }
            int senderUpdatedBalance = Integer.parseInt(senderAccount.getCurrentBalance()) - amount;
            int receiverUpdatedBalance = Integer.parseInt(receiverAccount.getCurrentBalance()) + amount;
            
            if(senderUpdatedBalance>=0)
            {
                String query1 = "update account set balance = '"+senderUpdatedBalance+"' where number = '"+transferSenderAccountNumber.getText()+"';";
                String query2 = "update account set balance = '"+receiverUpdatedBalance+"' where number = '"+transferReceiverAccountNumber.getText()+"';";
                String query3 = "insert into transaction values('"+senderAccount.getAccountNumber()+"','"+receiverAccount.getAccountNumber()+"','"+LocalDate.now().toString()+"','"+amount+"');";
                try {
                    if(database.createStatement().executeUpdate(query1)>0 && database.createStatement().executeUpdate(query2)>0 && database.createStatement().executeUpdate(query3)>0 )
                    {
                        accountList.set(accountList.indexOf(senderAccount), new Account(senderAccount.getAccountNumber(),senderAccount.getCifNumber(),senderAccount.getAccountType(),senderUpdatedBalance+""));
                        accountList.set(accountList.indexOf(receiverAccount), new Account(receiverAccount.getAccountNumber(),receiverAccount.getCifNumber(),receiverAccount.getAccountType(),receiverUpdatedBalance+""));
//                        senderAccount.updateBalance(senderUpdatedBalance+"");
//                        receiverAccount.updateBalance(receiverUpdatedBalance+"");
                        transactionList.add(new Transaction(senderAccount.getAccountNumber(),receiverAccount.getAccountNumber(),LocalDate.now().toString(),amount+""));
                        
                        transferSenderAccountNumber.clear();
                        transferSenderCustomerName.setText("");
                        transferSenderContactNumber.setText("");
                        transferSenderCurrentBalance.setText("");
                        transferReceiverAccountNumber.clear();
                        transferReceiverCustomerName.setText("");
                        transferReceiverContactNumber.setText("");
                        transferReceiverCurrentBalance.setText("");
                        transferAmount.clear();
                        transferSenderPersonImage.imageProperty().set(null);
                        transferReceiverPersonImage.imageProperty().set(null);
                        notify.confirm("Transfer Succesfull", amount+"");
                    }
                } catch (SQLException ex) {
                    notify.alert("Transaction Failed !!!", "Error from database");
                    Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
            {
                notify.alert("Not Sufficient Amount", "");
            }
        }
    }

    @FXML
    private void customerProfileSearchButtonActionEvent(ActionEvent event) {
        if(customerProfileContactNumber.getText().length()!= 10||customerProfileContactNumber.getText().isEmpty())
        {
            notify.warning("Invalid Contact number", customerProfileContactNumber.getText());
        }
        else
        {
            
            customerList.stream().filter((customer)->(customer.getContact().equals(customerProfileContactNumber.getText()))).forEach((customer)->{
                customerProfileName.setText(customer.getCustomerName());
                customerProfileDob.setText(customer.getDob().replaceAll("-", "/"));
                customerProfileAddress.setText(customer.getAddress());
                accountList.stream().filter((account)->(account.getAccountNumber().equals(customer.getNumber()))).forEach((account)->{
                    customerProfileAccoutType.setText(account.getAccountType());
                    customerProfileCurrentBalance.setText(account.getCurrentBalance());
                });
                customerProfileGender.setText(customer.getGender());
                customerProfileContact.setText(customer.getContact());
                customerProfileEmail.setText(customer.getEmail());
                customerProfilePanNumber.setText(customer.getPan());
                customerProfileAdhaarNumber.setText(customer.getAdhaar());
                customerProfileAccountNumber.setText(customer.getNumber());
                
            });
            try {
                customerProfilePersonImage.setImage(new Image(new FileInputStream(RESOURCE_DIRECTORY+"\\p_"+customerProfileAccountNumber.getText())));
                customerProfileSignatureImage.setImage(new Image(new FileInputStream(RESOURCE_DIRECTORY+"\\s_"+customerProfileAccountNumber.getText())));
                
            } catch (FileNotFoundException ex) {
                notify.alert("Images Not Found", "Restart the software");
                Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void customerProfileSeeButtonActionEvent(ActionEvent event) {
        BMS.transactionList = FXCollections.observableArrayList();
        transactionList.stream().filter((transaction)->(customerProfileAccountNumber.getText().equals(transaction.getFromAccount())||customerProfileAccountNumber.getText().equals(transaction.getToAccount()))).forEach((transaction)->{
//            System.out.println("inserted");
            BMS.transactionList.add(new Transaction(transaction.getFromAccount(),transaction.getToAccount(),transaction.getTransactionDate(),transaction.getAmount()));
        });
        try {
            Parent node = FXMLLoader.load(getClass().getResource("PersonTransactions.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Transactions");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/icon.png")));
            stage.setScene(new Scene(node));
            stage.show();
        } catch (IOException ex) {
            notify.alert("Sorry", "Unable to open");
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void accountEdit(TableColumn.CellEditEvent<Account, String> event) {
       copiedAccountNumber = ((Account) event.getTableView().getItems().get(event.getTablePosition().getRow())).getAccountNumber();
       updateAccountAccountNumber.setText(copiedAccountNumber);
       notify.confirm("Text Copied", copiedAccountNumber);
    }

    @FXML
    private void customerEdit(TableColumn.CellEditEvent<Customer, String> event) {
       String copiedContactNumber = ((Customer) event.getTableView().getItems().get(event.getTablePosition().getRow())).getContact();
       customerProfileContactNumber.setText(copiedContactNumber);
       notify.confirm("Text Copied", copiedContactNumber);
    }
    
    
    
   
}
