/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;

import WinnerScreen.WinnerScreenBase;
import javafx.scene.control.Button;
import services.Navigator;
import services.Saver;

/**
 *
 * @author Husayn
 */

public class BordBase extends BoardUI{
    public BordBase(){}
    public BordBase(String player1,String player2){
        player1Name.setText(player1);
        player2Name.setText(player2);
    }
    Saver saver=Saver.saverObject();
    @Override
    protected void addListen(Button btn) {
    btn.setOnAction(
                        e->{
                            doPlay(btn);
                            if(isWin()){
                                if(isPlayerTurn){
                                    BordBase.winner = 1;
                                    BordBase.page = 1; 
                                    Navigator.navigateTo(new WinnerScreenBase(saver.getPlayer1Name(),winner,page),e);
                                     isPlayerTurn=!isPlayerTurn;
                                     BordBase.scoreP1++;
                                }
                                else{
                                    BordBase.winner = 1;
                                    BordBase.page = 1;
                                    Navigator.navigateTo(new WinnerScreenBase(saver.getPlayer2Name(),winner,page), e);
                                    BordBase.scoreP2++;
                                }
                                resetGame();
                            }else if(isDraw()==true){
                                    BordBase.winner = 3;
                                    BordBase.page=1;
                                    Navigator.navigateTo(new WinnerScreenBase("This ",winner,page), e);
                                    resetGame();
                                    isPlayerTurn=!isPlayerTurn;
                            }
                            scoreBtnX.setText(Integer.toString(scoreP1));
                            scoreBtnO.setText(Integer.toString(scoreP2));
                        }
                );
                
    }
    
}