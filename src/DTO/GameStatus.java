/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author U S B
 */
public class GameStatus extends GsonHandler{
   
    public String userName;

    public GameStatus(String userName) {
        this.userName = userName;
    }
    
}
