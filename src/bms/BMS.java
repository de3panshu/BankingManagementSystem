/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bms;

import database.Transaction;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author HD
 */
public class BMS extends Application {
	public static Stage STAGE;
	public static ObservableList<Transaction> transactionList;
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		STAGE = primaryStage;
		Parent root = FXMLLoader.load(getClass().getResource("/ui/LoginUI.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Banking Management System");
		primaryStage.setScene(scene);
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/icon.png")));
		primaryStage.show();
		
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
}
