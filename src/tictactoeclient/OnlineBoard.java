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

    boolean validStep = true;
    NetworkConnection network;
    String opponentName;
    String currentGamePlayStep;
    Thread nextOppoenentMove;

    String playerCharacter;
    String opponentCharacter;

    public OnlineBoard(String opponentName, boolean isTurn) {
        network = NetworkConnection.getConnection();
        System.out.println(" this is 2 " + opponentName);
        isPlayerTurn = isTurn;

        if (isPlayerTurn) {
            playerCharacter = "X";
            opponentCharacter = "O";
        } else {
            {
                playerCharacter = "O";
                opponentCharacter = "X";
            }
        };
        this.opponentName = opponentName;
        currentGamePlayStep = "";
    }

    @Override
    protected void doPlay(Button btn) {
        if (btn.getText().isEmpty()) {
            if (isPlayerTurn()) {
                btn.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 36;");
                btn.setText(playerCharacter);
                player1Name.setFill(javafx.scene.paint.Color.valueOf("#ff8fda"));
                player2Name.setFill(javafx.scene.paint.Color.valueOf("#ffffff"));
                if (isWin()) {
                    return;
                }
                player1Name.setFill(javafx.scene.paint.Color.valueOf("#ffffff"));
                player2Name.setFill(javafx.scene.paint.Color.valueOf("#ff8fda"));
                //easyLevel();
                stopGame();
                ClientRequest nextStepRequest = new ClientRequest(ClientRequestHeader.nextStep, opponentName, Integer.parseInt(currentGamePlayStep.substring(currentGamePlayStep.length() - 1)));
                String nextStepRequestData = nextStepRequest.toJson();
                network.sentMessage(nextStepRequestData);
                nextOpponentStep();

            } else {
                nextOpponentStep();
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

    public void nextOpponentStep() {

        nextOppoenentMove = new Thread(() -> {
            while (!validStep) {

                String replyOnNextMove = network.getMessage();
                NextStep nextStep = new Gson().fromJson(replyOnNextMove, NextStep.class);

                if (replyOnNextMove != null && !currentGamePlayStep.contains(String.valueOf(nextStep.getNextStepIndex()))) {
                    validStep=false;
                    bordRecorder.get(nextStep.getNextStepIndex()).setText(opponentCharacter);
                    continueGame();
                    isPlayerTurn();
                    nextOppoenentMove.destroy();

                }
            }
        }
        );
        nextOppoenentMove.start();

    }

    @Override
    protected void addListen(Button btn) {
        btn.setOnAction(e -> {
            currentGamePlayStep += bordRecorder.indexOf(btn);

            doPlay(btn);

            if (isWin()) {
                if (isPlayerTurn) {
                    BordBase.winner = 1;
                    BordBase.page = 2;
                    Navigator.navigateTo(new WinnerScreenBase("YOU", winner, page), e);
                    isPlayerTurn = !isPlayerTurn;
                    BordBase.scoreP1++;
                } else {
                    BordBase.winner = 2;
                    BordBase.page = 2;
                    Navigator.navigateTo(new WinnerScreenBase("YOU", winner, page), e);
                    BordBase.scoreP2++;
                }
                resetGame();
            } else if (isDraw() == true) {
                BordBase.winner = 3;
                BordBase.page = 2;
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
