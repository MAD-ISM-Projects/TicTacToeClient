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
import static javax.swing.JOptionPane.showMessageDialog;
import tictactoeclient.AvailablePlayersBase;

/**
 *
 * @author mayar
 */
public class NetworkConnection {

    private Socket soc;
    public DataInputStream dis;
    private PrintStream print;
    private static NetworkConnection connection = null;
    public AvailablePlayersBase opponentBase;
    private String IP = IpAddress.getIp();

    private NetworkConnection() {
        try {
            this.soc = new Socket(IP, 5001);
            this.dis = new DataInputStream(soc.getInputStream());
            this.print = new PrintStream(soc.getOutputStream());

        } catch (IOException ex) {
            Logger.getLogger(NetworkConnection.class.getName())
                    .log(Level.SEVERE, null, ex);
            showMessageDialog(null, "Enter Correct IP");

        }

    }

    public static synchronized NetworkConnection getConnection() {
        if (connection == null) {
            connection = new NetworkConnection();
        }
        return connection;
    }

    public void sentMessage(String message) {
        new Thread() {
            @Override
            public void run() {
                print.println(message);
                System.out.println(message);
            }
        }.start();

    }

    synchronized public String getMessage() {
        String mess = null;
        try {
            mess = dis.readLine();
        } catch (IOException ex) {
            return mess;
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
