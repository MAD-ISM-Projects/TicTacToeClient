/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import com.google.gson.Gson;

/**
 *
 * @author mayar
 */
public class RequestHeader {
    private String reqeust;
    private SignInBase player;

    public RequestHeader(clientRequests reqeust, SignInBase player) {
        this.reqeust = reqeust.toString();
        this.player = player;
    }

    public String getReqeust() {
        return reqeust;
    }

    public void setReqeust(String reqeust) {
        this.reqeust = reqeust;
    }

    public SignInBase getPlayer() {
        return player;
    }

    public void setPlayer(SignInBase player) {
        this.player = player;
    }
    
        public String getJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
        
    }
}
