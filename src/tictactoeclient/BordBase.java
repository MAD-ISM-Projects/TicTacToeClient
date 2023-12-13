/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;

import Recorder.GamePlayManager;
import Recorder.GamePlay;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.event.ActionEvent;
import tictactoeclient.Models.DTOPlayer;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import tictactoeclient.Enum.Mark;

/**
 *
 * @author Husayn
 */

public class BordBase extends AnchorPane {
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected  Button recordGame;
    protected  Text player1Name;
    protected  Text player2Name;
    protected  Text ticText;
    protected  Text tacText;
    protected  Text toeText;
    protected  Button scoreBtnX;
    protected  Button scoreBtnO;
    protected  Text scorePlayer1;
    protected  Text scorePlayer2;
    protected DTOPlayer player1;
    protected DTOPlayer player2;
    protected boolean isPlayerTurn=false;
    static int scoreP1=0;
    static int scoreP2=0;
    String currentGamePlaySteps="";
    int stepper=0;
    String gamePlayId = "GamePlay";
    Map<String, String> players;
    GamePlayManager manager;
    public BordBase() {
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        player1Name = new Text();
        player2Name = new Text();
        ticText = new Text();
        tacText = new Text();
        toeText = new Text();
        scoreBtnX = new Button();
        scoreBtnO = new Button();
        scorePlayer1 = new Text();
        scorePlayer2 = new Text();
        recordGame = new Button();
        player1 = new DTOPlayer("Raneem",Mark.X);
        player2 = new DTOPlayer("Mayar",Mark.O);
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(550.0);
        setPrefWidth(800.0);
        setStyle("-fx-background-color: #34365C;");

        gridPane.setLayoutX(235.0);
        gridPane.setLayoutY(135.0);
        gridPane.setPrefHeight(330.0);
        gridPane.setPrefWidth(330.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        showBoard();
        player1Name.setFill(javafx.scene.paint.Color.valueOf("#fcfcfc"));
        player1Name.setLayoutX(50.0);
        player1Name.setLayoutY(150.0);
        player1Name.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player1Name.setStrokeWidth(0.0);
        player1Name.setText(player1.getName());
        player1Name.setFont(new Font("Times New Roman Italic", 36.0));

        player2Name.setFill(javafx.scene.paint.Color.valueOf("#ff8fda"));
        player2Name.setLayoutX(620.0);
        player2Name.setLayoutY(150.0);
        player2Name.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player2Name.setStrokeWidth(0.0);
        player2Name.setText(player2.getName());
        player2Name.setFont(new Font("Times New Roman Italic", 36.0));

        ticText.setFill(javafx.scene.paint.Color.valueOf("#ff8fda"));
        ticText.setLayoutX(272.0);
        ticText.setLayoutY(100.0);
        ticText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        ticText.setStrokeWidth(0.0);
        ticText.setText("Tic");
        ticText.setFont(new Font("Lucida Handwriting Italic", 36.0));

        tacText.setFill(javafx.scene.paint.Color.WHITE);
        tacText.setLayoutX(348.0);
        tacText.setLayoutY(100.0);
        tacText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        tacText.setStrokeWidth(0.0);
        tacText.setText("Tac");
        tacText.setFont(new Font("Lucida Handwriting Italic", 36.0));

        toeText.setFill(javafx.scene.paint.Color.valueOf("#ff8fda"));
        toeText.setLayoutX(434.0);
        toeText.setLayoutY(100.0);
        toeText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        toeText.setStrokeWidth(0.0);
        toeText.setText("Toe");
        toeText.setFont(new Font("Lucida Handwriting Italic", 36.0));

        scoreBtnX.setLayoutX(113.0);
        scoreBtnX.setLayoutY(170.0);
        scoreBtnX.setMnemonicParsing(false);
        scoreBtnX.setText(Integer.toString(scoreP1));
        scoreBtnX.setDisable(true);
        scoreBtnO.setLayoutX(676.0);
        scoreBtnO.setLayoutY(170.0);
        scoreBtnO.setMnemonicParsing(false);
        scoreBtnO.setText(Integer.toString(scoreP2));
        scoreBtnO.setDisable(true);
        
        scorePlayer1.setFill(javafx.scene.paint.Color.valueOf("#aea5b8"));
        scorePlayer1.setLayoutX(59.0);
        scorePlayer1.setLayoutY(191.0);
        scorePlayer1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        scorePlayer1.setStrokeWidth(0.0);
        scorePlayer1.setText("Score");

        scorePlayer2.setFill(javafx.scene.paint.Color.valueOf("#aea5b8"));
        scorePlayer2.setLayoutX(622.0);
        scorePlayer2.setLayoutY(191.0);
        scorePlayer2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        scorePlayer2.setStrokeWidth(0.0);
        scorePlayer2.setText("Score");

        recordGame.setLayoutX(640.0);
        recordGame.setLayoutY(471.0);
        recordGame.setMnemonicParsing(false);
        recordGame.setPrefHeight(30.0);
        recordGame.setPrefWidth(100.0);
        recordGame.setStyle("-fx-background-color:#ff8fda;");
        recordGame.setText("Record");
        recordGame.setTextFill(javafx.scene.paint.Color.WHITE);
        recordGame.setFont(new Font("System Bold", 18.0));
        recordGame.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            manager = new GamePlayManager();
            players = new HashMap<>();
            players.put("player1", player1Name.getText());
            players.put("player2", player2Name.getText());                       
        });



        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        getChildren().add(gridPane);
        getChildren().add(player1Name);
        getChildren().add(player2Name);
        getChildren().add(ticText);
        getChildren().add(tacText);
        getChildren().add(toeText);
        getChildren().add(scoreBtnX);
        getChildren().add(scoreBtnO);
        getChildren().add(scorePlayer1);
        getChildren().add(scorePlayer2);
        getChildren().add(recordGame);
    }
    private Button createButton(int index){    
                Button btn = new Button();
                btn.setMnemonicParsing(false);
                btn.setOpacity(0.7);
                btn.setPrefHeight(100.0);
                btn.setPrefWidth(100.0);
                btn.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 46;");
                btn.setOnAction(
                        e->{
                            int btnIndex=index;
                            doPlay(btn,btnIndex);
                            if(isWin()){
                                if(isPlayerTurn){
                                     showAlert(player1);
                                     isPlayerTurn=!isPlayerTurn;
                                     BordBase.scoreP1++;
                                }
                                else{
                                    showAlert(player2);
                                    BordBase.scoreP2++;
                                }
                               if(manager!=null) manager.saveGamePlay(gamePlayId, players, currentGamePlaySteps);
                               else {
                                    //we need to flush all the steps to re-record 
                                    currentGamePlaySteps="";                 
                               }
                                   
                                resetGame();
                            }else if(isDraw()==true){
                                    //we need to flush all the steps to re-record 
                                    currentGamePlaySteps="";
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                    alert.setTitle("Draw");
                                    alert.setHeaderText("No Winner");
                                    alert.showAndWait();   
                                    if(manager!=null) manager.saveGamePlay(gamePlayId, players, currentGamePlaySteps);
                                    else {
                                         //we need to flush all the steps to re-record 
                                         currentGamePlaySteps="";                 
                                    }
                                    resetGame();
                                    isPlayerTurn=!isPlayerTurn;
                            }
                            scoreBtnX.setText(Integer.toString(scoreP1));
                            scoreBtnO.setText(Integer.toString(scoreP2));
                            System.out.println("steps: "+currentGamePlaySteps);
                        }
                        
                );
                
                return btn;
    }
    private void showBoard(){
        for(int row=0;row<3;row++){
            for(int col=0;col<3;col++){
                Button btn = createButton(stepper++);
                gridPane.add(btn,col,row);
            }
        }
    }
    private void doPlay(Button btn,int btnIndex){
        if(btn.getText().isEmpty()){   
            currentGamePlaySteps+=btnIndex;
            btn.setText(isPlayerTurn()?player1.getMark().toString():player2.getMark().toString());          
        }
    }
    private boolean TicTac(List<Node> buttons){
        String mark=(isPlayerTurn?player1.getMark().toString():player2.getMark().toString());
        for(Node btn: buttons){
            Button button = (Button) btn;
            if(!(button.getText().equals(mark))) return false;
        }
        return true;
    }
    //sub list from 0 to n-1
    private boolean isWin(){
        for(int line=0 ; line < 3 ; line++){
            if(TicTac(gridPane.getChildren().subList(line*3, (line+1)*3))) return true;
        }
        for(int col=0 ; col < 3 ; col++){
            List<Node> colBtn= new ArrayList<>();
            for(int row = 0; row < 3; row++){
                  colBtn.add(gridPane.getChildren().get(row*3+ col));
            }
            if(TicTac(colBtn)) return true;
        }
        
        List<Node> leftDiag = Arrays.asList(gridPane.getChildren().get(0),gridPane.getChildren().get(4),gridPane.getChildren().get(8));
        List<Node> RightDiag=Arrays.asList(gridPane.getChildren().get(2),gridPane.getChildren().get(4),gridPane.getChildren().get(6));
        if(TicTac(leftDiag)||TicTac(RightDiag)){
            return true;
        }
        return false;
    }
    private boolean isDraw(){
        for(Node child:gridPane.getChildren()){
            if(child instanceof Button){
                Button btn=(Button) child;
                if(btn.getText().isEmpty()) return false;
            }
        }
        return true;
    }
    private boolean isPlayerTurn(){
        if(isPlayerTurn){
            isPlayerTurn=!isPlayerTurn;
        }else{
            isPlayerTurn=!isPlayerTurn;
        }
        return isPlayerTurn;
    }
    public void resetGame(){
        for(Node node:gridPane.getChildren()){
            Button button=(Button) node;
            button.setText("");
            button.setDisable(false);
        }
    }
    public void showAlert(DTOPlayer player){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Winner");
        alert.setHeaderText(player.getName()+" Win");
        alert.showAndWait();
    }
}