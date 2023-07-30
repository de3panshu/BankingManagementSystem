/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author HD
 */
public class BMSDataBase {
    
    
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/";
    public static Connection connection = null;
    private static Statement statement = null;
    private static final String DB_NAME = "BMS";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    public BMSDataBase()
    {
        createConnection();
    }
    
    public void createConnection()
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded...");  //comment this line
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_NAME, USERNAME, PASSWORD);
            System.out.println("Connection Establish...");  //comment this line
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
    }
    public void createAccountTable()
    {
       String TABLE_NAME = "Account";
       try
       {
           statement = connection.createStatement();
           DatabaseMetaData dbms = connection.getMetaData();
           ResultSet tables = dbms.getTables(null, null, TABLE_NAME.toUpperCase(), null);
           if(!tables.next())
           {
               statement.execute(" CREATE TABLE "+TABLE_NAME+ "(" 
                       +"           number char(11) primary key,"
                       +"           cif char(11)," 
                       +"           type char(15),"
                       +"           balance varchar(10));"
               );
               statement.executeUpdate("insert into account values('BANK','-----------','---------------','0');");
           }
           
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
    }
    public void createCustomerTable()
    {
       String TABLE_NAME = "Customer";
       try
       {
           statement = connection.createStatement();
           DatabaseMetaData dbms = connection.getMetaData();
           ResultSet tables = dbms.getTables(null, null, TABLE_NAME.toUpperCase(), null);
           if(!tables.next())
           {
               statement.execute(" CREATE TABLE "+TABLE_NAME+ "(" 
                       +"           number char(11),"
                       +"           name char(30)," 
                       +"           gender char(6),"
                       +"           dob date,"
                       +"           address varchar(30),"
                       +"           contact char(10),"
                       +"           email varchar(30),"
                       +"           adhaar char(12) primary key,"
                       +"           pan varchar(10));"
               );
           }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
    }
    public void createTansactionTable()
    {
       String TABLE_NAME = "Transaction";
       try
       {
           statement = connection.createStatement();
           DatabaseMetaData dbms = connection.getMetaData();
           ResultSet tables = dbms.getTables(null, null, TABLE_NAME.toUpperCase(), null);
           if(!tables.next())
           {
               statement.execute(" CREATE TABLE "+TABLE_NAME+ "(" 
                       +"           fromAcc char(11),"
                       +"           toAcc char(11),"
                       +"           onDate Date,"
                       +"           amount varchar(10));"
               );
           }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
    }
    
    public boolean addAccountData(String accountNumber, String cif, String accountType, String initialBalance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
