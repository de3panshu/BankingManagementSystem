/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author HD
 */
public final class Configuration {
    private String username;
    private String password;
    
    private static final String CONFIG_FILE = "resources/config.txt";

    public Configuration()
    {
        setUsername("someone");
        setPassword("someone");
        File file = new File(CONFIG_FILE);
        if(!file.exists())
        {
            try { 
                new File("resources").mkdirs();
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
            }
            configure();
        }
    }
    
    public void configure()
    {
        FileWriter writer = null;
        try {
            writer = new FileWriter(CONFIG_FILE);
            Gson gson = new Gson();
            gson.toJson(this,writer);
            
        } 
        catch (IOException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean isValidUser()
    {
        boolean validity = false;
        FileReader reader = null;
        try {
            reader = new FileReader(CONFIG_FILE);
            
            Configuration oldConfig = new Gson().fromJson(reader, Configuration.class);
            if(oldConfig.getUsername().equals(this.getUsername()) && oldConfig.getPassword().equals(this.getPassword()))
            validity = true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return validity;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public void setPassword(String password)
    {
        this.password = DigestUtils.sha1Hex(password);
    }
    
    public String getUsername()
    {
        return this.username;
    }
    
    public String getPassword()
    {
        return this.password;
    }
    
    
    public static void main(String [] args)
    {
//        System.out.println("Configuartion load");
         Configuration c = new Configuration();
//        System.out.println(c.getUsername());
//        System.out.println(c.getPassword());
//        
//        System.out.println("User1 created");
        c.setPassword("someone");
        c.setUsername("someone");
//        System.out.println(c.getUsername());
//        System.out.println(c.getPassword());
//        
//        System.out.println("User2 created");
          System.out.println(c.getUsername());
//        System.out.println(c.getPassword());
//        
//        System.out.println("Validate user1");
        System.out.println(c.isValidUser()?"true":"false");
//        System.out.println(c.getUsername()+"  "+user2.getUsername());
//        System.out.println(c.getPassword()+"  "+user2.getPassword());
//        
//        System.out.println("validate user2");
        c.setPassword("admin");
        c.setUsername("Deepanshu");
        System.out.println(c.isValidUser()?"true":"false");
//        System.out.println(c.getUsername()+"  "+user2.getUsername());
//        System.out.println(c.getPassword()+"  "+user2.getPassword());
//        
//        System.out.println("Configure user2");
        c.configure();
//        System.out.println(c.getUsername());
//        System.out.println(c.getPassword());
//        
//        System.out.println("Validate user2 again");
        System.out.println(c.isValidUser()?"true":"false");
//        System.out.println(c.getUsername()+"  "+user2.getUsername());
//        System.out.println(c.getPassword()+"  "+user2.getPassword());
    }
}