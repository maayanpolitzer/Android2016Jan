package com.company;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by hackeru on 09/03/2016.
 */
public class SendMessageThread extends Thread {

    private String message;

    public SendMessageThread(String message){
        this.message = message;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket(Main.IP_ADDRESS, Main.PORT);
            OutputStream out = socket.getOutputStream();
            out.write(1);
            byte[] messageInBytes = message.getBytes();
            out.write(messageInBytes);
            out.close();
        }catch(IOException e){
            System.out.println("PROBLEM...");
        }
    }
}
