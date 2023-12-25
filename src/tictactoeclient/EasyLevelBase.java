package tictactoeclient;

import Recorder.GamePlayManager;
import WinnerScreen.WinnerScreenBase;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import services.Navigator;
import services.Saver;

public class EasyLevelBase extends BoardUI {
    Saver saver=Saver.saverObject();
        String currentGamePlaySteps="";
    //int stepper=0;
    Map<String, String> players;
    GamePlayManager manager;
    public EasyLevelBase(String p1,String pc) {
        player1Name.setText(p1);
        player2Name.setText(pc);
           recordGame.addEventHandler(ActionEvent.ACTION, (event) -> {
            manager = new GamePlayManager();
            players = new HashMap<>();
            players.put("player1", player1Name.getText());
            players.put("player2", player2Name.getText());  
     });
    }
    private void easyLevel(){
        Random random = new Random() ;
        boolean choise = false;
        while(!choise){
            int idxRow=random.nextInt(3);
            int idxCol=random.nextInt(3);
            if(bord[idxRow][idxCol].getText().isEmpty()){
                bord[idxRow][idxCol].setStyle("-fx-background-color: #FFFFFF; -fx-text-fill:#ff8fda; -fx-font-size: 36;");
                bord[idxRow][idxCol].setText("O");
                bord[idxRow][idxCol].setDisable(true);
                choise=true;
                isPlayerTurn();
            }else if(isDraw()){
                return;
            }
        }
    }    
    @Override
    protected void doPlay(Button btn){
        if(btn.getText().isEmpty()){   
            if(isPlayerTurn()){
                btn.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 36;");
                btn.setText("X");
                player1Name.setFill(javafx.scene.paint.Color.valueOf("#ff8fda"));
                player2Name.setFill(javafx.scene.paint.Color.valueOf("#ffffff"));
                if(isWin()) return;
                player1Name.setFill(javafx.scene.paint.Color.valueOf("#ffffff"));
                player2Name.setFill(javafx.scene.paint.Color.valueOf("#ff8fda"));   
                easyLevel();
            }
        }
    }
    @Override
    protected void addListen(Button btn) {
    btn.setOnAction(
                        e->{
                            doPlay(btn);
                           currentGamePlaySteps+=bordRecorder.indexOf(btn);

                            if(isWin()){
                                if(isPlayerTurn){
                                    BordBase.winner = 1;
                                    BordBase.page = 2; 
                                    Navigator.navigateTo(new WinnerScreenBase("YOU",winner,page),e);
                                     isPlayerTurn=!isPlayerTurn;
                                     BordBase.scoreP1++;
                                }
                                else{
                                    BordBase.winner = 2;
                                    BordBase.page = 2;
                                    Navigator.navigateTo(new WinnerScreenBase("YOU",winner,page), e);
                                    BordBase.scoreP2++;
                                }
                                   if(manager!=null) 
                                   {
                                       manager.saveGamePlay( players, currentGamePlaySteps);
                                       currentGamePlaySteps="";
                                   }
                                resetGame();
                            }else if(isDraw()==true){
                                    BordBase.winner = 3;
                                    BordBase.page=2;
                                    Navigator.navigateTo(new WinnerScreenBase("YOU",winner,page), e);
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
