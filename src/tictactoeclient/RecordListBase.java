package tictactoeclient;

import Recorder.GamePlay;
import Recorder.GamePlayManager;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import services.Navigator;
import static tictactoeclient.BoardUI.scoreP1;
import static tictactoeclient.BoardUI.scoreP2;

public class RecordListBase extends AnchorPane {

    protected final Text text;
    protected final ImageView imageView;
    protected final ListView recordListView;
    private ArrayList<GamePlay> recordedGamePlays;
    private GamePlayManager manager;
    protected Button btnBack;
    
    public RecordListBase() {
        btnBack= new Button();
        manager=new GamePlayManager();
        ArrayList<GamePlay> recordedGamePlays=manager.getAllGamePlays();
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
                scoreP1=0;
                scoreP2=0;
            }
        });
        
        getChildren().add(text);
        getChildren().add(btnBack);
        getChildren().add(imageView);
        getChildren().add(recordListView);
        this.receiveRecords(recordedGamePlays);


    }
        public void receiveRecords(ArrayList<GamePlay> recordedGamePlays) {
        recordListView.getItems().clear();
        ObservableList<RecordCellBase> cellList = FXCollections.observableArrayList();
        
        for (GamePlay player : recordedGamePlays) {
            RecordCellBase cell = new RecordCellBase();
            cell.playerOne.setText(player.getPlayers().get("player1"));
            cell.playerTwo.setText(player.getPlayers().get("player2"));
            
            // Add cell to the ListView
            recordListView.getItems().add(cell);
            cell.button.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    //String name;
                   // name = cell.player.getText();
                    
                   // System.out.println(" ========== invitation");
                  //  System.out.println(InvitationResponse);
                    final int cellIndex = recordListView.getItems().indexOf(cell);
                  
                  Navigator.navigateTo(new RecordPlay(recordedGamePlays.get(cellIndex)), e);
                }
            });

        }
    }
    
}
