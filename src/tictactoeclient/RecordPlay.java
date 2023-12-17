/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;

import javafx.scene.control.Button;

/**
 *
 * @author NEW LAP
 */
public class RecordPlay extends BoardUI{

    
    void showRecord(){
        resetGame();
        new Thread(){
            public void run(){
                
            }
        }.start();
    }
    @Override
    protected void addListen(Button btn) {}
    
}
