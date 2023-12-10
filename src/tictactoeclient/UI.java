package tictactoeclient;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class UI extends AnchorPane {

    protected final BorderPane borderPane;
    protected final Pane pane;
    protected final Text signUpText;
    protected final TextField yourNameTextField;
    protected final PasswordField passwordTextField;
    protected final Text yourNameText;
    protected final Text passwordText;
    protected final Button joinNowButton;
    protected final Text alreadyHaveAnAccountText;
    protected final Button logInButton;
    protected final Line line;

    public UI() {

        borderPane = new BorderPane();
        pane = new Pane();
        signUpText = new Text();
        yourNameTextField = new TextField();
        passwordTextField = new PasswordField();
        yourNameText = new Text();
        passwordText = new Text();
        joinNowButton = new Button();
        alreadyHaveAnAccountText = new Text();
        logInButton = new Button();
        line = new Line();

        setId("pane");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(800.0);
        setPrefWidth(230.0);
        getStylesheets().add("/tictactoeclient/style.css");

        borderPane.setLayoutX(27.0);
        borderPane.setLayoutY(156.0);
        borderPane.setPrefHeight(233.0);
        borderPane.setPrefWidth(220.0);

        BorderPane.setAlignment(pane, javafx.geometry.Pos.CENTER);
        pane.setPrefHeight(229.0);
        pane.setPrefWidth(300.0);
        pane.setStyle("-fx-background-color: white;");

        signUpText.setFill(javafx.scene.paint.Color.valueOf("#3115e8"));
        signUpText.setLayoutX(26.0);
        signUpText.setLayoutY(22.0);
        signUpText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        signUpText.setStrokeWidth(0.0);
        signUpText.setStyle("-fx-font-size: 20;");
        signUpText.setText("Sign Up");

        yourNameTextField.setLayoutX(26.0);
        yourNameTextField.setLayoutY(75.0);

        passwordTextField.setLayoutX(26.0);
        passwordTextField.setLayoutY(137.0);

        yourNameText.setLayoutX(26.0);
        yourNameText.setLayoutY(71.0);
        yourNameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        yourNameText.setStrokeWidth(0.0);
        yourNameText.setText("Your Name");

        passwordText.setLayoutX(26.0);
        passwordText.setLayoutY(133.0);
        passwordText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        passwordText.setStrokeWidth(0.0);
        passwordText.setText("Password");

        joinNowButton.setLayoutX(72.0);
        joinNowButton.setLayoutY(175.0);
        joinNowButton.setMnemonicParsing(false);
        joinNowButton.setStyle("-fx-background-color: blue;");
        joinNowButton.setText("Join now");
        joinNowButton.setTextFill(javafx.scene.paint.Color.WHITE);

        alreadyHaveAnAccountText.setFill(javafx.scene.paint.Color.valueOf("#683e3e"));
        alreadyHaveAnAccountText.setLayoutX(8.0);
        alreadyHaveAnAccountText.setLayoutY(219.0);
        alreadyHaveAnAccountText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        alreadyHaveAnAccountText.setStrokeWidth(0.0);
        alreadyHaveAnAccountText.setText("Already have an account");

        logInButton.setLayoutX(149.0);
        logInButton.setLayoutY(202.0);
        logInButton.setMnemonicParsing(false);
        logInButton.setStyle("-fx-background-color: white;");
        logInButton.setText("Log In");
        logInButton.setTextFill(javafx.scene.paint.Color.valueOf("#083aee"));

        line.setEndX(100.0);
        line.setLayoutX(107.0);
        line.setLayoutY(204.0);
        line.setStartX(-100.0);
        line.setStroke(javafx.scene.paint.Color.valueOf("#dad8d8"));
        borderPane.setCenter(pane);

        pane.getChildren().add(signUpText);
        pane.getChildren().add(yourNameTextField);
        pane.getChildren().add(passwordTextField);
        pane.getChildren().add(yourNameText);
        pane.getChildren().add(passwordText);
        pane.getChildren().add(joinNowButton);
        pane.getChildren().add(alreadyHaveAnAccountText);
        pane.getChildren().add(logInButton);
        pane.getChildren().add(line);
        getChildren().add(borderPane);

    }
}
