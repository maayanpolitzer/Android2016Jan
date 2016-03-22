package com.company.threads;

import com.company.Main;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by maayanpolitzer on 07/03/2016.
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
            out.write(Main.SEND_MESSAGE);
            byte[] messageInBytes = message.getBytes();
            out.write(messageInBytes);
            out.close();
            System.out.println("message: \"" + message + "\" was sent to server...");
        } catch (IOException e) {
            System.out.println("Problem creating socket object - " + e.getMessage());
        }
    }
}
