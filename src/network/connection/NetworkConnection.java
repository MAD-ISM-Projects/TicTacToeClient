/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network.connection;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mayar
 */
public class NetworkConnection {
    private Socket soc;
    public DataInputStream dis;
    private PrintStream print;
    
    public NetworkConnection() {
        try {
            this.soc = new Socket("127.0.0.1",5005);
            this.dis=new DataInputStream(soc.getInputStream());
            this.print=new PrintStream(soc.getOutputStream());
            
            
        } catch (IOException ex) {
            Logger.getLogger(NetworkConnection.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
       
    }
    
    
   public void sentMessage(String message){
        new Thread() {
            @Override
            public void run() {
       print.println(message);
       System.out.println(message);
            }
        }.start(); 
       
    }
   public String getMessage(){
       String mess = null ;
        try {
            mess = dis.readLine();
        } catch (IOException ex) {
            Logger.getLogger(NetworkConnection.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return mess;
    }
        public void closeConnection() {
        try {
            if (dis != null) {
                dis.close();
            }
            if (print != null) {
                print.close();
            }
            if (soc != null) {
                soc.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(NetworkConnection.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
        
}
