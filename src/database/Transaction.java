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
public class Transaction {
    private final SimpleStringProperty fromAccount;
        private final SimpleStringProperty toAccount;
        private final SimpleStringProperty transactionDate;
        private final SimpleStringProperty amount;
        
        public Transaction(String from,String to,String date,String amount)
        {
            fromAccount = new SimpleStringProperty(from);
            toAccount = new SimpleStringProperty(to);
            transactionDate = new SimpleStringProperty(date);
            this.amount = new SimpleStringProperty(amount);
        }
        public String getFromAccount()
        {
            return fromAccount.get();
        }
        public String getToAccount()
        {
            return toAccount.get();
        }
        public String getTransactionDate()
        {
            return transactionDate.get();
        }
        public String getAmount()
        {
            return amount.get();
        }
}
