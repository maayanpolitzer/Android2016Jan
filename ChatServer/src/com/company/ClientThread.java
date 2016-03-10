package com.company;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by hackeru on 09/03/2016.
 */
public class ClientThread extends Thread {

    private Socket socket;

    public ClientThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in = null;
        OutputStream out = null;
        try{
            in = socket.getInputStream();
            out = socket.getOutputStream();
            int action = in.read();
            switch(action){
                case 1:
                    System.out.println("client sending message");
                    byte[] buffer = new byte[1024];
                    int length = in.read(buffer);
                    String message = new String(buffer, 0, length);
                    System.out.println(message);
                    break;
            }
        }catch(Exception e){
            System.out.println("PROBLEM....");
        }
    }
}
