package tictactoeclient;

import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class RecordListBase extends AnchorPane {

    protected final Text text;
    protected final ImageView imageView;
    protected final ListView recordListView;

    public RecordListBase() {

        text = new Text();
        imageView = new ImageView();
        recordListView = new ListView();

        setId("AnchorPane");
        setPrefHeight(550.0);
        setPrefWidth(800.0);
        setStyle("-fx-background-color: #34365C;");

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(250.0);
        text.setLayoutY(58.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Recorded Games");
        text.setWrappingWidth(308.50927734375);
        text.setFont(new Font(41.0));

        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(304.0);
        imageView.setLayoutY(73.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        recordListView.setLayoutX(57.0);
        recordListView.setLayoutY(230.0);
        recordListView.setPrefHeight(293.0);
        recordListView.setPrefWidth(688.0);

        getChildren().add(text);
        getChildren().add(imageView);
        getChildren().add(recordListView);

    }
}
