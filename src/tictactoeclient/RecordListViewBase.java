package tictactoeclient;

import Recorder.GamePlay;
import Recorder.GamePlayManager;
import java.net.URL;
import java.util.ArrayList;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import tictactoeclient.RecordItem;
import tictactoeclient.UsersItemListBase;

public class RecordListViewBase extends AnchorPane {

    protected final ListView RecoredListView;
    protected final Text text;
    protected final ImageView imageView;
    GamePlayManager gp;

    public RecordListViewBase() {

        RecoredListView = new ListView();
        text = new Text();
        imageView = new ImageView();
        gp = new GamePlayManager();

        setId("AnchorPane");
        setPrefHeight(550.0);
        setPrefWidth(800.0);
        setStyle("-fx-background-color: #34365C;");

        RecoredListView.setLayoutX(75.0);
        RecoredListView.setLayoutY(234.0);
        RecoredListView.setPrefHeight(281.0);
        RecoredListView.setPrefWidth(641.0);
        //RecordItem[] usersArray = new RecordItem[6];
        ArrayList<GamePlay> gamePlays=gp.getGamePlaysList();
        //ArrayList<>
        //System.out.println("Husan"+gp);
    //ArrayList<> records = new ArrayList<Records>();
        for (int i = 0; i < gamePlays.size(); i++) {
            //gamePlays.get(i) = new RecordItem();
            //RecoredListView.getItems().add(usersArray[i]);
        }

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(338.0);
        text.setLayoutY(59.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Records");
        text.setFont(new Font(35.0));

        imageView.setFitHeight(153.0);
        imageView.setFitWidth(158.0);
        imageView.setLayoutX(323.0);
        imageView.setLayoutY(72.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
       // imageView.setImage(new Image(getClass().getResource("../../../../../../Downloads/Group%201.png").toExternalForm()));
         URL imageUrl = getClass().getResource("xoImg.png");
          if (imageUrl == null) {
         System.out.println("Image not found!");
        } else {
           imageView.setImage(new Image(imageUrl.toExternalForm()));
        }
        getChildren().add(RecoredListView);
        getChildren().add(text);
        getChildren().add(imageView);

    }
}
