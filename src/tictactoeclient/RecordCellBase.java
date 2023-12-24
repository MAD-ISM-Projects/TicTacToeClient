package tictactoeclient;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class RecordCellBase extends AnchorPane {

    protected final Text text;
    protected final Button button;

    public RecordCellBase() {

        text = new Text();
        button = new Button();

        setId("AnchorPane");
        setPrefHeight(72.0);
        setPrefWidth(701.0);
        setStyle("-fx-border-radius: 20;");

        text.setLayoutX(57.0);
        text.setLayoutY(48.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Ranoma      Vs       Mayora");
        text.setWrappingWidth(471.525390625);
        text.setFont(new Font(30.0));

        button.setLayoutX(590.0);
        button.setLayoutY(24.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(28.0);
        button.setPrefWidth(84.0);
        button.setText("Play");

        getChildren().add(text);
        getChildren().add(button);

    }
}
