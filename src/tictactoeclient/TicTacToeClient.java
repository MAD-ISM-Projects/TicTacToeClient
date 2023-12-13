/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;
<<<<<<< HEAD
import java.util.Map;
=======

import UIViews.Auth.SignIn;
import UIViews.Auth.SignUp;
>>>>>>> a4ddc649c48c203da37c29f8dddf7da8486378fd
import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
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
<<<<<<< HEAD
        Parent root = new StartpageBase();
        root.setId("pane");
        
        Scene scene = new Scene(root,800,550);
        //scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
=======
        Parent root = new SignIn();
        
        Scene scene = new Scene(root,280,500);
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
>>>>>>> a4ddc649c48c203da37c29f8dddf7da8486378fd
        
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
