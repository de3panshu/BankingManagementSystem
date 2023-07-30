/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author HD
 */
public class Account {
   private final SimpleStringProperty accountNumber;
        private final SimpleStringProperty cifNumber;
        private final SimpleStringProperty accountType;
        private final SimpleStringProperty currentBalance;
        
        public Account(String accNumber,String cifNumber, String accType, String balance)
        {
            accountNumber = new SimpleStringProperty(accNumber);
            this.cifNumber = new SimpleStringProperty(cifNumber);
            accountType = new SimpleStringProperty(accType);
            currentBalance = new SimpleStringProperty(balance);
        }

        public String getAccountNumber() {
            return accountNumber.get();
        }

        public String getCifNumber() {
            return cifNumber.get();
        }

        public String getAccountType() {
            return accountType.get();
        }

        public String getCurrentBalance() {
            return currentBalance.get();
        } 
        public void setCurrentBalance(String amount)
        {
            this.currentBalance.set(amount);
        }
        public void updateBalance(String amount)
        {
            this.currentBalance.set(amount);
        }
                
}
