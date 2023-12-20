package tictactoeclient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Records extends AnchorPane {

    protected final ListView recordsList;
    protected final Pane record;
    protected final Label player1;
    protected final Label player2;
    protected final Label vs;
    protected final ImageView RecordPlayer;

    public Records() {

        recordsList = new ListView();
        record = new Pane();
        player1 = new Label();
        player2 = new Label();
        vs = new Label();
        RecordPlayer = new ImageView();

        setId("records-screen");
        setPrefHeight(607.0);
        setPrefWidth(850.0);
        getStylesheets().add("/tictactoeclient/style.css");


        // Assuming recordsList is a ListView<Pane>
       ListView<Pane> recordsList = new ListView<>();

       recordsList.setLayoutX(89.0);
       recordsList.setLayoutY(304.0);
       recordsList.setOpacity(0.0);
       recordsList.setPrefHeight(295.0);
       recordsList.setPrefWidth(725.0);

       Pane record = new Pane();
       record.setLayoutX(106.0);
       record.setLayoutY(322.0);
       record.setPrefHeight(38.0);
       record.setPrefWidth(638.0);
       record.setStyle("-fx-background-color: white; -fx-background-radius: 12;");

       recordsList.setStyle("-fx-background-color: #34365C;");

       // Add the new record to the ListView directly
       // recordsList.getItems().add(record);

        player1.setLayoutX(110.0);
        player1.setLayoutY(11.0);
        player1.setText("player 1 : ");

        player2.setLayoutX(474.0);
        player2.setLayoutY(11.0);
        player2.setText("player 2 :  ");

        vs.setLayoutX(310.0);
        vs.setLayoutY(11.0);
        vs.setText("VS");

        RecordPlayer.setFitHeight(38.0);
        RecordPlayer.setFitWidth(55.0);
        RecordPlayer.setLayoutX(584.0);
        RecordPlayer.setPickOnBounds(true);
        RecordPlayer.setPreserveRatio(true);
        RecordPlayer.setImage(new Image(getClass().getResource("video-circle.png").toExternalForm()));

        getChildren().add(recordsList);
        record.getChildren().add(player1);
        record.getChildren().add(player2);
        record.getChildren().add(vs);
        record.getChildren().add(RecordPlayer);
        getChildren().add(record);

    }
}
