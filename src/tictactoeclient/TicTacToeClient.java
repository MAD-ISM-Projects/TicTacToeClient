/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;

import UIViews.Auth.SignIn;
import UIViews.Auth.SignUp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Ramez
 */
public class TicTacToeClient extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new SignIn();
        root.setId("pane");
        
        Scene scene = new Scene(root,280,500);
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
