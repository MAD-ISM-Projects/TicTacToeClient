/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient.Models;

import tictactoeclient.Enum.Mark;

/**
 *
 * @author NEW LAP
 */
public class DTOPlayer  {
    private String playerName;
    private Mark mark;
    
    public DTOPlayer(){
        
    }
    public DTOPlayer(String playerName,Mark mark){
        this.playerName=playerName;
        this.mark=mark;
    }
    public void setName(String playerName){
        this.playerName=playerName;
    }
    public void setMark(Mark mark){
       this.mark=mark;
    }
    public String getName(){
        return playerName;
    }
    public Mark getMark(){
        return mark;
    }


}
