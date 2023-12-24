package tictactoeclient;

import DTO.ClientRequest;
import DTO.ClientRequestHeader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import static javax.swing.JOptionPane.showMessageDialog;
import network.connection.NetworkConnection;
import services.Navigator;

public class SignUp extends AnchorPane {

    protected final Label label;
    protected final Pane pane;
    protected final TextField userNameTextField;
    protected final PasswordField passwordTextField;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final PasswordField confirmPasswordTextField;
    protected final Label label3;
    protected final Button join;
    protected final Line line;
    protected final Label label4;
    protected final Button signIn;
 
    String jsonString ;
    boolean checkRegExPassward;
    boolean checkRegExName;
    String regexPassword = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{5,10}";
    String regexUserName = "^[A-Za-z]\\w.{5,30}$";
    NetworkConnection network ; 
    public SignUp() {
        network = new NetworkConnection();
        label = new Label();
        pane = new Pane();
        userNameTextField = new TextField();
        passwordTextField = new PasswordField();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        confirmPasswordTextField = new PasswordField();
        label3 = new Label();
        join = new Button();
        line = new Line();
        label4 = new Label();
        signIn = new Button();

        setId("pane");
        setPrefHeight(550.0);
        setPrefWidth(800.0);
        getStylesheets().add("/tictactoeclient/style.css");

        label.setLayoutX(126);
        label.setLayoutY(120);
        label.setMinHeight(16);
        label.setMinWidth(69);

        pane.setLayoutX(292.0);
        pane.setLayoutY(137.0);
        pane.setPrefHeight(318.0);
        pane.setPrefWidth(279.0);
        pane.setStyle("-fx-background-color: white; -fx-background-radius: 30;");

        userNameTextField.setLayoutX(65.0);
        userNameTextField.setLayoutY(92.0);
        userNameTextField.setStyle("-fx-background-radius: 6;");

        passwordTextField.setLayoutX(65.0);
        passwordTextField.setLayoutY(145.0);
        passwordTextField.setStyle("-fx-background-radius: 6;");

        label0.setLayoutX(40.0);
        label0.setLayoutY(24.0);
        label0.setText("Sign Up");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#5427d0"));
        label0.setFont(new Font(24.0));

        label1.setLayoutX(65.0);
        label1.setLayoutY(75.0);
        label1.setText("User Name");

        label2.setLayoutX(65.0);
        label2.setLayoutY(128.0);
        label2.setText("Password");

        confirmPasswordTextField.setLayoutX(65.0);
        confirmPasswordTextField.setLayoutY(200.0);
        confirmPasswordTextField.setStyle("-fx-background-radius: 6;");

        label3.setLayoutX(65.0);
        label3.setLayoutY(183.0);
        label3.setText("Confirm Password");

        join.setLayoutX(98.0);
        join.setLayoutY(237.0);
        join.setMnemonicParsing(false);
        join.setPrefHeight(25.0);
        join.setPrefWidth(83.0);
        join.setStyle("-fx-background-radius: 6; -fx-background-color: #5427d0;");
        join.setText("Join");
        join.setTextFill(javafx.scene.paint.Color.valueOf("#f8f8f8"));
        join.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
             try {
            checkRegExName = isValidUsername(userNameTextField.getText()); //JsonObject jsonObject = new Gson().fromJson(serverReply, JsonObject.class);
            if(passwordTextField.getText().length()<8){
                passwordTextField.setStyle("-fx-border-color: red;");
                
            }

            else if(confirmPasswordTextField.getText().equals(passwordTextField)){

                passwordTextField.setStyle("-fx-border-color: red;");
                confirmPasswordTextField.setStyle("-fx-border-color: red;");
                passwordTextField.clear();
                confirmPasswordTextField.clear();
  
            }
            else{
                
//                jsonString="{\"request\":\"signUp\",\"player\":{\"name\":\""+userNameTextField.getText()+"\""
//                        + ","
//                        + "\"password\":\""+passwordTextField.getText()+"\"}}";
                ClientRequest signUpRequest=new ClientRequest(ClientRequestHeader.signUp,userNameTextField.getText(),passwordTextField.getText());
                String signUpResponse=signUpRequest.toJson();
                System.out.println(signUpResponse);
                network.sentMessage(signUpResponse);
                network.sentMessage(jsonString);
                passwordTextField.clear();
                userNameTextField.clear();
                confirmPasswordTextField.clear();
                
                String serverReply = network.getMessage();
                if (Integer.parseInt(serverReply) > 0) {
                        showMessageDialog(null, "Signed up successfully");
                        // Close the connection after successful signup
                        network.closeConnection();
                        Navigator.navigateTo(new SignIn(), event);
                    } else {
                        showMessageDialog(null, "Already signed up");
                    }
                }
            } catch (Exception ex) {
            
            showMessageDialog(null, "Lost Connection To The Server");

        }
                   
        });

        line.setEndX(100.0);
        line.setLayoutX(139.0);
        line.setLayoutY(270.0);
        line.setOpacity(0.43);
        line.setStartX(-100.0);
        line.setStroke(javafx.scene.paint.Color.valueOf("#000000ae"));

        label4.setLayoutX(50.0);
        label4.setLayoutY(279.0);
        label4.setText("Already have an account");

        signIn.setLayoutX(184.0);
        signIn.setLayoutY(275.0);
        signIn.setMnemonicParsing(false);
        signIn.setPrefHeight(17.0);
        signIn.setPrefWidth(59.0);
        signIn.setStyle("-fx-background-radius: 6; -fx-background-color: white;");
        signIn.setText("Sign In");
        signIn.setTextFill(javafx.scene.paint.Color.valueOf("#5427d0"));
        signIn.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                
                Navigator.navigateTo(new SignIn(), e);

            }
        });

        getChildren().add(label);
        pane.getChildren().add(userNameTextField);
        pane.getChildren().add(passwordTextField);
        pane.getChildren().add(label0);
        pane.getChildren().add(label1);
        pane.getChildren().add(label2);
        pane.getChildren().add(confirmPasswordTextField);
        pane.getChildren().add(label3);
        pane.getChildren().add(join);
        pane.getChildren().add(line);
        pane.getChildren().add(label4);
        pane.getChildren().add(signIn);
        getChildren().add(pane);

    }
    
    public boolean isValidPassword(String password) {
        if (password.matches(regexPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidUsername(String name) {
        if (name.matches(regexUserName)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPassword(String password, String confirmpassword) {
        if (password.equals(confirmpassword) && password.matches(regexPassword)) {
            return true;
        } else {
            return false;
        }
}
}