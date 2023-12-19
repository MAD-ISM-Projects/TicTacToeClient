package tictactoeclient;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import services.Navigator;
import services.Saver;

public  class SetPlayersBase extends AnchorPane {

    protected final ImageView mode_image;
    protected final Text text_tic;
    protected final Text text_tac;
    protected final Text text_toe;
    protected final Button startButton;
    protected final TextField playerName2;
    protected final TextField playerName1;

    public SetPlayersBase() {

        mode_image = new ImageView();
        text_tic = new Text();
        text_tac = new Text();
        text_toe = new Text();
        startButton = new Button();
        playerName2 = new TextField();
        playerName1 = new TextField();
        playerName1.setPromptText("Player X Name");
        playerName2.setPromptText("Player O Name");
        playerName1.setPrefWidth(187);
        playerName2.setPrefWidth(187);
        playerName1.setPrefHeight(30.0);
        playerName2.setPrefHeight(30.0);

        

        setId("AnchorPane");
        setPrefHeight(550.0);
        setPrefWidth(800.0);
        setStyle("-fx-background-color: #34365C;");

        mode_image.setFitHeight(200.0);
        mode_image.setFitWidth(200.0);
        mode_image.setLayoutX(300.0);
        mode_image.setLayoutY(74.0);
        mode_image.setPickOnBounds(true);
        mode_image.setPreserveRatio(true);
        mode_image.setRotate(13.0);
        mode_image.setImage(new Image(getClass().getResource("xoImg.png").toExternalForm()));

        text_tic.setFill(javafx.scene.paint.Color.WHITE);
        text_tic.setLayoutX(312.0);
        text_tic.setLayoutY(313.0);
        text_tic.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text_tic.setStrokeWidth(0.0);
        text_tic.setText("Tic");
        text_tic.setFont(new Font(MyFont.MY_FONT, 40.0));

        text_tac.setFill(javafx.scene.paint.Color.valueOf("#ff8fda"));
        text_tac.setLayoutX(370.0);
        text_tac.setLayoutY(313.0);
        text_tac.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text_tac.setStrokeWidth(0.0);
        text_tac.setText("Tac");
        text_tac.setFont(new Font(MyFont.MY_FONT, 40.0));

        text_toe.setFill(javafx.scene.paint.Color.WHITE);
        text_toe.setLayoutX(436.0);
        text_toe.setLayoutY(313.0);
        text_toe.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text_toe.setStrokeWidth(0.0);
        text_toe.setText("Toe");
        text_toe.setFont(new Font(MyFont.MY_FONT, 40.0));

        startButton.setLayoutX(315.0);
        startButton.setLayoutY(461.0);
        startButton.setMnemonicParsing(false);
        startButton.setPrefHeight(37.0);
        startButton.setPrefWidth(187.0);
        startButton.setStyle("-fx-background-radius: 10; -fx-background-color: #8b91d5;");
        startButton.setText("Start");
        startButton.setTextFill(javafx.scene.paint.Color.WHITE);
        startButton.setFont(new Font(MyFont.MY_FONT, 19.0));
        
        startButton.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                if(playerName1.getText().isEmpty()&&playerName2.getText().isEmpty()){
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("Please Enter players Name");
                    a.show();
                }
                else if(playerName1.getText().isEmpty()){
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("Player1 name is required");
                    a.show();
                }else if(playerName2.getText().isEmpty()){
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("Player2 name is required");
                    a.show();
                }else{
                    Saver saver=Saver.saverObject();
                    saver.setPlayer1Name(playerName1.getText());
                    saver.setPlayer2Name(playerName2.getText());
                    Navigator.navigateTo(new BordBase(playerName1.getText(),playerName2.getText()),e);
                }
            }
        });


        playerName2.setLayoutX(315.0);
        playerName2.setLayoutY(399.0);

        playerName1.setLayoutX(315.0);
        playerName1.setLayoutY(353.0);

        getChildren().add(mode_image);
        getChildren().add(text_tic);
        getChildren().add(text_tac);
        getChildren().add(text_toe);
        getChildren().add(startButton);
        getChildren().add(playerName2);
        getChildren().add(playerName1);

    }
}
