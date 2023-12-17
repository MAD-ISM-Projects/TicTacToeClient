/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NEW LAP
 */
public class StartConnection {
    
    protected Socket soc;
    private DataInputStream dis;
    private PrintStream print;

    
    public void connectServer(String ip){
        try {
            this.soc = new Socket(ip,5005);
            this.dis=new DataInputStream(soc.getInputStream());
            this.print=new PrintStream(soc.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(StartConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
