package tictactoeclient;

import DTO.ClientRequest;
import DTO.ClientRequestHeader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.ArrayList;
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
import static tictactoeclient.BoardUI.scoreP1;
import static tictactoeclient.BoardUI.scoreP2;

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
    protected final Button btnBack;

    private Socket soc;
    private DataInputStream dis;
    private PrintStream print;
    String jsonString;
    private NetworkConnection network;

    public SignIn() {
        network = NetworkConnection.getConnection();
        label = new Label();
        pane = new Pane();
        userNameTextField = new TextField();
        passwordTextField = new PasswordField();
        btnBack = new Button();

        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        join = new Button();
        line = new Line();
        label3 = new Label();
        signUp = new Button();

        setId("pane");
        setPrefHeight(550.0);
        setPrefWidth(800.0);

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
                if (passwordTextField.getText().length() < 8) {
                    passwordTextField.setStyle("-fx-border-color: red;");
                } else if (userNameTextField.getText().isEmpty()) {
                    userNameTextField.setStyle("-fx-border-color: red;");
                } else {
                    String name = userNameTextField.getText();
                    ClientRequest signInRequest = new ClientRequest(ClientRequestHeader.signIn, userNameTextField.getText(), passwordTextField.getText());
                    String singInResponse = signInRequest.toJson();
                    network.sentMessage(singInResponse);
                    System.out.println(singInResponse);
                    passwordTextField.clear();
                    userNameTextField.clear();
                    String replyOnSingIn = network.getMessage();
                    System.out.println(" reply on signin " + replyOnSingIn);
                    if (Integer.parseInt(replyOnSingIn) > 0) {
                        // showMessageDialog(null, "signed In successfully");
                        //network.closeConnection();
                        Navigator.navigateTo(new AvailablePlayersBase(name), event);
                    } else {
                        showMessageDialog(null, "There is no player named " + name + " or wrong password");
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                showMessageDialog(null, "Lost Connection To The Server");
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
        signUp.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Navigator.navigateTo(new SignUp(), e);
            }
        });

        passwordTextField.setLayoutX(65.0);
        passwordTextField.setLayoutY(162.0);
        passwordTextField.setStyle("-fx-background-radius: 6;");

        getChildren().add(label);
        pane.getChildren().add(userNameTextField);
        btnBack.setLayoutX(60.0);
        btnBack.setLayoutY(50.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(37.0);
        btnBack.setPrefWidth(80.0);
        btnBack.setStyle("-fx-background-radius: 10;");
        btnBack.setText("Back");
        btnBack.setTextFill(javafx.scene.paint.Color.valueOf("#8b76a4"));
        btnBack.setFont(new Font(MyFont.MY_FONT, 19.0));
        btnBack.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Navigator.navigateTo(new ChooseModeBase(), e);
                scoreP1 = 0;
                scoreP2 = 0;
            }
        });
        getChildren().add(btnBack);

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
