/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;

import javafx.scene.control.Alert;
import tictactoeclient.Models.DTOPlayer;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import tictactoeclient.Enum.Mark;

/**
 *
 * @author NEW LAP
 */
public class BordBane extends AnchorPane {

    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected  Button btn0;
    protected  Button btn1;
    protected  Button btn2;
    protected  Button btn3;
    protected  Button btn4;
    protected  Button btn5;
    protected  Button btn6;
    protected  Button btn7;
    protected  Button btn8;
    protected  Text player1Name;
    protected  Text player2Name;
    protected  Text ticText;
    protected  Text tacText;
    protected  Text toeText;
    protected  Button scoreBtnX;
    protected  Button scoreBtnO;
    protected  Text scorePlayer1;
    protected  Text scorePlayer2;
    protected  Button recordGame;
    protected DTOPlayer player1;
    protected DTOPlayer player2;
    protected boolean isPlayerTurn=false;
    public BordBane() {
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        btn0 = new Button();
        btn1 = new Button();
        btn2 = new Button();
        btn3 = new Button();
        btn4 = new Button();
        btn5 = new Button();
        btn6 = new Button();
        btn7 = new Button();
        btn8 = new Button();
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

        btn0.setMnemonicParsing(false);
        btn0.setOpacity(0.7);
        btn0.setPrefHeight(100.0);
        btn0.setPrefWidth(100.0);
        btn0.setStyle("-fx-background-color: #FFFFFF;");
        GridPane.setMargin(btn0, new Insets(0.0));
        btn0.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            if(isPlayerTurn()){
                btn0.setText(player1.getMark().toString());
                btn0.setDisable(true);
                isWinning(player1.getMark());
            }else{
                btn0.setText(player2.getMark().toString());
                btn0.setDisable(true);
                isWinning(player2.getMark());
            }
        });
        GridPane.setColumnIndex(btn1, 1);
        btn1.setMnemonicParsing(false);
        btn1.setOpacity(0.7);
        btn1.setPrefHeight(100.0);
        btn1.setPrefWidth(100.0);
        btn1.setStyle("-fx-background-color: #FFFFFF;");
        btn1.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            if(isPlayerTurn()){
                btn1.setText(player1.getMark().toString());
                btn1.setDisable(true);
                isWinning(player1.getMark());
            }else{
                btn1.setText(player2.getMark().toString());
                btn1.setDisable(true);
                isWinning(player2.getMark());
            }
        });
        GridPane.setColumnIndex(btn2, 2);
        btn2.setMnemonicParsing(false);
        btn2.setOpacity(0.7);
        btn2.setPrefHeight(100.0);
        btn2.setPrefWidth(100.0);
        btn2.setStyle("-fx-background-color: #FFFFFF;");
        btn2.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            if(isPlayerTurn()){
                btn2.setText(player1.getMark().toString());
                btn2.setDisable(true);
                isWinning(player1.getMark());
            }else{
                btn2.setText(player2.getMark().toString());
                btn2.setDisable(true);
                isWinning(player2.getMark());
            }
        });
        GridPane.setRowIndex(btn3, 1);
        btn3.setMnemonicParsing(false);
        btn3.setOpacity(0.7);
        btn3.setPrefHeight(100.0);
        btn3.setPrefWidth(100.0);
        btn3.setStyle("-fx-background-color: #FFFFFF;");
        btn3.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            if(isPlayerTurn()){
                btn3.setText(player1.getMark().toString());
                btn3.setDisable(true);
                isWinning(player1.getMark());
            }else{
                btn3.setText(player2.getMark().toString());
                btn3.setDisable(true);
                isWinning(player2.getMark());
            }
        });
        GridPane.setColumnIndex(btn4, 1);
        GridPane.setRowIndex(btn4, 1);
        btn4.setMnemonicParsing(false);
        btn4.setOpacity(0.7);
        btn4.setPrefHeight(100.0);
        btn4.setPrefWidth(100.0);
        btn4.setStyle("-fx-background-color: #FFFFFF;");
        btn4.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            if(isPlayerTurn()){
                btn4.setText(player1.getMark().toString());
                btn4.setDisable(true);
                isWinning(player1.getMark());
            }else{
                btn4.setText(player2.getMark().toString());
                btn4.setDisable(true);
                isWinning(player2.getMark());
            }
        });
        GridPane.setColumnIndex(btn5, 2);
        GridPane.setRowIndex(btn5, 1);
        btn5.setMnemonicParsing(false);
        btn5.setOpacity(0.7);
        btn5.setPrefHeight(100.0);
        btn5.setPrefWidth(100.0);
        btn5.setStyle("-fx-background-color: #FFFFFF;");
        btn5.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            if(isPlayerTurn()){
                btn5.setText(player1.getMark().toString());
                btn5.setDisable(true);
                isWinning(player1.getMark());
            }else{
                btn5.setText(player2.getMark().toString());
                btn5.setDisable(true);
                isWinning(player2.getMark());
            }
        });
        GridPane.setRowIndex(btn6, 2);
        btn6.setMnemonicParsing(false);
        btn6.setOpacity(0.7);
        btn6.setPrefHeight(100.0);
        btn6.setPrefWidth(100.0);
        btn6.setStyle("-fx-background-color: #FFFFFF;");
        btn6.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            if(isPlayerTurn()){
                btn6.setText(player1.getMark().toString());
                btn6.setDisable(true);
                isWinning(player1.getMark());
            }else{
                btn6.setText(player2.getMark().toString());
                btn6.setDisable(true);
                isWinning(player2.getMark());
            }
        });
        GridPane.setColumnIndex(btn7, 1);
        GridPane.setRowIndex(btn7, 2);
        btn7.setMnemonicParsing(false);
        btn7.setOpacity(0.7);
        btn7.setPrefHeight(100.0);
        btn7.setPrefWidth(100.0);
        btn7.setStyle("-fx-background-color: #FFFFFF;");
        btn7.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            if(isPlayerTurn()){
                btn7.setText(player1.getMark().toString());
                btn7.setDisable(true);
                isWinning(player1.getMark());
            }else{
                btn7.setText(player2.getMark().toString());
                btn7.setDisable(true);
                isWinning(player2.getMark());
            }
        });
        GridPane.setColumnIndex(btn8, 2);
        GridPane.setRowIndex(btn8, 2);
        btn8.setMnemonicParsing(false);
        btn8.setOpacity(0.7);
        btn8.setPrefHeight(100.0);
        btn8.setPrefWidth(100.0);
        btn8.setStyle("-fx-background-color: #FFFFFF;");
        btn8.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            if(isPlayerTurn()){
                btn8.setText(player1.getMark().toString());
                btn8.setDisable(true);
                isWinning(player1.getMark());
            }else{
                btn8.setText(player2.getMark().toString());
                btn8.setDisable(true);
                isWinning(player2.getMark());
            }
        });
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
        scoreBtnX.setText("1");

        scoreBtnO.setLayoutX(676.0);
        scoreBtnO.setLayoutY(170.0);
        scoreBtnO.setMnemonicParsing(false);
        scoreBtnO.setText("0");

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

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(btn0);
        gridPane.getChildren().add(btn1);
        gridPane.getChildren().add(btn2);
        gridPane.getChildren().add(btn3);
        gridPane.getChildren().add(btn4);
        gridPane.getChildren().add(btn5);
        gridPane.getChildren().add(btn6);
        gridPane.getChildren().add(btn7);
        gridPane.getChildren().add(btn8);
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
    private void isWinning(Mark mark){
        if(btn0.getText().equals(mark.toString())&&btn1.getText().equals(mark.toString())&&btn2.getText().equals(mark.toString())){
            if(mark.X==mark){
                showAlert(player1);
                isPlayerTurn=!isPlayerTurn;
            }else{
                showAlert(player2);
            }
        }else if(btn3.getText().equals(mark.toString())&&btn4.getText().equals(mark.toString())&&btn5.getText().equals(mark.toString())){
            if(mark.X==mark){
                showAlert(player1);
                isPlayerTurn=!isPlayerTurn;
            }else{
                showAlert(player2);
            }
        }else if(btn6.getText().equals(mark.toString())&&btn7.getText().equals(mark.toString())&&btn8.getText().equals(mark.toString())){
            if(mark.X==mark){
                showAlert(player1);
                isPlayerTurn=!isPlayerTurn;
            }else{
                showAlert(player2);
            }
        }else if(btn0.getText().equals(mark.toString())&&btn3.getText().equals(mark.toString())&&btn6.getText().equals(mark.toString())){
            if(mark.X==mark){
                showAlert(player1);
                isPlayerTurn=!isPlayerTurn;
            }else{
                showAlert(player2);
            }
        }else if(btn1.getText().equals(mark.toString())&btn4.getText().equals(mark.toString())&&btn7.getText().equals(mark.toString())){
            if(mark.X==mark){
                showAlert(player1);
                isPlayerTurn=!isPlayerTurn;
            }else{
                showAlert(player2);
            }
        }else if(btn2.getText().equals(mark.toString())&&btn5.getText().equals(mark.toString())&&btn8.getText().equals(mark.toString())){
            if(mark.X==mark){
                showAlert(player1);
                isPlayerTurn=!isPlayerTurn;
            }else{
                showAlert(player2);
            }
        }else if(btn0.getText().equals(mark.toString())&&btn4.getText().equals(mark.toString())&&btn8.getText().equals(mark.toString())){
            if(mark.X==mark){
                showAlert(player1);
                isPlayerTurn=!isPlayerTurn;
            }else{
                showAlert(player2);
            }
        }else if(btn2.getText().equals(mark.toString())&&btn4.getText().equals(mark.toString())&&btn6.getText().equals(mark.toString())){
            if(mark.X==mark){
                showAlert(player1);
                isPlayerTurn=!isPlayerTurn;
            }else{
                showAlert(player2);
            }
        }
        else if(
                !btn0.getText().isEmpty()&&
                !btn1.getText().isEmpty()&&
                !btn2.getText().isEmpty()&&
                !btn3.getText().isEmpty()&&
                !btn4.getText().isEmpty()&&
                !btn5.getText().isEmpty()&&
                !btn6.getText().isEmpty()&&
                !btn7.getText().isEmpty()&&
                !btn8.getText().isEmpty()
                
                ){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Draw");
            alert.setHeaderText("Draw Draw");
            alert.showAndWait();
        }
        
    }
    private boolean isPlayerTurn(){
        if(isPlayerTurn){
            isPlayerTurn=!isPlayerTurn;
        }else{
            isPlayerTurn=!isPlayerTurn;
        }
        return isPlayerTurn;
    }
    public void showAlert(DTOPlayer player){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Winner");
        alert.setHeaderText(player.getName()+" Win");
        alert.showAndWait();
    }
}
