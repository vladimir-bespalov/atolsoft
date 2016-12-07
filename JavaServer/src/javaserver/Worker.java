/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
 
 
public class Worker implements Runnable {
 
 protected Socket clientSocket = null;
 
    public Worker(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
 
    @Override
    public void run() {
        try {
            InputStream input  = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            long time = System.currentTimeMillis();
            output.write("jdevnotes multithreaded server runs\n".getBytes());
            output.close();
            input.close();
            System.out.println("Request processed: " + time);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
