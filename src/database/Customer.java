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
public class Customer {
        private final SimpleStringProperty number;
        private final SimpleStringProperty customerName;
        private final SimpleStringProperty gender;
        private final SimpleStringProperty dob;
        private final SimpleStringProperty address;
        private final SimpleStringProperty contact;
        private final SimpleStringProperty eMail;
        private final SimpleStringProperty adhaar;
        private final SimpleStringProperty pan;

       public Customer(String number,String name,String gender,String dob,String address,String contact,String email,String adhaar, String pan)
       {
           this.number = new SimpleStringProperty(number);
           customerName = new SimpleStringProperty(name);
           this.gender = new SimpleStringProperty(gender);
           this.dob = new SimpleStringProperty(dob);
           this.address = new SimpleStringProperty(address);
           this.contact = new SimpleStringProperty(contact);
           this.eMail = new SimpleStringProperty(email);
           this.adhaar = new SimpleStringProperty(adhaar);
           this.pan = new SimpleStringProperty(pan);
       }
       public String getNumber()
       {
           return this.number.get();
       }
       public String getCustomerName()
       {
           return customerName.get();
       }
       public String getGender()
       {
           return gender.get();
       }
       public String getDob()
       {
           return dob.get();
       }
       public String getAddress()
       {
           return address.get();
       }
       public String getContact()
       {
           return contact.get();
       }
       public String getEmail()
       {
           return eMail.get();
       }
       public String getAdhaar()
       {
           return  adhaar.get();
       }
       public String getPan()
       {
           return pan.get();
       }    
}
