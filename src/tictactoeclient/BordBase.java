/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;

import Recorder.GamePlayManager;
import WinnerScreen.WinnerScreenBase;
import java.util.HashMap;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import services.Navigator;
import services.Saver;

/**
 *
 * @author Husayn
 */

public class BordBase extends BoardUI{
    String currentGamePlaySteps="";
    //int stepper=0;
    Map<String, String> players;
    GamePlayManager manager;
    
    public BordBase(){}
    public BordBase(String player1,String player2){
        player1Name.setText(player1);
        player2Name.setText(player2);

        
   recordGame.addEventHandler(ActionEvent.ACTION, (event) -> {
            manager = new GamePlayManager();
            players = new HashMap<>();
            players.put("player1", player1Name.getText());
            players.put("player2", player2Name.getText());  
     });
    }
    

    Saver saver=Saver.saverObject();
    

    @Override
    protected void addListen(Button btn) {
    btn.setOnAction(
                        e->{
                            doPlay(btn);
                           currentGamePlaySteps+=bordRecorder.indexOf(btn);
                           //stepper++;
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
                                   if(manager!=null) 
                                   {
                                       manager.saveGamePlay( players, currentGamePlaySteps);
                                       currentGamePlaySteps="";
                                   }
//                               else {
//                                    //we need to flush all the steps to re-record 
//                                    currentGamePlaySteps="";                 
//                               }
                                resetGame();
                            }else if(isDraw()==true){
                                    BordBase.winner = 3;
                                    BordBase.page=1;
                                    Navigator.navigateTo(new WinnerScreenBase("This ",winner,page), e);
                                                                    
                                   if(manager!=null) 
                                   {
                                       manager.saveGamePlay( players, currentGamePlaySteps);
                                       currentGamePlaySteps="";
                                   }
                                    resetGame();
                                    isPlayerTurn=!isPlayerTurn;
                            }
                            
                            scoreBtnX.setText(Integer.toString(scoreP1));
                            scoreBtnO.setText(Integer.toString(scoreP2));
                        }
                );
                
    }
    
}