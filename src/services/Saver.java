/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author NEW LAP
 */
public class Saver{
    private String player1Name;
    private String player2Name;
    public static Saver saverObject;
    public Saver(){
        
    }
    public static Saver saverObject(){
        if(saverObject==null){
            saverObject=new Saver();
        }
        return saverObject;
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }
    
}
