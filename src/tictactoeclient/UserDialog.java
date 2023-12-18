/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;

/**
 *
 * @author mayar
 */


import java.util.Optional;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class UserDialog {
    protected DialogPane dialogPaneName;
    protected GridPane gridPane;
    protected Label labelFirstPlayer;
    Node Button;
    Dialog<ButtonType> dialog;
    
    public void ExistDialog() {
        // Create a new DialogPane and GridPane
        dialogPaneName = new DialogPane();
        gridPane = new GridPane();

        // Create a Label to display the error message
        labelFirstPlayer = new Label("Repeated UserName try another one !");

        // Set header text and padding for the DialogPane
        dialogPaneName.setHeaderText(" ERROR  ");
        dialogPaneName.setPadding(new Insets(0, 10, 0, 10));

        // Add the error label to the GridPane
        gridPane.add(labelFirstPlayer, 0, 0);

        // Set the GridPane as the content of the DialogPane
        dialogPaneName.setContent(gridPane);

        // Create a new Dialog and set its properties
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane(dialogPaneName);
        dialog.setTitle("Existed UserName");

        // Create an "Ok" button type
        ButtonType OkButtonType = new ButtonType("Ok");

        // Add the "Ok" button type to the DialogPane's button types
        dialogPaneName.getButtonTypes().addAll(OkButtonType);

        // Show the dialog and wait for user interaction
        Optional<ButtonType> clickedButton = dialog.showAndWait();
    }
    public static void dialogSinUp(String message) {
        DialogPane dialogPaneName = new DialogPane();
        GridPane gridPane = new GridPane();
        Label labelFirstPlayer = new Label(message);

        dialogPaneName.setPadding(new Insets(0, 10, 0, 10));

        labelFirstPlayer.setFont(new Font("Comic Sans MS Bold", 18.0));
        labelFirstPlayer.setTextFill(Color.WHITE);

        dialogPaneName.setPadding(new Insets(0, 10, 0, 10));

        dialogPaneName.setPadding(new Insets(0, 10, 0, 10));

        dialogPaneName.setStyle("-fx-background-color: #22726e;");

        gridPane.add(labelFirstPlayer, 0, 0);
        gridPane.setMinSize(400, 100);

        dialogPaneName.setContent(gridPane);

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane(dialogPaneName);
        dialog.setTitle("Sin Up!");

        ButtonType OkButtonType = new ButtonType("Ok");

        dialogPaneName.getButtonTypes().addAll(OkButtonType);

        Node okButton = dialogPaneName.lookupButton(OkButtonType);
        okButton.setStyle("-fx-background-color: #ff9900; -fx-border-radius: 15; -fx-background-radius: 15; -fx-fontfamily: 'Comic-Sans MS'");

        Optional<ButtonType> clickedButton = dialog.showAndWait();
    }

}
