package tictactoeclient;

import WinnerScreen.WinnerScreenBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import services.Navigator;
import services.Saver;

import tictactoeclient.Enum.Mark;
import tictactoeclient.Models.DTOPlayer;

public class EasyLevelBase extends BoardUI {
    Saver saver=Saver.saverObject();
    public EasyLevelBase(String p1,String pc) {
        player1Name.setText(p1);
        player2Name.setText(pc);
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
    protected void doPlay(Button btn){
        if(btn.getText().isEmpty()){   
            if(isPlayerTurn()){
                btn.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 36;");
                btn.setText("X");
                player1Name.setFill(javafx.scene.paint.Color.valueOf("#ff8fda"));
                player2Name.setFill(javafx.scene.paint.Color.valueOf("#ffffff"));
                if(isWin()) return;
                easyLevel();
                player1Name.setFill(javafx.scene.paint.Color.valueOf("#ffffff"));
                player2Name.setFill(javafx.scene.paint.Color.valueOf("#ff8fda"));
            }
        }
    }
    protected void addListen(Button btn) {
    btn.setOnAction(
                        e->{
                            doPlay(btn);
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
                                resetGame();
                            }else if(isDraw()==true){
                                    BordBase.winner = 3;
                                    BordBase.page=2;
                                    Navigator.navigateTo(new WinnerScreenBase("YOU",winner,page), e);
                                    resetGame();
                                    isPlayerTurn=!isPlayerTurn;
                            }
                            scoreBtnX.setText(Integer.toString(scoreP1));
                            scoreBtnO.setText(Integer.toString(scoreP2));
                        }
                );
    }
}
