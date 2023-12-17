package tictactoeclient;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dto.RequestHeader;
import dto.SignInBase;
import dto.SignUpBase;
import dto.clientRequests;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import services.Navigator;

public class SignIn extends AnchorPane {

    protected final Label label;
    protected final Pane pane;
    protected final TextField userNameTextField;

    protected final PasswordField passwordTextField;

    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Button join;
    protected final Line line;
    protected final Label label3;
    protected final Button signUp;

    private Socket soc;
    private DataInputStream dis;
    private PrintStream print;
    String jsonString ;
    String defaultIp="127.0.0.1";


    public SignIn() {

        label = new Label();
        pane = new Pane();
        userNameTextField = new TextField();
        passwordTextField = new PasswordField();

        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        join = new Button();
        line = new Line();
        label3 = new Label();
        signUp = new Button();


        setId("pane");
        setPrefHeight(500.0);
        setPrefWidth(850.0);

        getStylesheets().add("/tictactoeclient/style.css");

        label.setLayoutX(126);
        label.setLayoutY(120);
        label.setMinHeight(16);
        label.setMinWidth(69);


        pane.setLayoutX(232.0);
        pane.setLayoutY(149.0);
        pane.setPrefHeight(330.0);
        pane.setPrefWidth(336.0);
        pane.setStyle("-fx-background-color: white; -fx-background-radius: 30;");

        userNameTextField.setLayoutX(65.0);
        userNameTextField.setLayoutY(96.0);
        userNameTextField.setStyle("-fx-background-radius: 6;");


        label0.setLayoutX(40.0);
        label0.setLayoutY(24.0);
        label0.setText("Sign In");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#5427d0"));
        label0.setFont(new Font(24.0));


        label1.setLayoutX(59.0);
        label1.setLayoutY(68.0);
        label1.setText("User Name");

        label2.setLayoutX(64.0);
        label2.setLayoutY(134.0);
        label2.setText("Password");

        join.setLayoutX(127.0);
        join.setLayoutY(210.0);


        join.setMnemonicParsing(false);
        join.setPrefHeight(25.0);
        join.setPrefWidth(83.0);
        join.setStyle("-fx-background-radius: 6; -fx-background-color: #5427d0;");
        join.setText("Join");
        join.setTextFill(javafx.scene.paint.Color.valueOf("#f8f8f8"));
        join.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
        try {
            if(passwordTextField.getText().length()<8){
                passwordTextField.setStyle("-fx-border-color: red;");
            }
            else{
            this.soc = new Socket("127.0.0.1",5005);
            this.dis=new DataInputStream(soc.getInputStream());
            this.print=new PrintStream(soc.getOutputStream());
            String name=userNameTextField.getText();

            //JsonObject playerJson = new JsonObject();
            SignInBase s=new SignInBase(userNameTextField.getText(),passwordTextField.getText());
          //  playerJson.addProperty("name", userNameTextField.getText());
          //  playerJson.addProperty("password", passwordTextField.getText());
            //playerJson.addProperty("ip", defaultIp);
         RequestHeader request = new RequestHeader(clientRequests.signIn,s);
          //  JsonObject jsonRequest = new JsonObject();
          //  jsonRequest.addProperty("request", "signIn");
           // jsonRequest.add("player", playerJson);

            // Convert JsonObject to JSON string
         //   String jsonString =request.getJson();
           

            print.println(request.getJson());
            // Clear text fields
            passwordTextField.clear();
            userNameTextField.clear();
            // Read server reply
            String serverReply = dis.readLine();

            // Show a dialog based on the server reply
            if (serverReply != null && !serverReply.isEmpty()) {
              //  showMessageDialog(null, (Integer.parseInt(serverReply) >= 0) ? "Signed up successfully" : "Already signed up");
                System.out.println("Signed up successfully");
            } else {
              System.out.println("Signed up not successfully");
                //showMessageDialog(null, "Error: Server reply is null or empty");
            }            }
        } catch (IOException ex) {
           System.out.println("Lost Connection To The Server"); 
           // showMessageDialog(null, "Lost Connection To The Server");

        }
          
                         
        });
        line.setEndX(130.0);
        line.setEndY(21.0);
        line.setLayoutX(168.0);
        line.setLayoutY(227.0);
        line.setOpacity(0.43);
        line.setStartX(-130.0);
        line.setStartY(21.0);
        line.setStroke(javafx.scene.paint.Color.valueOf("#000000ae"));

        label3.setLayoutX(38.0);
        label3.setLayoutY(257.0);
        label3.setText("Don't have an account?");

        signUp.setLayoutX(186.0);
        signUp.setLayoutY(252.0);
        signUp.setMnemonicParsing(false);
        signUp.setPrefHeight(31.0);
        signUp.setPrefWidth(83.0);

        signUp.setStyle("-fx-background-radius: 6; -fx-background-color: white;");
        signUp.setText("Sign Up");
        signUp.setTextFill(javafx.scene.paint.Color.valueOf("#5427d0"));
        signUp.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
             
                Navigator.navigateTo(new SignUp(), e);

            }
        });

        
        passwordTextField.setLayoutX(65.0);
        passwordTextField.setLayoutY(162.0);
        passwordTextField.setStyle("-fx-background-radius: 6;");

        getChildren().add(label);
        pane.getChildren().add(userNameTextField);

        pane.getChildren().add(label0);
        pane.getChildren().add(label1);
        pane.getChildren().add(label2);
        pane.getChildren().add(join);
        pane.getChildren().add(line);
        pane.getChildren().add(label3);
        pane.getChildren().add(signUp);
        pane.getChildren().add(passwordTextField);

        getChildren().add(pane);

    }
}
