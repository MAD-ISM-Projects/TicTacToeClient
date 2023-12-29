/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;

import DTO.Authentication;
import DTO.ClientRequest;
import DTO.ClientRequestHeader;
import DTO.NextStep;
import WinnerScreen.WinnerScreenBase;
import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Button;
import network.connection.NetworkConnection;
import services.Navigator;
import static tictactoeclient.BoardUI.winner;

/**
 *
 * @author NEW LAP
 */
public class OnlineBoard extends BoardUI {

    // boolean validStep = true;
    NetworkConnection network;
    String opponentName;
    String myName;
    String currentGamePlaySteps;

    String playerCharacter;
    String opponentCharacter;

    public OnlineBoard(String opponentName, String myName,boolean isTurn) {
        network = NetworkConnection.getConnection();
        System.out.println(" this is 2 " + opponentName);
        isPlayerTurn = isTurn;

        if (isPlayerTurn) {
            playerCharacter = "X";
            opponentCharacter = "O";
        } else {
            playerCharacter = "O";
            opponentCharacter = "X";
        }
        this.opponentName = opponentName;
        this.myName=myName;
        player1Name.setText(myName);
        player2Name.setText(opponentName);
        currentGamePlaySteps = "";
        Thread nextOppoenentMove = new Thread(() -> {
            while (true) {
                String replyOnNextMove = network.getMessage();
                if(isWin()) return;
                if(!replyOnNextMove.startsWith("{"))
                  replyOnNextMove="{"+replyOnNextMove;
                System.out.print("message got successfully: " + replyOnNextMove);

//                ClientRequest clientRequest = new Gson().fromJson(replyOnNextMove, ClientRequest.class);
//                System.out.print("another player next step is: " + clientRequest);
                NextStep nextStep = new Gson().fromJson(replyOnNextMove, NextStep.class);
                System.out.print("another player next step is: " + nextStep);
                if (replyOnNextMove != null && !currentGamePlaySteps.contains(String.valueOf(nextStep.getNextStepIndex()))) {
                    Platform.runLater(() -> {
                        // Update UI components here
                        bordRecorder.get(nextStep.getNextStepIndex()).setText(opponentCharacter);
                        
                        currentGamePlaySteps += nextStep.getNextStepIndex();
                        System.out.println("other opponent playee : "+currentGamePlaySteps);
                        continueGame();
                        isPlayerTurn();
                    });
                }
            }
        });
        nextOppoenentMove.start();

    }

    @Override
    protected void doPlay(Button btn) {
        if (btn.getText().isEmpty()) {
            if (isPlayerTurn()) {
                System.out.println(playerCharacter + " turn");
                btn.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 36;");
                btn.setText(playerCharacter);
                player1Name.setFill(javafx.scene.paint.Color.valueOf("#ff8fda"));
                player2Name.setFill(javafx.scene.paint.Color.valueOf("#ffffff"));
                player1Name.setFill(javafx.scene.paint.Color.valueOf("#ffffff"));
                player2Name.setFill(javafx.scene.paint.Color.valueOf("#ff8fda"));
                //easyLevel();
                stopGame();
                System.out.println("stop game successfully");
                ClientRequest nextStepRequest = new ClientRequest(ClientRequestHeader.nextStep, opponentName, Integer.parseInt(currentGamePlaySteps.substring(currentGamePlaySteps.length() - 1)));
                System.out.println("nextStepRequest " + nextStepRequest.toString());
                String nextStepRequestData = nextStepRequest.toJson();
                System.out.println("nextStepRequestData " + nextStepRequestData);
                network.sentMessage(nextStepRequestData);
                if(isWin()) return; 
                
            } else {
                System.out.println(opponentCharacter + " turn");

            }
        }
    }

    protected void stopGame() {
        for (Node node : gridPane.getChildren()) {
            node.setDisable(true);
        }
    }

    protected void continueGame() {
        for (Node node : gridPane.getChildren()) {
            node.setDisable(false);
        }
    }

    @Override
    protected void addListen(Button btn) {
        btn.setOnAction(e -> {
            currentGamePlaySteps += bordRecorder.indexOf(btn);
            System.out.println("player played :"+currentGamePlaySteps);

            doPlay(btn);

            if (isWin()) {
                if (isPlayerTurn) {
                    BordBase.winner = 1;
                    BordBase.page = 4;
                    Navigator.navigateTo(new WinnerScreenBase("YOU", winner, page), e);
                    isPlayerTurn = !isPlayerTurn;
                    BordBase.scoreP1++;
                } else {
                    BordBase.winner = 2;
                    BordBase.page = 4;
                    Navigator.navigateTo(new WinnerScreenBase("YOU", winner, page), e);
                    BordBase.scoreP2++;
                }
                resetGame();
            } else if (isDraw() == true) {
                BordBase.winner = 3;
                BordBase.page = 4;
                Navigator.navigateTo(new WinnerScreenBase("YOU", winner, page), e);
                resetGame();
                isPlayerTurn = !isPlayerTurn;
            }
            scoreBtnX.setText(Integer.toString(scoreP1));
            scoreBtnO.setText(Integer.toString(scoreP2));
        }
        );
    }

}