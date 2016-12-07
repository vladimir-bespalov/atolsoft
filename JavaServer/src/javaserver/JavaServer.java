/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaserver;
import java.io.*;
import java.net.*;
/**
 *
 * @author v.bespalov
 */
public class JavaServer {
    public static final int PORT_WORK = 9000;
    public static final int PORT_STOP = 9001;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
   MultiThreadedServer server = new MultiThreadedServer(PORT_WORK);
        new Thread(server).start();
        try {
            Thread monitor = new StopMonitor(PORT_STOP);
            monitor.start();
            monitor.join();
            System.out.println("Right after join.....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stopping Server");
        server.stop();
     
    }
    
}
