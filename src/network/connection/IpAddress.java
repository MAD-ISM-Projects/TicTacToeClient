/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network.connection;

/**
 *
 * @author mayar
 */
public class IpAddress {

    private static String ip;

    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        IpAddress.ip = ip;
    }
}
