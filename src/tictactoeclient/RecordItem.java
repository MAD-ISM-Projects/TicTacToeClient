package tictactoeclient;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class RecordItem extends Pane {

    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label player1Name;
    protected final Label player2Name;
    protected final Button button;

    public RecordItem() {

        label = new Label();
        label0 = new Label();
        label1 = new Label();
        player1Name = new Label();
        player2Name = new Label();
        button = new Button();

        setPrefHeight(38.0);
        setPrefWidth(562.0);
        setStyle("-fx-background-color: white; -fx-background-radius: 12;");

        label.setLayoutX(69.0);
        label.setLayoutY(11.0);
        label.setText("player 1 : ");

        label0.setLayoutX(373.0);
        label0.setLayoutY(11.0);
        label0.setText("player 2 :  ");

        label1.setLayoutX(254.0);
        label1.setLayoutY(11.0);
        label1.setText("VS");
        label1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        player1Name.setLayoutX(161.0);
        player1Name.setLayoutY(11.0);

        player2Name.setLayoutX(447.0);
        player2Name.setLayoutY(11.0);

        button.setId("record-player");
        button.setLayoutX(517.0);
        button.setLayoutY(4.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(31.0);
        button.setPrefWidth(80.0);
        //button.getStylesheets().add("/tictactoeclient/Views/../style.css");
        button.setText("Replay");
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(player1Name);
        getChildren().add(player2Name);
        getChildren().add(button);

    }
}
