package tictactoeclient;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class UsersItemListBase extends AnchorPane {

    protected final Label player;
    protected final Label Score;
    protected final Label Status;
    protected final Button button;

    public UsersItemListBase(String userName, String status, int score) {

        player = new Label();
        Score = new Label();
        Status = new Label();
        button = new Button();

        setId("AnchorPane");
        setPrefHeight(54.0);
        setPrefWidth(563.0);
        setStyle("-fx-background-radius: 50; -fx-border-color: #8b91b5;");

        player.setLayoutX(39.0);
        player.setLayoutY(12.0);
        player.setText("         "+userName);
        //player.setText("player");
        player.setFont(new Font(20.0));

        Score.setLayoutX(189.0);
        Score.setLayoutY(12.0);
        //Score.setText("Score");
        Score.setText(String.valueOf(score));
        Score.setFont(new Font(20.0));

        Status.setLayoutX(333.0);
        Status.setLayoutY(12.0);
        Status.setText("Status");
        Status.setFont(new Font(20.0));

        button.setLayoutX(454.0);
        button.setLayoutY(5.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(44.0);
        button.setPrefWidth(95.0);
        button.setStyle("-fx-background-color: #8b91b5;");
        button.setText("Invite");
        button.setTextFill(javafx.scene.paint.Color.WHITE);
        button.setFont(new Font(20.0));

        getChildren().add(player);
        getChildren().add(Score);
        getChildren().add(Status);
        getChildren().add(button);

    }
}
