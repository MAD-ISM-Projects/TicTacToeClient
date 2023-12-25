package tictactoeclient;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class RecordCellBase extends AnchorPane {

    protected final Text playerOne;
    protected final Button button;
    protected final Text playerTwo;
    protected final Text text;

    public RecordCellBase() {

        playerOne = new Text();
        button = new Button();
        playerTwo = new Text();
        text = new Text();

        setId("AnchorPane");
        setPrefHeight(72.0);
        setPrefWidth(701.0);
        setStyle("-fx-border-radius: 20;");

        playerOne.setLayoutX(35.0);
        playerOne.setLayoutY(47.0);
        playerOne.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerOne.setStrokeWidth(0.0);
        playerOne.setText("Mayora");
        playerOne.setWrappingWidth(151.525390625);
        playerOne.setFont(new Font(30.0));

        button.setLayoutX(590.0);
        button.setLayoutY(24.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(28.0);
        button.setPrefWidth(84.0);
        button.setText("Play");

        playerTwo.setLayoutX(321.0);
        playerTwo.setLayoutY(48.0);
        playerTwo.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerTwo.setStrokeWidth(0.0);
        playerTwo.setText("Ranoma");
        playerTwo.setWrappingWidth(194.525390625);
        playerTwo.setFont(new Font(30.0));

        text.setLayoutX(207.0);
        text.setLayoutY(49.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("VS");
        text.setWrappingWidth(40.525390625);
        text.setFont(new Font(30.0));

        getChildren().add(playerOne);
        getChildren().add(button);
        getChildren().add(playerTwo);
        getChildren().add(text);

    }
}
